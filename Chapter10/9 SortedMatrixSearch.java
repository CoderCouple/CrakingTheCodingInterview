package Chapter10;

public class SortedMatrixSearch {

	public static String sortedMatrixSearch(int array[][], int element) {
		int rowIndex = -1;
		int columnIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] <= element && element <= array[i][array[i].length - 1]) {
				int k = binarySearch(array[i], element, 0, array[i].length - 1);
				if (!(k == -1)) {
					columnIndex = k;
					rowIndex = i;
				}
			}
		}

		return "{" + rowIndex + " , " + columnIndex + "}";
	}

	public static int binarySearch(int myArray[], int n, int startNum, int endNum) {
		if (startNum > endNum)
			return -1;

		int midNum = (startNum + endNum) / 2;

		if (n == myArray[midNum])
			return midNum;

		if (n < myArray[midNum])
			return binarySearch(myArray, n, startNum, midNum - 1);
		else
			return binarySearch(myArray, n, midNum + 1, endNum);

	}

	public static void main(String[] args) {

		// int array[][] = { { 1, 2, 3, 4}, { 5,6, 7, 8}, { 9,10,11, 12},{ 13,
		// 14, 15,16}};
		int element = 12;
		int array[][] = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };

		System.out.println("Element is at Index : " + sortedMatrixSearch(array, element));

	}

}
