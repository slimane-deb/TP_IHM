package Presentation;

import java.awt.EventQueue;



import javax.imageio.ImageIO;
import javax.swing.JFrame;
//import java.awt.Window.Type;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import controleDuDialogue.Dialogue;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.JScrollBar;



/******** Affichage Graphique , interface utilisateur *****/ 
public class affichage extends JFrame implements ActionListener {

	private JFrame frmPizza;

/* d�claration des tableaux qui contients les noms des images */	
	private String [] listefichiers; // pour les noms des pizzas 
	
	private String [] listefichiers3;// pour les noms des suppl�ments 
	
	private String [] listefichiers2;// pour les noms des tailles 

/* d�claration des tableaux des boutons  */ 	
	private JButton [] listePizza ;
	
	private JButton [] listeTaille ;
	
	private JButton [] listeSupplement ;

/* des entiers pour la v�rification des selections */	
	
	private int pizzaselect=-1;
	
	private int tailleselect=-1;

/* un tableau pour les suppl�ments selectionn�s */	
	private int suppselect [] ; 

/* des tableaux pour les icones des boutons */	
	
	private ImageIcon [] listeicon3;//pour les icones des boutons des suppl�ments 
	
	private ImageIcon [] listeicon2;// pour les icones des boutons de la taille 
	
	private ImageIcon [] listeicon;//pour les icones des boutons du nom des pizza  
	
	
/*on instancie un objet du dialogue*/	
	private Dialogue dialogue ;

/* d�claration des boutons */	
	
	private JButton button = new JButton("Ajouter");
	private JButton button_1 = new JButton("Supprimer");
	private JButton btnEffacer = new JButton("Effacer");
	private JButton btnQuitter = new JButton("Quitter");
	private JButton btnEnvoyer = new JButton("Envoyer");
	private JButton button_2 = new JButton("");

	
/* d�claration des labels */	
	private JLabel lblTotal = new JLabel("Total :");
	private JLabel lblSommeTotal = new JLabel("Somme Total :");
	private JLabel lblNombreTotal = new JLabel("Nombre Total :");
	private JLabel lblDa = new JLabel("00 DA");
	private JLabel label = new JLabel("00 DA");
	private JLabel label_1 = new JLabel("00 DA");
	private JLabel lblDa_1 = new JLabel("00 DA ");
	private JLabel lblPizzas = new JLabel("0 Pizzas");
	private JLabel lblNom = new JLabel("");

	
	private JPanel panel_19 = new JPanel();
	
	
/* d�claration des boutons de menu */ 
	
	private JMenuItem mntmNewMenuItem = new JMenuItem("Ajouter");
	
	private JMenuItem mntmSupprimerPizza = new JMenuItem("Supprimer");
	
	private JMenuItem mntmQuitter = new JMenuItem("Quitter");
	
	
	private JMenuItem mntmAjouter = new JMenuItem("Envoyer ");
	
	 
	private JMenuItem mntmEffacer = new JMenuItem("Effacer ");
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu mnCommande = new JMenu("Pizza");
	
	private JMenu mnCommande_1 = new JMenu("Commande");
	
	
/* on instancie les fenetres de l'aide et de A propos */	
	
	private Apropos win_apropos ;
	private Aide win_aide ;
	
 
/* d�claration un objet model de SModel pour la manipulation du tableau */	
	SModel model;
	Object[][] data = {};
	JTable tableau;
	
	//Les titres des colonnes 
	String title[] = {"Pizza", "Taille", "Suppl�ments", "Prix"};

	
		
	

	/**
	 * Launch the application.
	 */
        
