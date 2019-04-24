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
        System.out.println("Got IO Streams");
    }

    /**
     * Receives command from the client. Polymorphically takes action to query the database or adds to the database.
     * @throws IOException
     */
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
                String sql = "insert into " + tableName + " values (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement add = dbConnection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);

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
            else if ( (command.getCommand() == CommandWord.ADD) && ( tableName.equals("Tenants")) ){
                Tenant newTenant = ( Tenant ) command.getDataObject();
                PreparedStatement add = dbConnection.prepareStatement("insert into Tenants values (?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE);
                add.setString(1, newTenant.getIdNumber());
                add.setString(2, newTenant.getFirstName());
                add.setString(3, newTenant.getLastName());
                add.setString(4, newTenant.getCellphone());
                LocalDate date = newTenant.getRentPaid(); //we're using local date because date is pretty deprecated at this point
                add.setDate(5, java.sql.Date.valueOf(date));
                add.setString(6, newTenant.getEmail());

                System.out.println("about to do the execute for tenant");
                int row = add.executeUpdate();
                System.out.println("executed done, now about to write out");
                output.writeObject(row);
                System.out.println("written out done ");
            }// next case we get a statement from client asking for data
            else if (command.getCommand() == CommandWord.RETRIEVE){
                String sql = ( String ) command.getDataObject();
                //Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                //ResultSet retrieveResult = statement.executeQuery(sql);

                output.writeObject( makeModel(sql));
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

    private ResultSetModel makeModel(String sqlQuery){
        ResultSetModel model = null;
        try (Connection connection = DriverManager.getConnection("jdbc:derby:rentaldata", "student", "student")){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            ArrayList<ArrayList<Object>> table = new ArrayList<ArrayList<Object>>();

            for(int column = 0; column < metaData.getColumnCount(); column++ ){
                table.add(new ArrayList<Object>());
                table.get(0).add(metaData.getColumnName(column + 1))  ;
            }

            int row = 0;
            while(resultSet.next()){
                row++;
                table.add(new ArrayList<Object>());
                for(int column = 1; column < columnCount; column++){
                    if(metaData.getColumnClassName(column).equals("java.lang.String"))
                        table.get(row).add(resultSet.getString(column));
                    if(metaData.getColumnClassName(column).equals("java.sql.Date"))
                        table.get(row).add(resultSet.getDate(column));
                    if(metaData.getColumnClassName(column).equals("java.lang.Integer"))
                        table.get(row).add(resultSet.getInt(column));
                    if(metaData.getColumnClassName(column).equals("java.lang.Float"))
                        table.get(row).add(resultSet.getFloat(column));
                }
            }

            resultSet.last();
            int rowCount = resultSet.getRow();
            model = new ResultSetModel(table, rowCount, columnCount);

        } catch (
                SQLException e) {

            e.printStackTrace();
        }
        return model;
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
