package Chapter1;

import java.util.Scanner;

public class PalindromePermutation {

	public static boolean isPalindrome(String s) {
		String inputString = s.replaceAll("\\s+", "");
		boolean truthCheck[] = new boolean[128];

		for (int i = 0; i < inputString.length(); i++) {
			int value = inputString.charAt(i);
			truthCheck[value] = !truthCheck[value];
		}

		int count = 0;
		for (int i = 0; i < truthCheck.length; i++) {

			if (count > 1)
				return false;

			if (truthCheck[i] == true) {
				count++;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the String to be checked for the Plindrome");
		String s = input.nextLine();
		System.out.println("Palindrome :" + isPalindrome(s));

	}

}
