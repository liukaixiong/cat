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
