package Chapter8;

public class Multiply {

	public static int getMultiplication(int num1, int num2) {

		if (num2 <= 0) {
			return 0;
		}

		return num1 + getMultiplication(num1, num2 - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getMultiplication(7, 7));

	}

}
