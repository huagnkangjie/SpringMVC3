package test.designmode.proxy.dynamic;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class RealSubject implements Subject {

	@Override
	public void saleBook() {
		System.out.println("卖书");
	}

}
