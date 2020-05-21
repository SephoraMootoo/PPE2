package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class user extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtUsername;
	private JTextField txtRole;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private static JTable utilisateur;
    private JComboBox<String> comboBox,comboBoxCriteria;     
    private JTextField txtSearch;
    public String filterCriteria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user frame = new user();
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
	public user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txtId.getText();	
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String username = txtUsername.getText();
				String role = txtRole.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String value = comboBox.getSelectedItem().toString();
				
				if(id.trim().length()==0 || nom.trim().length()==0 || prenom.trim().length()==0 || username.trim().length()==0 || role.trim().length()==0  
						|| email.trim().length()==0 ||password.trim().length()==0 || value.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
				}else {
					
					try {
						dbc db =new dbc ();
					Connection con = db.db_connect();
						 PreparedStatement stmt = con.prepareStatement("UPDATE USER SET prenom=?,nom=?,username=?,role=?,email=?,password=? WHERE id_user=?");
						    stmt.setString(7, id);
							stmt.setString(1, prenom);
							stmt.setString(2, nom);
							stmt.setString(4, role);
							stmt.setString(5, email);
							stmt.setString(3, username);
							stmt.setString(6, password);
							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null,"Mise à jour effectuée");
							showTable();
						}catch(Exception e1) {
							System.out.print(e1);
						}	
				}
				
	
				
				
				
				
				
			}
		});
		btnModifier.setBounds(12, 495, 97, 25);
		contentPane.add(btnModifier);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();	
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String username = txtUsername.getText();
				String role = txtRole.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String value = comboBox.getSelectedItem().toString();
				
				if(  nom.trim().length()==0 || prenom.trim().length()==0 || username.trim().length()==0 || role.trim().length()==0  
						|| email.trim().length()==0 ||password.trim().length()==0 || value.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
				}else {
					
					try {
						dbc db =new dbc ();
					Connection con = db.db_connect();
						 PreparedStatement stmt = con.prepareStatement("INSERT INTO  USER (prenom,nom,role,email,username,password) VALUES(?,?,?,?,?,?)");
						  
							stmt.setString(1, prenom);
							stmt.setString(2, nom);
							stmt.setString(4, role);
							stmt.setString(5, email);
							stmt.setString(3, username);
							stmt.setString(6, password);
						
							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null,"Mise à jour effectuée");
							showTable();
						}catch(Exception e1) {
							System.out.print(e1);
						}	
				}
				
				
				
			}
		});
		btnNouveau.setBounds(229, 495, 97, 25);
		contentPane.add(btnNouveau);
		
		JButton btnEffacer = new JButton("Effacer");
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				String username = txtUsername.getText();
				String role = txtRole.getText();
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String value = comboBox.getSelectedItem().toString();
				
				if(  nom.trim().length()==0 || prenom.trim().length()==0 || username.trim().length()==0 || role.trim().length()==0  
						|| email.trim().length()==0 ||password.trim().length()==0 || value.trim().length()==0) {
					
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
				}else {
					
					try {
						dbc db =new dbc ();
						Connection con = db.db_connect();
						 PreparedStatement stmt = con.prepareStatement("DELETE FROM USER WHERE id_user=?");
						  
							stmt.setString(1, id);
				 
						
							stmt.executeUpdate();
							JOptionPane.showMessageDialog(null,"Mise à jour effectuée");
							showTable();
						}catch(Exception e1) {
							System.out.print(e1);
						}	
				}
				
				
				
			}
		});
		btnEffacer.setBounds(457, 495, 97, 25);
		contentPane.add(btnEffacer);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTable();
				
			}
		});
		
		btnActualiser.setBounds(720, 495, 97, 25);
		contentPane.add(btnActualiser);
		
		JLabel lblGestionUtilisateur = new JLabel("Gestion Utilisateur");
		lblGestionUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGestionUtilisateur.setBounds(361, 29, 133, 25);
		contentPane.add(lblGestionUtilisateur);
		
		JLabel lblid = new JLabel("id");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblid.setForeground(Color.WHITE);
		lblid.setBounds(33, 78, 28, 16);
		contentPane.add(lblid);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenom.setForeground(Color.WHITE);
		lblPrenom.setBounds(33, 179, 56, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblusername = new JLabel("Nom utilisateur");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblusername.setForeground(Color.WHITE);
		lblusername.setBounds(32, 238, 105, 16);
		contentPane.add(lblusername);
		
		JLabel lblRole = new JLabel("role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRole.setForeground(Color.WHITE);
		lblRole.setBounds(33, 291, 56, 16);
		contentPane.add(lblRole);
		
		JLabel lblemail = new JLabel("email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblemail.setForeground(Color.WHITE);
		lblemail.setBounds(33, 345, 56, 16);
		contentPane.add(lblemail);
		
		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(33, 408, 87, 16);
		contentPane.add(lblPassword);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setForeground(Color.WHITE);
		lblNom.setBounds(33, 135, 56, 16);
		contentPane.add(lblNom);
		
		txtId = new JTextField();
		txtId.setBounds(173, 75, 116, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(173, 132, 116, 22);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(173, 176, 116, 22);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(173, 235, 116, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtRole = new JTextField();
		txtRole.setBounds(173, 288, 116, 22);
		contentPane.add(txtRole);
		txtRole.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(173, 342, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBounds(173, 405, 116, 22);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
	
	
		
		scrollPane.setBounds(439, 121, 456, 334);
		contentPane.add(scrollPane);
		
		utilisateur = new JTable() {
			/////////////////////////////////////////////////make rows not editable step 1
		
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		};
		
		
		///////////////////////////////////////////////////Make rows not editable
		
		//////////////////////////////////////////////////Make rows clickable step 2
		

		utilisateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					int row = utilisateur.getSelectedRow();
//					System.out.print(row);
					
					String tableClick = (utilisateur.getModel().getValueAt(row,0).toString());
					
					System.out.print(tableClick);
					 dbc db = new dbc();
					Connection con;
					con = db.db_connect ();
					PreparedStatement callInfo = con.prepareStatement("SELECT * FROM user WHERE  ");
					ResultSet rs = callInfo.executeQuery();
					if(rs.next()) {
						
						String data1 = rs.getString("id_user");
						String data2 = rs.getString("nom");
						String data3 = rs.getString("prenom");
						String data4 = rs.getString("username");
						String data5 = rs.getString("role");
						String data6 = rs.getString("email");
						String data7 = rs.getString("password");
						
						
//						System.out.print(data1);
//						System.out.print(data2);
//						System.out.print(data3);
//						System.out.print(data4);
//						System.out.print(data5);
//						System.out.print(data6);
//						System.out.print(data7);
						
						txtId.setText(data1);
						txtNom.setText(data2);
						txtPrenom.setText(data3);
						txtUsername.setText(data4);
						txtRole.setText(data5);
						txtEmail.setText(data6);
						txtPassword.setText(data7);
					    comboBox.setSelectedItem(data5);
						
					}
					
				
				} catch(Exception ex) {
				
		JOptionPane.showMessageDialog(null, ex);
				
				}
			}
					
		
		});
		scrollPane.setViewportView(utilisateur);
		
		
		 comboBox = new JComboBox();
		comboBox.addItem("administrateur");
		comboBox.addItem("utilisateur");
		comboBox.setBounds(120, 433, 270, 22);
		comboBox.setEditable(false);
		contentPane.add(comboBox);
		
		 comboBoxCriteria = new JComboBox();
		 comboBoxCriteria.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		
		 		Object selected = comboBoxCriteria.getSelectedItem();
		 		    if (selected.toString().contentEquals("Nom"))
		 		    	filterCriteria="nom";
		 		
		 		   if (selected.toString().contentEquals("Prénom"))
		 		    	filterCriteria="prenom";
		 		        
		 		
		 		  if (selected.toString().contentEquals("Email"))
		 		    	filterCriteria="email";
		 		        
		 		 if (selected.toString().contentEquals("Username"))
		 		    	filterCriteria="username";
		 		
		 		
		 	}
		 });
		 
		 comboBoxCriteria.setModel(new DefaultComboBoxModel<String>(new String[]
				 {"", "Nom", "Prénom", "Email", "Username"}));
		 
		 
		comboBoxCriteria.setBounds(644, 75, 116, 22);
		contentPane.add(comboBoxCriteria);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				dbc db = new dbc();
				try {
				    
					String searchObject=txtSearch.getText();
					Connection con ;
					con =db.db_connect();
					PreparedStatement userStmt = con.prepareStatement("SELECT id_user as '#',nom as 'Nom',prenom as 'Prénom',username as'Username',role as 'Role',email as 'Email' FROM user WHERE "+filterCriteria+" LIKE ? ");
				   userStmt.setString(1,"%"+ searchObject +"%");
				   System.out.println(searchObject);
					
//				userStmt.setString(1, txtSearch.getText());
				ResultSet rs = userStmt.executeQuery();
				
				
				utilisateur.setModel(DbUtils.resultSetToTableModel(rs));//link database data to table
				}catch(Exception e) {
				
					System.out.println(e);
				
				
				}
					
				}
		});
		txtSearch.setBounds(482, 75, 116, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRecherche.setBounds(468, 46, 97, 16);
		contentPane.add(lblRecherche);
		
		JLabel lblCritère = new JLabel("Crit\u00E8re");
		lblCritère.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCritère.setForeground(Color.WHITE);
		lblCritère.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCritère.setBounds(609, 46, 97, 16);
		contentPane.add(lblCritère);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\git\\repository\\SA2\\images\\user.jpg"));
		lblNewLabel.setBounds(0, 0, 907, 533);
		contentPane.add(lblNewLabel);
		
		
		

		
		
	}
	
	public static void showTable() {
		
		 dbc db = new dbc();
		
		try {
			
			Connection con ;
			con =db.db_connect();
			PreparedStatement userStmt = con.prepareStatement("SELECT id_user as '#',nom as 'Nom',prenom as 'Prénom',username as'Username',role as 'Role',email as 'Email' FROM user");
			ResultSet rs = userStmt.executeQuery();
			utilisateur.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e1) {
			System.out.print(e1);
			
		}
	}
}
