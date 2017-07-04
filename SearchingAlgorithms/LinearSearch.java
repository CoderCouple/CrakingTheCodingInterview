
public class LinearSearch {

	public static int linearSearch(int array[], int element) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int array[] = { 50, 91, 32, -3, 800, -5, 1, 0 };
		System.out.println("Element index is :" + linearSearch(array, 0));

	}

}
