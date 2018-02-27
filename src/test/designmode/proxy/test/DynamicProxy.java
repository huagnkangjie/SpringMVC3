package test.designmode.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月15日
 * 
 */
public class DynamicProxy implements InvocationHandler{
	
	public Object object = null;
	
	public DynamicProxy(Object object){
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object reaslut = null;
		
		System.out.println("xiaoming call me play!");
		
		reaslut = method.invoke(object, args);
		
		System.out.println("go home.");
		
		return reaslut;
	}

}
