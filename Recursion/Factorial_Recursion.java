
public class Factorial_Recursion {

	public static int factorial(int n) {
		  if (n<=1)
		  return 1;
		  
		  else
		  return n*factorial(n-1);
		}



	public static void main(String[] args) {

		int fact;
		System.out.println("This is my first recursion Program..!!!");
		fact = factorial(5);
		System.out.println("The factorial is :" + fact);


	}
}
