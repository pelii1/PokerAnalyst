package test.robottest;

import java.awt.AWTException;
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
		while(index < 50) {
			BufferedImage image = robot.createScreenCapture(rectangle);
			ImageIO.write(image, "BMP", new File("c:\\tmp\\" + index + ".bmp"));
			Thread.sleep(1000);
			index++;
		}
		
		System.out.println("RobotTest");
	}

}
