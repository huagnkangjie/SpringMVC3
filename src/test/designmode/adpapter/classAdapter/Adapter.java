package test.designmode.adpapter.classAdapter;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("targetable method 新类的方法");
	}
}
