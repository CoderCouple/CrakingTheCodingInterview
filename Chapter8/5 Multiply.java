package Chapter8;

public class Multiply {

	public static int getMultiplication(int num1, int num2) {
		int b=num1>num2 ? num1 : num2;
		int s=num1<num2 ? num1 : num2;
		
		if (s <= 0) {
			return 0;
		}

		return b + getMultiplication(b, s-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getMultiplication(7, 3));

	}

}
