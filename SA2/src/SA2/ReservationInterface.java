package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class ReservationInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdc;
	private JComboBox<String> comboBox, comboBoxstatut;
	private JComboBox<String> comboBox1, comboBoxcriteria;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationInterface frame = new ReservationInterface();
					frame.setVisible(true);
					showTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private JTextField txtNp;
	private JTextField txtIdClient;
	private static JTable tableReser;
	private JDateChooser dateA;
	private JDateChooser dateD;
	private JDateChooser dateR;
	private JTextField txtNc;
	private JTextField txtSearch;
	private JTextField txtId;
	
	public void refreshTable() {
		try {
			dbc db =new dbc ();
			Connection con;
			 con = (Connection) db.db_connect();
			PreparedStatement reserStmt = con.prepareStatement("Select id_reservation, nombres_personnes, dateArriver,  dateDepart, date_reservation, id_client, id_categorie, num_chambres from reservation");
			ResultSet rs = reserStmt.executeQuery();
		
	reserStmt.close();
	rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Create the frame.
	 */
	public ReservationInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 68, 1275, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Gestion de Reservation");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 29));
		lblNewLabel.setBounds(493, 26, 330, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblReservation = new JLabel("Date Arriv\u00E9e");
		lblReservation.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblReservation.setBounds(12, 188, 195, 29);
		contentPane.add(lblReservation);
		
		JLabel lblreservation = new JLabel("Id_Reservation");
		lblreservation.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblreservation.setBounds(12, 131, 195, 29);
		contentPane.add(lblreservation);
		
		JLabel lblAdulte = new JLabel("Date R\u00E9servation");
		lblAdulte.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblAdulte.setBounds(12, 308, 195, 29);
		contentPane.add(lblAdulte);
		
		JLabel lblChambre = new JLabel("Id Categorie");
		lblChambre.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblChambre.setBounds(12, 543, 195, 29);
		contentPane.add(lblChambre);
		
		JLabel lblFinDeReservation = new JLabel("Date D\u00E9part");
		lblFinDeReservation.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblFinDeReservation.setBounds(12, 249, 195, 29);
		contentPane.add(lblFinDeReservation);
		
		txtIdc = new JTextField();
		txtIdc.setColumns(10);
		txtIdc.setBounds(206, 548, 158, 22);
		contentPane.add(txtIdc);
		
		JDateChooser dateA = new JDateChooser();
		dateA.setBackground(new Color(240, 248, 255));
		dateA.setBounds(206, 188, 158, 29);
		contentPane.add(dateA);
		
		JDateChooser dateD = new JDateChooser();
		dateD.setBounds(206, 249, 158, 29);
		contentPane.add(dateD);
		
		JDateChooser dateR = new JDateChooser();
		dateD.setBounds(206, 249, 158, 29);
		contentPane.add(dateR);
		
		////////////////////=========================SAVE==================/////////////
		////////////////////////////================================////////////////////
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				////collecter des infos depuis le textfield//////
				
				String id = txtId.getText();	
				String nombres_personnes = txtNp.getText();
				
				String dateArriver = ((JTextField)dateA.getDateEditor().getUiComponent()).getText();
				String dateDepart = ((JTextField)dateD.getDateEditor().getUiComponent()).getText();
				String date_reservation = ((JTextField)dateR.getDateEditor().getUiComponent()).getText();
				String statut = comboBoxstatut.getSelectedItem().toString();
				String id_client = txtIdClient.getText();
				String id_categorie = txtIdc.getText();
				String num_chambres =txtNc.getText();
				
				
				
				System.out.println(nombres_personnes);
				System.out.println(dateArriver);
				System.out.println(dateDepart);
				System.out.println( date_reservation);
				System.out.println( statut);
				System.out.println( id_client);
				System.out.println(id_categorie);
				System.out.println(num_chambres);
				
			if(  nombres_personnes.trim().length()==0 || dateArriver.trim().length()==0 || dateDepart.trim().length()==0 || date_reservation.trim().length()==0  || statut.trim().length()==0
				|| id_client.trim().length()==0 ||id_categorie.trim().length()==0 || num_chambres.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
			}else {
				
				try {
					dbc db =new dbc ();
					Connection con;
					 con =(Connection) db.db_connect();
						 PreparedStatement stmt = con.prepareStatement("INSERT INTO  RESERVATION (nombres_personnes, dateArriver, dateDepart, date_reservation, id_client, id_categorie, num_chambres) VALUES(?,?,?,?,?,?,?)");
						  
							stmt.setString(1, nombres_personnes);
							stmt.setString(2, dateArriver);
      						stmt.setString(3, dateDepart);
							stmt.setString(4, date_reservation);
							stmt.setString(5, id_client);
							stmt.setString(6, id_categorie);
							stmt.setString(7,num_chambres);
							
						stmt.execute();
						showTable();
						JOptionPane.showMessageDialog(null,"Utilisateur Enregistrer");
						
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
					
					}
				}
					
				});		
				
				
			
		
		btnEnregistrer.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnEnregistrer.setBounds(246, 697, 131, 29);
		contentPane.add(btnEnregistrer);
		
		
		//////////////===========================================///////////////////////////////
		//////////////=======================DELETE============////////////////////////////////
		JButton btnSupprimer = new JButton("Effacer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();	
				String nombres_personnes = txtNp.getText();
				
				String dateArriver = ((JTextField)dateA.getDateEditor().getUiComponent()).getText();
				String dateDepart = ((JTextField)dateD.getDateEditor().getUiComponent()).getText();
				String date_reservation = ((JTextField)dateR.getDateEditor().getUiComponent()).getText();
				String id_client = txtIdClient.getText();
				String id_categorie = txtIdc.getText();
				String num_chambres =txtNc.getText();
				
				
				System.out.println(nombres_personnes);
				System.out.println(dateArriver);
				System.out.println(dateDepart);
				System.out.println( date_reservation);
				System.out.println( id_client);
				System.out.println(id_categorie);
				System.out.println(num_chambres);
				
			if( id.trim().length()==0 || nombres_personnes.trim().length()==0 || dateArriver.trim().length()==0 || dateDepart.trim().length()==0 || date_reservation.trim().length()==0  
				|| id_client.trim().length()==0 ||id_categorie.trim().length()==0 || num_chambres.trim().length()==0) {
				
					
			} else 
				
			{
				try {
					dbc db =new dbc ();
					Connection con;
					 con =(Connection) db.db_connect();
					PreparedStatement stmt = con.prepareStatement("DELETE FROM reservation WHERE id_reservation=?");
					stmt.setString(1, id);
					stmt.execute();
					showTable();
					
					JOptionPane.showMessageDialog(null,"Form cancel");
					
				}catch(Exception e1) {
				}
			}
		}
		});
		btnSupprimer.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnSupprimer.setBounds(769, 697, 131, 29);
		contentPane.add(btnSupprimer);
		
		
		
		JLabel lblEnfant = new JLabel("Nombres de Personnes");
		lblEnfant.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblEnfant.setBounds(12, 371, 195, 29);
		contentPane.add(lblEnfant);
		
		txtNp = new JTextField();
		txtNp.setColumns(10);
		txtNp.setBounds(206, 374, 158, 27);
		contentPane.add(txtNp);
		
		JLabel lblIdClient = new JLabel("Id Client");
		lblIdClient.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblIdClient.setBounds(12, 488, 195, 29);
		contentPane.add(lblIdClient);
		
		txtIdClient = new JTextField();
		txtIdClient.setColumns(10);
		txtIdClient.setBounds(206, 491, 158, 27);
		contentPane.add(txtIdClient);
		

		JLabel lblNumchambres = new JLabel("Num\u00E9ro de Chambres");
		lblNumchambres.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNumchambres.setBounds(12, 602, 195, 29);
		contentPane.add(lblNumchambres);
		
		txtNc = new JTextField();
		txtNc.setBounds(206, 601, 158, 22);
		contentPane.add(txtNc);
		txtNc.setColumns(10);
		
		txtSearch = new JTextField();

		txtSearch.setBounds(659, 147, 116, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setBounds(672, 117, 85, 16);
		contentPane.add(lblRecherche);
		

		
		
		///////////////////////======================================MODIFIER=========================/////////////////////////////////////////////////////
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				String id = txtId.getText();	
				String nombres_personnes = txtNp.getText();
				
				String dateArriver = ((JTextField)dateA.getDateEditor().getUiComponent()).getText();
				String dateDepart = ((JTextField)dateD.getDateEditor().getUiComponent()).getText();
				String date_reservation = ((JTextField)dateR.getDateEditor().getUiComponent()).getText();
				String status = txtIdClient.getText();
				String id_client = txtIdClient.getText();
				String id_categorie = txtIdc.getText();
				String num_chambres =txtNc.getText();
				
				
//				System.out.println(nombres_personnes);
//				System.out.println(dateArriver);
//				System.out.println(dateDepart);
//				System.out.println( date_reservation);
//				System.out.println( id_client);
//				System.out.println(id_categorie);
//				System.out.println(num_chambres);
				
			if(  nombres_personnes.trim().length()==0 || dateArriver.trim().length()==0 || dateDepart.trim().length()==0 || date_reservation.trim().length()==0 || status.trim().length()==0 
				|| id_client.trim().length()==0 ||id_categorie.trim().length()==0 || num_chambres.trim().length()==0) {
				
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs");
			}else {
				
				try {
					dbc db =new dbc ();
					Connection con;
					 con =(Connection) db.db_connect();
						 PreparedStatement stmt = con.prepareStatement("INSERT INTO  RESERVATION (nombres_personnes, dateArriver, dateDepart, date_reservation,statut, id_client, id_categorie, num_chambres) VALUES(?,?,?,?,?,?,?,?)");
						  
							stmt.setString(1, nombres_personnes);
							stmt.setString(2, dateArriver);
      						stmt.setString(3, dateDepart);
							stmt.setString(4, date_reservation);
							stmt.setString(5, status);
							stmt.setString(6, id_client);
							stmt.setString(7, id_categorie);
							stmt.setString(8,num_chambres);
							
				
							showTable();
							
						}catch(Exception e1) {
							System.out.print(e1);
						}	
				}
				
			}
		});
		btnModifier.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnModifier.setBounds(26, 697, 131, 29);
		contentPane.add(btnModifier);
		
		
		/////////////////====================COMBOBOX===================//////////////////////////////////////
		///////////////////===============================================////////////////////////////////
		comboBoxstatut = new JComboBox();
		comboBoxstatut.setForeground(new Color(255, 250, 240));
		comboBoxstatut.addItem(" ");
		comboBoxstatut.addItem("Occupé");
		comboBoxstatut.addItem("Libre");
		comboBoxstatut.addItem("Hors Service");
		comboBoxstatut.setEditable(false);
		comboBoxstatut.setBounds(206, 432, 158, 29);
		contentPane.add(comboBoxstatut);
		
		 comboBoxcriteria = new JComboBox();
		 comboBoxcriteria.addItem(" ");
		 comboBoxcriteria.addItem("id_reservation");
		 comboBoxcriteria.addItem("id_client");
		 comboBoxstatut.setEditable(false);
		comboBoxcriteria.setBounds(821, 147, 196, 22);
		contentPane.add(comboBoxcriteria);
		
		JLabel lblStatut = new JLabel("Statut");
		lblStatut.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblStatut.setBounds(12, 430, 195, 29);
		contentPane.add(lblStatut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(452, 196, 835, 427);
		contentPane.add(scrollPane);
		
		
		
		//////////////////////====================Pour configurer notre Table============================================//////////////////////////////////
		tableReser = new JTable();
		tableReser.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		tableReser.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = tableReser.getSelectedRow();
					System.out.print(row); //////getSelectedRow() donne l`indice de chaque ranger
					
					String Clicktable = (tableReser.getModel().getValueAt(row, 0).toString());
			////		System.out.print(tableClick);
					
					
					dbc db =new dbc ();
					Connection con;
					 con =(Connection) db.db_connect();
					PreparedStatement callInfo = con.prepareStatement("SELECT * FROM reservation WHERE id_reservation='"+Clicktable+"'"); //////faire la concatenation avec le nom du variable clicktable
					ResultSet rs = callInfo.executeQuery();
					if(rs.next()) {
						
						String data1 = rs.getString("id_reservation");
						String data2 = rs.getString("dateArriver");
						String data3 = rs.getString("dateDepart");
						String data4 = rs.getString("date_reservation");
						String data5 = rs.getString("nombres_personnes");
						String data6 = rs.getString("statut");
						String data7 = rs.getString("id_client");
						String data8 = rs.getString("id_categorie");
						String data9 = rs.getString("num_chambres");


		
						txtId.setText(data1);
						((JTextField)dateA.getDateEditor().getUiComponent()).setText(data2);
						((JTextField)dateD.getDateEditor().getUiComponent()).setText(data3);
						((JTextField)dateR.getDateEditor().getUiComponent()).setText(data4);
						txtNp.setText(data5);
						comboBox.setSelectedItem(data6);
						txtIdClient.setText(data7);
						txtIdc.setText(data8);
						txtNc.setText(data9);
						
						showTable();
					}
					
					
				}catch(Exception e1) {
					System.out.print(e1);
				}
				
			}
			
		});
		scrollPane.setViewportView(tableReser);
		
	
		
		
		
		////////////////////=========================ACTUALISER++++++++++++=============////////////////////////
		JButton btn = new JButton("Actualiser");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				showTable();
				((JTextField)dateA.getDateEditor().getUiComponent()).setText(" ");
				((JTextField)dateD.getDateEditor().getUiComponent()).setText(" ");
				((JTextField)dateR.getDateEditor().getUiComponent()).setText(" ");
				txtNp.setText(" ");
				txtIdClient.setText(" ");
				txtIdc.setText(" ");
				txtNc.setText(" ");
				
			}
		});
		btn.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		btn.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btn.setBounds(1029, 142, 177, 29);
		contentPane.add(btn);
		
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnAnnuler.setBounds(512, 697, 131, 29);
		contentPane.add(btnAnnuler);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(206, 308, 158, 29);
		contentPane.add(dateChooser);
		
		txtId = new JTextField();
		txtId.setBounds(206, 136, 158, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNew = new JButton("Nouveau");
		btnNew.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				formReservation frame = new formReservation();
				frame.setVisible(true);
			}
		});
		btnNew.setBounds(999, 697, 141, 29);
		contentPane.add(btnNew);
		
		JLabel lblCritres = new JLabel("Crit\u00E8res");
		lblCritres.setBounds(868, 117, 56, 16);
		contentPane.add(lblCritres);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\git\\repository\\SA2\\images\\13.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1287, 753);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
	
	
	
	////////////////////////////////////++++++++++++++++++++la fonction showTable+++++++++++++++++++++++++++++++///////////////////////////////////////////
	
	public static void showTable() {
		
		 
		
		try {
			dbc db = new dbc();
			Connection con;
			con = (Connection) db.db_connect();
			PreparedStatement userStmt = con.prepareStatement("SELECT id_reservation AS '#',nombres_personnes as 'nombres_personnes', dateArriver as 'dateArriver',"
					+ " dateDepart as 'dateDepart',date_reservation as 'date_reservation', statut as 'Statut',num_chambres as 'num_chambres' FROM"
					+ " reservation INNER JOIN categorie ON categorie.id_categorie=reservation.id_categorie ");	
		//////////////pour renomer le nom de colonne dans ma table en referant aux noms donnees dans la base de donnees======
		ResultSet rs = userStmt.executeQuery();///////////l`execution du query se fait ici...
		tableReser.setModel(DbUtils.resultSetToTableModel(rs));///////on passe en parametre le resultset 
		
		}catch (Exception e) {
			System.out.print(e);
		}
		
	
	
}
}
