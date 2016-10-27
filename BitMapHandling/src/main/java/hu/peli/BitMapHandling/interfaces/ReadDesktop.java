package hu.peli.BitMapHandling.interfaces;

import hu.peli.BitMapHandling.bitmap.Bitmap;
import hu.peli.BitMapHandling.exception.BitMapException;

public interface ReadDesktop {
	public Bitmap readDesktop() throws BitMapException;
}
