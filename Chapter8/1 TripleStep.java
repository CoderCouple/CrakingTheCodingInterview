package Chapter8;

public class TripleStep {

	public static int getTripleStepPermutation(int n) {

		if (n == 0)
			return 1;
		else if (n < 0)
			return 0;
		else
			return getTripleStepPermutation(n - 1) + getTripleStepPermutation(n - 2) + getTripleStepPermutation(n - 3);

	}

	public static void main(String[] args) {

		System.out.println(getTripleStepPermutation(3));

	}

}
