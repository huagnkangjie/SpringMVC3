package test.system;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年10月20日
 * @version v1.0.
 * 
 */
public class SystemTest {

	
	public static void main(String[] args) {
		System.setProperty("test", "test111111111");
		
		
		System.out.println(System.getProperty("test"));
	}
}
