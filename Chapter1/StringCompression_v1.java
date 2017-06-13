package Chapter1;

import java.util.Scanner;

public class StringCompression {

	public static String getCompressedString(String str) {
		int count = 1;
		char c = 0;
		StringBuilder compressedString = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				c = str.charAt(i);
				count++;
				System.out.println(count);
			} else {

				compressedString.append(str.charAt(i));
				compressedString.append(count);
				System.out.println(count);
				c = str.charAt(i + 1);
				count = 1;
			}
		}
		compressedString.append(c);
		compressedString.append(count);

		if (compressedString.length() >= str.length())
			return str;

		return compressedString.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string to be compressed :");
		String s1 = input.nextLine();
		System.out.println("OneAway:" + getCompressedString(s1));

	}

}
