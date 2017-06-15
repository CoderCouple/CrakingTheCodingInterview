package Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class isUnique {

	static String inputString = new String();

	public static boolean isUniqueString(String s) {

		inputString = s;
		if (inputString.length() == 0) {
			System.out.println("This is sn empty String..!!!");
			return true;
		}

		if (inputString.length() > 256) {
			System.out.println("I am assuming it is an ASCII String...!!!");
			return false;
		}

		boolean charArray[] = new boolean[256];

		for (int i = 0; i < inputString.length(); i++) {
			int characterValue = inputString.charAt(i);
			if (charArray[characterValue])
				return false;
			charArray[characterValue] = true;
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
