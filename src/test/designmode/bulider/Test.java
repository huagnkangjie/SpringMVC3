package test.designmode.bulider;
/**
 * 类说明
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月13日
 * 
 */
public class Test {

	public static void main(String[] args) {
		Bulider bulider = new Bulider();
		bulider.produceMailSender(5);
		bulider.produceSmsSender(10);
		System.out.println(bulider.getList().size());
		
		for (int i = 0; i < bulider.getList().size(); i++) {
			bulider.getList().get(i).send();
		}
	}
}
