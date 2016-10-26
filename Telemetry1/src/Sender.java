import java.net.*;
import java.io.*;
public class Sender {
	private Socket socket;
	private static int portNum;		// Port number
	private static String IP;		// IP number
	
	public Sender(String IPadress, int port) throws IOException {
		
		// Set the port number
		setPortNum(port);
			
		this.socket = new Socket(IPadress, portNum);
		//InputStream is = socket.getInputStream();
	}
	
	/**
	 * Method to set the port number
	 * @param newPort
	 */
	public void setPortNum(int newPort){
		portNum = newPort;
	}
	
	
	/**
	 * Method to set the IP number
	 * @param newIP
	 */
	public void setIP(String newIP){
		IP = IP.replace(IP, newIP);
	}
	
	
	/**
	 * Method to get the port number
	 * @return IP number as a string
	 */
	public String getIP(){
		return IP;
	}
	
	
	
	//This method handles all things required to send a file is supplied the file location
	public void send(String fileLocation) throws IOException {
		
		// TODO change this part
		File transferFile = new File (fileLocation);
		byte [] bytearray1  = new byte [(int)transferFile.length()];
		FileInputStream fin = new FileInputStream(transferFile);
		BufferedInputStream bin = new BufferedInputStream(fin);
		bin.read(bytearray1,0,bytearray1.length);
		OutputStream os = socket.getOutputStream();
		System.out.println("Sending Files...");
		os.write(bytearray1,0,bytearray1.length);
		os.flush();
		bin.close();
		System.out.println("File transfer complete");
	}
		
	//This method safely closes the peer-to-peer connection	
	public void close() throws IOException {
		socket.close();
		System.out.println("Link disconnected");
	}
	
	
}




				
