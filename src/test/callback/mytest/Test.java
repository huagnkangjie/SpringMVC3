package test.callback.mytest;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年10月16日
 * @version v1.0.
 * 
 */
public class Test {

	
	public static void main(String[] args) {
		B b = new B(new A());
		b.doWork();
	}
}
