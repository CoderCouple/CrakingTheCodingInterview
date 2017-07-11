package Chapter10;

public class SparseSearch {

	public static int binarySparseSearch(String array[], String str, int lb, int ub) {

		if (lb > ub) {
			return -1;
		}

		int mid = (ub + lb) / 2;
		System.out.println(mid);

		if (array[mid].equals("")) {

			int left = mid - 1;
			int right = mid + 1;
			System.out.println(left);
			System.out.println(right);
			while (true) {
				if (left < lb && right > ub) {
					return -1;
				} else if (!array[left].equals("") && lb <= left) {
					if (array[left].equals(str)) {
						return left;
					} else if (array[left].compareToIgnoreCase(str) < 0) {
						return binarySparseSearch(array, str, left + 1, ub);
					} else {
						return binarySparseSearch(array, str, lb, left - 1);

					}
				} else if (!array[right].equals("") && right <= ub) {
					if (array[right].equals(str)) {
						return right;
					} else if (array[right].compareToIgnoreCase(str) < 0) {
						return binarySparseSearch(array, str, right + 1, ub);
					} else {
						return binarySparseSearch(array, str, lb, right - 1);

					}
				}

			}
		} else if (array[mid].equals(str)) {
			System.out.println(mid);
			return mid;
		} else if (array[mid].compareToIgnoreCase(str) < 0) {
			return binarySparseSearch(array, str, mid + 1, ub);
		} else {
			return binarySparseSearch(array, str, lb, mid - 1);
		}

	}

	public static void main(String[] args) {

		String array[] = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		String str = "ball";
		System.out.println("Output Index : " + binarySparseSearch(array, str, 0, array.length - 1));
	}

}
