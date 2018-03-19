package test.callback.mytest2;
/**
 * @描述：
 *
 *
 *接着定义一个学生接口，学生当然是解决问题，但是接收一个Callback参数，这样学生就知道解决完毕问题向谁报告：
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月16日
 * @version v1.0.
 * 
 */
public interface Student {

	
	public void resolveQuestion(CallBack callback);
}
