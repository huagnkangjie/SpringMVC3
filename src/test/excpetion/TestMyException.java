package test.excpetion;

public class TestMyException {

	public static void main(String[] args) {
		throw new MyException("参数的键值对个数不匹配");
	}
}
