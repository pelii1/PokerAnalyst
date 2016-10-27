package hu.peli.BitMapHandling.bitmap;

import java.awt.Color;

public enum GrayscaleType {
	LIGHTNESS {
		public int convert(Color color) {
			return Math.max(color.getBlue(), Math.max(color.getGreen(), color.getRed())) + 
					Math.min(color.getBlue(), Math.min(color.getGreen(), color.getRed())) / 2;
		}
	},
	AVARAGE {
		public int convert(Color color) {
			return (color.getBlue() + color.getGreen() + color.getRed()) / 3;
		}
	},
	LUMINOSITIY {
		public int convert(Color color) {
			return (int) (color.getRed() * 0.21 + color.getGreen() * 0.72 + color.getBlue() * 0.07);
		}
	};
	
	public int convert(Color color) {
		return 0;
	}
}
