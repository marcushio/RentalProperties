import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client extends javax.swing.JFrame implements Serializable {
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
	private javax.swing.JTable Tenants2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButtonExit;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private Socket client;
	private ObjectOutputStream output;
	private ObjectInputStream input;

	public Client() {
		initComponents();
	}

	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		Tenants2 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
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

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		Tenants2.setModel(new javax.swing.table.DefaultTableModel(
				new Tenant[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "ID", "LastName", "FirstName", "PhoneNumber", "PropRented", "RentPaid", "Email" }));
		jScrollPane1.setViewportView(Tenants2);

		jButton1.setText("Add");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Delete");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Update");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		IDTxt.addActionListener(new java.awt.event.ActionListener() { // ID text field
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IDTxtActionPerformed(evt);
			}
		});

		RPTxt.addActionListener(new java.awt.event.ActionListener() { // Rental paid text field
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RPTxtActionPerformed(evt);
			}
		});

		LNtxt.setText("LastName");

		FNtxt.setText("FirstName");

		PNtxt.setText("PhoneNumber");

		RPtxt.setText("RentPaid");

		LNTxt.addActionListener(new java.awt.event.ActionListener() { // Last name text field
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				LNTxtActionPerformed(evt);
			}
		});

		SFtxt.setText("Search Tenant");

		IDtxt.setText("ID");

		SFTxt.addActionListener(new java.awt.event.ActionListener() { // search tenant button
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SFTxtActionPerformed(evt);
			}
		});
		SFTxt.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				SFTxtKeyReleased(evt);
			}
		});

		ETxt.addActionListener(new java.awt.event.ActionListener() { // email text field
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ETxtActionPerformed(evt);
			}
		});

		Etxt.setText("Email");

		jButtonExit.setText("Exit"); // exit button
		jButtonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonExitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3))
						.addGap(38, 38, 38)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(FNtxt).addComponent(PNtxt).addComponent(RPtxt)
								.addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(LNtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(Etxt))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(IDTxt).addComponent(FNTxt)
								.addComponent(PNTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
								.addComponent(LNTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
								.addComponent(RPTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
								.addComponent(ETxt))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(SFtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(SFTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(39, 39, 39)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(69, 69, 69).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(IDtxt))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(LNtxt).addComponent(LNTxt,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addComponent(jButton1).addGap(14, 14,
														14)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(jButton2)
												.addGap(26, 26, 26).addComponent(jButton3)
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(FNTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(FNtxt)).addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(PNTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(PNtxt))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(RPTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(RPtxt))
												.addGap(18, 18, 18)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(Etxt).addComponent(ETxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(
								layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235,
												Short.MAX_VALUE)
										.addGap(6, 6, 6)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(SFtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(SFTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jButtonExit)
						.addContainerGap()));

		pack();
	}

	private void connectToServer() throws IOException {
		boolean connected = false;
		while (!connected) {
			try {
				client = new Socket();
				client.connect(new InetSocketAddress("127.0.0.1", 12345), 2000);
				connected = true;
				output = new ObjectOutputStream(client.getOutputStream());
				output.flush();
				input = new ObjectInputStream(client.getInputStream());
				input.readObject();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { // add button
		Tenant tenant = new Tenant(IDTxt.getText(), LNTxt.getText(), FNTxt.getText(), PNTxt.getSelectedText(),
				RPTxt.getText(), ETxt.getText());
		Command cmd = new Command();
		cmd.setTenant(tenant);
		cmd.setCommnad(0);
		try {
			output.writeObject(cmd);
			ErrorResponse error = (ErrorResponse) input.readObject();
			System.out.println(error.getErrorCode());
			//System.out.println(error.getList());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void IDTxtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void LNTxtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { // delete tenant from table
		Tenant tenant = new Tenant(IDTxt.getText(), LNTxt.getText(), FNTxt.getText(), PNTxt.getSelectedText(),
				RPTxt.getText(), ETxt.getText());
		Command cmd = new Command();
		cmd.setTenant(tenant);
		cmd.setCommnad(1);
		try {
			output.writeObject(cmd);
			ErrorResponse error = (ErrorResponse) input.readObject();
			System.out.println(error.getErrorCode());
			System.out.println("Delete it");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { // update tenant info on the table
		Tenant tenant = new Tenant(IDTxt.getText(), LNTxt.getText(), FNTxt.getText(), PNTxt.getSelectedText(),
				RPTxt.getText(), ETxt.getText());
		Command cmd = new Command();
		cmd.setTenant(tenant);
		cmd.setCommnad(2);
		try {
			output.writeObject(cmd);
			ErrorResponse error = (ErrorResponse) input.readObject();
			System.out.println(error.getErrorCode());
			System.out.println("Update");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void RPTxtActionPerformed(java.awt.event.ActionEvent evt) { // rental paid
		// TODO add your handling code here:
	}

	private void SFTxtActionPerformed(java.awt.event.ActionEvent evt) { // search for tenant event
		// TODO add your handling code here:
	}

	private void SFTxtKeyReleased(java.awt.event.KeyEvent evt) {

	}

	private void ETxtActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) { // exit event
		this.dispose();
	}

	public static void main(String args[]) { // main method
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Client client = new Client();
				try {
					client.connectToServer();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				client.setVisible(true);
				// new Client().setVisible(true);
			}
		});

	}
}
