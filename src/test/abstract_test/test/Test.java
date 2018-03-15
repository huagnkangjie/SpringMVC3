package test.abstract_test.test;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月14日
 * @version v1.0.
 * 
 */
public class Test {

	
	public static void main(String[] args) {
		
		
		ITestService test = new TestServiceImpl();
		test.operation();
		
	}
}
