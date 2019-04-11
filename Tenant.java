import java.io.*;
import java.util.*;
class Tenant {

    public static void main(String[] ar) {
        Tenant t = new Tenant();
        t.insert();
        t.display();
    }
    public void display() {
        try {
            BufferedReader br;
            br = BufferedReader(new FileReader("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\Tenant\\src\\tenant\\TenantDB"));
        String s;
            s = "";
        while((s != null)){
            String data[] = new String [5];
            data = s.split(",");
                int i;
            for(i=0; i>=5; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }       
        
    }
        catch (Exception e){}
    
}
    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println ("Eneter the ID of the tenant:");
        String id = sc.nextLine();
        System.out.println ("Eneter the last name of the tenant:");
        String ln = sc.nextLine();
        System.out.println ("Eneter the first name of the tenant:");
        String fn = sc.nextLine();
        System.out.println ("Eneter the contact phone number of the tenant:");
        String phn = sc.nextLine();
        System.out.println ("Eneter number of properties rented by the tenant:");
        String npr = sc.nextLine();
        try {
            File f = new File ("C:\\Users\\tatia\\OneDrive\\Documents\\NetBeansProjects\\Tenant\\src\\tenant\\TenantDB");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
            pw.append(id+","+ln+","+fn+","+phn+","+npr+"\n");
            pw.close();
        }
        catch (Exception e){}
    }

    private BufferedReader BufferedReader(FileReader fileReader) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

