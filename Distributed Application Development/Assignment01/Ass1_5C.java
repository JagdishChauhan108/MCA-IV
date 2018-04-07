import java.net.*;
import java.io.*;
import java.util.*;

class Ass1_5C implements Runnable
{
	static Socket s;
	static InputStream is ;
	static OutputStream os ;
	static String msg ;
	
	public void run ()
	{
		Scanner sc1 = new Scanner(is);
		while ( true )
		{
			while ( sc1.hasNextLine() )
			{
				msg = sc1.nextLine();
				System.out.print	("\n" + msg + "\nyou : ");
			}
		}
		
	}
	public static void main ( String[] args ) throws Exception
	{
		String name = args[0] ;
		
		try
		{
			
			 s = new Socket("localhost",14499);
			 is =s.getInputStream();
			 os = s.getOutputStream();
			 msg = ""	 ;
					
			Thread t = new Thread(new Client());
			t.start();
			Scanner sc2 = new Scanner ( System.in ) ;
			PrintWriter pw = new PrintWriter(os,true); // True  autofluss...
				while ( true )
				{	
					System.out.print("you : ");
					msg = sc2.nextLine();
					pw.println(name + " : " + msg);
					if (msg.equals("bye"))
						System.exit(0);
					
				}
		}
		catch ( UnknownHostException UHE )
		{
			System.out.println(UHE);
		}
		catch ( IOException IOE)
		{
			System.out.println(IOE);
		}
		catch ( Exception e )
		{
				System.out.println("\n\nDisconnected");
		}		
	}	
}
