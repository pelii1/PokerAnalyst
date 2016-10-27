package hu.peli.BitMapHandling.bitmap;

import static org.junit.Assert.fail;

import java.nio.file.Paths;

import org.junit.Test;

import hu.peli.BitMapHandling.exception.BitMapException;
import hu.peli.BitMapHandling.interfaces.ReadDesktop;
import hu.peli.BitMapHandling.screen.ScreenFactory;

public class BitmapTest {
	private final String inputDirectory = "";
	
	@Test
	public void test() throws BitMapException {
		ReadDesktop readDesktop = ScreenFactory.createScreenReadMock(Paths.get(inputDirectory));
		
		Bitmap testObj = readDesktop.readDesktop();
		Bitmap avarageGrayScale = testObj.convertBitmapToGrayscale(GrayscaleType.AVARAGE);
		
		
		
		fail("Not yet implemented");
	}

}
