package test.designmode.factory.factoryMethod;
/**
 * 测试类
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class Test {

	public static void main(String[] args) {
		String type = "mail";
//		String type = "sms";
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce(type);
		sender.send();
	}
}
