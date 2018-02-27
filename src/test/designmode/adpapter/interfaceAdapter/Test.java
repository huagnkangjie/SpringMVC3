package test.designmode.adpapter.interfaceAdapter;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) {
		Sourceable sorce1 = new SourceSub1();
		Sourceable sorce2 = new SourceSub2();
		
		sorce1.method1();
		sorce1.method2();
		
		sorce2.method1();
		sorce2.method2();
		
		
	}
}
