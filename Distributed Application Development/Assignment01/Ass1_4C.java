import java.util.*;
import java.io.*;
import java.net.*;

class Ass1_4C
{

	public static void main(String args[])throws Exception
	{
	
		Socket soket=new Socket("localhost",8052);
		InputStream is = soket.getInputStream();
		OutputStream os = soket.getOutputStream();
			
		Scanner sc=new Scanner(System.in);
		Scanner scSkt=new Scanner(is);
		PrintWriter pw=new PrintWriter(os,true);
			
			
		System.out.print("\nEnter Command For Get The File : ");
		String str=sc.nextLine();
		System.out.println();
		pw.println(str);
		System.out.println(scSkt.nextLine()+" OK");
		System.out.println(scSkt.nextLine());
			
		System.out.println("* * * * * * * * Display your file data * * * * * * * *\n");
		while(scSkt.hasNext())
		{
			String Text=scSkt.nextLine();
			System.out.println(Text);
		}
		
		System.out.println("\n* * * * * * * * * * End OF File * * * * * * * * * * *\n");
			
	}
	
}