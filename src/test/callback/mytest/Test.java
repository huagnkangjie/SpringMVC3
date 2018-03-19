package test.callback.mytest;
/**
 * @描述：对于回调的理解就是，A - B， B执行完毕之后，再调用A的方法，这就叫做回调
 * 
 * https://www.cnblogs.com/xrq730/p/6424471.html
 * 
 * 这个帖子写的很清晰
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
