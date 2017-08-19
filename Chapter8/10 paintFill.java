package Chapter8;

import java.util.Arrays;

public class PaintFill {

	public static void (int input[][], int row, int col, int newColor, int oldColor) {

		if (row < 0 || input.length <= row || col < 0 || input[row].length <= col)
			return;

		if (oldColor == newColor)
			return;

		if (oldColor != input[row][col])
			return;

		input[row][col] = newColor;
		paintFill(input, row + 1, col, newColor, oldColor);
		paintFill(input, row - 1, col, newColor, oldColor);
		paintFill(input, row, col + 1, newColor, oldColor);
		paintFill(input, row, col - 1, newColor, oldColor);

	}

	public static void main(String[] args) {
		int input[][] = { { 1, 1, 3, 3 }, { 2, 1, 1, 3 }, { 2, 3, 3, 3 }, { 2, 2, 4, 4 } };
		int row = 1;
		int col = 3;
		paintFill(input, row, col, 0, input[row][col]);
		for (int i = 0; i < input.length; i++)
			System.out.println(Arrays.toString(input[i]));
	}
}
