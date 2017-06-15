package Chapter1;

public class RotateMatrix {

	public static int[][] rotateMatrix(int[][] input) {

		/*for (int p = 0; p < input.length; p++) {
			for (int q = 0; q < input.length; q++) {
				System.out.print(input[p][q] + " ");
			}
			System.out.println();
		}

		System.out.println("");*/

		for (int n = 0; n < input.length / 2; n++) {
			int k = n;
			int i = n;
			int l = input.length - 1 - n;
			int j = input.length - 1 - n;
			//System.out.println("*");
			for (; j - n > 0;) {
				int temp = input[k][i];
				//System.out.println(input[k][i]);
				input[k][i] = input[j][k];
				//System.out.println(input[j][k]);
				input[j][k] = input[l][j];
				//System.out.println(input[l][j]);
				input[l][j] = input[i][l];
				//System.out.println(input[i][l]);
				input[i][l] = temp;
				j--;
				i++;

				/*for (int p = 0; p < input.length; p++) {
					for (int q = 0; q < input.length; q++) {
						System.out.print(input[p][q] + " ");
					}
					System.out.println();
				}

				System.out.println("");*/
			}

		}
		return input;
	}

	public static void main(String[] args) {
		//int input[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		 int input[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },{ 13, 14, 15, 16 } };

		int output[][] = rotateMatrix(input);

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}

	}

}
