package test.callback.mytest;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2017年10月16日
 * @version v1.0.
 * 
 */
public class B {
	
	public CallBack callback = null;
	
	public B(CallBack callBanck){
		this.callback = callBanck;
	}
	

	public void doWork(){
		
		System.out.println("doing work");
		
		this.callback.callBack();
		
	}
}
