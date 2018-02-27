package test.designmode.prototype;

import java.io.IOException;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class Test {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			//浅克隆
			ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
			clonecp.show();
//			System.out.println(clonecp);
			
			//深克隆
//			ConcretePrototype deepClone = (ConcretePrototype) cp.deepClone();
//			deepClone.show();
//			System.out.println(deepClone);
		}
	}
}
