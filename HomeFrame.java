import javax.swing.*;

/**
 * The frame where the app starts it is where our Tabbed Pane lives.
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
    BillingFrame billingFrame;

    public HomeFrame(){
        //create and add components to our tabs
        tabs = new JTabbedPane();
        //tenantsFrame = new TenantsFrame();
        propertiesFrame = new PropertiesFrame();
        //billingFrame = new BillingFrame();

        //tabs.addTab("Tenants", tenantsFrame );
        tabs.addTab("Properties", propertiesFrame);
        //tabs.addTab("Billing", billingFrame);
        add(tabs);
        pack();
        setVisible(true);
    }

    public static void main(String args[]){
        HomeFrame gui = new HomeFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