	public static void main(String[] args) {
            
             try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(affichage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					affichage window = new affichage();
					window.frmPizza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public affichage() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private  void initialize() throws IOException {
		
		dialogue =new Dialogue(this);
		frmPizza = new JFrame();
		frmPizza.setResizable(false);
        
		frmPizza.setTitle("PiZzA \t");
		frmPizza.setSize(1110,730);
		
		frmPizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmPizza.setJMenuBar(menuBar);
		
		mnCommande.setMnemonic('P'); // on rajoute un raccourci clavier  
		menuBar.add(mnCommande);
		
		
/* l'�couteur du bouton ajouter une pizza  de la barre de menu */
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean x;
				try {
					
					/*on fait appel � la fonction de l'ajout d'une pizza du dialogue */ 
					x=dialogue.demandeSelection(); 
					if (x==true)
					{
						/* affichage d'un message de succes */
						JOptionPane jop = new JOptionPane();
						ImageIcon ok = new ImageIcon("images/fond/ok.png");
						jop.showMessageDialog(null,"Pizza ajout�e dans la commande ","Ajouter", JOptionPane.INFORMATION_MESSAGE,ok);	
						
					}
					
					else 
					{
						/* affichage d'un message d'erreur */
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null,"Vous Devez choisir un type de pizza , une taille et les suppl�ments s'ils sont n�cessaire !","Erreur", JOptionPane.ERROR_MESSAGE);	
						
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}});
		
/* on rajoute un raccourci clavier pour l'action ajouter un pizza (CTRL + A) */
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		mnCommande.add(mntmNewMenuItem);

		
/* l'�couteur du bouton supprimer une pizza */ 		
		mntmSupprimerPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean x;
				{
					/*on fait appel � la fonction de la suppression d'une pizza du dialogue */ 
					
					x=dialogue.demandeEffacerDernier();
					if (x==true)
					{
						/* affichage d'un message de succes */ 
						JOptionPane jop = new JOptionPane();
						ImageIcon ok = new ImageIcon("images/fond/ok.png");
						jop.showMessageDialog(null,"Pizza supprim�e dans la commande ","Ajouter", JOptionPane.INFORMATION_MESSAGE,ok);	
						
					}
					else 
					{
						/* affichage d'un message d'erreur */
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null,"Vous avez aucune commande !","Erreur", JOptionPane.ERROR_MESSAGE);	
					
					}
					}
				
			}});
		
/* raccourci clavier (CTRL + S) pour supprimer une pizza */  		
		
		mntmSupprimerPizza.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		
		mnCommande.add(mntmSupprimerPizza);


/* un s�parateur entre quitter et les boutons d'une pizza */		
	
		JSeparator separator = new JSeparator();
		mnCommande.add(separator);
		

		
/*l'�couteur du boutons "quitter" de la barre de menu */		
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					JOptionPane jop = new JOptionPane();
					/* affichage d'un message de confirmation */ 
					int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir quitter l'application","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.OK_OPTION)
					{
					/* on fait appel a la fonction quitter du controleur*/
					dialogue.demandeQuiter();}

					
		
	
			}});
				
/*raccourci clavier pour quitter l'application */				
		mntmQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
				
		mnCommande.add(mntmQuitter);

/*raccourci clavier pour le menu Commande */ 		
		mnCommande_1.setMnemonic('C');
		menuBar.add(mnCommande_1);

		
/* l'�couteur du bouton envoyer une commande */		
		mntmAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/* on fait appel � la fonction envoyer liste du  dialogue */
				JOptionPane jop = new JOptionPane();
				int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir Envoyer la liste des commandes","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if (option == JOptionPane.OK_OPTION)
				{
				
				
				dialogue.demandeEnvoyerListe();
				JOptionPane jop2 = new JOptionPane();
				
				ImageIcon ok = new ImageIcon("images/fond/ok.png");
				jop2.showMessageDialog(null,"Commande envoy�e","Commande", JOptionPane.INFORMATION_MESSAGE,ok);	
				
				}	}});

/* raccourci clavier pour l'envoie de la commande */		
		mntmAjouter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		mnCommande_1.add(mntmAjouter);

		
		
