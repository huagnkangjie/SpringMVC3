package test.video;

import java.util.Random;

public class ImgThread implements Runnable{
	private int name ;

	public ImgThread(int name){
		this.name = name;
	}
	
	@Override
	public void run() {
		VideoFirstThumbTaker videoThumbTaker = new VideoFirstThumbTaker("D:\\c\\1\\ffmpeg.exe");
        try
        {
            videoThumbTaker.getThumb("D:\\c\\1\\mp42.mp4", "D:\\c\\1\\"+name+".png",    800, 600);
            System.out.println("第" + name + "张图片 OK");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		ImgThread t = new ImgThread(1);
		new Thread(t).start();
		ImgThread t2 = new ImgThread(2);
		new Thread(t2).start();
		ImgThread t3 = new ImgThread(3);
		new Thread(t3).start();
	}
}
