package SA2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class chambre extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum;
	private JTextField txtTarif;
	private JComboBox <String>comboTypeChambre,combo;
	private JTextField textSearch;
	public String filterCriteria;///variable
	private static JTable roomTable;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	dbc db =new dbc ();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chambre frame = new chambre();
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
	public chambre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumChambres = new JLabel("Numero de chambre:");
		lblNumChambres.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNumChambres.setBounds(33, 130, 185, 27);
		contentPane.add(lblNumChambres);
		
		JLabel lblTarif = new JLabel("Tarif de la chambre:");
		lblTarif.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblTarif.setBounds(33, 212, 185, 27);
		contentPane.add(lblTarif);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblType.setBounds(33, 282, 128, 27);
		contentPane.add(lblType);
		
		txtNum = new JTextField();
		txtNum.setBounds(254, 134, 116, 22);
		contentPane.add(txtNum);
		txtNum.setColumns(10);
		
		txtTarif = new JTextField();
		txtTarif.setColumns(10);
		txtTarif.setBounds(254, 216, 116, 22);
		contentPane.add(txtTarif);
		//============================AJOUTER============================
		JButton btnSave = new JButton("Ajouter");
		btnSave.setBackground(Color.CYAN);
		btnSave.setForeground(Color.BLACK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String type =comboTypeChambre.getSelectedItem().toString();
				String tarif =txtTarif.getText();
				
				
				if( type.trim().length()==0 || tarif.trim().length()==0) {

					JOptionPane.showMessageDialog(null, "Empty txt fields");
				} else {
					
					try {
						Connection con = db.db_connect();
						PreparedStatement stmt = con.prepareStatement("INSERT INTO categorie(type,tarif) VALUES( ?, ?)");
						stmt.setString(1, type);
						stmt.setString(2, tarif);
						stmt.execute();
						JOptionPane.showMessageDialog(null, "ajoutee");
						showTable();
 
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				}
			
			}
		});
		btnSave.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnSave.setBounds(39, 608, 122, 36);
		contentPane.add(btnSave);
//========================SUPRIMER================================		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.CYAN);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id_categorie =txtNum.getText();
				String type =comboTypeChambre.getSelectedItem().toString();
				String tarif =txtTarif.getText();
				
				if(id_categorie.trim().length()==0 || type.trim().length()==0 || tarif.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Empty txt fields");
				} else {
					
					try {
						Connection con = db.db_connect();
						PreparedStatement stmt = con.prepareStatement("DELETE FROM categorie WHERE id_categorie=?");
						stmt.setString(1, id_categorie);
						stmt.execute();
						JOptionPane.showMessageDialog(null,"supprimé");
						showTable();
 
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				}	
			}
		});
		
		btnSupprimer.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnSupprimer.setBounds(268, 608, 122, 36);
		contentPane.add(btnSupprimer);
	
	
		
		JSeparator separator = new JSeparator();
		separator.setBounds(80, 64, 783, 2);
		contentPane.add(separator);
		
		JLabel lblTitre = new JLabel("Gestion de Chambres");
		lblTitre.setForeground(new Color(0, 0, 255));
		lblTitre.setFont(new Font("Trebuchet MS", Font.BOLD, 29));
		lblTitre.setBounds(353, 37, 300, 27);
		contentPane.add(lblTitre);
		
		 comboTypeChambre = new JComboBox<String>();
		 comboTypeChambre.addItem("");
		 comboTypeChambre.addItem("Simple");
		 comboTypeChambre.addItem("Double");
		 comboTypeChambre.addItem("Double confort");
		 comboTypeChambre.addItem("Suite");
		 comboTypeChambre.setEditable(false);
		comboTypeChambre.setBounds(254, 286, 116, 22);
		contentPane.add(comboTypeChambre);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.setBackground(Color.CYAN);
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showTable();
			}
		});
		btnActualiser.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnActualiser.setBounds(470, 608, 122, 36);
		contentPane.add(btnActualiser);
	
