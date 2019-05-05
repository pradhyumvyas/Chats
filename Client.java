import java.io.*;
import java.net.*;
/**
 *
 * @author Pradhyum
 */
public class Client
{
	public static void main(String args[]) throws IOException
	{
                BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter The IP Address");
                String IP = brr.readLine();
                
                System.out.println("Enter The Port Number");
                int port = Integer.parseInt(brr.readLine());
                
		Socket s = new Socket(IP,port);                                                        //create socket
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());                              // to send data from the client 
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));             //to read the data coming from the server
		BufferedReader bs = new BufferedReader(new InputStreamReader(System.in));                      //to read data from the keyboard
		System.out.println("Connection Established");
                String str,str1;
                
                while(!(str=bs.readLine()).equals("exit"))
		{ 
                        
			dos.writeBytes(str + "\n");                                          //byte  method send string in the form of group of bytes
			str1 = br.readLine();                                                         //receive from server
                        System.out.println(str1);                                                                      
                         			
		}
		dos.close();
		br.close();
		bs.close();
		s.close();
	}
};
