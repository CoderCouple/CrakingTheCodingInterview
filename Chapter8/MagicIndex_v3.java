package Chapter8;

public class MagicIndex3 {

	public static int getMagicIndex(int array[], int lb, int ub) {
		int mid = (lb + ub) / 2;

		if (lb > ub)
			return -1;

		if (array[mid] == mid)
			return mid;
		else if (array[mid] < mid)
			return getMagicIndex(array, mid + 1, ub);
		else
			return getMagicIndex(array, lb, mid - 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -5, -2, -1, 1, 2, 5 };
		System.out.println("magic Index is :" + getMagicIndex(a, 0, a.length - 1));

	}

}
