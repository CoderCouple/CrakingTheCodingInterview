
public class coun8_Recursion {

	public static int count8(int n) {
		   if(n == 0)
				  return 0;
				  
				  int lastDigit = n%10;
				  int remainingDigit = n/10;
				  
				  int secondLastDigit = remainingDigit%10;
				  
				  if(lastDigit == 8 && secondLastDigit==8)
				    return 2+count8(remainingDigit);
				  else if(lastDigit == 8)
				    return 1+count8(remainingDigit);
				  else
				    return count8(remainingDigit);
				    
		}



	public static void main(String[] args) {
		int digitSum;
		System.out.println("This is my first recursion Program..!!!");
		digitSum = count8(1823485);
		System.out.println("The sum of digits is :" + digitSum);
	}

}
