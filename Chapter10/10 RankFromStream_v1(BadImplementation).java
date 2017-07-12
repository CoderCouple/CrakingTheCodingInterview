package Chapter10;

import java.util.ArrayList;

public class RankFromStream {
	static ArrayList<Integer> inputList = new ArrayList<Integer>();

	public static int getRankOfNumber(int num) {

		return binarySearch(inputList, num, 0, inputList.size() - 1);
	}

	public static void track(int index, int element) {
		if (index <= 0)
			inputList.add(index, element);
		else
			inputList.add(index - 1, element);
	}

	public void addElement(int num) {
		int i = addUsingBinarySearch(num, inputList, 0, inputList.size() - 1);
		track(i, num);
	}

	public static int binarySearch(ArrayList myArray, int n, int startNum, int endNum) {
		if (startNum > endNum)
			return -1;

		int midNum = (startNum + endNum) / 2;

		if (n == (int) myArray.get(midNum))
			return midNum;

		if (n < (int) myArray.get(midNum))
			return binarySearch(myArray, n, startNum, midNum - 1);
		else
			return binarySearch(myArray, n, midNum + 1, endNum);

	}

	public static int addUsingBinarySearch(int element, ArrayList myArray, int lb, int ub) {

		if (myArray.size() == 0)
			return 0;

		if (myArray.size() == 1)
			if (element < (int) myArray.get(0)) {
				return 0;
			} else {
				return 2;
			}
		
		if (myArray.size() == 2)
			if (element < (int) myArray.get(0)) {
				return 0;
			} else if(element >= (int) myArray.get(0) && element < (int) myArray.get(1)){
				return 2;
			} else {return 3;}

		
		if (ub - lb <= 1) {
			return ub;
		}

		int mid = (lb + ub) / 2;

		if (lb <= element && element < (int) myArray.get(mid)) {
			return addUsingBinarySearch(element, myArray, lb, mid - 1);
		} else {
			return addUsingBinarySearch(element, myArray, mid + 1, ub);
		}
	}

	public static void main(String[] args) {
		RankFromStream rs = new RankFromStream();
		rs.addElement(5);
		rs.addElement(1);
		rs.addElement(4);
		rs.addElement(4);
		rs.addElement(5);
		rs.addElement(9);
		rs.addElement(7);
		rs.addElement(13);
		rs.addElement(3);

		for (int i = 0; i < rs.inputList.size(); i++) {
			System.out.print(rs.inputList.get(i));
			System.out.print(" ");
		}

		System.out.println("");
		System.out.println("Rank of 1: " + getRankOfNumber(1));
		System.out.println("Rank of 3: " + getRankOfNumber(3));
		System.out.println("Rank of 4: " + getRankOfNumber(4));

	}

}
