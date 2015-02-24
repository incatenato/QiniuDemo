package qiniu.demo.service;

import com.qiniu.api.rsf.ListItem;
import qiniu.demo.util.ManageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghao on 15/2/25.
 */
public class FileManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bucket = req.getParameter("bucket");
        String limit = req.getParameter("limit");
        int lim = 0;
        if (limit != null && !limit.equals("")){
            lim = Integer.parseInt(limit);
        }
        List<ListItem> fileList = ManageUtil.listFile(bucket, lim);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListItem item : fileList){
            sb.append("[")
                    .append("\""+item.key+"\",")
                    .append("\""+item.hash+"\",")
                    .append("\""+item.mimeType+"\",")
                    .append("\""+item.fsize+"\",")
                    .append("\""+item.putTime+"\"")
                    .append("],");
        }
        sb.append("]");
        if (sb.length() > 2){
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(sb);
        out.flush();
        out.close();
    }
}
