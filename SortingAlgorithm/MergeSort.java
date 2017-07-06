package sortingAlgos;

public class MergeSort {

	public static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		}

		int size = array.length;
		int mid = array.length / 2;
		int left[] = new int[mid];
		int right[] = new int[size - mid];
		int k = 0;

		for (int i = 0; i < left.length; i++) {
			left[i] = array[k];
			k++;
		}

		for (int j = 0; j < right.length; j++) {
			right[j] = array[k];
			k++;
		}

		mergeSort(left);
		mergeSort(right);
		merge(left, right, array);

	}

	public static void merge(int left[], int right[], int array[]) {
		int i, j, k;
		i = j = k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}

			k++;
		}

		while (i < left.length) {
			array[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			array[k] = right[j];
			j++;
			k++;
		}

	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 500, -5, 2, -3, 5, 100, 0 };
		mergeSort(a);
		printArray(a);

	}

}