/* l'�couteur du bouton effacer une commande de la barre du menu */		
		mntmEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/* on fait appel � la fonction d'effacement d'une commande  du dialogue */
			
				
				
				JOptionPane jop = new JOptionPane();
				int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir supprimer la liste des commandes","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if (option == JOptionPane.OK_OPTION)
				{
				
					dialogue.demandeEffacerListe();
					
					
				}
					
			}});
		
/* raccourci clavier (CTRL+E) pour effacer une commande */		
		mntmEffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		
		mnCommande_1.add(mntmEffacer);

/*le menu autres */		
		JMenu mnNewMenu = new JMenu("Autres");

/* raccourci clavier A */		
		mnNewMenu.setMnemonic('A');
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAide = new JMenuItem("Aide");

		mntmAide.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , KeyEvent.CTRL_MASK));
		mntmAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/* on fait appel � la classe d'affichage de l'aide */	
			 win_aide= new Aide();
			 win_aide.setVisible(true);
				}});
		
		
		
		mnNewMenu.add(mntmAide);

/*un s�parateur entre aide et A propos */		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		
		JMenuItem mntmAPropos = new JMenuItem("A propos");

		mntmAPropos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
/* l'�couteur de A propos */
		mntmAPropos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/* on instancie un objet de classe a propos */	
			 win_apropos= new Apropos();
			 win_apropos.setVisible(true);
				}});
		
		
		mnNewMenu.add(mntmAPropos);
		
		
		frmPizza.getContentPane().setLayout(null);

/* le menu principal */		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(930, 130, 170, 430);
		frmPizza.getContentPane().add(panel);
		panel.setLayout(null);

/* le sous menu pizza */		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(127, 255, 212));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pizza", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(10, 20, 150, 115);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
/* bouton d'ajout d'une pizza */		
		button.setIcon(new ImageIcon("icon\\journal_mirror1.png"));
                button.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		button.setMnemonic('A');
		button.addActionListener(this);
		button.setBounds(10, 25, 130, 32);
		button.setToolTipText("");
		button.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1.add(button);
		

/* bouton de suppression d'une pizza */ 		
		button_1.setIcon(new ImageIcon("icon\\mac_photo_booth_mirror.png"));
                button_1.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		button_1.addActionListener(this);
		button_1.setMnemonic('S');
		
		button_1.setBounds(10, 66, 130, 32);
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_1.add(button_1);

/* le sous-menu commande */		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(127, 255, 212));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Commande", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(10, 160, 150, 150);
		panel.add(panel_2);
		panel_2.setLayout(null);

/* le bouton effacer une commande */		
		btnEffacer.setIcon(new ImageIcon("icon\\recycle_bin_full_mirror.png"));
                btnEffacer.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnEffacer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEffacer.setMnemonic('E');
		
		btnEffacer.addActionListener(this);
		btnEffacer.setBounds(10, 30, 130, 32);
		panel_2.add(btnEffacer);

/* le bouton d'envoi de la commande */		
		btnEnvoyer.setIcon(new ImageIcon("icon\\1 (105).png"));
                btnEnvoyer.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnEnvoyer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEnvoyer.setBounds(10, 82, 130, 32);
		btnEnvoyer.setMnemonic('n');
		btnEnvoyer.addActionListener(this);
		
		panel_2.add(btnEnvoyer);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(127, 255, 212));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sortie", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(0, 191, 255));
		panel_3.setBounds(10, 340, 144, 80);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
/* le bouton quitter */ 
		
		btnQuitter.setIcon(new ImageIcon("icon\\gnome_session_logout.png"));
                btnQuitter.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
//btnQuitter.setHorizontalAlignment(SwingConstants.LEFT) ;
		btnQuitter.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuitter.setBounds(10, 26, 130, 32);
		btnQuitter.setMnemonic('Q');
		
		btnQuitter.addActionListener(this);
		
		panel_3.add(btnQuitter);
		
//*****************************************************************************************		  		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(0, 11, 1148, 649);
		frmPizza.getContentPane().add(panel_4);

/* d�claration du panel qui contient les types des pizzas */ 		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(230, 5, 687, 310);
		panel_5.setBackground(Color.LIGHT_GRAY);
		

