public class Primes 
{
	public static void main(String[] args) 
	{
		for (int i=1;i<=100;i++)
		{
			if (isPrime(i))
				System.out.println("Simple number - "+i);	
			else 
				System.out.println("Not simple number  - "+i);	
		}
	}
	public static boolean isPrime(int n)
	{
		for (int j=2;n>j;j++)
		{
			if (n%j==0)
			{
				return false;
			}
		}
		return true;
	}
}