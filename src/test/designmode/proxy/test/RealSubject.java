package test.designmode.proxy.test;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月15日
 * 
 */
public class RealSubject implements Subject {

	@Override
	public int play(int no, String s) {
		
		System.out.println("playing, so happy ! " + s);
		
		return no;
	}

}
