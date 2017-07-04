
public class BunnyEars2_Recursion {

	
	public static int bunnyEars2(int bunnies) {
		   if (bunnies<=0)
				  return 0;
				  
				  else if(bunnies%2==0)
				  return 3+bunnyEars2(bunnies-1);
				  else return 2+bunnyEars2(bunnies-1);
		}
	
	
	public static void main(String[] args) {
		int bunnyEars;
		System.out.println("This is my first recursion Program..!!!");
		bunnyEars = bunnyEars2(2);
		System.out.println("The number of bunny ears is :" + bunnyEars);
	}

}
