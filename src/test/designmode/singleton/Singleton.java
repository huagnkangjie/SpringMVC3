package test.designmode.singleton;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class Singleton {

	private static Singleton singleton = new Singleton();
	
	public static Singleton getInstance(){
		return Singleton.singleton;
	}
	
	public void play(){
		System.out.println("单例模式");
	}
}
