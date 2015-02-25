package qiniu.demo.service;

import qiniu.demo.util.ManageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jianghao on 15/2/25.
 */
public class DeleteFileServlet extends HttpServlet {
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
        boolean mark;
        if (key != null && !key.equals("")){
             mark = ManageUtil.deleteFile(bucket, key);
            if (mark)
                out.print("{\"status\":\"file delete success.\"}");
            else
                out.print("{\"status\":\"failed.\"}");
        }
        else {
            out.print("{\"status\":\"key cannot be null.\"}");
        }
        out.flush();
        out.close();
    }
}
