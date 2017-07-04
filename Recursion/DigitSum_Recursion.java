
public class DigitSum_Recursion {

	public static int count7(int n) {
		  
		  if(n == 0)
		  return 0;
		  int count=0;
		  int lastDigit = n%10;
		  int remainingDigit = n/10;
		  
		  if(lastDigit==7)
			count++;
		  
		  
		  return count+count7(remainingDigit);
		  
		}


	public static void main(String[] args) {
		int digitCount;
		System.out.println("This is my first recursion Program..!!!");
		digitCount = count7(1277345);
		System.out.println("The sum of digits is :" + digitCount);
	}

}
