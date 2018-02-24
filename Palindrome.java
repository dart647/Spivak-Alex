 public class Palindrome 
 {
	 public static void main(String[] args) 
	 {
		 String s="",buf;
		 for (int i = 0; i < args.length; i++) 
		 {
			 s = args[i];
			 System.out.println(s);
			 buf=reverseString(s);
			 System.out.println(buf);
			 if (s.equals(buf))
				 System.out.println(s+" is Palindrome\n");
			 else
				 System.out.println(s+" is not Palindrome\n");
		 } 
	 }
 
	 public static String reverseString(String s)
	 {
		 String buf="";
		 int temp=s.length();
		 for(int i=temp-1;i>=0;i--)
		 {
			 buf+=s.charAt(i);
		 }
		 return buf;
	 }
}