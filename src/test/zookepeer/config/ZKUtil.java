package test.zookepeer.config;

import org.I0Itec.zkclient.ZkClient;

/**
 * @描述：zk客户端连接工具，分别连接多个zk服务器的
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月12日
 * @version v1.0.
 * 
 */
public class ZKUtil {

	public static final String FTP_CONFIG_NODE_NAME = "/config/ftp";
	 
    public static ZkClient getZkClient() {
//        return new ZkClient("localhost:2181,localhost:2182,localhost:2183");
    	 return new ZkClient("17219.10.42:2181,172.19.1.28:2181");
    }
    
}
