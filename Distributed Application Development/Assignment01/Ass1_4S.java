import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;

class Ass1_4S
{
	
	public static void main(String args[])throws Exception
	{
		
		ServerSocket sSoket=new ServerSocket(8052);
		System.out.println("\nServer is up and running waiting for client request......");
			
		Socket soket=sSoket.accept();
		System.out.println("\nServer side socket is created.....\n");
			
		Scanner sc=new Scanner(System.in);
		Scanner scSrvr=new Scanner(soket.getInputStream());
			
		PrintWriter pw=new PrintWriter(soket.getOutputStream(),true);
			
		System.out.println("File in process .....");
	
		String cmd=scSrvr.nextLine();
		String token[]=cmd.split(" ");
			
		if(token[0].equals("GET") && token.length==3)
		{
						
			pw.println(token[2]);
			pw.println(" ");
			BufferedReader br=new BufferedReader(new FileReader(token[1]));
						
			String line=br.readLine();
		
			for(int i=0;line!=null;i++)
			{
					
				pw.println(line);
				line=br.readLine();
			
			}
		}
			
		System.out.println("Result successfully sended to client.....");
			
			
	}
	
}