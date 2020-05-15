package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	public String priviledge;
	public String myname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("role","nom");
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
	public Dashboard(String priviledge, String myname) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonPradis = new JLabel("Mon Pradis");
		lblMonPradis.setBounds(165, 26, 73, 16);
		contentPane.add(lblMonPradis);
		
		JButton btnClients = new JButton("Clients");
		btnClients.setBounds(27, 67, 97, 25);
		btnClients.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			client client = new client();
			client.showTable();
			client.setVisible(true);
			}
		});
		
		JButton btnChambre = new JButton("Chambres");
		btnChambre.setBounds(27, 117, 97, 25);
		btnChambre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			chambre chambre= new chambre();
				chambre.showTable();
				chambre.setVisible(true);
				}
			});
		
		
		JButton btnReservation = new JButton("Reservation");
		btnReservation.setBounds(27, 159, 97, 25);
		btnReservation.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ReservationInterface ReservationInterface= new  ReservationInterface();
				 ReservationInterface.showTable();
				 ReservationInterface.setVisible(true);
				}
			});
		
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				user user = new user();
				user.showTable();
				user.setVisible(true);
			}
		});
		btnUtilisateur.setBounds(27, 197, 97, 25);
		
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(230, 215, 116, 25);
		contentPane.add(btnDeconnexion);
		
		JLabel lblGestion = new JLabel("Gestion");
		lblGestion.setBounds(273, 86, 48, 16);
		contentPane.add(lblGestion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\Eclipse\\SA2\\images\\mer.jpg"));
		lblNewLabel.setBounds(0, 0, 432, 253);
		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\mer.jpg"));
//		lblNewLabel.setBounds(0, 0, 443, 253);
//		contentPane.add(lblNewLabel);
		
		System.out.println(priviledge);
		System.out.println(myname);
		
		try {
			
			
		 if (priviledge.equals("administrateur")) {
			 
				contentPane.add(btnChambre);
				contentPane.add(btnReservation);
				contentPane.add(btnClients);
				contentPane.add(btnUtilisateur);
			 
		 }else if (priviledge.equals("utilisateur")) {
				contentPane.add(btnChambre);
				contentPane.add(btnReservation);
				contentPane.add(btnClients);
		 }
			
		}catch(Exception e) {
			
			
		}
		
//		try {
//			if (priviledge.equals("Administrateur")) {
//		
//			contentPane.add(btnChambres);
//			contentPane.add(btnReservation);
//			contentPane.add(btnClients);
//			contentPane.add(btnUtilisateur);}
//			
//		}else  if (priviledge.equals("utilisateur")) {
//			contentPane.add(btnChambres);
//			contentPane.add(btnReservation);
//			contentPane.add(btnUtilisateur);
//		}
//		
//		catch(Exception e) {
//			System.out.print(e);}
//		
			
		
	}
		
		}
