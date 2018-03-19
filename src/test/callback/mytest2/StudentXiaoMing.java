package test.callback.mytest2;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月16日
 * @version v1.0.
 * 
 */
public class StudentXiaoMing implements Student{

	@Override
	public void resolveQuestion(CallBack callback) {

		System.out.println("收到老师的问题，我思考一下");
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		
		callback.tellAnswer(2);
		
	}

}
