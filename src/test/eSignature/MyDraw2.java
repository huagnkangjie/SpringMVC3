package test.eSignature;

import java.io.*;

import javax.imageio.ImageIO;

import java.awt.image.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D; 
public class MyDraw2 {
	
	public static final int CENTERX = 150;
   	public static final int CENTERY = 150;
	
	public static void main(String[] args) { 
		String message = "中华人民共和国";
			try
			{
				int width = 150;
				int height = 150;
				// 创建BufferedImage对象
				Font font=new Font("宋体",Font.PLAIN,16);
				BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
				// 获取Graphics2D
				Graphics2D g2d = image.createGraphics();
				// 画图
//				g2d.setBackground(new Color(255,255,255));
				g2d.setPaint(new Color(0,0,0));
				g2d.clearRect(0, 0, width, height);  
//				g2d.drawString("名称：娃哈哈纯净水",0,10);
//				g2d.drawString("产地：浙江杭州",0,26);
//				g2d.drawString("品牌：娃娃哈哈",0,42);
//				g2d.drawString("单价：9876543210",0,58);
				
				
				g2d.setColor(Color.RED);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		      
				//绘制圆
				int radius = 150;
				Ellipse2D circle = new Ellipse2D.Double();
				circle.setFrameFromCenter(CENTERX, CENTERY, CENTERX + radius, CENTERY + radius);
				g2d.draw(circle);
				
				//绘制中间的五角星
				Font starFont = new Font("宋体", Font.BOLD, 60);
				g2d.setFont(starFont);
				g2d.drawString("★", CENTERX - 60, CENTERY + 40);	
				
				//根据输入字符串得到字符数组
				String[] messages2 = message.split("",0);
				String[] messages = new String[messages2.length-1];
				System.arraycopy(messages2,1,messages,0,messages2.length-1);
				
				//输入的字数
				int ilength = messages.length;
				
				//设置字体属性
				int fontsize = 40;
				Font f = new Font("Serif", Font.BOLD, fontsize);

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
				
				if (odd)
				{
					g2d.setFont(f);
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
				g2d.setFont(font); 
				//释放对象
				g2d.dispose();
				// 保存文件    
				ImageIO.write(image, "png", new File("C://Users//Mr-H//Desktop//Jquery仿电子印章在线制作//images/test.png"));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			} 
		} 
}
