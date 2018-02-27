package test.interpretation;
/**
 * @描述：
 *
 * @author 作者 : huang_kangjie
 * @date 创建时间：2018年2月11日
 * @version v1.0.
 * 
 */
public class UserBean {

	/**
	 * 评论
	 */
	@InterpretTest(comments = "this is a interpreation comment", value = "test")
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