/* d�claration du panel qui contient les tailles des pizzas  */ 		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Type de PIZZA", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0,0,0)), "", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Taille", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		
/* d�claration du panel qui contient les suppl�ments des pizzas  */ 		

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Suppl\u00E8ments", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		
/* D�claration d'un repertoire qui contient les types des pizzas */		
				File repertoire=new File("images/TypePizza"); 

/* on v�rifie si le repertoire n'est pas vide */ 				
				if(repertoire.exists()==true)
				{
				
				listefichiers=repertoire.list(); 
				listePizza = new JButton[listefichiers.length];
				listeicon =new ImageIcon[listefichiers.length];
				
				int i;
				
/* on parcourt les images du fichier type de pizza */ 				
				for(i=0;i<listefichiers.length;i++){ 
				
				listeicon[i] = new ImageIcon("images/TypePizza/"+listefichiers[i]);
				
				ImageIcon icon = new ImageIcon(listeicon[i].getImage().getScaledInstance(100,(int)((panel_4.getHeight()*0.15)), Image.SCALE_DEFAULT));

				
				listePizza[i]=new JButton(icon);
				listePizza[i].setIcon(icon);
				listePizza[i].setToolTipText(listefichiers[i].substring(0,listefichiers[i].length()-4));
				listePizza[i].addActionListener(this);
				this.setImagePizza(icon);
				
				listePizza[i].setBorder(BorderFactory.createLineBorder(Color.white));
				panel_6.add(listePizza[i]);
				
				
				}
				}
