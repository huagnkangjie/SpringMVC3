package test.abstract_test.test;

import java.io.IOException;

import test.abstract_test.AbstractTest;

/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月14日
 * @version v1.0.
 * 
 */
public class TestServiceImpl extends AbstractTest implements ITestService{

	@Override
	public void read() throws IOException {
		System.out.println("this test read()");
		
	}

	@Override
	public void write() throws IOException {
		System.out.println("this test write()");
		
	}

}
