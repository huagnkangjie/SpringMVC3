package test.designmode.proxy.buyTicket;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class Test {

	public static void main(String[] args) {
		Person person = new XiaoMing();
		person.buyTicket();
		
		
		XiaoLi xiali = new XiaoLi();
		XiaoMing xiaoming = new XiaoMing(xiali);
		Person persons = xiaoming;
		persons.buyTicket();
		
		System.out.println("-------------");
		
		XiaoMing t = new XiaoMing();
		t.buyTicket();
		
		XiaoLi t2 = new XiaoLi();
		XiaoMing t3 = new XiaoMing(t2);
		t3.buyTicket();
		
	}
}
