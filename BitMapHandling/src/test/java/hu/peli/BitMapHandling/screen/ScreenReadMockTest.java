package hu.peli.BitMapHandling.screen;

import java.nio.file.Paths;

import org.junit.Test;

import junit.framework.TestCase;

public class ScreenReadMockTest extends TestCase {
	private String filePath = System.getProperty("user.dir") + "\\..\\datas\\desktopimages\\";
	
	@Test
	public void test() {
		System.out.println(filePath);
		ScreenReadMock testObj = (ScreenReadMock) ScreenFactory.
				createScreenReadMock(Paths.get(filePath));
		
		assertEquals(testObj.getNextFilePath().getName(),"asztal1.png");
		assertEquals(testObj.getNextFilePath().getName(),"asztal2.png");
		
		ScreenReadMock.initDesktopId();
		assertEquals(testObj.getNextFilePath().getName(),"asztal1.png");
	}
}
