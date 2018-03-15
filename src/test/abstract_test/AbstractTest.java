package test.abstract_test;

import java.io.IOException;

/**
 * @描述：该类主要是提供一个可读、可写、自身操作的测试
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月14日
 * @version v1.0.
 * 
 */
public abstract class AbstractTest{

	/**
	 * 文件操作
	 */
	public void operation(){
		System.out.println("======开始操作文件=======");
		
		try {
			this.read();
		} catch (Exception e) {
			System.out.println("======读取文件出错=======");
		}
		
		try {
			this.write();
		} catch (Exception e) {
			System.out.println("======写文件出错=======");
		}
		
		
		
	}
	
	/**
	 * 读取文件
	 * @throws IOException
	 */
	public abstract void read() throws IOException;
	
	/**
	 * 写文件
	 * @throws IOException
	 */
	public abstract void write() throws IOException;
	
}
