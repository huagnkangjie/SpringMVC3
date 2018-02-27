package test.designmode.factory.abstractFactory;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class MailSendFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
