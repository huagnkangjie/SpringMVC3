package test.video;

import java.io.IOException;

/***
 * 
 * 得到第一秒（也是第一帧）图片
 */
public class VideoFirstThumbTaker extends VideoThumbTaker
{
    public VideoFirstThumbTaker(String ffmpegApp)
    {
        super(ffmpegApp);
    }

    public void getThumb(String videoFilename, String thumbFilename, int width,
            int height) throws IOException, InterruptedException
    {
        super.getThumb(videoFilename, thumbFilename, width, height, 0, 0, 1);
    }
    
    public static void main(String[] args) {
    	VideoFirstThumbTaker videoThumbTaker = new VideoFirstThumbTaker("G:\\c\\1\\ffmpeg.exe");
         try
         {
             videoThumbTaker.getThumb("G:\\c\\1\\mp42.mp4", "G:\\c\\1\\thumbTestFirst.png",    800, 600);
             System.out.println("over");
         } catch (Exception e)
         {
             e.printStackTrace();
         }
	}
}
