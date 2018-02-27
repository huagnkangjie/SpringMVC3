package test.designmode.adpapter.objectAdapter;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) {
		Source source = new Source();
		Wrapper wrapper = new Wrapper(source);
		wrapper.method1();
		wrapper.method2();
	}
}
