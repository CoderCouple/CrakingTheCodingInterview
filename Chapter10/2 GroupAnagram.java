package Chapter10;

import java.util.Arrays;

public class GroupAnagram {

	public static String[] getAnagramGroups(String in[]) throws Exception {
		if (in.length < 1)
			throw new Exception("Not a valid Input");

		String[] output = new String[in.length];
		int k = -1;

		for (int i = 0; i < in.length - 1; i++) {
			if (!in[i].equals("-1"))
				output[++k] = in[i];
			for (int j = i + 1; j < in.length; j++) {
				if (getSortedString(in[i]).equals(getSortedString(in[j]))
						&& (!in[i].equals("-1") || !in[j].equals("-1"))) {
					output[++k] = in[j];
					in[j] = "-1";

				}
			}
		}
		return output;

	}

	public static String getSortedString(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static void printArray(String[] array) {

		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) throws Exception {
		String input[] = { "pqr", "qrp", "cb", "a", "mno", "xyz", "a", "bc", "abc", "bca", "cab", "rpq", "xyz" };
		String[] output = getAnagramGroups(input);
		printArray(output);

	}

}
