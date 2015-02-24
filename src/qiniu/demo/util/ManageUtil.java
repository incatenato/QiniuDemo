package qiniu.demo.util;

import com.qiniu.api.auth.digest.Mac;
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
}