/* meme principe pour les tailles et les suppl�ments */				
				File repertoire2=new File("images/TaillePizza");  
				if(repertoire2.exists()==true)
				{
				listefichiers2=repertoire2.list(); 
				listeTaille = new JButton[listefichiers2.length];
				listeicon2 =new ImageIcon[listefichiers2.length];
				
				
				for(int i=0;i<listefichiers2.length;i++){ 
				
				listeicon2[i] = new ImageIcon("images/TaillePizza/"+listefichiers2[i]);
				
				ImageIcon icon = new ImageIcon(listeicon2[i].getImage().getScaledInstance(100,(int)((panel_4.getHeight()*0.15))-50, Image.SCALE_DEFAULT));
				
				
				listeTaille[i]=new JButton( icon );
				listeTaille[i].addActionListener(this);
				listeTaille[i].setToolTipText(listefichiers2[i].substring(0,listefichiers2[i].length()-4));
				
				listeTaille[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				panel_7.add(listeTaille[i]);

				
				}
				}
				
				File repertoire3=new File("images/SupplementsPizza");  

				if(repertoire3.exists()==true)
				{
				listefichiers3=repertoire3.list(); 
				listeSupplement = new JButton[listefichiers3.length];
				suppselect=new int[listefichiers3.length];
				for(int i=0;i<suppselect.length;i++)
				{
			
						suppselect[i]=-1;
						
				}
				listeicon3 =new ImageIcon[listefichiers3.length];
				
				
				for(int i=0;i<listefichiers3.length;i++){ 
					//System.out.println(listefichiers3[i].substring(0, listefichiers3[i].length()-4) );
				
				listeicon3[i] = new ImageIcon("images/SupplementsPizza/"+listefichiers3[i]);
				
				ImageIcon icon = new ImageIcon(listeicon3[i].getImage().getScaledInstance(100,(int)((panel_4.getHeight()*0.15))-10, Image.SCALE_DEFAULT));
				
				
				listeSupplement[i]=new JButton( icon );
				listeSupplement[i].addActionListener(this);
				listeSupplement[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				listeSupplement[i].setToolTipText(listefichiers3[i].substring(0,listefichiers3[i].length()-4));
				
				panel_8.add(listeSupplement[i]);
				
				}

				}
		panel_4.setLayout(null);
		
			
			
				
				
		panel_5.setLayout(new GridLayout(3,1));
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_6.setSize((int)((panel_4.getWidth()*0.8)) , (int)((panel_4.getHeight()*0.15)));
		
		
		
		panel_5.add(panel_6);
		
				
		panel_7.setSize((int)((panel_4.getWidth()*0.8)) , (int)((panel_4.getHeight()*0.15)));
		
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_5.add(panel_7);
				
		panel_8.setSize((int)((panel_4.getWidth()*0.8)) , (int)((panel_4.getHeight()*0.15)));
		
		panel_5.add(panel_8);
		
		
		
		
		panel_4.add(panel_5);

/* le tableau de r�capitulatif */ 		
		model=new SModel(data, title);
		tableau = new JTable(model);
		tableau.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableau.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 567, 1036, 71);
		panel_9.setLayout(new GridLayout(1, 2));
		JPanel panel_10 = new JPanel();

/* L'affichage du montant et du nombre des pizzas*/

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Montant", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.add(panel_12);
		
		lblSommeTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_12.add(lblSommeTotal);
		
		lblDa_1.setForeground(Color.BLUE);
		lblDa_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_12.add(lblDa_1);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new TitledBorder(null, "Nombre", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		panel_10.add(panel_13);
		
		lblNombreTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_13.add(lblNombreTotal);
		
		lblPizzas.setForeground(Color.BLUE);
		lblPizzas.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_13.add(lblPizzas);
		
		panel_9.add(panel_10);
		
		panel_4.add(panel_9);
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "R\u00E9capitulatif", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_11.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(10, 21, 667, 193);
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_11.add(scrollPane);
		
		
		
		panel_11.setBounds(230, 332, 687, 225);
		panel_4.add(panel_11);
                //---------------------------------------
                /*JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon("images\\fond\\logo2.png"));
		logo.setBounds(10, 11, 163, 310);
		panel_4.add(logo);
		*/
		JLabel logo_2 = new JLabel("");
		logo_2.setIcon(new ImageIcon("images\\fond\\logo.png"));
		logo_2.setBounds(930, 5, 180, 128);
		panel_4.add(logo_2);
                panel_4.add(panel);
		
		//****************************************************************
                JPanel panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "Prix", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_14.setBounds(7, 332, 200, 224);
		panel_14.setLayout(new GridLayout(3,1));
			
		
		panel_4.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.add(panel_15);
		panel_15.setLayout(new GridLayout(2,1));
		
		JLabel lblNewLabel = new JLabel("Pizza : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_15.add(lblNewLabel);
		
		lblDa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDa.setForeground(Color.RED);
		lblDa.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_15.add(lblDa);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(new GridLayout(2,1));
		
		panel_17.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.add(panel_17);
		
		JLabel lblSupplements = new JLabel("Supplements: ");
		lblSupplements.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupplements.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_17.add(lblSupplements);
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_17.add(label);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_16.setLayout(new GridLayout(2,1));
		
		panel_14.add(panel_16);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_16.add(lblTotal);
		
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_16.add(label_1);

		
/* un panel pour le zoom du choix de l'utilisateur */		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new TitledBorder(null, "Votre choix", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_18.setBounds(10, 5, 200, 310);
		panel_4.add(panel_18);
		panel_18.setLayout(null);
		
		panel_19.setBackground(Color.WHITE);
		panel_19.setBounds(10, 21, 180, 248);
		panel_18.add(panel_19);
		panel_19.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_19.add(button_2);
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setForeground(Color.BLUE);
		
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNom.setBounds(10, 272, 156, 27);
		panel_18.add(lblNom);
		
		
		
		
		
		
	}
	
	
/* les �couteurs des boutons */ 	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				int i;
				
				boolean x;
						
		int boole=0;
		Object source = e.getSource();
		if(boole==0)
		{
/* �couteur du bouton ajouter */ 			
		if(((JButton) source)==button)
		{
			
			try {
				// on fait appel � la m�thode d'ajout d'une pizza 
				x=dialogue.demandeSelection();
				
				//pour les messages de v�rification et d'erreur 
				if (x==true)
				{
					JOptionPane jop = new JOptionPane();
					ImageIcon ok = new ImageIcon("images/fond/ok.png");
					jop.showMessageDialog(null,"Pizza ajout�e dans la commande ","Ajouter", JOptionPane.INFORMATION_MESSAGE,ok);	
					
				}
				else 
				{
					JOptionPane jop = new JOptionPane();
					jop.showMessageDialog(null,"Vous Devez choisir un type de pizza , une taille et les suppl�ments s'ils sont n�cessaire !","Erreur", JOptionPane.ERROR_MESSAGE);	
					
				}
				
				
				
				
				
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		
		
/* �couteur du bouton supprimer une pizza */		
		if(((JButton) source)==button_1)
			{
			// on fait appel � la m�thode de suppression d'une pizza 
			x=dialogue.demandeEffacerDernier();
			// mes message de confirmation et d'erreur 
			if (x==true)
			{
				JOptionPane jop = new JOptionPane();
				ImageIcon ok = new ImageIcon("images/fond/ok.png");
				jop.showMessageDialog(null,"Pizza supprim�e dans la commande ","Ajouter", JOptionPane.INFORMATION_MESSAGE,ok);	
				
			}
			else 
			{
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null,"Vous avez aucune commande !","Erreur", JOptionPane.ERROR_MESSAGE);	
			
			}
			}
		// �couteur du bouton d'effacement d'une commande 
		if(((JButton) source)==btnEffacer)
			{
			
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir supprimer la liste des commandes","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if (option == JOptionPane.OK_OPTION)
			{
			
				dialogue.demandeEffacerListe();
				
				
			}
			
			
			}
		// �couteur du bouton d'envoie d'une commande 
		if(((JButton) source)==btnEnvoyer) 
		{
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir Envoyer la liste des commandes","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if (option == JOptionPane.OK_OPTION)
			{
			
			
			dialogue.demandeEnvoyerListe();
			JOptionPane jop2 = new JOptionPane();
			
			
			}
		}
		//�couteur du bouton de quitter l'application 
		if(((JButton) source)==btnQuitter) 
			{
			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null, "etes-vous sur de vouloir quitter l'application","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (option == JOptionPane.OK_OPTION)
			{
			dialogue.demandeQuiter();}

			}
		}
		if(boole==0)
		{
		// on parcourt la liste des images de type de pizza 	
		for(i=0;i<listePizza.length;i++)
		{
			
			if(((JButton) source)==listePizza[i]) {
				if(pizzaselect==i) {
					pizzaselect=-1;
					((JButton) source).setBorder(BorderFactory.createLineBorder(Color.WHITE));
					try {
						
						// on fait appel au m�thode du choix d'une bouton (icone de l'image ) 
						dialogue.demandeChoix();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				else
				{
					//on met les icones non s�lectionn�es avec une bordure blanche 
					if(pizzaselect != -1) listePizza[pizzaselect].setBorder(BorderFactory.createLineBorder(Color.WHITE));
					pizzaselect=i;
					//sinon , on fait l'image d'une pizza s�l�ctionn�e avec une bordure rouge 
					((JButton) source).setBorder(BorderFactory.createLineBorder(Color.RED,3));
					try {
						dialogue.demandeChoix();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				boole=1;
				break;
			}
		}
		}if(boole==0)
		{
			//meme principe pour les tailles et les suppl�ments 
		for(i=0;i<listeTaille.length;i++)
		{
			if(((JButton) source)==listeTaille[i]) {
			if(tailleselect==i) {
				tailleselect=-1;
				((JButton) source).setBorder(BorderFactory.createLineBorder(Color.WHITE));
				try {
					dialogue.demandeChoix();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				if(tailleselect!=-1) listeTaille[tailleselect].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				tailleselect=i;
				((JButton) source).setBorder(BorderFactory.createLineBorder(Color.RED,3));
				try {
					dialogue.demandeChoix();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			boole=1;
			break;
		}
		}
		}if(boole==0)
		{
		for(i=0;i<listeSupplement.length;i++)
		{
			if(((JButton) source)==listeSupplement[i]) {
				int j;
				for(j=0;j<suppselect.length;j++)
				{
					if((int)suppselect[j]==i) 
					{
						suppselect[j]=-1;
						((JButton) source).setBorder(BorderFactory.createLineBorder(Color.WHITE));
						try {
							dialogue.demandeChoix();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						boole=1;
					}
				}
				
				
				//dabs le cas des suppl�ments on peut choisir plusieurs suppl�ments 
				if(boole==0){
					for(j=0;j<suppselect.length;j++)
					{
						if((int)suppselect[j]==-1) 
						{
							suppselect[j]=i;
							((JButton) source).setBorder(BorderFactory.createLineBorder(Color.RED,3));
							try {
							dialogue.demandeChoix();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						}
						
					}
				}
				
			}
		}
		}
		
		
		
			
	}
	
	//r�cuperation du pizza s�lectionn�e par l'utilisateur 
	public String getNomPizzaSellection(){
		if(pizzaselect!=-1) return listefichiers[pizzaselect].substring(0, listefichiers[pizzaselect].length()-4);
		else return "";
	}
	//r�cup�ration de la taille d'une pizza s�l�ctionn�e par l'utilisateur 
	public String getTaillePizzaSellection(){
		if(tailleselect!=-1) return listefichiers2[tailleselect].substring(0, listefichiers2[tailleselect].length()-4);
		else return "";
	}
	
	public ImageIcon getImagePizzaSellection(){
		
		
		
		if(pizzaselect!=-1) { 
			
			ImageIcon icon = new ImageIcon(listeicon[pizzaselect].getImage().getScaledInstance((int)((panel_19.getWidth())),(int)((panel_19.getHeight())), Image.SCALE_DEFAULT));
			
			return icon;
		}
		else return null;
	}
	
	
	//r�cup�ration d'un ensemble des suppl�ments s�lectionn�es par l'utilisateur 
	public ArrayList getSupplmentPizzaSellection(){
		
		ArrayList supplements = new ArrayList();
		int j=0;
		for(j=0;j<suppselect.length;j++)
		{
			if(suppselect[j]!=-1) 
			{
				supplements.add( listefichiers3[suppselect[j]].substring(0, listefichiers3[suppselect[j]].length()-4));
			}
			
		}

		return supplements;
	}
	//l'affichage du nombre total des pizzas 
	public void setNbrPizza(int nbr){
		
		lblPizzas.setText(""+nbr+"Pizzas");
	}
	//l'affichage du montant total de la commande 
	public void setPrixTotal(double nbr){
		
		lblDa_1.setText(""+nbr+" DA");
	}
	
	//l'affichage du prix d'une pizza 
	public void setPrixPizza(double nbr){
		
		lblDa.setText(""+nbr+" DA");
	}

	//l'affichage du prix total d'une pizza 
	public void setprixTotalePizza(double nbr){
		
		label_1.setText(""+nbr+" DA");
	}

	//l'affichage du prix des suppl�ments 
	public void setprixsupplements(double nbr){
		
		label.setText(""+nbr+" DA");
	}
	
	//l'affichage du nom du pizza 
	public void setNomPizza (String nom) {
		lblNom.setText(nom);
		
	}
	//l'affichage de l'image d'une pizza  
	public void setImagePizza(ImageIcon image)
	{	
		button_2.setIcon(image);
		
	}
	
	//l'ajout d'une pizza au tableau  
	public void ajouterPizza(Object[] lineData){
		
		model.addRow(lineData);
	}
	//suppresion d'une pizza � partir du tableau 
	public void supprimerPizza(){
		
		int a=model.getRowCount()-1;
		model.setRowCount(a);
	}
	
	//suppression d'une commande 
	public void supprimmerCommande(){
																
		model.setRowCount(0);
	}
}
