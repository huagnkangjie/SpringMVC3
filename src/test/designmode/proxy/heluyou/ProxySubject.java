package test.designmode.proxy.heluyou;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年8月16日
 * @version v1.0.
 * 
 */
public class ProxySubject extends RealSubject{

	public void send(){
		super.send();
		System.err.println("代理对象");
	}
}
