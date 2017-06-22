package core.primitive;

public class RectangleIntersection {
	public static class Rectangle {
		int x, y, width, height;

		public Rectangle(int x, int y, int width, int height) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}

		public void print(String s) {
			System.out.println(s + x + " " + y + " " + width + " " + height);
		}
	}

	public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2) {
		if (!isIntersect(R1, R2)) {
			return new Rectangle(0, 0, -1, -1); // No intersection.
		}
		return new Rectangle(Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
				Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
				Math.min(R1.y + R1.height, R2.y + R2.height) - Math.max(R1.y, R2.y));
	}

	public static boolean isIntersect(Rectangle R1, Rectangle R2) {
		return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x && R1.y <= R2.y + R2.height
				&& R1.y + R1.height >= R2.y;
	}
}
