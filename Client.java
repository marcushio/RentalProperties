import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Cleaner;
import java.net.Socket;

/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
class Client{
    Socket client;
    ObjectOutputStream output;
    ObjectInputStream input;
    public void runClient(){
        try{
            connectToServer();
            System.out.println("Connected to server");
            getStreams();
            System.out.println("Streams got");
            processConnection();
        } catch (Exception ex){
            System.out.println("Problem while running client");
        } finally {
            closeConnection();
            System.out.println("Closed connections");
        }
    }
    private void connectToServer() throws IOException {
        client = new Socket("127.0.0.1", 12345);
    }
    private void getStreams() throws IOException{
        System.out.println("getting streams...");
        output = new ObjectOutputStream(client.getOutputStream());
        System.out.println("made new out, now flushing...");
        output.flush();
        System.out.println("flushed... now making input");
        input = new ObjectInputStream(client.getInputStream());
        System.out.println("input made");
    }
    private void processConnection(){
        try{
            Property testProp = new Property(); testProp.setToDefault();
            Command testCommand = new Command("Properties", testProp, CommandWord.ADD );
            Command testCommand2 = new Command("Tenants", new Tenant(), CommandWord.ADD );

            System.out.println("sending property from client");
            output.writeObject(testCommand);
            output.writeObject(testCommand2);
        } catch(Exception ex){
            System.out.println("Exception while testing");

        }
    }
    private void closeConnection(){
        try {
            output.close();
            input.close();
            client.close();
        } catch (Exception ex){
            System.out.println("Something went wrong in the closing process");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        System.out.println("New client created about to send the property");
        client.runClient();

    }
}
