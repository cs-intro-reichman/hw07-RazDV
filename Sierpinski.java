/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) { //n=0 is the base triangle. n is the time of steps
		// Configure canvas and coordinate system (0..100 keeps arithmetic simple).
		StdDraw.setCanvasSize();
		StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);

		// Equilateral triangle centered at (50, 50) with side length 80.
		double length = 80.0;
		double height = (length * Math.sqrt(3)) / 2.0;
		double centerX = 50.0;
		double centerY = 50.0;

		double xLeft = centerX - (length / 2.0);
		double yLeft = centerY - (height / 2.0);
		double xTop = centerX;
		double yTop = centerY + (height / 2.0);
		double xRight = centerX + (length / 2.0);
		double yRight = centerY - (height / 2.0);

		// Draw the fractal starting from the outer triangle.
		sierpinski(Math.max(0, n), xLeft, xTop, xRight, yLeft, yTop, yRight);
	}
	// height of equilateral triangles (each _ is x) is (3^0.5)*x/2
	//center of the canvas = center(x0,y0)
	// go down half h
	//go left 1 
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			double[] xs = { x1, x2, x3 };
			double[] ys = { y1, y2, y3 };
			StdDraw.polygon(xs, ys);
			return;
		}

		// Midpoints of each edge define the 3 sub-triangles.
		double x12 = (x1 + x2) / 2.0;
		double y12 = (y1 + y2) / 2.0;
		double x23 = (x2 + x3) / 2.0;
		double y23 = (y2 + y3) / 2.0;
		double x31 = (x3 + x1) / 2.0;
		double y31 = (y3 + y1) / 2.0;

		// Recurse on the three corner triangles (leave the center white).
		sierpinski(n - 1, x1, x12, x31, y1, y12, y31);
		sierpinski(n - 1, x12, x2, x23, y12, y2, y23);
		sierpinski(n - 1, x31, x23, x3, y31, y23, y3);
	}
}
