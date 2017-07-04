
public class BunnyEars_Recursion {

	
	public static int bunnyEars(int bunnies) {
		   if (bunnies<=0)
				  return 0;
				  
				  else
				  return 2+bunnyEars(bunnies-1);
		}
	
	
	public static void main(String[] args) {
		int bunnyEars;
		System.out.println("This is my first recursion Program..!!!");
		bunnyEars = bunnyEars(5);
		System.out.println("The number of bunny ears is :" + bunnyEars);
	}

}
