package qiniu.demo.util;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import qiniu.demo.config.ConfigInfo;

import java.io.InputStream;

/**
 * Created by jianghao on 15/2/13.
 */
public class UploadUtil extends ConfigInfo{

    public static PutRet upload(InputStream input){
        Mac mac = new Mac(ACCESS_KEY,SECRET_KEY);
        PutPolicy policy = new PutPolicy(BUCKET_NAME);
        String upToken = null;
        //获取token
        try {
            upToken = policy.token(mac);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        catch (AuthException e) {
            e.printStackTrace();
        }
        PutExtra extra = new PutExtra();
        //检查file path
        if (input == null) return null;
        //生成文件key
        String key = String.valueOf(System.currentTimeMillis());
        return IoApi.Put(upToken, key, input, extra);
    }

}
