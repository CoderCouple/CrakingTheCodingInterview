package Chapter10;

public class SortedMerge {

	public static int[] mergeSortedArrays(int large[], int small[]) {
		int i = large.length - small.length-1;
		int j = small.length-1;
		int k = large.length-1;
		while (j >= 0) {
			if (large[i] >= small[j]) {
				large[k] = large[i];
				i--;
			} else {
				large[k] = small[j];
				j--;
			}
			k--;
		}

		return large;
	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {

		int large[] = { -55, -9, 0, 5, 100, 200, 500, 0, 0, 0, 0, 0 };
		int small[] = { -30, 30, 31, 300, 900 };
		mergeSortedArrays(large, small);
		printArray(large);

	}

}
