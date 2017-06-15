package Chapter1;

import java.util.Arrays;

public class URLify {

	public static String getConvertedURL(String url, int ol) {

	//int spaceCount=(url.length()-len)/2;
	char charUrl []=url.toCharArray();
	int al=url.length();
	for(;ol>0;ol--)
		if(charUrl[ol-1]==' '){
			charUrl[al-1]='0';
			charUrl[al-2]='2';
			charUrl[al-3]='%';
			al=al-3;
			//System.out.println(Arrays.toString(charUrl));

		}
		else {charUrl[al-1]=charUrl[ol-1];
	          al--;
	          //System.out.println(Arrays.toString(charUrl));
		}
	    
	
	return new String(charUrl);
	}

	public static void main(String[] args) {
		String originalString = "Mr John Smith    ";
		System.out.println("Converted URL : "+getConvertedURL(originalString, 13));

	}

}
