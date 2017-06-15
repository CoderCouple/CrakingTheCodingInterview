package Chapter1;

import java.util.Scanner;

public class OneAway {

	public static boolean isOnwAway(String str1, String str2) {

		if (str1.length() - str2.length() > 1)
			System.out.println("Improper String..!!");

		int count = 0;
		if (str1.length() == str2.length()) {

			for (int i = 0; i < str1.length(); i++) {
				System.out.println(count);
				if (count > 1)
					return false;
				if (str1.charAt(i) != str2.charAt(i)) {
					count++;
				}

			}
			return true;
		}

		String ls;
		String ll;
		if (str1.length() > str2.length()) {
			ll = str1;
			ls = str2;
		} else {
			ls = str1;
			ll = str2;
		}

		int counter = 0;
		for (int i = 0, j = 0; i < ls.length(); i++, j++) {

			System.out.println(counter);
			if (counter > 1)
				return false;
			if (ll.charAt(j) != ls.charAt(i)) {
				j++;
				counter++;
			}

		}

		return true;

	}

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Base String");
		String s1 = input.nextLine();
		System.out.println("Enter the String to be checked");
		String s2 = input.nextLine();
		System.out.println("OneAway:" + isOnwAway(s1, s2));

	}

}
