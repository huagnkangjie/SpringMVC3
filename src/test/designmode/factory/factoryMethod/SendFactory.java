package test.designmode.factory.factoryMethod;
/**
 * 工厂类，对接口实例化
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class SendFactory {

	
	public Sender produce(String type){
		Sender sender = null;
		if(type.equals("mail")){
			sender = new MailSender();
		}else if(type.equals("sms")){
			sender = new SmsSender();
		}
		return sender;
	}
}
