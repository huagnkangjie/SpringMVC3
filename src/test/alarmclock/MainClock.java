package test.alarmclock;

import java.io.IOException;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

/**
 * 主要的闹钟控制类
 * 
 * 用于创建、
 *
 * @author 作者 : huang_kangjie
 * @version 创建时间：2017年3月3日
 * 
 */
public class MainClock implements Runnable{
	
	private boolean flag;
	
	public MainClock(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		while (flag) {
			
//			System.out.println("主线程： 执行任务！");
			
			this.checkAlarmClock();//true ： 继续执行; false: 关闭现在还在执行的闹钟任务
			this.checkAlarmClockDel();//判断是否有删除的
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 获取属性的值
	 * @param key
	 * @return
	 */
	public static String getVaue(String key){
		try {
			return PropertiesLoaderUtils.loadAllProperties(Constant.ALARM_CLOCK_PROPERTISE).getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 判断当前的状态，暂停还是继续
	 * 如果暂停，则把所有的闹钟都暂停
	 */
	public void checkAlarmClock(){
		String openFlag = MainClock.getVaue(Constant.ALARM_OPEN);
		if(openFlag.equals("false")){
			//把所有的线程全部调为暂停状态
		}
	}
	
	/**
	 * 删除已存在的线程
	 */
	public void checkAlarmClockDel(){
		String delFlag = MainClock.getVaue(Constant.ALARM_DEL);
		if(!StringUtils.isEmpty(delFlag)){
			//删除对应的闹钟
		}
	}

	
}
