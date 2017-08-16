package Chapter8;

public class MagicIndex2 {

	public static int getMagicIndex(int array[], int lb, int ub) {
		int mid = (lb + ub) / 2;

		if (lb > ub)
			return -1;

		if (array[mid] == mid)
			return mid;
		else {
			int r = getMagicIndex(array, mid + 1, ub);
			int l = getMagicIndex(array, lb, mid - 1);

			if (l >= 0)
				return l;
			return r;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -5, 1, -1, 1, 2, 5 };
		System.out.println("magic Index is :" + getMagicIndex(a, 0, a.length - 1));

	}

}
