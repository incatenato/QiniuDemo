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
public class Token extends ConfigInfo {
    /**
     * 获取上传凭证
     * @return upToken
     */
    public static String getUpToken(){
        Mac mac = new Mac(ACCESS_KEY,SECRET_KEY);
        PutPolicy policy = new PutPolicy(BUCKET_NAME);
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

    /**
     * 获取管理凭证
     * @param url
     * @return
     */
    public String getManageToken(String url){
        String sign = "";
        if (url != null && !(url.equals(""))){
            //step 1. split url string.
            url = url.substring(url.lastIndexOf("/"),url.length());
            //step 2. add '\n' to url string.
            url += "\\n";
            System.out.println("step1:"+url);
        }
        return generateToken(url);
    }

    /**
     * sha1＋base64加密
     * @param url
     * @return sign
     */
    private String generateToken(String url){
        String sign = "";
        Mac mac = new Mac(ACCESS_KEY,SECRET_KEY);
        try {
            sign = mac.sign(url.getBytes());
            System.out.println("step2:"+sign);
        }
        catch (AuthException e) {
            e.printStackTrace();
        }
        return urlSafeBase64(sign);
    }

    /**
     * url安全base64加密
     * @param sign
     * @return sign
     */
    private String urlSafeBase64(String sign){
        sign.replaceAll("\\+","-");
        sign.replaceAll("//","_");
        return sign;
    }

//    public static void main(String[] args) {
//        String sign = new Token().getManageToken("http://rsf.qbox.me/list?bucket=demo&prefix=00");
//        System.out.println("step3:"+sign);
//    }
}
