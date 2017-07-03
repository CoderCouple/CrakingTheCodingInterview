package Chapter8;

public class MagicIndex {

	public static int getMagicIndex(int array[], int lb, int ub) {

		if (ub < lb) {
			return -1;
		}

		int mid = (ub + lb) / 2;
		if (array[mid] == mid)
			return mid;
		else if (array[mid] >= mid)
			return getMagicIndex(array, lb, mid - 1);
		else
			return getMagicIndex(array, mid + 1, ub);
	

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -5, -2, -1, 1, 2, 5 };
		System.out.println("magic Index is :" + getMagicIndex(a, 0, a.length - 1));

	}

}
