package qiniu.demo.util;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import qiniu.demo.config.ConfigInfo;

/**
 *
 * Created by jianghao on 15/2/12.
 */
public class Token {
    public static String getUpToken(){
        Mac mac = new Mac(ConfigInfo.ACCESS_KEY,ConfigInfo.SECRET_KEY);
        PutPolicy policy = new PutPolicy(ConfigInfo.BUCKET_NAME);
        String token = "";
        try {
            token =  policy.token(mac);
        }
        catch (AuthException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return token;
    }
}
