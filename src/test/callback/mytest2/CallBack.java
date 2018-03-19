package test.callback.mytest2;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月16日
 * @version v1.0.
 * 
 */
public interface CallBack {

	/**
	 * 首先定义一个回调接口，只有一个方法tellAnswer(int answer)，即学生思考完毕告诉老师答案：
	 * @param answer
	 */
	public void tellAnswer(int answer);
}
