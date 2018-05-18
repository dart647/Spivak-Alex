package lab5;
import java.awt.geom.Rectangle2D;


	public class Mandelbrot extends FractalGenerator {
		public static final int MAX_ITERATIONS = 2000;

		public void getInitialRange(Rectangle2D.Double range) {
			range.x = -2;
			range.y = -1.5;
			range.width = 3;
			range.height = 3;
		}


    public int numIterations(double x, double y) {
		int count = 0;
		double real = 0,image = 0,z2 = 0;

		while (count < MAX_ITERATIONS && z2 < 4) {
			count++;
			double nextRe = Math.pow(real, 2) - Math.pow(image, 2) + x;
			double nextIm = 2 * real * image + y;
			z2 = Math.pow(nextRe, 2) + Math.pow(nextIm, 2);
			real = nextRe;
			image = nextIm;
		}

		return count < MAX_ITERATIONS ? count : -1;
    }
}