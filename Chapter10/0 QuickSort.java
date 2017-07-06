package sortingAlgos;

public class QuickSort {

	public static void quickSort(int start, int end, int array[]) {
		if (start < end) {

			int PIndex = getPartition(start, end, array);
			// System.out.println("PIndex :"+PIndex);
			quickSort(start, PIndex - 1, array);
			quickSort(PIndex + 1, end, array);
		}

	}

	public static int getPartition(int start, int end, int array[]) {

		int pivot = array[end];
		int partitionIndex = start;
		//System.out.println(partitionIndex);

		for (int i = start; i <= end - 1; i++) {
			if (array[i] <= pivot) {
				int temp = array[i];
				//System.out.println(partitionIndex);
				array[i] = array[partitionIndex];
				array[partitionIndex] = temp;
				partitionIndex++;
			}
		}

		int temp = array[partitionIndex];
		array[partitionIndex] = array[end];
		array[end] = temp;
		return partitionIndex;
	}

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int a[] = { 500, -5, 2, -3, 5, 100, 0 };
		quickSort(0, a.length - 1, a);
		printArray(a);

	}

}
