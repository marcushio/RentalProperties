
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalServer {
	String ID;
	String LastName;
	String FirstName;
	String PhoneNumber;
	String RentPaid;
	String Email;
	final String DATABASE_URL = "jdbc:derby:Rentals";

	public void runServer() {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(12345, 100);

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
			ErrorResponse er = new ErrorResponse();
			er.setErrorCode(0);
			out.writeObject(er);

			ObjectInputStream br = new ObjectInputStream(in);

			Command cmd;
			Tenant ten;
			while (true) {
				try {

					cmd = (Command) br.readObject();
					if (cmd.getCommnad() == 0) {
						// add
						//try {
							ten = cmd.getTenant();
							// use try-with-resources to connect to and query the database
							/*Connection connection;
							connection = DriverManager.getConnection(DATABASE_URL, "root", "Aurelius11!");
							PreparedStatement statement = connection.prepareStatement(
									"insert into Tenant (lastname,firstname,phonenumber,rentpaid,email) values(?,?,?,?,?)");
							statement.setString(1, ten.getLastName());
							statement.setString(2, ten.getFirstName());
							statement.setString(3, ten.getCellphone());
							statement.setString(4, ten.getRentalPaid());
							statement.setString(5, ten.getEmail());
							int rs = statement.executeUpdate();
							statement = connection.prepareStatement("SELECT * FROM Rentals");
							ResultSet resultSet = statement.executeQuery();
							ArrayList<Tenant> list = new ArrayList<Tenant>();
							while(resultSet.next()) {
								list.add(new Tenant(resultSet.getString(ID), resultSet.getString(LastName), resultSet.getString(FirstName), resultSet.getString(PhoneNumber), 
										resultSet.getString(RentPaid), resultSet.getString(Email)));
							}
							er.setList(list);*/
							out.writeObject(er);

						//} catch (SQLException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						//}

					} else if (cmd.getCommnad()== 1) {
						ten = cmd.getTenant();
						out.writeObject(er);
						System.out.print(ten.getIdNumber());
					} else if(cmd.getCommnad() == 2) {
						ten = cmd.getTenant();
						out.writeObject(er);
						System.out.print(ten.getEmail());
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} /*
					 * catch (SQLException E) { E.printStackTrace(); }
					 */
				// out.write(response.getBytes("UTF-8"));
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