//===================================MODIFIER========================		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBackground(Color.CYAN);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id_categorie =txtNum.getText();
				String type =comboTypeChambre.getSelectedItem().toString();
				String tarif =txtTarif.getText();
				
				if(id_categorie.trim().length()==0 || type.trim().length()==0 || tarif.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Empty txt fields");
				} else {
					
					try {
						Connection con = db.db_connect();
						PreparedStatement stmt = con.prepareStatement("UPDATE categorie set type=?,tarif=? WHERE id_categorie=?");
						stmt.setString(1, type);
						stmt.setString(2, tarif);
						stmt.setString(3, id_categorie);
						stmt.execute();
						JOptionPane.showMessageDialog(null,"utilisateur modifié");
						showTable();
 
					}catch(Exception e1) {
						System.out.print(e1);
						
					}
				}
			
			}
		});
		btnModifier.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnModifier.setBounds(660, 608, 122, 36);
		contentPane.add(btnModifier);
		
		
//================================filter=========================================
		 combo = new JComboBox<String>();
		 combo.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {

			////creer une variable selected de type objet qui prendre la valeur de comboType			
				Object selected = combo.getSelectedItem();
			if(selected.toString().equals("type")) // quand je clique sur nom c'est le nom qui va apparaitre 
					filterCriteria="type";
			
			if(selected.toString().equals("Tarif"))
				filterCriteria="Tarif";
		
		System.out.println(filterCriteria);
	 		
		 		
		 	}
		 });
		combo.setBounds(1042, 64, 144, 22);
		contentPane.add(combo);
		
	
		//===================SEARCH BOX===================
		textSearch = new JTextField();
		textSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				dbc db =new dbc ();
				
				try {
					String searchObject=textSearch.getText();
					Connection con = db.db_connect();
					 PreparedStatement userStmt = con.prepareStatement(" SELECT id_categorie as '#', type as 'Type', tarif as 'Tarif FROM categorie WHERE "+filterCriteria+" LIKE ?");
				
					 userStmt.setString(1, "%"+ searchObject +"%");
//					userStmt.setString(1, textSearch.getText());
				ResultSet rs=userStmt.executeQuery();
				
				
				roomTable.setModel(DbUtils.resultSetToTableModel(rs));//link database to table
				}catch(Exception e) {
					System.out.println(e);
				}
				
				
			}
		});
		textSearch.setBounds(883, 64, 116, 22);
		contentPane.add(textSearch);
		textSearch.setColumns(10);

		combo.setModel(new DefaultComboBoxModel<String>(new String[] {"","type","tarif"}));
		
		JScrollPane scrollPane = 	new JScrollPane();
		scrollPane.setBounds(456, 130, 642, 409);
		contentPane.add(scrollPane);
		
		roomTable = new JTable();
		scrollPane.setViewportView(roomTable);
		
		JLabel lblRecherche = new JLabel("Recherche");
		lblRecherche.setForeground(Color.WHITE);
		lblRecherche.setBounds(906, 35, 81, 16);
		contentPane.add(lblRecherche);
		
		JLabel lblCritre = new JLabel("Crit\u00E8re");
		lblCritre.setForeground(Color.WHITE);
		lblCritre.setBounds(1053, 35, 81, 16);
		contentPane.add(lblCritre);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Documents\\Eclipse\\SA2\\images\\CHAMBREC.jpg"));
		lblNewLabel.setBounds(12, 0, 1199, 709);
		contentPane.add(lblNewLabel);
	}
	
	
	

public static void showTable() {

	dbc db =new dbc ();
try {
	Connection con = db.db_connect();
	PreparedStatement userStmt = con.prepareStatement("SELECT num_chambre as 'num', tarif as 'Tarif', type as'type' FROM categorie  inner join chambre on chambre.id_categorie = categorie.id_categorie ");//pour renommer le nom de colonne dans ma base de donnee
	ResultSet rs = userStmt.executeQuery();//l'execution du query se fait ici
	roomTable.setModel(DbUtils.resultSetToTableModel(rs)); //on passe en parametre le resultSet
	
} catch(Exception e) {
	System.out.println(e);
}
}
}






;
	
