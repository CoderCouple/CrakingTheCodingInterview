package Chapter1;

public class ZeroMatrix {

	public static int[][] getZeroMatrix(int[][] input) {
		int rows[] = new int[input.length];
		int cols[] = new int[input[0].length];

		for (int i = 0; i < rows.length; i++) {
			rows[i] = -1;
		}

		for (int i = 0; i < cols.length; i++) {
			cols[i] = -1;
		}

		int count = 0;
		// System.out.println(rows.length+" "+cols.length);
		for (int i = 0; i < rows.length; i++)
			for (int j = 0; j < cols.length; j++) {
				// System.out.println(i+" "+j);
				if (input[i][j] == 0) {
					rows[count] = i;
					cols[count] = j;
					count++;
				}
			}
		// System.out.println(rows[0]+" "+rows[0]);

		for (int k = 0; k < rows.length; k++)
			for (int l = 0; l < cols.length; l++)
				if (rows[k] != -1) {
					input[rows[k]][l] = 0;

					if (cols[k] != -1) {
						input[l][cols[k]] = 0;
					}

				}

		return input;

	}

	public static void main(String[] args) {
		// int input[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int input[][] = { { 0, 2, 3, 4 }, { 5, 6, 0, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		int output[][] = getZeroMatrix(input);

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output.length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}

	}

}
