package test.alarmclock;

import org.springframework.util.StringUtils;

/**
 * 仿照小米的闹钟的功能
 * 
 * 1、定时间闹钟响
 * 2、可以设置闹钟的延时时间 比如：响了以后可以定时5分钟后再响
 * 3、可以关闭
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月3日
 * 
 */
public class AlarmClock implements Runnable{
	
	private String name;
	
	public AlarmClock (String name) {
		this.name = name;
	}
	

	@Override
	public void run() {
		System.out.println("闹钟【"+name+"】启动");
		while(true){
			String time = TimeUtil.getDate();
			String alarmTime = (String)AlarmClockCache.getVlaue(name);
			System.out.println("当前时间【"+time+"】,闹钟时间【"+alarmTime+"】");
			if(time.equals(alarmTime)){
				System.err.println("闹铃【"+name+"】时间到了");
				AlarmClockCache.mapDel.put(name, name);
				int i = 1;
				while(true){
					if(StringUtils.isEmpty(AlarmClockCache.mapDel.get(name))){
						break;
					}
					System.err.println("闹钟【"+name+"】叫你起床了！！！！");
					i++;
					if(i == 10){
						AlarmClockCache.mapDel.remove(name);
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}

	
}
