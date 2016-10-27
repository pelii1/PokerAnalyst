package hu.peli.BitMapHandling.bitmap;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import lombok.Getter;

@Getter
public class Bitmap {
	private BufferedImage image;
	
	public Bitmap(BufferedImage image) {
		this.image = image;
	}
	
	public Bitmap getRectangle(Rectangle rectangle) {
		return new Bitmap(image.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
	}
	
	public Bitmap convertBitmapToGrayscale(GrayscaleType grayscaleType) {
		BufferedImage resultImage = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		
		for(int row=0;row<image.getHeight();row++) {
			for(int col = 0;col<image.getWidth();col++) {
				resultImage.setRGB(col,row, grayscaleType.convert(new Color(image.getRGB(col,row))));
			}
		}
		return new Bitmap(resultImage);
	}
}
