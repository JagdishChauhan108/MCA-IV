
import java.util.*;
import java.net.*;
import java.io.*;

class Ass1_2S
{
	
	public static void main(String args[]) throws IOException
	{
		
		Socket soket = null;
		ServerSocket sSoket = null;
		
		try
		{
			
			sSoket = new ServerSocket(8052);
			
			System.out.println("\nServer is up and running waiting for client request......");
				
			while(true)
			{
				
				soket = sSoket.accept();
				System.out.println("\nServer side socket is created......\n");	
					
				PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
				Scanner sc = new Scanner(soket.getInputStream());
				
				int no = sc.nextInt(); 
				
				System.out.println("Received number is : " + no);		
		
				pw.println(no);  
				pw.println(SumOfDigits(no)); 
				System.out.println("Result successfully sended to client.....");
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			soket.close();
			sSoket.close();
		}
		
	}
	
	public static int SumOfDigits(int no) 
	{
		
		int sum = 0;
		
		while( no > 0 )
		{
			int rem = no % 10;
				sum = sum + rem;
				no = no / 10;
		}
		
		return sum;
	
	}
	
}