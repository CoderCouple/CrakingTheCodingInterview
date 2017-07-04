package sortingAlgos;

public class BubbleSort {

	public static void bubbleSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
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
		bubbleSort(a);
		printArray(a);

	}

}
