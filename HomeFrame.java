import javax.swing.*;

/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
public class HomeFrame extends JFrame {
    JTabbedPane tabs;
    TenantsFrame tenantsFrame;
    PropertiesFrame propertiesFrame;

    public HomeFrame(){
        //create and add components to our tabs
        tabs = new JTabbedPane();
        tabs.addTab("Tenants", tenantsFrame );
        tabs.addTab("Properties", propertiesFrame);
        add(tabs);
        pack();
        setVisible(true);
    }

    public static void main(String args[]){
        HomeFrame gui = new HomeFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
