package test.designmode.adpapter.objectAdapter;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Wrapper implements Targetable{
	
	private Source source;
	
	public Wrapper(Source source){
		this.source = source;
	}
	

	@Override
	public void method2() {
		System.out.println("targetable method 新类的方法");
	}

	@Override
	public void method1() {
		source.method1();
	}
}
