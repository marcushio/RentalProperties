
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RentalServer {
	
	public void runServer() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(12345);

			while (true) {
				System.out.println("Server is Waiting for Connection.");
				Socket socket = ss.accept();
				System.out.println("Succesfull Connection");
				processConnection(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void processConnection(Socket socket) {
		ObjectOutputStream out = null;
		InputStream in = null;
		try {
			in = socket.getInputStream();
			out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(new Object());

			ObjectInputStream br = new ObjectInputStream(in);

				Tenant ten;
			try {
				ten = (Tenant) br.readObject();
				System.out.println("Tenant  fname  = "+ ten.getFirstName());
				
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException ex) {
			System.out.println("Unable to get streams from client");
			ex.printStackTrace();
		} finally {
			try {
				System.out.println("Closing Connection...");
				in.close();
				out.close();
				socket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args) {
		RentalServer server = new RentalServer();
		server.runServer();
		
	}

}
