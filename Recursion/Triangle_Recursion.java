
public class Triangle_Recursion {

	public static int triangle(int rows) {
		if (rows <= 0)
			return 0;

		else return rows + triangle(rows-1);
	}

	public static void main(String[] args) {
		
		
		int blocks;
		System.out.println("This is my first recursion Program..!!!");
		blocks = triangle(3);
		System.out.println("The number of bunny ears is :" + blocks);
	}

}
