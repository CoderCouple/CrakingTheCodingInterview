import java.util.Scanner;

public class isUnique {

	static String inputString = new String();

	public static boolean isUniqueString(String s) {

		inputString = s;
		if (inputString.length() == 0) {
			System.out.println("This is sn empty String..!!!");
			return true;
		}

		for (int i = 0; i < inputString.length() - 1; i++) {
			for (int j = i + 1; j < inputString.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return false;

			}
		}

		return true;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the String to be checked for the uniqueness");
		String s = input.nextLine();
		System.out.println("Unique :" + isUniqueString(s));
	}

}
