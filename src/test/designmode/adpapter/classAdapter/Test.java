package test.designmode.adpapter.classAdapter;

import java.util.Random;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) {
		Targetable taget = new Adapter();
		taget.method1();
		taget.method2();
		
		
	}
}
