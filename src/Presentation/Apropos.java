package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
//import java.awt.Window.Type;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;








/**************La classe d'affichage de l'interface a propos ********/
public class Apropos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apropos frame = new Apropos();
					
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
	public Apropos() {
		setAlwaysOnTop(true);
		//setType(POPUP);
		setTitle("A propos");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(400,400);
		
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 11, 265, 233);
		panel.setBorder(new TitledBorder(null, "A propos", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5,1));
		
		JLabel lblCreatedBy = new JLabel("Created By :\r\n");
		lblCreatedBy.setForeground(SystemColor.activeCaption);
		lblCreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatedBy.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		panel.add(lblCreatedBy);
		
		JLabel lblNewLabel = new JLabel("MEKDOUR Yassine");
		lblNewLabel.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblGuernaneHamza = new JLabel("GUERNANE Hamza");
		lblGuernaneHamza.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuernaneHamza.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		panel.add(lblGuernaneHamza);
		
		JLabel lblGroupe = new JLabel("Groupe : ");
		lblGroupe.setForeground(SystemColor.activeCaption);
		lblGroupe.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		lblGroupe.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGroupe);
		
		JLabel lblCs = new JLabel("2 CS - SIT - B2 ");
		lblCs.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		lblCs.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCs);
		
		JLabel lblNewLabel_1 = new JLabel("All right reserved \u00A9  2013 -2014 ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(179, 351, 205, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnOk = new JButton("OK ");
		
		btnOk.setIcon(new ImageIcon("images\\fond\\ok.png"));
		btnOk.setFont(new Font("Biting My Nails", Font.BOLD, 16));
		btnOk.setMnemonic('O'); // on rajoute un raccourci clavier  
		
		btnOk.setBounds(122, 279, 157, 61);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
					
			}});
		
		
		
		contentPane.add(btnOk);
	}
	
	public void exit()
	{
		this.setVisible(false);
	}
}
