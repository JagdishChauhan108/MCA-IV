import java.util.*;
import java.net.*;
import java.io.*;

public class Ass1_1C
{

	public static void main(String args[]) throws IOException
	{
	
		Socket soket = null;
		
		try
		{
			double avg;
			int max,term,i,choice;
			
			soket = new Socket("localhost",8181);
			
			Scanner sc = new Scanner(System.in);
			
			PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
			Scanner scn = new Scanner(soket.getInputStream());
			
			
			System.out.println("\n\n* * Client Server Programming * *\n");
			System.out.println("\n* * Perform Operation * *\n    1 For Average \n    2 For Maximum \n    
				3 For Fibonacci \n    4 For Prime \n* * * * * * * * * * * * *");

			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();  
			pw.println(choice);     
			
			if(choice==1)
			{
				
				System.out.print("\nEnter no-1 : ");
				pw.println(sc.nextInt());
				
				System.out.print("\nEnter no-2 : ");
				pw.println(sc.nextInt());
			
				avg = scn.nextDouble();
				System.out.println("\nAverage is : " + avg);
				
			}	
			else if(choice==2)
			{
			
				System.out.print("\nEnter no-1 : ");
				pw.println(sc.nextInt());
				
				System.out.print("\nEnter no-2 : ");
				pw.println(sc.nextInt()); 
				
				System.out.print("\nEnter no-3 : ");
				pw.println(sc.nextInt()); 
				
				max = scn.nextInt();  
				System.out.println("\nMaximum is : " + max);
			
			}
			else if(choice==3)
			{
				
				System.out.print("\nEnter number total term(s) : ");
				term = sc.nextInt(); 
				
				pw.println(term);    
				for(i=0;i<term;i++)
				{
					System.out.println(scn.nextLine());  
				}
				
			}
			else if(choice==4)
			{
			
				System.out.print("\nEnter number total term(s) : ");
				term = sc.nextInt(); 
				
				pw.println(term);    
				for(i=0;i<term;i++)
				{
					System.out.println(scn.nextLine());
				}
		
			}
			else
			{
				System.out.println("\nInvalid choice try again..???");
			}
	
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