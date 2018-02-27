package test.designmode.proxy.Static;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class ProxySubject implements Subject {
	
	public RealSubject realSubject;

	@Override
	public void saleBook() {

		if(realSubject == null){
			realSubject = new RealSubject();
		}
		
		System.out.println("打折");
		realSubject.saleBook();
		System.out.println("送优惠券");
		
	}

}
