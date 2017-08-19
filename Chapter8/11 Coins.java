package Chapter8;

import java.util.HashMap;
import java.util.Map;

public class Coins {

	public static int dn1 = 1;
	public static int dn5 = 5;
	public static int dn10 = 10;
	public static int dn25 = 25;

	public static void getPossibleDenominations(int n, Map<String, Integer> map, int c1, int c5, int c10, int c25) {

		if (n == 0) {
			map.put(Integer.toString(c1 + c5 + c10 + c25), c1 + c5 + c10 + c25);
			return;
		}

		if (n < 0)
			return;

		getPossibleDenominations(n - dn1, map, c1 + 1, c5, c10, c25);
		getPossibleDenominations(n - dn5, map, c1, c5 + 1, c10, c25);
		getPossibleDenominations(n - dn10, map, c1, c5, c10 + 1, c25);
		getPossibleDenominations(n - dn25, map, c1, c5, c10, c25 + 1);

	}

	public static void main(String[] args) {
		int money = 50;
		Map<String, Integer> map = new HashMap<String, Integer>();
		getPossibleDenominations(money, map, 0, 0, 0, 0);
		System.out.println(map.size());
		

	}

}
