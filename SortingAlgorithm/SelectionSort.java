package sortingAlgos;

class SelectionSort {

	public static void selectionSort(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) {
			int min = array[i];
			int minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < min) {
					min = array[j];
					minIndex = j;
				}
			}

			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}

	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 500, -5, 2, -3, 5, 100, 0 };
		selectionSort(a);
		printArray(a);

	}

}
