package test.designmode.decorator;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 10; i++) {
			Sourceable source = new Source();
			Sourceable dacorator = new Decorator(source);
			dacorator.method();
			Thread.sleep(2000);
		}
		
	}
}
