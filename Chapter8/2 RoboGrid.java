package Chapter8;

public class RoboGrid {

	public static int getRoboGridWays(int r, int c) {

		if (r < 0 || c < 0) {
			return 0;
		} else if (r == 1 && c == 1)
			return 1;

		return getRoboGridWays(r - 1, c) + getRoboGridWays(r, c - 1);
	}

	public static void main(String[] args) {

		System.out.println("No of ways :" + getRoboGridWays(3, 3));

	}

}
