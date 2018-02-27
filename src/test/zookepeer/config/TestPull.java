package test.zookepeer.config;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * @描述：初始化的时候获取一个zk的客户端连接，
 * 保持这个长连接，并通过这个长连接不断的向服务器获取数据
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月12日
 * @version v1.0.
 * 
 */
public class TestPull {
	
	static FtpConfig ftpConfig;
	 
	 
    public static FtpConfig getFtpConfig(ZkClient zk) {
        if (ftpConfig == null) {
        	System.out.println("==========>首次获取时，连接zk取得配置，并监听配置变化");
            //首次获取时，连接zk取得配置，并监听配置变化
//            ZkClient zk = ZKUtil.getZkClient();
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

	public static void main(String[] args) {
		
		ZkClient zk = ZKUtil.getZkClient();
		
		for (int i = 0; i < 10000; i++) {
			 
	        try {
	        	
	        	System.out.println("pull 索引：" + i);
	        	getFtpConfig(zk);
	        	
	        	Thread.sleep(2000);
	        	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        
	}
}
