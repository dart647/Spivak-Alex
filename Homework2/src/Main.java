import java.io.*;
import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) throws Exception 
	{
		FileReader fileR = new FileReader("./src/logdet15-08-12.log");
		FileWriter fileW = new FileWriter("./src/logdet15-08-12 - измененный.log");
		Scanner scan = new Scanner(fileR);
		try
		{	
			System.out.println("Начало записи...");
			while (scan.hasNextLine())
			{
				String str = scan.nextLine();
				fileW.write(str.replaceAll("0", "null") + "\n");
			}
			System.out.println("Изменненый файл записан!");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try 
			{
				scan.close();
				fileR.close();
				fileW.close();
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
