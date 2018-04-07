import java.util.*;
import java.net.*;
import java.io.*;


class Ass1_3S
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
				
				int width,height;
				int area,perimeter=0;
				
				soket = sSoket.accept();
				System.out.println("\nServer side socket is created......\n");	
					
				PrintWriter pw = new PrintWriter(soket.getOutputStream(),true);
				Scanner sc = new Scanner(soket.getInputStream());
				
				width = sc.nextInt(); 
				System.out.println("Received width is  : " + width);
			
				height = sc.nextInt(); 
				System.out.println("Received height is : " + height);
			
				
				perimeter = findPerimeterOfRectangle(width,height); 
				pw.println(perimeter);   
			
				area = findAreaOfRectangle(width,height);  
				pw.println(area);      
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
	
	public static int findPerimeterOfRectangle(int height,int width)
	{
		return 2*(height + width);
	}
	
	public static int findAreaOfRectangle(int height,int width)  
	{
		return height * width;
	}
	
}