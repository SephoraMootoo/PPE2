package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class formReservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtNp;
	private JTextField txtIdClient;
	private JTextField txtIdc;
	private JTextField txtNc;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtage;
	private JTextField txtadresse;
	private JTextField txtemail;
	private JTextField txtnumtel;
	private JTextField txtnationalite;
	private JTextField txtpaysorigine;
	private JComboBox<String> comboBoxGender;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formReservation frame = new formReservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formReservation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormReservation = new JLabel("Formulaire Res\u00E9rvation");
		lblFormReservation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFormReservation.setBounds(326, 33, 251, 53);
		contentPane.add(lblFormReservation);
		
		JLabel lblNp = new JLabel("Nombres de Personnes");
		lblNp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNp.setForeground(Color.GREEN);
		lblNp.setBounds(12, 140, 148, 16);
		contentPane.add(lblNp);
		
		JLabel lblDatearriver = new JLabel("Date Arriv\u00E9e");
		lblDatearriver.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatearriver.setForeground(Color.GREEN);
		lblDatearriver.setBounds(12, 184, 107, 16);
		contentPane.add(lblDatearriver);
		
		JLabel lblDatedepart = new JLabel("Date D\u00E9part");
		lblDatedepart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatedepart.setForeground(Color.GREEN);
		lblDatedepart.setBounds(12, 228, 107, 16);
		contentPane.add(lblDatedepart);
		
		
		comboBoxGender = new JComboBox<String>();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Masculin","Feminin"}));
		comboBoxGender.setBounds(624, 225, 116, 22);
		contentPane.add(comboBoxGender);
		
		JLabel lblDatereservation = new JLabel("Date de R\u00E9servation");
		lblDatereservation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDatereservation.setForeground(Color.GREEN);
		lblDatereservation.setBounds(12, 267, 123, 16);
		contentPane.add(lblDatereservation);
		
		JLabel lblstatut = new JLabel("Statut");
		lblstatut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblstatut.setForeground(Color.GREEN);
		lblstatut.setBounds(12, 315, 56, 16);
		contentPane.add(lblstatut);
		
		JLabel lblIdclient = new JLabel("Id_Client");
		lblIdclient.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdclient.setForeground(Color.GREEN);
		lblIdclient.setBounds(12, 356, 77, 16);
		contentPane.add(lblIdclient);
		
		JLabel txtSexe = new JLabel("Id_Categorie");
		txtSexe.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSexe.setForeground(Color.GREEN);
		txtSexe.setBounds(12, 399, 95, 16);
		contentPane.add(txtSexe);
		
		txtNp = new JTextField();
		txtNp.setBounds(177, 137, 116, 22);
		contentPane.add(txtNp);
		txtNp.setColumns(10);
		
		JDateChooser dateA = new JDateChooser();
		dateA.setBounds(177, 178, 116, 22);
		contentPane.add(dateA);
		
		JDateChooser dateD = new JDateChooser();
		dateD.setBounds(177, 222, 116, 22);
		contentPane.add(dateD);
		
		JDateChooser dateR = new JDateChooser();
		dateR.setBounds(177, 261, 116, 22);
		contentPane.add(dateR);
		
		txtIdClient = new JTextField();
		txtIdClient.setBounds(177, 353, 116, 22);
		contentPane.add(txtIdClient);
		txtIdClient.setColumns(10);
		
		txtIdc = new JTextField();
		txtIdc.setBounds(177, 396, 116, 22);
		contentPane.add(txtIdc);
		txtIdc.setColumns(10);
		
		
		JLabel lblNumchambres = new JLabel("Num\u00E9ro de Chambres");
		lblNumchambres.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumchambres.setForeground(Color.GREEN);
		lblNumchambres.setBounds(12, 435, 142, 16);
		contentPane.add(lblNumchambres);
		
		txtNc = new JTextField();
		txtNc.setBounds(177, 432, 116, 22);
		contentPane.add(txtNc);
		txtNc.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setForeground(Color.GREEN);
		lblNom.setBounds(521, 140, 56, 16);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrenom.setForeground(Color.GREEN);
		lblPrenom.setBounds(521, 184, 56, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexe.setForeground(Color.GREEN);
		lblSexe.setBounds(521, 228, 56, 16);
		contentPane.add(lblSexe);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAge.setForeground(Color.GREEN);
		lblAge.setBounds(521, 267, 56, 16);
		contentPane.add(lblAge);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setForeground(Color.GREEN);
		lblAdresse.setBounds(521, 315, 56, 16);
		contentPane.add(lblAdresse);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setForeground(Color.GREEN);
		lblEmail.setBounds(521, 356, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblNumeroTelephone = new JLabel("Numero Telephone");
		lblNumeroTelephone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumeroTelephone.setForeground(Color.GREEN);
		lblNumeroTelephone.setBounds(503, 399, 123, 16);
		contentPane.add(lblNumeroTelephone);
		
		JLabel lblNationalite = new JLabel("Nationalite");
		lblNationalite.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNationalite.setForeground(Color.GREEN);
		lblNationalite.setBounds(521, 435, 91, 16);
		contentPane.add(lblNationalite);
		
		JLabel lblPaysOrigine = new JLabel("Pays Origine");
		lblPaysOrigine.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPaysOrigine.setForeground(Color.GREEN);
		lblPaysOrigine.setBounds(521, 488, 91, 16);
		contentPane.add(lblPaysOrigine);
		
		txtnom = new JTextField();
		txtnom.setBounds(624, 137, 116, 22);
		contentPane.add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(624, 181, 116, 22);
		contentPane.add(txtprenom);
		
		txtage = new JTextField();
		txtage.setColumns(10);
		txtage.setBounds(624, 264, 116, 22);
		contentPane.add(txtage);
		
		txtadresse = new JTextField();
		txtadresse.setColumns(10);
		txtadresse.setBounds(624, 312, 116, 22);
		contentPane.add(txtadresse);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(624, 353, 116, 22);
		contentPane.add(txtemail);
		
		txtnumtel = new JTextField();
		txtnumtel.setColumns(10);
		txtnumtel.setBounds(624, 396, 116, 22);
		contentPane.add(txtnumtel);
		
		txtnationalite = new JTextField();
		txtnationalite.setColumns(10);
		txtnationalite.setBounds(624, 432, 116, 22);
		contentPane.add(txtnationalite);
		
		txtpaysorigine = new JTextField();
		txtpaysorigine.setColumns(10);
		txtpaysorigine.setBounds(624, 485, 116, 22);
		contentPane.add(txtpaysorigine);
		
		JComboBox<String> comboBoxStatut = new JComboBox();
		comboBoxStatut.addItem(" ");
		comboBoxStatut.addItem("Occupé");
		comboBoxStatut.addItem("Libre");
		comboBoxStatut.addItem("Hors Service");
		comboBoxStatut.setEditable(false);
		comboBoxStatut.setBounds(177, 309, 116, 22);
		contentPane.add(comboBoxStatut);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.GREEN);
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnregistrer.setForeground(new Color(0, 0, 0));
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
//				////collecter des infos depuis le textfield//////
				String nom = txtnom.getText();
				String prenom = txtprenom.getText();
				String sexe = comboBoxGender.getSelectedItem().toString();
				String age = txtage.getText();
				String adresse = txtadresse.getText();
				String email = txtemail.getText();
				String pays_origine = txtpaysorigine.getText();
				String nationalite = txtnationalite.getText();
				String Numero_Telephone = txtnumtel.getText();
				
//					
				String nombres_personnes = txtNp.getText();
				String dateArriver = ((JTextField)dateA.getDateEditor().getUiComponent()).getText();
				String dateDepart = ((JTextField)dateD.getDateEditor().getUiComponent()).getText();
				String date_reservation = ((JTextField)dateR.getDateEditor().getUiComponent()).getText();
				String statut = comboBoxStatut.getSelectedItem().toString();
				String id_client = txtIdClient.getText();
				String id_categorie = txtIdc.getText();
				String num_chambres =txtNc.getText();
//				
//					
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(sexe);
				System.out.println(age);
				System.out.println(adresse);
				System.out.println(email);
				System.out.println(Numero_Telephone);
				System.out.println(nationalite);
				System.out.println(pays_origine);
				System.out.println(nombres_personnes);
				System.out.println(dateArriver);
				System.out.println(dateDepart);
				System.out.println( date_reservation);
				
				System.out.println(id_categorie);
				System.out.println(num_chambres);
	////////////////////////////////////////////////////////////////////////			
				
				
				
				if(nom.trim().length()==0 && prenom.trim().length()==0 && sexe.trim().length()==0 && age.trim().length()==0 && adresse.trim().length()==0
						&& email.trim().length()==0 && pays_origine.trim().length()==0 && nationalite.trim().length()==0&& Numero_Telephone.trim().length()==0  ) {
					JOptionPane.showMessageDialog(null, "Remplissez tous les champs SVP");
					return;}else
	
				try {
					dbc db =new dbc ();
					 Connection con;
					 String id;
					 con =(Connection) db.db_connect();
					 PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO client( nom, prenom, "
					 		+ "sexe, age, adresse, email, Numero_Telephone, nationalite, pays_origine) VALUES(?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
					 stmt.setString(1, nom);
					 stmt.setString(2, prenom);
					 stmt.setString(3, sexe);
					 stmt.setString(4, age);
					 stmt.setString(5, adresse);
					 stmt.setString(6, email);
					 stmt.setString(7, Numero_Telephone);
					 stmt.setString(8, nationalite);
					 stmt.setString(9, pays_origine);
					 stmt.executeUpdate();
					 JOptionPane.showMessageDialog(null,"client Enregistrer");
					 
					 ResultSet rs=stmt.getGeneratedKeys();
					 if(rs.next()) {
						
					 
						 PreparedStatement r  = con.prepareStatement("INSERT INTO  Reservation (nombres_personnes, dateArriver, dateDepart,"
						 		+ " date_reservation, statut, id_client, id_categorie, num_chambres) VALUES(?,?,?,?,?,?,?,?)");
						  
							r.setString(1, nombres_personnes);
							r.setString(2, dateArriver);
      						r.setString(3, dateDepart);
							r.setString(4, date_reservation);
							r.setString(5, statut);
							r.setString(6, id_client);
							r.setString(7, id_categorie);
							r.setString(8,num_chambres);
							
						r.executeUpdate();}
					
						JOptionPane.showMessageDialog(null,"Reservation Enregistrer");
						
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				
				}
				 

			
					
				});	
		btnEnregistrer.setBounds(366, 506, 116, 37);
		contentPane.add(btnEnregistrer);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\Eclipse\\SA2\\images\\reservation.jpg"));
		lblNewLabel_1.setBounds(0, 0, 927, 557);
		contentPane.add(lblNewLabel_1);
		

		

		
	
	}
}
