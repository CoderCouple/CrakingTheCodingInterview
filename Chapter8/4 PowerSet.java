package Chapter8;

public class PowerSet {

	public static void getPowerSet(int[] array, int index, String output) {

		if (index >= array.length) {
			System.out.println(output);
			return;
		}

		String str = Integer.toString(array[index]);
		getPowerSet(array, index + 1, output + str);
		getPowerSet(array, index + 1, output);
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };
		int start = 0;
		String output = "";
		getPowerSet(a, 0, output);

	}

}
