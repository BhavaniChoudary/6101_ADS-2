import java.awt.Color;
public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture; 
	public SeamCarver(Picture picture) {
		this.picture = picture;
	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if(x == 0 || y == 0 || x == picture.width() - 1 || y == picture.height() - 1) {
			return 1000;
		}
		Color cobj1 = picture.get(x+1, y);
		Color cobj2 = picture.get(x-1, y);
		Color cobj3 = picture.get(x, y+1);
		Color cobj4 = picture.get(x, y-1);
		int re =  Math.abs(cobj1.getRed() - cobj2.getRed());
		int bl = Math.abs(cobj1.getBlue() - cobj2.getBlue());
		int gr = Math.abs(cobj1.getGreen() - cobj2.getGreen());
		int xValue = re*re + bl*bl + gr*gr;
		int re2 = Math.abs(cobj3.getRed() - cobj4.getRed());
		int bl2 = Math.abs(cobj3.getBlue() - cobj4.getBlue());
		int gr2 = Math.abs(cobj3.getGreen() - cobj4.getGreen());
		int yValue = re2*re2 + bl2*bl2 + gr2*gr2;
		return Math.sqrt(xValue + yValue);
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}