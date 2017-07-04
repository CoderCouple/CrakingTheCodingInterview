
public class PowerN_Recursion {

	public static  int powerN(int base, int n) {
		  if (n==1)
		  return base;
		  
		  else return base*powerN(base,n-1);
		}



	public static void main(String[] args) {

		int result;
		System.out.println("This is my first recursion Program..!!!");
		result = powerN(5,3);
		System.out.println("The PoerN is :" + result);


	}
}
