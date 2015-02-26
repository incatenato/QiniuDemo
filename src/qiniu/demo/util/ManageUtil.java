package qiniu.demo.util;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.net.CallRet;
import com.qiniu.api.rs.Entry;
import com.qiniu.api.rs.RSClient;
import com.qiniu.api.rsf.ListItem;
import com.qiniu.api.rsf.ListPrefixRet;
import com.qiniu.api.rsf.RSFClient;
import com.qiniu.api.rsf.RSFEofException;
import qiniu.demo.config.ConfigInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghao on 15/2/25.
 */
public class ManageUtil extends ConfigInfo {

    /**
     * 列举所有文件
     * @param bucket
     * @param limit
     */
    public static List<ListItem> listFile(String bucket, int limit){
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);

        RSFClient rsfClient = new RSFClient(mac);
        List<ListItem> all = new ArrayList<ListItem>();
        ListPrefixRet ret = null;
        while (true){
            ret = rsfClient.listPrifix(bucket, null, null, -1);
            all.addAll(ret.results);
            if (!ret.ok())
                break;
        }
        if (ret.exception.getClass() != RSFEofException.class){
            //TODO: error handler
        }
        return all;
    }

    /**
     * 删除单个文件
     * @param bucket
     * @param key
     * @return boolean
     */
    public static boolean deleteFile(String bucket, String key){
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);

        RSClient client = new RSClient(mac);
        CallRet ret = client.delete(bucket, key);
        return ret.ok();
    }

    /**
     * 获取单个文件状态
     * @param bucket
     * @param key
     * @return entry
     */
    public static Entry getFileStat(String bucket, String key){
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        RSClient client = new RSClient(mac);
        return client.stat(bucket, key);
    }

    public static void main(String[] args) {
        Entry entry = getFileStat("demo", "zzz.mp4");
        System.out.println(entry.getStatusCode());
    }
}
