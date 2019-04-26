/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */

import java.io.*;
import java.net.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.sql.*;
import javax.swing.plaf.nimbus.State;
import javax.swing.table.TableModel;

/**
 * This is what does the bulk of the work for dealing with data. It connects to the database to get the data the client
 * wants. Serializable objects need to be sent back and forth between client and server so we can't use ResultSet. We
 * had to make our own class that we called ResultSetModel in order to be able to send something to the client
 */

public class Server {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket clientConnection;
    private Connection dbConnection;

    private final int backlog = 100;
    private final int port = 12345;
    private static final String url = "jdbc:derby:RentalData";
    private static final String user = "student";
    private static final String password = "student";
/*
    public Server(){
        try {
            dbConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex){
            System.out.println("Error: check status of database");
            ex.printStackTrace();
        }
    }
    */

    public void runServer(){
        try{
            System.out.println("Server Running...");
            server = new ServerSocket(port, backlog);
            while(true){
                try{
                    waitForConnection();
                    getStreams();
                    processConnection();
                } catch (EOFException ex){
					ex.printStackTrace();
                }finally{
                    closeConnection();
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * Our server patiently waiting for a connection.
     * @throws IOException
     */
    private void waitForConnection() throws IOException{
        clientConnection = server.accept();
    }

    /**
     * Gets the streams for our connection so we can read and write
     * @throws IOException
     */
    private void getStreams() throws  IOException{
        output = new ObjectOutputStream(clientConnection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(clientConnection.getInputStream());
    }

    /**
     * Receives command from the client. Polymorphically takes action to query the database or adds to the database.
     * @throws IOException
     */
    private void processConnection() throws IOException{
        try {
            Command command = ( Command ) input.readObject();
            CommandWord commandWord = command.getCommand();
            String tableName = command.getTableName();

            if ( (commandWord == CommandWord.ADD) && (tableName.equals("Properties"))){ // we have a property to add to db
                addToProperties(command);
            } // next case we get a tenant to add to the tenants table
            else if ( (command.getCommand() == CommandWord.ADD) && ( tableName.equals("Tenants")) ){
                addToTenants(command);
            }// next case we get a statement from client asking for data
            else if (command.getCommand() == CommandWord.RETRIEVE){
                retrieveData(command);
            } else if (command.getCommand() == CommandWord.DELETE){ //we want to delete something
                deleteData(command);
            }
			else if((command.getCommand() == CommandWord.UPDATE) && (tableName.equals("Properties"))) {
				updateProperties(command);
			}
			else if((command.getCommand() == CommandWord.UPDATE) && (tableName.equals("Tenants"))) {
				updateTenants(command);
			}

        } catch (ClassNotFoundException ex){
            System.out.println("Bad Data sent from client ");
        }
    }
    private void retrieveData(Command command){
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = (String) command.getDataObject();

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            TableModel model = DbUtils.resultSetToTableModel(resultSet);
            output.writeObject(model);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     *
     * @param command
     */
    private void addToProperties(Command command){
        try (Connection dbConnection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){
            String tableName = command.getTableName();
            Property newProperty = (Property) command.getDataObject();
            String sql = "insert into " + tableName + " values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement add = dbConnection.prepareStatement(sql);//ResultSet.TYPE_SCROLL_INSENSITIVE if we use other model making

            add.setString(1, newProperty.getPropertyID());
            add.setString(2, newProperty.getAddress());
            add.setInt(3, newProperty.getBedrooms());
            add.setFloat(4, newProperty.getBathrooms());
            add.setString(5, newProperty.getInfo());
            add.setFloat(6, newProperty.getCost());
            add.setString(7, newProperty.getTerms());
            add.setString(8, newProperty.getAvailable());
            LocalDate date = newProperty.getDateAvailable();
            add.setDate(9, java.sql.Date.valueOf(date));
            add.setString(10, newProperty.getTenantID());
            add.setString(11, newProperty.getFullDescription());

            System.out.println("about to do the execute");
            int row = add.executeUpdate();
            System.out.println("Execution complete: " + row + "  was effected.");
            System.out.println("written out done ");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void addToTenants(Command command){
        try (Connection connection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){

            Tenant newTenant = (Tenant) command.getDataObject();
            PreparedStatement add = connection.prepareStatement("insert into Tenants values (?,?,?,?,?,?)");
            add.setString(1, newTenant.getIdNumber());
            add.setString(2, newTenant.getFirstName());
            add.setString(3, newTenant.getLastName());
            add.setString(4, newTenant.getCellphone());
            LocalDate date = newTenant.getRentPaid(); //we're using local date because java's Date is pretty deprecated at this point
            add.setDate(5, java.sql.Date.valueOf(date));
            add.setString(6, newTenant.getEmail());

            System.out.println("about to do the execute for tenant");
            int row = add.executeUpdate();
            System.out.println("executed done, now about to write out");
            output.writeObject(row);
            System.out.println("written out done ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteData(Command command){
        try (Connection connection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){
            String sql = (String) command.getDataObject();
            Statement delete = connection.createStatement();
            delete.executeUpdate(sql);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
	public void updateProperties(Command command) {
		try (Connection connection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){
            String sql = (String) command.getDataObject();
            Statement update = connection.createStatement();
            update.executeUpdate(sql);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
	}

	public void updateTenants(Command command) {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){
            String sql = (String) command.getDataObject();
            Statement update = connection.createStatement();
            update.executeUpdate(sql);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            output.close();
            input.close();
            clientConnection.close();
            //dbConnection.close();
        } catch (IOException ex){
            System.out.println("Closed Connections");
        }
    }

    private TableModel makeModel(String sqlQuery){
        ResultSet resultSet = null;
        try  {
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sqlQuery);
        } catch ( SQLException ex){
            ex.printStackTrace();
        }
        return DbUtils.resultSetToTableModel(resultSet);
    }
//code to test our server
    public static void main(String[] args){
        System.out.println("Creating new server...");
        Server server = new Server();
        System.out.println("Attempting to run server");
        server.runServer();
    }
}
