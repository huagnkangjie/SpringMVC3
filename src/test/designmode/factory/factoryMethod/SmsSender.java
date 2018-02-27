package test.designmode.factory.factoryMethod;
/**
 * 短信发送
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println(">>>>>>>>>> 我是【短信发送】" );
	}

}
