package test.alarmclock;
/**
 * 初始化，启动类
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月3日
 * 
 */
public class StartBoot {
	
	public static void main(String[] args) {
		
		StartBoot startBoot = new StartBoot();
		
		/**
		 * 初始化闹钟
		 * 启动线程
		 */
		System.err.println("启动闹钟应用");
		startBoot.initClock();
		startBoot.startAlarmClock();
		
	}
	
	public void startAlarmClock(){
		
		MainClock main = new MainClock(true);
		Thread t = new Thread(main);
		t.start();
		
	}
	
	/**
	 * 初始化所有的既定闹钟
	 */
	public void initClock(){
		
		String alarm = MainClock.getVaue(Constant.ALARM_CLOCK);
		String[] alarmArray = alarm.split(",");
		for (int i = 0; i < alarmArray.length; i++) {
			String[] clock = alarmArray[i].split(";");
			String name = clock[0];
			String time = clock[1];
			String pause = clock[2];
			if(pause.equals("no")){
				Thread t = new Thread(new AlarmClock(name));
				t.start();
				AlarmClockCache.setValue(name, time);
			}
		}
		
		System.err.println("系统当前闹钟： " + AlarmClockCache.map);
	}
}
