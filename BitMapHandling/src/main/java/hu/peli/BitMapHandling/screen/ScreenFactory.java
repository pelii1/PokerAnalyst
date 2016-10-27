package hu.peli.BitMapHandling.screen;

import java.nio.file.Path;

import hu.peli.BitMapHandling.interfaces.ReadDesktop;

public class ScreenFactory {
	
	public static ReadDesktop createScreenRead() {
		return new ScreenRead();
	}
	//c:\develop\workspace\PokerAnalyst\datas\desktopimages\.. 
	public static ReadDesktop createScreenReadMock(Path inputDirectory) {
		return new ScreenReadMock(inputDirectory);
	}

}
