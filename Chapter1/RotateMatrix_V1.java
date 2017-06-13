package Chapter1;

public class RotateMatrix {

	public static int[][] rotateMatrix(int[][] input) {
		int k = input.length - 1;
		int rotatedArray[][] = new int[input.length][input.length];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				rotatedArray[j][k] = input[i][j];
			}
			k--;
		}
		return rotatedArray;
	}

	public static void main(String[] args) {
		//int input1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		 int input2[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		int output[][] = rotateMatrix(input2);

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}

	}

}
