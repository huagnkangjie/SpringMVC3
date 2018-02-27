package test.designmode.proxy.mytest;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Boss implements Subject{

	@Override
	public void openMeeting() {
		System.out.println("老板才是开会的主角，开会中...");
	}

}
