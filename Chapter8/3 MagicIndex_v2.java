package Chapter8;

public class MagicIndex {

	public static int getMagicIndex(int array[]) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { -5, -2, -1, 1, 2, 5 };
		System.out.println("magic Index is :" + getMagicIndex(a));

	}

}
