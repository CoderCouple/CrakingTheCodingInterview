package Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class StringPermutation {

	static String inputString = new String();

	public static boolean isPermuted(String base, String perm) {

		if (base.length() != perm.length())
			return false;

		char charArray1[] = base.toCharArray();
		char charArray2[] = perm.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);

		String s1 = new String(charArray1);
		String s2 = new String(charArray2);

		if (s1.equals(s2))
			return true;

		return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Base String :");
		String base = input.nextLine();
		System.out.println("Enter the permutated String :");
		String perm = input.nextLine();

		System.out.println("Is Permutation :" + isPermuted(base, perm));
	}

}
