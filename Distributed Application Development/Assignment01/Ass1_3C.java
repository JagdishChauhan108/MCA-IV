import java.util.*;
import java.net.*;
import java.io.*;


class Ass1_3C
{	
	public static void main(String args[]) throws IOException
	{		
		Socket soket = null;		
		try
		{
		
			int width,height;
			int area,perimeter;
			
			soket = new Socket("localhost",8052);
			
			Scanner sc = new Scanner(System.in);
			
			PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
			Scanner scn = new Scanner(soket.getInputStream());
		
			System.out.print("\nEnter width of rectangle  : ");
			width = sc.nextInt(); //Take width of rectangle from user.
			pw.println(width);    //Send width of rectangle to server.
			
			
			System.out.print("Enter height of rectangle : ");
			height = sc.nextInt();  //Take height of rectangle from user.
			pw.println(height);     //Send height of rectangle to server.
		
			perimeter = scn.nextInt(); //retriving perimeter from server side.
			area = scn.nextInt();      //retriving perimeter from server side.
			
			System.out.println("\n* * * Retrived Result From Server * * *\n");
			System.out.println("Perimeter of a Rectangle is : " + perimeter);  
			System.out.println("Area of a Rectangle is      : " + area);
		
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