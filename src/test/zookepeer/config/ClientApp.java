package test.zookepeer.config;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月12日
 * @version v1.0.
 * 
 */
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
 
import java.util.concurrent.TimeUnit;
 
 
public class ClientApp {
 
    FtpConfig ftpConfig;
 
 
    public FtpConfig getFtpConfig() {
        if (ftpConfig == null) {
        	System.out.println("==========>首次获取时，连接zk取得配置，并监听配置变化");
            //首次获取时，连接zk取得配置，并监听配置变化
            ZkClient zk = ZKUtil.getZkClient();
            ftpConfig = (FtpConfig) zk.readData(ZKUtil.FTP_CONFIG_NODE_NAME);
            System.out.println("ftpConfig => " + ftpConfig);
 
            zk.subscribeDataChanges(ZKUtil.FTP_CONFIG_NODE_NAME, new IZkDataListener() {
 
                @Override
                public void handleDataChange(String s, Object o) throws Exception {
                    System.out.println("ftpConfig is changed !");
                    System.out.println("node:" + s);
                    System.out.println("o:" + o.toString());
                    ftpConfig = (FtpConfig) o;//重新加载FtpConfig
                }
 
                @Override
                public void handleDataDeleted(String s) throws Exception {
                    System.out.println("ftpConfig is deleted !");
                    System.out.println("node:" + s);
                    ftpConfig = null;
                }
            });
        }else{
        	System.out.println("==========>ftpConfig 配置已经存在，直接返内容：" + ftpConfig.toString());
        }
        return ftpConfig;
 
    }
 
    /**
     * 模拟程序运行
     *
     * @throws InterruptedException
     */
    public void run() throws InterruptedException {
 
        getFtpConfig();
 
        upload();
 
        download();
    }
    
    public void getConfig(){
    	 System.out.println("正在获取配置文件...");
         System.out.println(ftpConfig);
         System.out.println("获取配置文件完成...");
    }
 
    public void upload() throws InterruptedException {
        System.out.println("正在上传文件...");
        System.out.println(ftpConfig);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("文件上传完成...");
    }
 
 
    public void download() throws InterruptedException {
        System.out.println("正在下载文件...");
        System.out.println(ftpConfig);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("文件下载完成...");
    }
 
 
}