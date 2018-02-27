package test.designmode.proxy.mytest;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class MiShu implements Subject{

	private Subject subject;
	
	public MiShu(Subject subject){
		this.subject = subject;
	}

	@Override
	public void openMeeting() {
		System.out.println("秘书：开会前准备会场，通知大家开会");
		subject.openMeeting();
		System.out.println("秘书：开会结束后整理会场");
	}

}
