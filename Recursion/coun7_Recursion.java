
public class coun7_Recursion {

	public static int sumDigits(int n) {
		  
		  if(n == 0)
		  return 0;
		  
		  int lastDigit = n%10;
		  int remainingDigit = n/10;
		  
		  return lastDigit+sumDigits(remainingDigit);
		  
		}


	public static void main(String[] args) {
		int digitSum;
		System.out.println("This is my first recursion Program..!!!");
		digitSum = sumDigits(12345);
		System.out.println("The sum of digits is :" + digitSum);
	}

}
