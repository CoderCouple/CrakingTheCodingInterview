package Chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class StringPermutation {

	static String inputString = new String();

	public static int[] getCharacterCount(String s) {
		int array[] = new int[s.length()];
		int characterValue = 0;
		for (int i = 0; i < s.length(); i++) {
			characterValue = s.charAt(i);
			array[characterValue] = array[characterValue] + 1;
		}

		return array;
	}

	public static boolean isPermuted(String base, String perm) {

		if (base.length() != perm.length())
			return false;
		for (int i = 0; i < base.length(); i++)
			if (getCharacterCount(base)[i] != getCharacterCount(perm)[i]) {
				return false;
			}

		return true;
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
