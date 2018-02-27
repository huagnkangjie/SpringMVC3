package test.generic.main;

import test.generic.bean.UserA;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年7月27日
 * @version v1.0.
 * 
 */
public class Test {

	public static void main(String[] args) {
		TestA test = new TestA();
		UserA a = new UserA();
		a.setName("lisi");
		test.play(a);
	}
	
}
