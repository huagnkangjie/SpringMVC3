package test.designmode.proxy.buyTicket;
/**
 * 想买票
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class XiaoWang implements Person{

	@Override
	public void buyTicket() {
		System.out.println("我是小王，想买票");
	}
}
