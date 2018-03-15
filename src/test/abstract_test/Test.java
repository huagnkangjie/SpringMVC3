package test.abstract_test;

import java.io.IOException;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月14日
 * @version v1.0.
 * 
 */
public class Test extends AbstractTest{

	@Override
	public void read() throws IOException {
		System.out.println("子类的read()");
		
	}

	@Override
	public void write() throws IOException {
		System.out.println("子类的write()");
		
	}
	
	
	public static void main(String[] args) {
		AbstractTest test = new Test();
		test.operation();
	}
	

}
