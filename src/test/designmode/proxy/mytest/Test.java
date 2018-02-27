package test.designmode.proxy.mytest;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) {
		
		/**
		 * 秘书代理了老板的对象，不直接用老板的对象做开会前后的事
		 */
		Subject subject = new Boss();
		Subject mishu = new MiShu(subject);
		mishu.openMeeting();
		
	}
}
