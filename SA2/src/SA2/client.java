package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class client extends JFrame {

	private JPanel contentPane;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JComboBox<String>comboBox,comboBoxGender;
	private JTextField txtage;
	private JTextField txtadresse;
	private JTextField txtemail;
	private JTextField txtnumtel;
	private JTextField txtnationalite;
	private JTextField txtpaysorigine;
	private JTextField txtid_client;
	private JTable table_1;
	 public String filterGender;
	 private JTextField txtSearch;
	private JComboBox<String> comboBox1,comboBoxCriteria;
	 private String filterCriteria;
	 private static JTable clienttable;
	 
     /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client frame = new client();
					frame.setVisible(true);
					showTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public client() {
		
		/////////////////////////////////////////////////////////////////////
		
	//	private ImageIcon loadImage() {

		 //   ImageIcon ii = new ImageIcon("src/images/snake.jpg");
	// return ii;
	//}
		
		
		
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestionclient = new JLabel("Gestion de Client");
		lblGestionclient.setForeground(Color.BLUE);
		lblGestionclient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblGestionclient.setBounds(402, 13, 240, 16);
		contentPane.add(lblGestionclient);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setForeground(Color.CYAN);
		lblnom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblnom.setBounds(12, 120, 56, 16);
		contentPane.add(lblnom);
		
		JLabel lblprenom = new JLabel("Prenom");
		lblprenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblprenom.setForeground(Color.CYAN);
		lblprenom.setBounds(12, 168, 56, 16);
		contentPane.add(lblprenom);
		
		JLabel lblsexe = new JLabel("sexe");
		lblsexe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblsexe.setForeground(Color.CYAN);
		lblsexe.setBounds(12, 217, 56, 16);
		contentPane.add(lblsexe);
		
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblage.setForeground(Color.CYAN);
		lblage.setBounds(12, 265, 56, 16);
		contentPane.add(lblage);
		
		JLabel lbladresse = new JLabel("Adresse");
		lbladresse.setForeground(Color.CYAN);
		lbladresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbladresse.setBounds(12, 309, 56, 16);
		contentPane.add(lbladresse);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setForeground(Color.CYAN);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblemail.setBounds(12, 355, 56, 16);
		contentPane.add(lblemail);
		
		JLabel lblNumero_Telephone = new JLabel("Numero Telephone");
		lblNumero_Telephone.setForeground(Color.CYAN);
		lblNumero_Telephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero_Telephone.setBounds(12, 416, 128, 16);
		contentPane.add(lblNumero_Telephone);
		
		JLabel lblnationalite = new JLabel("Nationalit\u00E9");
		lblnationalite.setForeground(Color.CYAN);
		lblnationalite.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblnationalite.setBounds(12, 472, 88, 16);
		contentPane.add(lblnationalite);
		
		JLabel lblpays_origine = new JLabel("Pays origine");
		lblpays_origine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblpays_origine.setForeground(Color.CYAN);
		lblpays_origine.setBounds(12, 523, 116, 16);
		contentPane.add(lblpays_origine);
		
		/////////////////////////////===========================connexion botton enregistrer=====================////////////////////////////////
		
		JButton btnenregistrer = new JButton("Enregistrer");
		btnenregistrer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnenregistrer.setBounds(126, 620, 111, 25);
		btnenregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_client = txtid_client.getText();
				String nom = txtnom.getText();
				String prenom = txtprenom.getText();
				String sexe = comboBoxGender.getSelectedItem().toString();
				String age = txtage.getText();
				String adresse = txtadresse.getText();
				String email = txtemail.getText();
				String Numero_Telephone = txtnumtel.getText();
				String nationalite = txtnationalite.getText();
				String pays_origine = txtpaysorigine.getText();
				
				System.out.println(id_client);	
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(sexe);
				System.out.println(age);
				System.out.println(adresse);
				System.out.println(email);
				System.out.println(Numero_Telephone);
				System.out.println(nationalite);
				System.out.println(pays_origine);
				
	////////////////////////////////////////////////////////////////////////			
				
				
				
				if(nom.trim().length()==0 && prenom.trim().length()==0 && sexe.trim().length()==0 && age.trim().length()==0 && adresse.trim().length()==0
						&& email.trim().length()==0 && Numero_Telephone.trim().length()==0 && nationalite.trim().length()==0 && pays_origine.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null, "BOTH FIELDS ARE NULL");
					
				
							
				}
				else {
					// dbc db = new dbc();
					
					try{
						 dbc db = new dbc();
						 Connection con =db.db_connect();
						 PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO client ( nom, prenom, sexe, age, adresse, email, Numero_Telephone, nationalite, pays_origine) VALUES(?,?,?,?,?,?,?,?,?)");
					//	 stmt.setString(1, id_client);
						 stmt.setString(1, nom);
						 stmt.setString(2, prenom);
						 stmt.setString(3, sexe);
						 stmt.setString(4, age);
						 stmt.setString(5, adresse);
						 stmt.setString(6, email);
						 stmt.setString(7, Numero_Telephone);
						 stmt.setString(8, nationalite);
						 stmt.setString(9, pays_origine);
						//ResultSet rs = stmt.executeQuery();
						 stmt.execute();
							JOptionPane.showMessageDialog(null,"client Enregistrer");
							showTable();
						 
					}catch(Exception e1) {
							System.out.print(e1);
						}	
						
					}
						
					}
				
			
				
				
				
				
			
		});
		contentPane.add(btnenregistrer);
		
	////////////==================validation boutton supprimer====================///////////////
		
		JButton btnsupprimer = new JButton("Supprimer");
		btnsupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id_client = txtid_client.getText();
				String nom = txtnom.getText();
				String prenom = txtprenom.getText();
				String sexe = comboBoxGender.getSelectedItem().toString();
				String age = txtage.getText();
				String adresse = txtadresse.getText();
				String email = txtemail.getText();
				String Numero_Telephone = txtnumtel.getText();
				String nationalite = txtnationalite.getText();
				String pays_origine = txtpaysorigine.getText();
				
				//System.out.println(id_client);	
				//System.out.println(nom);
				//System.out.println(prenom);
				//System.out.println(sexe);
				//System.out.println(age);
				//System.out.println(adresse);
				//System.out.println(email);
				//System.out.println(Numero_Telephone);
				//System.out.println(nationalite);
				//System.out.println(pays_origine);
				
				
				if( id_client.trim().length()==0
						|| nom.trim().length()==0 
						|| prenom.trim().length()==0 
						|| sexe.trim().length()==0 
						|| age.trim().length()==0  
						|| adresse.trim().length()==0 
						||email.trim().length()==0 
						|| Numero_Telephone.trim().length()==0 
						|| nationalite.trim().length()==0 
						|| pays_origine.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
				}else {
					
					try {
						dbc db =new dbc ();
						Connection con = db.db_connect();
						 PreparedStatement stmt = (PreparedStatement) con.prepareStatement("DELETE FROM client WHERE id_client=?");
						  
							stmt.setString(1, id_client);
				            stmt.execute();
				            
							JOptionPane.showMessageDialog(null,"Client effacer");
							showTable();
							
						}catch(Exception e1) {
							System.out.print(e1);
						}	
				}
				
				
				
			}
				
				
			
	
		});
		
		btnsupprimer.setBounds(375, 620, 111, 25);
		contentPane.add(btnsupprimer);
		/////////////////////////////////fin connexion///////////////////////////////////////////////////
		
		txtnom = new JTextField();
		txtnom.setBounds(174, 117, 116, 22);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setBounds(174, 162, 116, 22);
		contentPane.add(txtprenom);
		txtprenom.setColumns(10);
		
		txtage = new JTextField();
		txtage.setBounds(174, 262, 116, 22);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		txtadresse = new JTextField();
		txtadresse.setBounds(174, 306, 116, 22);
		contentPane.add(txtadresse);
		txtadresse.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(174, 352, 116, 22);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtnumtel = new JTextField();
		txtnumtel.setBounds(174, 413, 116, 22);
		contentPane.add(txtnumtel);
		txtnumtel.setColumns(10);
		
		txtnationalite = new JTextField();
		txtnationalite.setBounds(174, 469, 116, 22);
		contentPane.add(txtnationalite);
		txtnationalite.setColumns(10);
		
		txtpaysorigine = new JTextField();
		txtpaysorigine.setBounds(174, 517, 116, 22);
		contentPane.add(txtpaysorigine);
		txtpaysorigine.setColumns(10);
		
		JLabel lblid_client = new JLabel("id_client");
		lblid_client.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblid_client.setForeground(Color.CYAN);
		lblid_client.setBounds(12, 68, 56, 16);
		contentPane.add(lblid_client);
		
		txtid_client = new JTextField();
		txtid_client.setBounds(174, 65, 116, 22);
		contentPane.add(txtid_client);
		txtid_client.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 42, 905, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 597, 878, 2);
		contentPane.add(separator_1);
		table_1 = new JTable() {
		/**
			 * 
			 */
			

		///make rows not editable step 1////////	
			
			public boolean isCellEditable(int row,int column){  
				return false;  
				}	
			
		};
		
		
	//////////////////////////////////validation of combo/////////////////////////////////////////////	
	    comboBoxGender = new JComboBox();
	    comboBoxGender.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		Object selected = comboBoxGender.getSelectedItem();
	 		    if (selected.toString().contentEquals("Female"))
	 		    	filterGender="Female";
	 		
	 		   if (selected.toString().contentEquals("Male"))
	 		    	filterGender="Male";
	 		        
	    		
	    		
	    		
	    		
	    	}
	    });
	    
	    
	    comboBoxGender.setModel(new DefaultComboBoxModel<String>(new String[]
				 {"Female", "Male"}));
		 
	    
	    
	    //////////////////////////////////////////////////////////////////////////////////
		comboBoxGender.setBounds(174, 214, 111, 22);
		contentPane.add(comboBoxGender);
		
		/////////////////////////////////======================configuration boutton modifier========================================////////////////////////
		
		JButton btnmodifier = new JButton("Modifier");
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_client = txtid_client.getText();
				String nom = txtnom.getText();
				String prenom = txtprenom.getText();
				String sexe = comboBoxGender.getSelectedItem().toString();
				String age = txtage.getText();
				String adresse = txtadresse.getText();
				String email = txtemail.getText();
				String Numero_Telephone = txtnumtel.getText();
				String nationalite = txtnationalite.getText();
				String pays_origine = txtpaysorigine.getText();
	
				if(id_client.trim().length()==0||
						nom.trim().length()==0 ||
						prenom.trim().length()==0 || 
						sexe.trim().length()==0||
						age.trim().length()==0||
					    adresse.trim().length()==0||
						email.trim().length()==0||
						Numero_Telephone.trim().length()==0||
						nationalite.trim().length()==0||
						pays_origine.trim().length()==0){					
					JOptionPane.showMessageDialog(null, "Empty txt fields");
				} else {
					

					try {
						dbc db = new dbc();
						Connection con;
						con = db.db_connect();
						PreparedStatement stmt = (PreparedStatement) con.prepareStatement("UPDATE client SET nom=?, prenom=?, sexe= ?, age= ?, adresse=?, email= ?, Numero_Telephone=?, nationalite=?, pays_origine=? where id_client=? ");
						 stmt.setString(1, id_client);
						 stmt.setString(2, nom);
						 stmt.setString(3, prenom);
						 stmt.setString(4, sexe);
						 stmt.setString(5, age);
						 stmt.setString(6, adresse);
						 stmt.setString(7, email);
						 stmt.setString(8, Numero_Telephone);
						 stmt.setString(9, nationalite);
						 stmt.setString(10, pays_origine);
						stmt.execute();
						JOptionPane.showMessageDialog(null,"client modifier");
						showTable();
						
 
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				} 
				
				
				
				
				
				
			}
		});
		btnmodifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnmodifier.setBounds(666, 620, 104, 25);
		contentPane.add(btnmodifier);
		
		//////////================configuring search box====================///////////////////////////
		
		txtSearch = new JTextField();
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//dbc db = new dbc();
				try {
					dbc db = new dbc();
					String searchObject=txtSearch.getText();
					Connection con ;
					con =db.db_connect();
					PreparedStatement clientStmt = con.prepareStatement("SELECT id_client as '#',nom as 'nom',prenom as 'Prénom',age as'Age',adresse as 'Adresse', as 'Email' FROM client WHERE "+filterCriteria+" LIKE ? ");
				   clientStmt.setString(1,"%"+ searchObject +"%");
				   System.out.println(searchObject);
					
				clientStmt.setString(1, txtSearch.getText());
				ResultSet rs = clientStmt.executeQuery();
				
				
				clienttable.setModel(DbUtils.resultSetToTableModel(rs));//link database data to table
				}catch(Exception e) {
				
					System.out.println(e);
				
				
				}
					
				
			}
		});
		txtSearch.setBounds(394, 134, 116, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		
	//////////////////////////////////////////////////////////////////////////	
		
		comboBoxCriteria = new JComboBox();
		comboBoxCriteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Object selected = comboBoxCriteria.getSelectedItem();
	 		    if (selected.toString().contentEquals("Nom"))
	 		    	filterCriteria="nom";
	 		
	 		   if (selected.toString().contentEquals("Prénom"))
	 		    	filterCriteria="prenom";
	 		        
	 		
	 		  if (selected.toString().contentEquals("Email"))
	 		    	filterCriteria="email";
	 		        
	 		// if (selected.toString().contentEquals("Username"))
	 		 //   	filterCriteria="username";
	 		
				
			}
		});
		
		comboBoxCriteria.setModel(new DefaultComboBoxModel<String>(new String[]
				 {"", "Nom", "Prénom", "Email"}));
		
		comboBoxCriteria.setBounds(695, 134, 133, 22);
		contentPane.add(comboBoxCriteria);
		
		/////////////////////////////////////////////
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(325, 191, 772, 384);
		contentPane.add(scrollPane);
		
		clienttable = new JTable() {
		//===========================make rows not editable==================//	
			
			public boolean isCellEditable(int row,int column){  
				return false;  
				}	
		};
		
		
		//=============================make rows clickable==================//
		
		
		clienttable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row=clienttable.getSelectedRow();
					
					String tableClick =(clienttable.getModel().getValueAt(row, 0).toString());
					
				    System.out.print(tableClick);
					dbc db = new dbc();
					Connection con;
					con = db.db_connect();
					PreparedStatement callInfo = (PreparedStatement) con.prepareStatement("SELECT * FROM client WHERE id_client='"+tableClick+ "'");
					ResultSet rs = callInfo.executeQuery();
					if(rs.next()) {
						
						String data1 =rs.getString("id_client");
						String data2 =rs.getString("nom");
						String data3 =rs.getString("prenom");
						String data4 =rs.getString("sexe");
						String data5 =rs.getString("age");
						String data6 =rs.getString("adresse");
						String data7 =rs.getString("email");
						String data8 =rs.getString("pays_origine");
						String data9 =rs.getString("nationalite");
						String data10 =rs.getString("Numero_Telephone");

				
						txtid_client.setText(data1);
						txtnom.setText(data2);
						txtprenom.setText(data3);
						comboBoxGender.setSelectedItem(data4);
						txtage.setText(data5);
						txtadresse.setText(data6);
						txtemail.setText(data7);
						txtpaysorigine.setText(data8);
						txtnationalite.setText(data9);
						txtnumtel.setText(data10);
				
				
			}

			} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			}
			
		
				
						
						
				
				
				
				
				
				
				
				
				
			}
		});
		scrollPane.setViewportView(clienttable);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setForeground(Color.CYAN);
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecherche.setBounds(402, 105, 95, 16);
		contentPane.add(lblRecherche);
		
		JLabel lblCritres = new JLabel("Crit\u00E8res");
		lblCritres.setForeground(Color.CYAN);
		lblCritres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCritres.setBounds(714, 105, 88, 16);
		contentPane.add(lblCritres);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\Eclipse\\SA2\\images\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 1097, 658);
		contentPane.add(lblNewLabel);
		
				

	//////////////////////////////////////////////////////////////	
	}
	public static void showTable(){
		
		
		
		// dbc db = new dbc();
			
			try {
				dbc db = new dbc();
				Connection con ;
				con =db.db_connect();
				PreparedStatement clientStmt = con.prepareStatement("SELECT id_client as '#',nom as 'Nom',prenom as 'Prénom',sexe as'Sexe',age as 'Age',adresse as 'Adresse',email as 'Email',pays_origine as 'Pays origine', nationalite as 'Nationalite', Numero_Telephone as 'Numero Telephone' FROM client");
				ResultSet rs = clientStmt.executeQuery();
				clienttable.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			} catch (Exception e1) {
				System.out.print(e1);
				
			
		
		
	}
}

      private static void setModel(TableModel resultSetToTableModel) {
		// TODO Auto-generated method stub
		
	}
}
