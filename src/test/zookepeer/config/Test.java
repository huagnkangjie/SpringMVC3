package test.zookepeer.config;
/**
 * @描述： 此类为综合执行。
 * 
 * 执行往zk里面加载初始化、获取数据、更新数据
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月12日
 * @version v1.0.
 * 
 */
public class Test {
	
	public static void main(String[] args) {
		ConfigManager cfgManager = new ConfigManager();
        ClientApp clientApp = new ClientApp();
 
        try {
			//模拟【配置管理中心】初始化时，从db加载配置初始参数
			cfgManager.loadConfigFromDB();
			//然后将配置同步到ZK
			cfgManager.syncFtpConfigToZk();

			//模拟客户端程序运行
			clientApp.run();

			//模拟配置修改
			cfgManager.updateFtpConfigToDB(23, "10.6.12.34", "newUser", "newPwd");
			cfgManager.syncFtpConfigToZk();

			//模拟客户端自动感知配置变化
			clientApp.run();
			//模拟客户端自动感知配置变化
			clientApp.run();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
