package test.designmode.proxy.buyTicket;
/**
 * 票贩子，专门买票
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月14日
 * 
 */
public class XiaoMing implements Person{
	
	private Person pserson;
	
	/**
	 * 静态代理
	 */
	public XiaoMing(){
		//默认只买小王的票
		this.pserson = new XiaoWang();
	}
	
	/**
	 * 动态代理
	 * @param pserson
	 */
	public XiaoMing(Person pserson){
		//不管什么人，都可以买
		this.pserson = pserson;
	}

	@Override
	public void buyTicket() {
		pserson.buyTicket();
	}

}
