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
        
		System.out.println(inputString);
		char array [] = inputString.toCharArray();
		
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
			for (int i = 0; i < array.length-1; i++) {
				System.out.println(array[i]+" "+array[i+1]);
				if (inputString.charAt(i) == inputString.charAt(i+1))
					return false;

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
