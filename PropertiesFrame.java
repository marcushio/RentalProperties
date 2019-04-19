/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */
/*
CREATE TABLE "TENANT" (
    "ID" INTEGER not null primary key,
    "LASTNAME" VARCHAR(30),
    "FIRSTNAME" VARCHAR(30),
    "PHONENUMBER" VARCHAR(20),
    "RENTPAID" DATE,
    "EMAIL" VARCHAR(60),
);

INSERT INTO RENTALS.TENANT (ID, LASTNAME, FIRSTNAME, PHONENUMBER, RENTPAID, EMAIL)
	VALUES (3, 'Smith', 'Jack', '505-258-9856', 1, '2019-04-01', 'j.smith@gmail.com')
INSERT INTO RENTALS.TENANT (ID, LASTNAME, FIRSTNAME, PHONENUMBER, RENTPAID, EMAIL)
	VALUES (10, 'Collins', 'Merry', '505-254-7878', '2019-04-01', 'm.collins@gmail.com')
*/

/*


INSERT INTO RENTALS.PROPERTIES (PROPID, ADDRESS, BED, BATH, ADDITIONALINFO, RENTAMOUNT, TERMS, AVAILABILITY, TENANT_ID)
	VALUES (1, '2345 Montgomery Ave NE', 3, 2, 'garage, front/back yard', '1300', 'first, last mont and sec. deposit, $25/day late fee', 'Not Available', 3)

*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PropertiesFrame extends javax.swing.JInternalFrame {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public PropertiesFrame() {
        initComponents();
        selectional();
    }

    public final void selectional() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentaldata", "root", "Aurelius11!");
            st = con.createStatement();
            rs = st.executeQuery("select * from Rentaldata.properties");
            PropertiesTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        PropertiesTable = new javax.swing.JTable();
        button_add= new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        IDTxt = new javax.swing.JTextField();
        bathroomTxt = new javax.swing.JTextField();
        additionalInfoTxt = new javax.swing.JTextField();
        rentTxt = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        bathroomLabel = new javax.swing.JLabel();
        additionalInfoLabel = new javax.swing.JLabel();
        rentLabel = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        SFtxt = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        SFTxt = new javax.swing.JTextField();
        bedroomsTxt = new javax.swing.JTextField();
        bedroomsLabel = new javax.swing.JLabel();
        termsTxt = new javax.swing.JTextField();
        termsLabel = new javax.swing.JLabel();
        availTxt = new javax.swing.JTextField();
        availLabel = new javax.swing.JLabel();
        availDateTxt = new javax.swing.JTextField();
        availDateLabel = new javax.swing.JLabel();
        tenantIDTxt = new javax.swing.JTextField();
        tenantIDLabel = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();

        idLabel.setText("Property ID");
        addressLabel.setText("Address");
        bathroomLabel.setText("Bathrooms");
        additionalInfoLabel.setText("Additional Info");
        rentLabel.setText("Rent");
        termsLabel.setText("Terms");
        availLabel.setText("Available");
        availDateLabel.setText("Available Date");
        tenantIDLabel.setText("Tenant ID");
        idLabel.setText("ID");
        bedroomsLabel.setText("Bedrooms");
        jButtonExit.setText("Exit");


        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); this was from when this
        //was our primary Jframe.

        PropertiesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String[]{
                        "ID", "Address", "Bedrooms", "Bathrooms", "Rent", "Terms", "Avail", "Date Avail", "Additional Info", "Tenant"
                }
        ));
        jScrollPane1.setViewportView(PropertiesTable);
         button_add.setText("Add"); button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {  button_addActionPerformed(evt);
            }
        });

        button_delete.setText("Delete");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_update.setText("Update");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        IDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTxtActionPerformed(evt);
            }
        });

        rentTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentTxtActionPerformed(evt);
            }
        });

        addressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTxtActionPerformed(evt);
            }
        });

        SFtxt.setText("Search Properties");



        SFTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SFTxtActionPerformed(evt);
            }
        });
        SFTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SFTxtKeyReleased(evt);
            }
        });

        bedroomsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bedroomsTxtActionPerformed(evt);
            }
        });

        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button_update))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bathroomLabel)
                                        .addComponent(additionalInfoLabel)
                                        .addComponent(rentLabel)
                                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bedroomsLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IDTxt)
                                        .addComponent(bathroomTxt)
                                        .addComponent(additionalInfoTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(addressTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(rentTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(bedroomsTxt))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(SFtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SFTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(idLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(addressLabel)
                                                                .addComponent(addressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(button_add)
                                                                .addGap(14, 14, 14)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(button_delete)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(button_update)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(bathroomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(bathroomLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(bedroomsLabel)
                                                                        .addComponent(bedroomsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(additionalInfoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(additionalInfoLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(rentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(rentLabel))
                                                                .addGap(18, 18, 18)


                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                .addGap(6, 6, 6)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SFtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SFTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExit)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String ID = IDTxt.getText();
            String address = addressTxt.getText();
            String numBedrooms = bedroomsTxt.getText();
            String numBaths = bathroomTxt.getText();
            String additionalInfo = additionalInfoTxt.getText();
            String rent = rentTxt.getText();

            PreparedStatement add = con.prepareStatement("insert Into Rentaldata.properties values (?,?,?,?,?,?)"); //we'll have to add space for other cols
            add.setString(1, ID);
            add.setString(2, address);
            add.setString(3, numBedrooms);
            add.setString(4, numBaths);
            add.setString(5, additionalInfo);
            add.setString(6, rent);
            //add.setString(7, terms);
            //add.setString(8, avail);
            //add.setString(9, availableDate);
            //add.setString(10, tenantID);
            int row = add.executeUpdate();

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void IDTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addressTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String sql = "Delete from Rentaldata.properties where id = " + IDTxt.getText();
            Statement add = con.createStatement();
            add.executeUpdate(sql);
            IDTxt.setText("");
            addressTxt.setText("");
            bathroomTxt.setText("");
            additionalInfoTxt.setText("");
            rentTxt.setText("");
            bedroomsTxt.setText("");

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {
      /*  String ID = IDTxt.getText();
        String last = addressTxt.getText();
        String first = bathroomTxt.getText();
        String phone = additionalInfoTxt.getText();
        String Prop = PRTxt.getText();
        String date = rentTxt.getText();

        int newID = Integer.parseInt(ID);
        int newProp = Integer.parseInt(Prop);
        try {
            rs.updateInt("ID", newID);
            rs.updateString("First_Name", first);
            rs.updateString("last_Name", last);
            rs.updateString("Job_Title", job);
            rs.updateRow();
            JOptionPane.showMessageDialog(Tenant.this, "Updated");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }*/
        try {
            String sql = "update rentaldata.properties set ID = " + IDTxt.getText() + " ,Address = '" + addressTxt.getText() + "' ,bathrooms = '" + bathroomTxt.getText() + "' ,AdditionalInfo ="
                    + " '" + additionalInfoTxt.getText() + "',Rent = '" + rentTxt.getText() + "',Bedrooms = '" + bedroomsTxt.getText() +  "' where ID = " + IDTxt.getText() + "";
            Statement update = con.createStatement();
            update.executeUpdate(sql);
        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void rentTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SFTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void SFTxtKeyReleased(java.awt.event.KeyEvent evt) {
        try {

            String query = "select * from Rentals.Tenant where LastName =? ";
            PreparedStatement search = con.prepareStatement(query);
            search.setString(1, SFTxt.getText());
            ResultSet rs = search.executeQuery();


            //Properties.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void bedroomsTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PropertiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PropertiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PropertiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PropertiesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PropertiesFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify
    private javax.swing.JTextField bedroomsTxt;
    private javax.swing.JLabel bedroomsLabel;
    private javax.swing.JTextField bathroomTxt;
    private javax.swing.JLabel bathroomLabel;
    private javax.swing.JTextField IDTxt;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField addressTxt;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField additionalInfoTxt;
    private javax.swing.JLabel additionalInfoLabel;
    private javax.swing.JTextField rentTxt;
    private javax.swing.JLabel rentLabel;
    private javax.swing.JTextField termsTxt;
    private javax.swing.JLabel termsLabel;
    private javax.swing.JTextField availTxt;
    private javax.swing.JLabel availLabel;
    private javax.swing.JTextField availDateTxt;
    private javax.swing.JLabel availDateLabel;
    private javax.swing.JTextField tenantIDTxt;
    private javax.swing.JLabel tenantIDLabel;
    private javax.swing.JTextField SFTxt;
    private javax.swing.JLabel SFtxt;
    private javax.swing.JTable PropertiesTable;
    private javax.swing.JButton button_add;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_update;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // end of declarations
}

