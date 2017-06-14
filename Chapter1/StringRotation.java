package Chapter1;

import java.util.Scanner;

public class StringRotation {

	public static boolean isRotatedString(String str1, String str2) {

		str1 = str1 + str1;
		if (str1.contains(str2)) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the original String :");
		String s1 = input.nextLine();

		System.out.println("Enter the rotated String :");
		String s2 = input.nextLine();

		System.out.println("Is this string rotated :" + isRotatedString(s1, s2));
	}

}
