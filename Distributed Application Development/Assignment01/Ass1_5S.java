import java.util.*;
import java.io.*;
import java.net.*;

class Ass1_5S implements Runnable
{
	static ServerSocket ss  ;
	Socket s ;
	static Vector<Socket> V = new Vector<Socket> () ;
	static PrintWriter pout;
	public void run()
	{
		try
		{
			Scanner scan_socket = new Scanner ( s.getInputStream() );
			String str ;
			while ( scan_socket.hasNextLine() )
			{
				str = scan_socket.nextLine() ;
				System.out.print("\n"+str);
				System.out.print("\nyou : ") ;
				if ( str.endsWith("bye") )
				{
					V.remove(s) ;
					s.close();
				}
				for ( Socket p : V )
				{
					if ( p != s )
					{
						pout = new PrintWriter(p.getOutputStream() , true ) ;
						pout.println(str);	
					}
				}
			}
		}
		catch(Exception e )
		{}	
	}
	
	public Server( Socket s)
	{
		try
		{
			this.s  = s ;
			V.add(s);
		}
		catch(Exception e )
		{}
	}
	
	
	public static void main(String[] args ) throws Exception
	{
		
		ss = new ServerSocket(14499);
		
		/*Thread w = new Thread(new WriteServer());
		w.start(); */
		while ( true )
		{
			Socket s = ss.accept();
			Thread t = new Thread(new Server(s));
			t.start() ;
		
		
		}	

	}

}

class WriteServer implements Runnable
{
	
	public void run()
	{
		try
		{
			Scanner sc = new Scanner ( System.in ) ;
			String str ;
			while(true)
			{
				System.out.print("\nyou : ") ;
				str = sc.nextLine();
				for (Socket s : Server.V )
				{
					PrintWriter pout = new PrintWriter(s.getOutputStream() , true ) ;
					pout.println("server : " + str);	
				}
				
			}
		}
		catch(Exception e)
		{}
	}
}
