package qiniu.demo.service;

import com.qiniu.api.io.PutRet;
import qiniu.demo.util.UploadUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
* Created by jianghao on 15/2/13.
*/
public class FormUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream ins = req.getInputStream();
        PutRet ret = UploadUtil.upload(ins);
        System.out.println("Hash:"+ret.getHash());
        System.out.println("Key:"+ret.getKey());
        System.out.println("Response:"+ret.getResponse());
        System.out.println("Status:"+ret.getStatusCode());
    }
}
