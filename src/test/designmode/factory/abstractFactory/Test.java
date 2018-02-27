package test.designmode.factory.abstractFactory;
/**
 * 测试类
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class Test {

	public static void main(String[] args) {
		//假如要发邮件
		Provider provider = new MailSendFactory();
		Sender sender = provider.produce();
		sender.send();
		
		//假如要发短信
		Provider providerSms = new SmsSendFactory();
		Sender senderSms = providerSms.produce();
		senderSms.send();
		
		/**
		 * 假如要扩展发送接口
		 * 1、对provide进行扩展
		 * 2、创建对应的工厂类，提供对应的实例
		 * 3、实现对用的接口
		 */
	}
}
