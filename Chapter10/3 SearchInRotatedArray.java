//package Chapter10;
//
//public class SearchInRotatedArray {
//
//	public static int SearchInRotatedArray(int element, int[] array, int lb, int ub) {
//
//		if (lb > ub)
//			return -1;
//
//		// System.out.println("*");
//		int mid = (lb + ub) / 2;
//		// System.out.println(array[mid]);
//
//		if (array[mid] == element) {
//			return mid;
//		} else if (array[lb] < array[mid]) {
//			if (array[lb] <= element && element < array[mid]) {
//				return SearchInRotatedArray(element, array, lb, mid - 1);
//			} else {
//				return SearchInRotatedArray(element, array, mid + 1, ub);
//			}
//		} else if (array[ub] > array[mid]) {
//			if (array[mid] < element && element <= array[ub]) {
//				return SearchInRotatedArray(element, array, mid + 1, ub);
//			} else {
//				return SearchInRotatedArray(element, array, lb, mid - 1);
//			}
//		}
//		if (array[lb] == array[mid]) {
//			if (array[mid] != array[ub]) {
//				return SearchInRotatedArray(element, array, mid + 1, ub);
//			} else {
//				int result = SearchInRotatedArray(element, array, lb, mid - 1);
//				if (result == -1) {
//					return SearchInRotatedArray(element, array, mid + 1, ub);
//				} else {
//					return result;
//				}
//			}
//		}
//
//		return -1;
//	}
//
//	public static void main(String[] args) {
//		int element = 5;
//		int array[] = { 15, 16, 19, 20, 25,1, 3, 4, 5, 7, 10, 14 };
//		System.out.println(
//				"Element " + element + " at index : " + SearchInRotatedArray(element, array, 0, array.length - 1));
//	}
//
//}
