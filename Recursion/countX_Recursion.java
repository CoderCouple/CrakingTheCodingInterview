
public class countX_Recursion {

	public static int countX(String str) {
		  int count =0;
		  String s = Character.toString('x');
		  if(str.length() == 0)
		  return 0;
		  
		  String lastChar = str.substring(str.length()-1, str.length());
		  String remainingChar = str.substring(0,str.length()-1);
		  if(lastChar.equals(s))
		  {count++;}
		  
		  return count+countX(remainingChar);
		  
		}


	public static void main(String[] args) {
		int stringCount;
		System.out.println("This is my first recursion Program..!!!");
		stringCount= countX("sunXil");
		System.out.println("The count of characters is :" + stringCount);
	}

}
