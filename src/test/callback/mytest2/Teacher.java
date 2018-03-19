package test.callback.mytest2;
/**
 * @描述：
 *
 *
 *定义一个老师对象，实现Callback接口：
 *
 *
 *老师对象有两个public方法：

（1）回调接口tellAnswer(int answer)，即学生回答完毕问题之后，老师要做的事情

（2）问问题方法askQuestion()，即向学生问问题
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年3月16日
 * @version v1.0.
 * 
 */
public class Teacher implements CallBack{
	
	
	private Student student;
	
	public Teacher(Student student){
		this.student = student;
	}
	
	public void askQuestion(){
		System.out.println("老师：小明回答下1 + 1 = ？");
		/**
		 * 同步的方式
		 */
//		student.resolveQuestion(this);
		
		/**
		 * 这里可以考虑成异步的，
		 * 同步会减少对象的生成
		 */
		Thread t = new Thread(new Runnable() {
			public void run() {
				Teacher t = new Teacher(student);
				student.resolveQuestion(t);
			}
		});
		t.start();
		
		play();
		
	}

	@Override
	public void tellAnswer(int answer) {
		System.out.println("老是提问后，学生思考并作出解答，答案是：" + answer);
	}
	
	public void play(){
		System.out.println("老师：小名你先想想怎么解答");
	}

}
