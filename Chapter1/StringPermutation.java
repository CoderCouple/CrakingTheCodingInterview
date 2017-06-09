import java.util.Scanner;

public class StringPermutation {

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

	public static boolean isPermuted(String base, String perm) {
		int count = 0;
		if (isUniqueString(perm)) {

		
		for (int i = 0; i < base.length(); i++) {
			for (int j = 0; j < perm.length(); j++) {
				if (base.charAt(i) == perm.charAt(j))
					count++;

			}

		}
		}
		else {System.out.println("Not a unique String...!!!");}
		
		if (count == perm.length())
			return true;
		return false;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Base String :");
		String base = input.nextLine();
		System.out.println("Enter the permutated String :");
		String perm = input.nextLine();

		System.out.println("Is Permutation :" + isPermuted(base,perm));
	}

}
