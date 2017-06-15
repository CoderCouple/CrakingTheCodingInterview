package Chapter1;

import java.util.Arrays;

public class URLify {

	public static char[] getConvertedURL(char url[], int len) {

		for (int i = 0; i < url.length; i++)
			if (url[i] == " ".charAt(0)) {
				System.arraycopy(url, i + 1, url, i + 3, url.length - 3 - i);
				url[i] = '%';
				url[i + 1] = '2';
				url[i + 2] = '0';

			}

		return url;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String originalString = "Mr John Smith    ";
		//String truncatedString = originalString.trim();
		char output []=getConvertedURL(originalString.toCharArray(), 13);
		System.out.println("Converted URL : "+Arrays.toString(output));

	}

}
