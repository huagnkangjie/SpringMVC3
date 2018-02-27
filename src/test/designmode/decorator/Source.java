package test.designmode.decorator;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Source implements Sourceable{

	@Override
	public void method() {
		System.out.println("原始方法");
	}

}
