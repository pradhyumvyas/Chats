import java.io.*;
import java.net.*;
/**
 *
 * @author Pradhyum
 */
 public class Server
{
	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(888);
		Socket s = ss.accept();    //server wait till a client accepts connection
		System.out.println("Connection Established");
		PrintStream ps = new PrintStream(s.getOutputStream());  //to send data till the socket,socket to send data to client(getoutputStream method) 
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));  //to read data 
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));           //send data from server to client
		while(true)
		{
			String str,str1;
			while((str = br.readLine()) != null)
			{
				System.out.println(str);
				str1 = bs.readLine();
				ps.println(str1);
			}
			ps.close();
			br.close();
			bs.close();
			ss.close();
			s.close();
			System.exit(0);
			
		}
	}
}