package test.designmode.factory.abstractFactory;
/**
 * 工厂类，对接口实例化
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class SmsSendFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
