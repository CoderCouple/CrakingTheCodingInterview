package sortingAlgos;

public class InsertionSort {

	public static void InsertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int element = array[i];
			int elementIndex = i;

			while (elementIndex > 0) {
				if (element < array[elementIndex - 1]) {
					array[elementIndex] = array[elementIndex - 1];
					array[elementIndex - 1] = element;
				}
				elementIndex--;
			}

		}

	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 500, -5, 2, -3, 5, 100, 0 };
		InsertionSort(a);
		printArray(a);

	}

}
