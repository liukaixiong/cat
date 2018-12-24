package com.dianping.cat.report.page.utils;

import com.alibaba.fastjson.JSONObject;
import com.dianping.cat.report.page.toptransaction.Context;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : liukx
 * @create : 2018/12/18 11:49
 * @email : liukx@elab-plus.com
 */
public class JsonResponseUtils {
    public static void view(Context ctx, JSONObject jsonObject) throws ServletException, IOException {
        HttpServletResponse res = ctx.getHttpServletResponse();

        if (jsonObject != null) {
            ServletOutputStream out = res.getOutputStream();

            res.setContentType("application/json;charset=UTF-8");
            out.print(jsonObject.toJSONString());
        } else {
            res.sendError(404, "Not found!");
        }
    }

}
