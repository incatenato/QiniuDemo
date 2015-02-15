package qiniu.demo.service;

import qiniu.demo.util.Token;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jianghao on 15/2/15.
 */
public class GetTokenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"uptoken\":\""+Token.getUpToken()+"\"")
                .append("}");
        out.print(sb);
    }
}
