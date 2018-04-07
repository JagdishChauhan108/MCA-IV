import java.util.*;
import java.net.*;
import java.io.*;

class Ass1_2C
{
	
	public static void main(String args[]) throws IOException
	{
		
		Socket soket = null;
		
		try
		{
		
			int no;
			int Ono;
			int sum;
			
			soket = new Socket("localhost",8052);	
			Scanner sc = new Scanner(System.in);
			
			PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
			Scanner scn = new Scanner(soket.getInputStream());
		
			System.out.print("\nEnter Your Number    : ");
			no = sc.nextInt();  
			pw.println(no);     
		
			Ono = scn.nextInt();  
			sum = scn.nextInt();  
			
			System.out.println("\nUser enter number is : " + Ono);
			System.out.println("\n* * * Retrived Result From Server * * *\n");
			System.out.println("Sum of Digit is      : " + sum);
		
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			soket.close();
		}
		
	}	
	
}