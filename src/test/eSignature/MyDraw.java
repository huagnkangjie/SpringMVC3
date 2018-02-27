package test.eSignature;

import java.io.*;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D; 

/**
 * 电子签章
 * @author Mr-H
 *
 */
public class MyDraw {
	
	public static final int CENTERX = 150;
   	public static final int CENTERY = 150;
	
	public static void main(String[] args) { 
		String message = "13-135专用章";
			try
			{
				int width = 300;
				int height = 300;
				//设置字体属性
				int fontsize = 40;
				
				// 创建BufferedImage对象
				BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
				// 获取Graphics2D
				Graphics2D g2d = image.createGraphics();
				
				
				// 画图
//				g2d.setBackground(new Color(255,255,255));
//				g2d.setPaint(new Color(0,0,0));
//				g2d.clearRect(0, 0, width, height);  
//				g2d.setColor(Color.RED);
//				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				
				
				// ----------  增加下面的代码使得背景透明  -----------------
				image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
				g2d.dispose();
				g2d = image.createGraphics();
				// ----------  背景透明代码结束  -----------------
				
				// 画图
				Font f = new Font("宋体", Font.BOLD, fontsize);
				g2d.setFont(f);
				g2d.setColor(new Color(255,0,0));
				g2d.setStroke(new BasicStroke(1));
		      
				//绘制圆
				int radius = 150;
				for (int i = 0; i < 5; i++) {
					Ellipse2D circle = new Ellipse2D.Double();
					circle.setFrameFromCenter(CENTERX, CENTERY, CENTERX + radius, CENTERY + radius);
					g2d.draw(circle);
					radius--;
				}
				
				//绘制中间的五角星
				Font starFont = new Font("宋体", Font.BOLD, 120);
				g2d.setFont(starFont);
				g2d.drawString("★", CENTERX - 60, CENTERY + 40);	
				
				//根据输入字符串得到字符数组
				String[] messages2 = message.split("",0);
				String[] messages = new String[messages2.length-1];
				System.arraycopy(messages2,1,messages,0,messages2.length-1);
				
				//输入的字数
				int ilength = messages.length;

				FontRenderContext context = g2d.getFontRenderContext();
				Rectangle2D bounds = f.getStringBounds(message, context);
				
				//字符宽度＝字符串长度/字符数
				double char_interval = (bounds.getWidth() / ilength);
				//上坡度
				double ascent = -bounds.getY();

				int first = 0,second = 0;
				boolean odd = false;
				if (ilength%2 == 1)
				{
					first = (ilength-1)/2;
					odd = true;
				}
				else
				{
					first = (ilength)/2-1;
					second = (ilength)/2;
					odd = false;
				}
				
				double radius2 = radius - ascent;
				double x0 = CENTERX;
				double y0 = CENTERY - radius + ascent;
				//旋转角度
				double a = 2*Math.asin(char_interval/(2*radius2));
				
				//重新设置字体
				g2d.setFont(f);
				//签章横排字体
				//g2d.drawString("135专用",80,260);
				
				if (odd)
				{
					g2d.drawString(messages[first], (float)(x0 - char_interval/2), (float)y0);
					
					//中心点的右边
					for (int i=first+1;i<ilength;i++)
					{
						double aa = (i - first) * a;
						double ax = radius2 * Math.sin(aa);
						double ay = radius2 - radius2 * Math.cos(aa);
						AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
						Font f2 = f.deriveFont(transform);
						g2d.setFont(f2);
						g2d.drawString(messages[i], (float)(x0 + ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay - char_interval/2* Math.sin(aa)));
					}
					//中心点的左边
					for (int i=first-1;i>-1;i--)
					{
						double aa = (first - i) * a;
						double ax = radius2 * Math.sin(aa);
						double ay = radius2 - radius2 * Math.cos(aa);
						AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
						Font f2 = f.deriveFont(transform);
						g2d.setFont(f2);
						g2d.drawString(messages[i], (float)(x0 - ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay + char_interval/2* Math.sin(aa)));
					}
					
				}
				else
				{
					//中心点的右边
					for (int i=second;i<ilength;i++)
					{
						double aa = (i - second + 0.5) * a;
						double ax = radius2 * Math.sin(aa);
						double ay = radius2 - radius2 * Math.cos(aa);
						AffineTransform transform = AffineTransform.getRotateInstance(aa);//,x0 + ax, y0 + ay);
						Font f2 = f.deriveFont(transform);
						g2d.setFont(f2);
						g2d.drawString(messages[i], (float)(x0 + ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay - char_interval/2* Math.sin(aa)));
					}
					
					//中心点的左边
					for (int i=first;i>-1;i--)
					{
						double aa = (first - i + 0.5) * a;
						double ax = radius2 * Math.sin(aa);
						double ay = radius2 - radius2 * Math.cos(aa);
						AffineTransform transform = AffineTransform.getRotateInstance(-aa);//,x0 + ax, y0 + ay);
						Font f2 = f.deriveFont(transform);
						g2d.setFont(f2);
						g2d.drawString(messages[i], (float)(x0 - ax - char_interval/2* Math.cos(aa)), (float)(y0 + ay + char_interval/2* Math.sin(aa)));
					}
				}
				//释放对象
				g2d.dispose();
				// 保存文件    
				ImageIO.write(image, "png", new File("C://Users//Mr-H//Desktop//1//test.jpg"));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			} 
		} 
	
	
}
