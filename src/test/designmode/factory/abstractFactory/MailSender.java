package test.designmode.factory.abstractFactory;
/**
 * 邮件发送
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class MailSender implements Sender{

	@Override
	public void send() {
		System.out.println(">>>>>>>>>> 我是【邮件发送】" );
	}

}
