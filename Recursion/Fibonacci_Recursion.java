
public class Fibonacci_Recursion {

	
	public static int fibonacci(int n) {
		  
		   if (n==0)
				  return 0;
			 
			 if (n==1)
				  return 1;
				  
			if (n==2)
				  return 1;

			
			return fibonacci(n-1)+fibonacci(n-2);
			         
		  
		}

	public static void main(String[] args) {
		
		int fib;
		System.out.println("This is my first recursion Program..!!!");
		fib = fibonacci(7);
		System.out.println("The fibonacci number is :" + fib);
		
	}

}
