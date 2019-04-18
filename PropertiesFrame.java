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
        FNTxt = new javax.swing.JTextField();
        PNTxt = new javax.swing.JTextField();
        RPTxt = new javax.swing.JTextField();
        LNtxt = new javax.swing.JLabel();
        FNtxt = new javax.swing.JLabel();
        PNtxt = new javax.swing.JLabel();
        RPtxt = new javax.swing.JLabel();
        LNTxt = new javax.swing.JTextField();
        SFtxt = new javax.swing.JLabel();
        IDtxt = new javax.swing.JLabel();
        SFTxt = new javax.swing.JTextField();
        ETxt = new javax.swing.JTextField();
        Etxt = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();

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

        RPTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RPTxtActionPerformed(evt);
            }
        });

        LNtxt.setText("LastName");

        FNtxt.setText("FirstName");

        PNtxt.setText("PhoneNumber");

        RPtxt.setText("RentPaid");

        LNTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LNTxtActionPerformed(evt);
            }
        });

        SFtxt.setText("Search Tenant");

        IDtxt.setText("ID");

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

        ETxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETxtActionPerformed(evt);
            }
        });

        Etxt.setText("Email");

        jButtonExit.setText("Exit");
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
                                        .addComponent(FNtxt)
                                        .addComponent(PNtxt)
                                        .addComponent(RPtxt)
                                        .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LNtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Etxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(IDTxt)
                                        .addComponent(FNTxt)
                                        .addComponent(PNTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(LNTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(RPTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                        .addComponent(ETxt))
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
                                                        .addComponent(IDtxt))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(LNtxt)
                                                                .addComponent(LNTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                                        .addComponent(FNTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(FNtxt))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(PNTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(PNtxt))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(RPTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(RPtxt))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Etxt)
                                                                        .addComponent(ETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            String LastName = LNTxt.getText();
            String FirstName = FNTxt.getText();
            String PhoneNumber = PNTxt.getText();
            String RentPaid = RPTxt.getText();
            String Email = ETxt.getText();
            PreparedStatement add = con.prepareStatement("insert Into Rentaldata.properties values (?,?,?,?,?,?)");
            add.setString(1, ID);
            add.setString(2, LastName);
            add.setString(3, FirstName);
            add.setString(4, PhoneNumber);
            add.setString(5, RentPaid);
            add.setString(6, Email);
            int row = add.executeUpdate();

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void IDTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void LNTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            String sql = "Delete from Rentals.Tenant where id = " + IDTxt.getText();
            Statement add = con.createStatement();
            add.executeUpdate(sql);
            IDTxt.setText("");
            LNTxt.setText("");
            FNTxt.setText("");
            PNTxt.setText("");
            RPTxt.setText("");
            ETxt.setText("");

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {
      /*  String ID = IDTxt.getText();
        String last = LNTxt.getText();
        String first = FNTxt.getText();
        String phone = PNTxt.getText();
        String Prop = PRTxt.getText();
        String date = RPTxt.getText();

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

            String sql = "update Rentals.Tenant set ID = " + IDTxt.getText() + " ,LastName = '" + LNTxt.getText() + "' ,FirstName = '" + FNTxt.getText() + "' ,PhoneNumber ="
                    + " '" + PNTxt.getText() + "',RentPaid = '" + RPTxt.getText() + "',Email = '" + ETxt.getText() + "' where ID = " + IDTxt.getText() + "";
            Statement update = con.createStatement();
            update.executeUpdate(sql);
        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void RPTxtActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void ETxtActionPerformed(java.awt.event.ActionEvent evt) {
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
    private javax.swing.JTextField ETxt;
    private javax.swing.JLabel Etxt;
    private javax.swing.JTextField FNTxt;
    private javax.swing.JLabel FNtxt;
    private javax.swing.JTextField IDTxt;
    private javax.swing.JLabel IDtxt;
    private javax.swing.JTextField LNTxt;
    private javax.swing.JLabel LNtxt;
    private javax.swing.JTextField PNTxt;
    private javax.swing.JLabel PNtxt;
    private javax.swing.JTextField RPTxt;
    private javax.swing.JLabel RPtxt;
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

