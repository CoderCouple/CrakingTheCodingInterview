package Chapter8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parenthesis {

	public static Set<String> generateValidParenthesis(int n) {
		Set<String> set = new HashSet<String>();
		if (n == 0)
			set.add("");
		else {
			Set<String> prev=generateValidParenthesis(n - 1);
			for (String str : prev) {
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '(') {
						String s=insertAfterIndex(str,i);
						set.add(s);
					}
				}
				set.add("()"+str);
			}
		}

		return set;
	}

	public static String insertAfterIndex(String str,int index){
		StringBuilder sb = new StringBuilder(str);
		sb.insert(index+1, "()");
		return sb.toString();
	}

	public static void main(String[] args) {
		int number = 2;
		Set<String> result=generateValidParenthesis(number);
		System.out.println(result);

	}

}
