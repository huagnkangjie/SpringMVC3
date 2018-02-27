package test.zookepeer.config;

import org.I0Itec.zkclient.ZkClient;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @描述：
 * 模拟一个客户端，此客户端是维护一个对zk子节点数据
 * 
 * 更新子节点数据
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月12日
 * @version v1.0.
 * 
 */
public class TestPush {
	
	
	/**
     * 将配置同步到ZK
     */
    public static void syncFtpConfigToZk(ZkClient zk, FtpConfig ftpConfig) throws JsonProcessingException {
    	
    	
        if (!zk.exists(ZKUtil.FTP_CONFIG_NODE_NAME)) {
            zk.createPersistent(ZKUtil.FTP_CONFIG_NODE_NAME, true);
        }
        try {
        	zk.writeData(ZKUtil.FTP_CONFIG_NODE_NAME, ftpConfig);
            zk.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			zk.close();
		}
        
    }
    
    public static void main(String[] args) {
    	
    	
		
		for (int i = 0; i < 1000; i++) {
			 
	        try {
	        	ZkClient zk = ZKUtil.getZkClient();
	        	System.out.println("push 索引：" + i);
	        	FtpConfig ftpConfig = new FtpConfig(i, "host" + i, "user" + i, "password" + i);
	        	syncFtpConfigToZk(zk, ftpConfig); 
	        	System.out.println("ftp配置更新完毕");
	        	Thread.sleep(5000);
	        	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
