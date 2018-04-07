import java.util.*;
import java.net.*;
import java.io.*;

public class Ass1_1S
{

	public static void main(String args[])
	{

		Socket soket = null;
		ServerSocket sSoket = null;
		
		try
		{

			sSoket = new ServerSocket(8181);
			
			System.out.println("\nServer is up and running waiting for client request......");
			
			while(true)
			{
		
				double avg;
				int max,no,choice;
				
				soket = sSoket.accept();
				System.out.println("\nServer side socket is created.....\n");	
				
				Scanner sc = new Scanner(soket.getInputStream());
			
				PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
			
				choice = sc.nextInt();

				if(choice==1)
				{
		
					avg = findAverage(sc.nextDouble(),sc.nextDouble()); //Do process to find Average.
					pw.println(avg);                //Send result value to client	
					
					System.out.println("Average calculated...");
					System.out.println("Result successfully sended to client.....");
					
				}
				else if(choice==2)
				{
					
					int n1,n2,n3;
					
					n1 = sc.nextInt();
					n2 = sc.nextInt();
					n3 = sc.nextInt();
					
					max = findMaximumNumber(n1,n2,n3);  //Do process to find Maximum no.
					
					pw.println(max);		    //Send result value to client		
					System.out.println("Maximum number is founded...");
					System.out.println("Result successfully sended to client.....");
					
				}
				else if(choice==3)
				{
				
					no = sc.nextInt();
					findFibonacciNumber(pw,no);
					System.out.println("Fibonacci numbers are founded...");					
					System.out.println("Result successfully sended to client.....");
					
				}
				else if(choice==4)
				{
					
					no = sc.nextInt();
					findPrimeNumber(pw,no);
					System.out.println("Prime numbers are founded...");
					System.out.println("Result successfully sended to client.....");
				
				}	
				else
				{
				
					System.out.println("\nInvalid choice try again..???");	
				
				}
			
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
			try
			{
				soket.close();
				sSoket.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}	
		}
		
	}
	
	
	public static double findAverage(double no1,double no2)  //Function for find average of two no.
	{
	
		System.out.println("\nProcess of average calculating is running...");
		
		return (no1 + no2) / 2;
		
	}
	
	public static int findMaximumNumber(int n1,int n2,int n3)  //Function for find maximum no of three no.
	{
		System.out.println("\nProcess of finding maximum into three number is running...");
		
		return n1>n2 ? n1>n3?n1:n3 : n2>n3?n2:n3;
		
	}
	
	public static void findFibonacciNumber(PrintWriter pw,int n) //Function find the fibonacci no.
	{
			
			int no1=0,no2=1;
			int i,sum;
			
			System.out.println("\nProcess of finding Fibonacci number is running...");
			
			pw.println(no1);
			pw.println(no2);
			
			for(i=2; i<n; i++)
			{
				sum = no1 + no2;
				no1 = no2;
				no2 = sum;
				
				pw.println(sum);
			}
			
	}
	
	
	public static void findPrimeNumber(PrintWriter pw,int num) //Function find the prime no.
	{	
	
		int i,j;
		boolean prime;
		
		System.out.println("\nProcess of finding Prime number is running...");
		
		for(i=2; num>0; i++)
		{
			prime = true;
			for(j=2; j<=Math.sqrt(i); j++)
			{
				if(i%j==0)
				{
					prime = false;
					break;
				}
			}
			if(prime)
			{
				pw.println(i);
				num--;
			}
		}
		
	}
	
	
	
}