/**
 * Class Description
 *
 * @author Marcus Trujillo
 * @author Tatiana Nassiri
 * @version CS2251 - Intermediate Programming
 * email: mtrujillo255@cnm.edu
 * assignment due date:
 */

import javax.swing.table.TableModel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class PropertiesFrame extends javax.swing.JInternalFrame {
    //marked for removal
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    //Our objects for connection to server
    private Socket client;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String host = "127.0.0.1";
    private String tableName = "Properties";

    public PropertiesFrame() {
        initComponents();
        selectional();
    }

    /**
     * Selects the model that we're going to use to display data on the Jtable
     */
    public final void selectional() {
        try {
            connectToServer();
            getStreams();
            Command command = new Command("Properties", "SELECT * FROM Properties", CommandWord.RETRIEVE );
            output.writeObject(command);
            TableModel model  = (TableModel) input.readObject();
            Properties2.setModel(model);
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }

    }
    private void connectToServer() throws IOException {
        client = new Socket(host , 12345);
    }

    /**
     * Gets the streams that we'll communicate between server and client over
     * @throws IOException
     */
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush();
        input = new ObjectInputStream(client.getInputStream());
    }

    /**
     * Once we're finished with the connection of the server then we can just close all the connections that we've
     */
    private void closeConnection(){
        try {
            output.close();
            input.close();
            client.close();
        } catch (Exception ex){
            //can we print error in JFrame?
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Properties2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        PropIDTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        AddressTxt = new javax.swing.JTextField();
        BathTxt = new javax.swing.JTextField();
        BedTxt = new javax.swing.JTextField();
        AdditionalTxt = new javax.swing.JTextField();
        RentAmountTxt = new javax.swing.JTextField();
        TermsTxt = new javax.swing.JTextField();
        AvailabilityTxt = new javax.swing.JTextField();
        TenantIDTxt = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        AvailDateTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Properties2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "PropID", "Address", "Bed", "Bath", "AdditionalInfo", "RentAmount", "Terms", "Available", "AvailDate", "Tenant_ID"
                }
        ));
        jScrollPane1.setViewportView(Properties2);

        jLabel2.setText("Bed");

        PropIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropIDTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("PropID");

        jLabel4.setText("Address");

        jLabel5.setText("Bath");

        jLabel6.setText("AdditionalInfo");

        jLabel7.setText("RentAmount");

        jLabel8.setText("Terms");

        jLabel9.setText("Available");

        jLabel10.setText("Tenant_ID");

        AddressTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTxtActionPerformed(evt);
            }
        });

        BathTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BathTxtActionPerformed(evt);
            }
        });

        BedTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BedTxtActionPerformed(evt);
            }
        });

        AdditionalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdditionalTxtActionPerformed(evt);
            }
        });

        RentAmountTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentAmountTxtActionPerformed(evt);
            }
        });

        TermsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TermsTxtActionPerformed(evt);
            }
        });

        AvailabilityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailabilityTxtActionPerformed(evt);
            }
        });

        TenantIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenantIDTxtActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("AvailDate");

        AvailDateTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailDateTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(78, 78, 78)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))))
                                .addGap(0, 103, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(52, 52, 52)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel6)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel8)
                                                                                .addGap(1, 1, 1))))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(63, 63, 63)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel9)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(AvailabilityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(RentAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(BathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(AvailDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(TenantIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(PropIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(347, 347, 347))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(AddressTxt)
                                                                                                .addGap(82, 82, 82)))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                                        .addComponent(TermsTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                                                                                        .addComponent(AdditionalTxt, javax.swing.GroupLayout.Alignment.LEADING))
                                                                                                .addComponent(BedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(82, 82, 82)))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(102, 102, 102)
                                                                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(PropIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addButton)
                                                .addGap(3, 3, 3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(AdditionalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deleteButton))
                                        .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(RentAmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(TermsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(updateButton)))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(AvailabilityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jButton3)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(AvailDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TenantIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(250, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void AddressTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BathTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AdditionalTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void RentAmountTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AvailabilityTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TenantIDTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void TermsTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        try {
            String sql = "select * from Properties where TenantId =? ";
            Command search = new Command(tableName, sql, CommandWord.SEARCH);
             connectToServer();
            getStreams();
            output.writeObject(search);
        } catch (Exception E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void PropIDTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void BedTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void AvailDateTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Property newProperty = new Property();
            newProperty.setPropertyID(PropIDTxt.getText());
            newProperty.setAddress(AddressTxt.getText());
            newProperty.setBedrooms( Integer.parseInt(BedTxt.getText()));
            newProperty.setBathrooms( Float.parseFloat(BathTxt.getText()));
            newProperty.setInfo(AdditionalTxt.getText());
            newProperty.setCost(Float.parseFloat(RentAmountTxt.getText()));
            newProperty.setTerms(TermsTxt.getText());
            newProperty.setAvailable(AvailabilityTxt.getText());
            newProperty.setDateAvailable(LocalDate.parse(AvailDateTxt.getText()));
            newProperty.setTenantID(TenantIDTxt.getText());

            Command command = new Command("Properties", newProperty, CommandWord.ADD);
            connectToServer();
            getStreams();
            output.writeObject(command);

            //this will be redundant, can be deleted after refactoring
            String ID = PropIDTxt.getText();
            String address = AddressTxt.getText();
            String numBedrooms = BedTxt.getText();
            String numBaths = BathTxt.getText();
            String additionalInfo = AdditionalTxt.getText();
            String rent = RentAmountTxt.getText();
            String terms = TermsTxt.getText();
            String avail = AvailabilityTxt.getText();
            String availDate = AvailDateTxt.getText();
            String tenantID = TenantIDTxt.getText();
//marked for removal
             /*
            PreparedStatement add = con.prepareStatement(
                    "insert Into properties (PropertyID,Address,Bedrooms,Bathrooms,AdditionalInfo,RentAmount,RentType,Available,AvailableDate,tenantID) values (?,?,?,?,?,?,?,?,?,?)"); //we'll have to add space for other cols

            add.setString(1, ID);
            add.setString(2, address);
            add.setString(3, numBedrooms);
            add.setString(4, numBaths);
            add.setString(5, additionalInfo);
            add.setString(6, rent);
            add.setString(7, terms);
            add.setString(8, avail);
            add.setString(9, availDate);
            add.setString(10, tenantID);

            add.executeUpdate();
            */
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        selectional();
    }

    private void IDTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addressTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String sql = sql = "Delete from Properties where PropertyID = '" + PropIDTxt.getText() + "'";
            Command command = new Command("Properties", sql, CommandWord.DELETE );

            connectToServer();
            getStreams();
            output.writeObject(command);

            //marked for removal once refactoring is done
            PropIDTxt.setText("");
            AddressTxt.setText("");
            BedTxt.setText("");
            BathTxt.setText("");
            AdditionalTxt.setText("");
            RentAmountTxt.setText("");
            TermsTxt.setText("");
            AvailabilityTxt.setText("");
            AvailDateTxt.setText("");
            TenantIDTxt.setText("");


            /*
            String sql = "Delete from Properties where PropertyID = '" + PropIDTxt.getText() + "'";
            Statement add = con.createStatement();
            add.executeUpdate(sql);

            */
        } catch (Exception E) {
            E.printStackTrace();
        }
        selectional();
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String propertyID = PropIDTxt.getText();
        String address = AddressTxt.getText();
        String numBeds = BedTxt.getText();
        String numBaths = BathTxt.getText();
        String info = AdditionalTxt.getText();
        String rent = RentAmountTxt.getText();
        String terms = TermsTxt.getText();
        String avail = AvailabilityTxt.getText();
        String availDate = AvailDateTxt.getText();
        //we don't have a field for full description right now
        String tenantID = TenantIDTxt.getText();
        try {
            String sql = "UPDATE properties SET propertyID = '" + PropIDTxt.getText() +
                    "' ,Address = '" + AddressTxt.getText() +
                    "' ,Bedrooms = " + Integer.parseInt(BedTxt.getText()) +
                    " ,bathrooms = " + BathTxt.getText() +
                    " ,AdditionalInfo = '" + AdditionalTxt.getText() +
                    "' ,RentAmount = " + RentAmountTxt.getText() +
                    " ,RentType = '" + TermsTxt.getText() +
                    "' ,Available  = '" + AvailabilityTxt.getText() +
                    "' ,AvailableDate = '" + AvailDateTxt.getText() +
                    "' ,tenantID = '" + TenantIDTxt.getText() +
                    "' where propertyID = '" + PropIDTxt.getText() + "'";

            Command command = new Command(tableName, sql, CommandWord.UPDATE);

            connectToServer();
            getStreams();
            output.writeObject(command);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        selectional();

        ///////Marked for removal old sql
        /*
        try {
            rs.updateString("PropertyID", propertyID);
            rs.updateString("Address", address);
            rs.updateString("Bedrooms", numBeds);
            rs.updateString("Bathrooms", numBaths);
            rs.updateString("AdditionalInfo", info);
            rs.updateString("RentAmount", rent );
            rs.updateString("RentType", terms);
            rs.updateString("Available", avail);
            rs.updateString("AvailableDate", availDate );
            rs.updateString("tenantId", tenantID);
            rs.updateRow();
            //JOptionPane.showMessageDialog(Tenant.this, "Updated");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
        try {
            //marked for removal old sql commands
            Statement update = con.createStatement();
            update.executeUpdate(sql);

        } catch (SQLException E) {
            E.printStackTrace();
        }
        selectional();
        */
    }

    private void rentTxtActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
/* We don't have a variable named SFTxt anymore, i think this was the old search?
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
*/
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
    private javax.swing.JButton addButton;
    private javax.swing.JTextField AdditionalTxt;
    private javax.swing.JTextField AddressTxt;
    private javax.swing.JTextField AvailDateTxt;
    private javax.swing.JTextField AvailabilityTxt;
    private javax.swing.JTextField BathTxt;
    private javax.swing.JTextField BedTxt;
    private javax.swing.JTextField PropIDTxt;
    private javax.swing.JTable Properties2;
    private javax.swing.JTextField RentAmountTxt;
    private javax.swing.JTextField TenantIDTxt;
    private javax.swing.JTextField TermsTxt;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration

}

