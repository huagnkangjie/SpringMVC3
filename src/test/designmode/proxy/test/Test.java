package test.designmode.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月15日
 * 
 */
public class Test {

	
	public static void main(String[] args) {
		
		Subject realSuject = new RealSubject();
		
		InvocationHandler handler = new DynamicProxy(realSuject);
		
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSuject.getClass().getInterfaces(), handler);
		
		Object result = subject.play(5, "曹尼玛sdfsdfafasdf");
		
		System.out.println(result);
		
	}
}
