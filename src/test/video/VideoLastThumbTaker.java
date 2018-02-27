package test.video;

import java.io.IOException;
/**
 * 获取最后一帧托片
 * @author Mr-H
 *
 */
public class VideoLastThumbTaker extends VideoThumbTaker
{
    public VideoLastThumbTaker(String ffmpegApp)
    {
        super(ffmpegApp);
    }

    public void getThumb(String videoFilename, String thumbFilename, int width,
            int height) throws IOException, InterruptedException
    {
        VideoInfo videoInfo = new VideoInfo(ffmpegApp);
        videoInfo.getInfo(videoFilename);
        super.getThumb(videoFilename, thumbFilename, width, height,
                videoInfo.getHours(), videoInfo.getMinutes(),
                videoInfo.getSeconds() - 1f);
    }
    
    public static void main(String[] args) {
    	VideoLastThumbTaker videoThumbTaker = new VideoLastThumbTaker("D:\\c\\1\\ffmpeg.exe");
         try
         {
             videoThumbTaker.getThumb("D:\\c\\1\\mp42.mp4", "D:\\c\\1\\thumbTestLast.png",    800, 600);
             System.out.println("over");
         } catch (Exception e)
         {
             e.printStackTrace();
         }
	}
}