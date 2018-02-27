package test.eSignature;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.common.util.StringUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;

public class MyDraw3 {
	
	public static void main(String[] args) throws IOException {
		MyDraw3.transparentImage("C://Users//Mr-H//Desktop//1//test.jpg", "C://Users//Mr-H//Desktop//1//test2.jpg", 
				100, "png");
		new MyDraw3().createPng();

	}

	/**
	* 设置源图片为背景透明，并设置透明度
	* @param srcFile 源图片
	* @param desFile 目标文件
	* @param alpha 透明度
	* @param formatName 文件格式
	* @throws IOException
	*/
	public static void transparentImage(String srcFile,String desFile,int alpha,String formatName) throws IOException{
	    BufferedImage temp =  ImageIO.read(new File(srcFile));//取得图片
	        transparentImage(temp, desFile, alpha, formatName);
	    }
	/**
	* 设置源图片为背景透明，并设置透明度
	* @param srcImage 源图片
	* @param desFile 目标文件
	* @param alpha 透明度
	* @param formatName 文件格式
	* @throws IOException
	*/
	public static void transparentImage(BufferedImage srcImage,
	String desFile, int alpha, String formatName) throws IOException {
	int imgHeight = srcImage.getHeight();//取得图片的长和宽
	        int imgWidth = srcImage.getWidth();
	        int c = srcImage.getRGB(3, 3);
	        //防止越位
	        if (alpha < 0) {
	            alpha = 0;
	         } else if (alpha > 10) {
	            alpha = 10;
	         }
	        BufferedImage bi = new BufferedImage(imgWidth, imgHeight,
	                BufferedImage.TYPE_4BYTE_ABGR);//新建一个类型支持透明的BufferedImage
	        for(int i = 0; i < imgWidth; ++i)//把原图片的内容复制到新的图片，同时把背景设为透明
	        {
	            for(int j = 0; j < imgHeight; ++j)
	            {
	            //把背景设为透明
	                if(srcImage.getRGB(i, j) == c){
	                    bi.setRGB(i, j, c & 0x00ffffff);
	                }
	                //设置透明度
	                else{
	                int rgb = bi.getRGB(i, j);
	                    rgb = ((alpha * 255 / 10) << 24) | (rgb & 0x00ffffff);
	                    bi.setRGB(i, j, rgb);
	                }
	            }
	        }
	ImageIO.write(bi, StringUtil.isEmpty(formatName)?"png":formatName, new File(desFile));
	}
	
	
	public void createPng() throws IOException{
		int width = 400;
		int height = 300;
		// 创建BufferedImage对象
		BufferedImage image = new BufferedImage(width, height,     BufferedImage.TYPE_INT_RGB);
		// 获取Graphics2D
		Graphics2D g2d = image.createGraphics();

		// ----------  增加下面的代码使得背景透明  -----------------
		image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = image.createGraphics();
		// ----------  背景透明代码结束  -----------------


		// 画图
		g2d.setColor(new Color(255,0,0));
		g2d.setStroke(new BasicStroke(1));
		g2d.drawString("按时打发第三方阿斯蒂芬爱上的范范阿斯蒂芬阿斯蒂芬阿斯蒂芬大师傅阿萨德法师打发阿斯蒂芬", 0, 10);
		//释放对象
		g2d.dispose();
		// 保存文件    
		ImageIO.write(image, "png", new File("F:/test.png"));
		
	}
}
