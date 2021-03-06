<img src="https://github.com/dianping/cat/raw/master/cat-home/src/main/webapp/images/logo/cat_logo03.png" width="50%">

**CAT**
 [![GitHub stars](https://img.shields.io/github/stars/dianping/cat.svg?style=social&label=Star&)](https://github.com/dianping/cat/stargazers)
 [![GitHub forks](https://img.shields.io/github/forks/dianping/cat.svg?style=social&label=Fork&)](https://github.com/dianping/cat/fork)

**接入手册可以直接去CAT的主页去查看**

### CAT 拓展 
## 报表
这个报表功能只是为了能够将所有项目能够根据CAT现有的数据做了一次汇总。  
目的是为了当项目很多的情况下，有针对性的根据当前构建的所有报表来确定哪些项目需要我去关注。
### 小时汇总报表
![image.png](https://upload-images.jianshu.io/upload_images/6370985-00df3f65460bc523.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 这里主要是汇总了所有项目这一个小时的异常情况，并且将异常进行划分。

**稍微提一下这个和CAT本身的Dashboard有何区别?**  
其实CAT的这个报表的纬度是八分钟，并不是一个小时之内，需要用户自己根据选择分钟才能看到当前分钟和前八分钟的异常情况。

## 心跳报表
![image.png](https://upload-images.jianshu.io/upload_images/6370985-8e31f9d5fde87ac6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

这里主要列出了所有项目当前小时的心跳情况，分别取了最大值和最小值的数据。

## 事务报表
![image.png](https://upload-images.jianshu.io/upload_images/6370985-50b74bd26c196de6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 这里的报表是通过跑批的数据跑出来的 

1. 这里的消息类型指的就是Transaction中的Type ， 通用的就是 interfaces 或者URL 
2. 项目是针对项目名，支持前缀匹配 ： test-domain = test就能匹配到.

这里需要注意一点的就是小时的是实时计算出来的。天的话需要跑批。  
由于CAT的天报表在这里去做的话会比较麻烦，因为需要聚合24小时的并且还要做特殊处理，建议通过跑批的方式在每个凌晨触发一个URL让它把指定类型的数据跑出来。

跑批的URL ： http://localhost:2281/cat/r/toptransaction?op=topBatchDay&&type=interfaces&&date=20181217

## 小细节改动
1. 将每个接口的最长时间的日志展现出来
![image.png](https://upload-images.jianshu.io/upload_images/6370985-c16441eaae72f4ae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2. 读取应用名称修改
  SpringBoot读取domain的时候是需要在`META-INF/app.properties`中定义app.name来获取，
  不是非常友好。
  而本次针对加载顺序做了调整：
   1. 首先加载启动参数中是否有`spring.application.name`配置
   2. 其次判断启动参数中是否有`spring.profiles.active`环境区分配置,如果有则加载application-${spring.profiles.active}.yml配置中的`app.name` 。
    > 例如变量为dev , 则加载application-dev.yml中的app.name

   3. 最后再加载默认的CAT的配置:`META-INF/app.properties`

上述流程只要其中一条满足，则不会往下执行。

## 开发调试建议
1. tomcat参数
```tex
// 解决乱码 , 并且打印debug日志,方便调试
-Dfile.encoding=UTF-8 -DdevMode=true
```

2. 停止tomcat,关闭2280脚本
> vim stop.sh
```shell
curl http://localhost:2281/cat/r/home?op=checkpoint
cd bin
./shutdown.sh
```


## 针对一些使用CAT遇到的一些问题记录并且提出解决方案:
#### 如果按照配置发现还是收不到告警邮件或者短信等等如何排查?
> 前提是已经按照文档配置还是不行!!!!!
1. 先判断是否报警的配置是否有误?
  1. 直接到测试用例中com.dianping.cat.report.alert.SenderManagerTest去尝试一下。
    如果这个用例发送成功了，表明发送的这部分配置是OK的。
  2. 需要注意的是这个是本地环境，如果是测试环境，则可以将本地数据源切换成测试换数据源。
2. 判断是否配置的项目是否有误？
 - CAT如果触发了要发邮件的规则,会在数据表alert中体现。
3. 源码角度
 - com.dianping.cat.alarm.spi.AlertManager中会在SendExecutor中启动一个线程run来查看队列中是否存在需要发送的消息,在那里定位一下就OK了
 - 又或者在AlertManager.addAlert的方法中加入断点,因为所有发送告警的都会经过该方法,如果该方法触发了,说明规则没问题。


#### 点击LogViews中查看消息 : Sorry, the message is not there. It could be missing or archived.
查看客户端版本是否是2.0或者2.0以下的? **升级到3.0**  

具体原因分析 : [CAT消息丢失问题排查Sorry, the message is not there. It could be missing or archived.](https://www.jianshu.com/p/186e7b959a66)

#### 查看小时数据是有的,历史数据数据都没有
原因: 没有开启历史数据线程

需要在configs - 全局系统配置 - 服务端配置 - job-machine 设置为 true 。

需要注意的是，设置好了之后需要重启，因为在启动的时候才会起开启这个线程

##### 密码修改
参考 : SessionManager.java : 我这里默认的是elab@666