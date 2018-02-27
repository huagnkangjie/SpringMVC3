package test.aop;

public class SleepableImpl implements Sleepable{

	@Override
	public void sleep() {
		System.out.println("进入甜蜜的梦乡！");
		
	}

}
