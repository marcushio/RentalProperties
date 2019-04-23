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
import javax.sql.*;
import javax.swing.plaf.nimbus.State;


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

    public Server(){
        try {
            dbConnection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex){
            System.out.println("Error: check status of database");
            ex.printStackTrace();
        }
    }
    public void runServer(){
        try{
            server = new ServerSocket(port, backlog);
            while(true){
                try{
                    waitForConnection();
                    getStreams();
                    System.out.println("about to process connection...");
                    processConnection();
                    System.out.println("processed connection");
                } catch (EOFException ex){
                    //maybe send a message or something?
                }finally{
                    closeConnection();
                }
            }
        } catch (IOException ex){
            System.out.println("IOException at server socket");
            ex.printStackTrace();
        }
    }

    private void waitForConnection() throws IOException{
        clientConnection = server.accept();
    }

    private void getStreams() throws  IOException{
        output = new ObjectOutputStream(clientConnection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(clientConnection.getInputStream());
        System.out.println("Got IO Streams");
    }

    private void processConnection() throws IOException{
        try {
            //we can have a few objects come through the pipeline, let's handle each accordingly
            //case 1 we get a Property to add to the properties table
            Command command = ( Command ) input.readObject();
            System.out.println("Object in and read.");
            String tableName = command.getTableName();
            System.out.println("table name is " + tableName);
            CommandWord commandWord = command.getCommand();
            System.out.println(commandWord);
            if ( (commandWord == CommandWord.ADD) && (tableName.equals("Properties"))){
                Property newProperty = ( Property ) command.getDataObject();

                PreparedStatement add = dbConnection.prepareStatement("insert into " + tableName + " values (?,?,?,?,?,?,?,?,?,?,?)");

                add.setString(1, newProperty.getPropertyID());
                add.setString(2, newProperty.getAddress());
                add.setInt(3, newProperty.getBedrooms());
                add.setInt(4, newProperty.getBathrooms());
                add.setString(5, newProperty.getInfo());

                add.setFloat(6, newProperty.getCost());
                add.setString(7, newProperty.getTerms());
                add.setString(8, newProperty.getAvailable());
                LocalDate date = newProperty.getDateAvailable();
                add.setDate(9, java.sql.Date.valueOf(date));
                add.setString(10, newProperty.getTenantID());
                add.setString(11, newProperty.getFullDescription());
                System.out.println(add.toString());

                System.out.println("about to do the execute");
                int row = add.executeUpdate();
                System.out.println("executed done row:  " + row + "  was effected. Time to write out");
                output.writeObject(row);
                System.out.println("written out done ");
            } // next case we get a tenant to add to the tenants table
            else if (command.getCommand() == CommandWord.ADD && tableName == "Tenants") {
                Tenant newTenant = ( Tenant ) command.getDataObject();
                PreparedStatement add = dbConnection.prepareStatement("insert into RentalData.Tenants values (?,?,?,?,?,?)");
                add.setString(1, newTenant.getIdNumber());
                add.setString(2, newTenant.getFirstName());
                add.setString(3, newTenant.getLastName());
                add.setString(4, newTenant.getCellphone());
                LocalDate date = newTenant.getRentPaid();
                add.setDate(5, java.sql.Date.valueOf(date)); //I'm super dumb, valueOf can also take a string as a param. I didn't have to change the tenant class to have a LocalDate...
                add.setString(6, newTenant.getEmail());
                //need to add bit for having mult properties. We have one, that's why Properties have Tenant Id's that are foreign keys.
                System.out.println(add);

                System.out.println("about to do the execute");
                int row = add.executeUpdate();
                System.out.println("executed done, now about to write out");
                output.writeObject(row);
                System.out.println("written out done ");
            }// next case we get a statement from client asking for data
            else if (command.getCommand() == CommandWord.RETRIEVE){
                //we'll have to implement new class
            } // next case we want to send billing data back

        } catch (ClassNotFoundException ex){
            System.out.println("Bad Data sent from client ");
        } catch (SQLException ex ){
            System.out.println("SQL exception.");
            ex.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            output.close();
            input.close();
            clientConnection.close();
            dbConnection.close();
        } catch (IOException ex){
            System.out.println("Closed Connections");
        } catch (SQLException ex){
            System.out.println("Can't d/c from db");
        }
    }
//code to test our server
    public static void main(String[] args){

        class Client{
            Socket client;
            ObjectOutputStream output;
            ObjectInputStream input;
            public void runClient(){
                try{
                    connectToServer();
                    getStreams();
                    processConnection();
                } catch (Exception ex){
                    System.out.println("Problem while running client");
                }
            }
            private void connectToServer() throws IOException{
                client = new Socket("127.0.0.1", 12345);
            }
            private void getStreams() throws IOException{
                output = new ObjectOutputStream(client.getOutputStream());
                output.flush();
                input = new ObjectInputStream(client.getInputStream());
            }
            private void processConnection(){
                try{
                    Property testProp = new Property();
                    testProp.setToDefault();
                    System.out.println("sending property from client");
                    output.writeObject(testProp);
                } catch(Exception ex){
                    System.out.println("Exception while testing");

                }
            }
        }
        System.out.println("Creating new server...");
        Server server = new Server();
        System.out.println("Attempting to run server");
        server.runServer();
        System.out.println("Making new client to test server...");
        Client client = new Client();
        client.runClient();


    }
}
