package test.designmode.proxy.dynamic.test;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class TestInerfaceImpl implements TestInterface {

	@Override
	public void method1() {

		System.out.println("method1");
		
	}

	@Override
	public void method2() {
		
		System.out.println("method2");
	}

}
