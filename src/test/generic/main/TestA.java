package test.generic.main;

import test.generic.IGeneric;
import test.generic.bean.UserA;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年7月27日
 * @version v1.0.
 * 
 */
public class TestA implements IGeneric<UserA>{

	public void play(UserA o) {
		System.out.println("do A = " + o.getName());
	}

}
