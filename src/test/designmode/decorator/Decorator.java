package test.designmode.decorator;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Decorator implements Sourceable{
	
	private Sourceable source;
	
	public Decorator(Sourceable source){
		this.source = source;
	}

	@Override
	public void method() {
		System.out.println("方法执行前>>>>>>>>>");
		System.out.println();
		source.method();
		System.out.println(">>>>>>>>>方法执行后");
		System.out.println();
		System.out.println("------------------------");
	}

}
