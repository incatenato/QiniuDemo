package qiniu.demo.service;

import com.qiniu.api.rs.Entry;
import qiniu.demo.util.ManageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jianghao on 15/2/26.
 */
public class GetFileStat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucket = req.getParameter("bucket");
        String key = req.getParameter("key");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Entry entry = ManageUtil.getFileStat(bucket, key);
        StringBuilder sb = new StringBuilder();
        sb.append("[{")
                .append("\"key\":\""+key+"\",")
                .append("\"hash\":\""+entry.getHash()+"\",")
                .append("\"mime-type\":\""+entry.getMimeType()+"\",")
                .append("\"fsize\":\""+entry.getFsize()+"\",")
                .append("\"put time\":\""+entry.getPutTime()+"\"}]");
        if (entry.getStatusCode() == 200){
            out.print(sb);
        }
        else {
            out.print("[]");
        }
        out.flush();
        out.close();
    }
}
