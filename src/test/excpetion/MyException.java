package test.excpetion;

/**
 * 自定义异常
 * @author Mr-H
 *
 */
public class MyException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4969351466655313655L;

	public MyException(){
		super();
	}
	
	public MyException(String message, Throwable t){
		super(message, t);
	}
	
	public MyException(String message){
		super(message);
	}
	
	public MyException(Throwable t){
		super(t);
	}

}
