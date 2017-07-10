package Chapter10;

public class SortedSearchNoSize {

	public static int elementAt(int index) {
		int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10, 11, 11, 12, 13, 14, 15 };
		if (index > array.length - 1)
			return -1;

		return array[index];

	}

	public static int SortedSearchNoSize(int element, int array[], int searchFactor) {

		if (array.length <= 0) {
			return -1;
		}

		if (array[0] == element) {
			return 0;
		}

		int searchStartRange = searchFactor / 2;
		int searchEndRange = searchFactor;
		System.out.println(array[searchStartRange]);
		System.out.println(array[searchEndRange]);
		System.out.println(" * ");

		if (array[searchStartRange] <= element && element < array[searchEndRange]) {
			binarySearch(element, array, searchStartRange, searchEndRange);
		} else {
			if (elementAt(searchFactor * 2) != -1) {
				return SortedSearchNoSize(element, array, searchFactor * 2);
			} else {
				int x = searchFactor;
				while (elementAt(x) != -1) {

					if (array[x] == element)
						return x;
					else {
						x++;
					}
				}
			}
		}

		return -1;
	}

	public static int binarySearch(int element, int array[], int lb, int ub) {

		if (lb > ub) {
			return -1;
		}

		int mid = (ub + lb) / 2;

		if (array[mid] == element) {
			return mid;
		} else if (element < array[mid]) {
			binarySearch(element, array, lb, mid - 1);
		} else {
			binarySearch(element, array, mid + 1, ub);
		}

		return -1;
	}

	public static void main(String[] args) {
		int element = 13;
		int searchFactor = 2;
		int array[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 8, 9, 10, 11, 11, 12, 13, 14, 15 };
		System.out.println("Element at index :" + SortedSearchNoSize(element, array, 2));

	}

}
