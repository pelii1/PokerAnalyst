package test.robottest;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RobotTest {

	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		Rectangle rectangle = new Rectangle(100,100,100,200);
		Robot robot = new Robot();
		
		int index = 1;
		//long kezd = System.currentTimeMillis();
		while(index < 50) {
			
			BufferedImage image = robot.createScreenCapture(rectangle);
			BufferedImage imageGrayscale = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			BufferedImage imageBlackAndWhite = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
			BufferedImage imageGrayscale2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			BufferedImage imageGrayscale3 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			BufferedImage imageGrayscale4 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			
			for(int row = 0;row < image.getHeight() - 1;row++) {
				for(int col=0;col < image.getWidth() - 1; col++) {
					
					int p = image.getRGB(col, row);
					imageGrayscale.setRGB(col,row, p);
					
					//int a = (p>>24)&0xff;
			        int r = (p>>16)&0xff;
			        int g = (p>>8)&0xff;
			        int b = p&0xff;
			        
			        if(r + g + b > 384) {
			        	imageBlackAndWhite.setRGB(col, row, Color.BLACK.getRGB());
			        } else {
			        	imageBlackAndWhite.setRGB(col, row, Color.WHITE.getRGB());
			        }
			        
			        int rgb2 = (Math.max(Math.max(r,g),b) + Math.min(r, Math.min(g, b))) / 2;
			        imageGrayscale2.setRGB(col, row, new Color(rgb2,rgb2,rgb2).getRGB());
			        
			        int rgb3 = (r + g + b) / 3;
			        imageGrayscale3.setRGB(col, row, new Color(rgb3,rgb3,rgb3).getRGB());
			        
			             
			        int rgb4 = (int) (r * 0.21 + g * 0.72 + b * 0.07);
			        imageGrayscale4.setRGB(col, row, new Color(rgb4,rgb4,rgb4).getRGB());
				}
			}
			
			ImageIO.write(image, "PNG", new File("c:\\tmp\\" + index + ".png"));
			ImageIO.write(imageGrayscale, "PNG", new File("c:\\tmp\\" + index + "gc.png"));
			ImageIO.write(imageGrayscale2, "PNG", new File("c:\\tmp\\" + index + "gc2.png"));
			ImageIO.write(imageGrayscale3, "PNG", new File("c:\\tmp\\" + index + "gc3.png"));
			ImageIO.write(imageGrayscale4, "PNG", new File("c:\\tmp\\" + index + "gc4.png"));
			ImageIO.write(imageBlackAndWhite, "PNG", new File("c:\\tmp\\" + index + "bw.png"));
			//Thread.sleep(1000);
			index++;
		}
		
		//long vege = System.currentTimeMillis();
		
		System.out.println("RobotTest ");
	}
}
