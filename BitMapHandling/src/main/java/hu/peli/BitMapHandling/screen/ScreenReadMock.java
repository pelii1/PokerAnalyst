package hu.peli.BitMapHandling.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import hu.peli.BitMapHandling.bitmap.Bitmap;
import hu.peli.BitMapHandling.exception.BitMapException;
import hu.peli.BitMapHandling.interfaces.ReadDesktop;

public class ScreenReadMock implements ReadDesktop {
	private static int desktopId = 0;
	private Path inputDirectory;
	
	public Bitmap readDesktop() throws BitMapException {
		Bitmap bitMap = null;
		try {
			bitMap = new Bitmap(ImageIO.read(getNextFilePath()));
		} catch (IOException e) {
			throw new BitMapException();
		}
		
		return bitMap;
	}
	
	public ScreenReadMock(Path inputDirectory) {
		this.inputDirectory = inputDirectory;
	}
	
	public static void initDesktopId() {
		desktopId = 0;
	}
	
	public File getNextFilePath() {
		ScreenReadMock.desktopId++;
		return Paths.get(inputDirectory + "\\asztal" + desktopId + ".png").toFile();
	}

}
