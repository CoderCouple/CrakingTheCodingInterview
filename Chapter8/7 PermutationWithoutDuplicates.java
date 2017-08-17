package Chapter8;

import java.util.List;
import java.util.ArrayList;

public class PermutationWithoutDuplicates {

	public static void getPermutationOfString(String str, int index, int length, List<String> output) {

		if (index == length)
			output.add(str);

		else {
			for (int j = index; j < length; j++) {
				str = swap(str, j, index);
				getPermutationOfString(str, index + 1, length, output);
				str = swap(str, index, j);
			}
		}

	}

	public static String swap(String str, int startIndex, int endIndex) {
		StringBuilder sb = new StringBuilder(str);
		char ch = sb.charAt(startIndex);
		sb.setCharAt(startIndex, sb.charAt(endIndex));
		sb.setCharAt(endIndex, ch);
		return sb.toString();

	}

	public static void main(String[] args) {
		String input = "MAN";
		List<String> output = new ArrayList<String>();
		getPermutationOfString(input, 0, input.length(), output);
		System.out.println(output);
	}

}
