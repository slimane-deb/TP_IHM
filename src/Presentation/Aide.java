package Presentation;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;



/********La classe Aide pour afficher l'interface d'aide  ******/
public class Aide extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aide frame = new Aide();
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
	public Aide() {
		setTitle("Aide");
		setSize(400,400);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,1));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aide PDF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblConsulterLaideversion = new JLabel("Consulter l'aide (Version PDF) ");
		lblConsulterLaideversion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblConsulterLaideversion.setBounds(10, 32, 194, 35);
		panel_1.add(lblConsulterLaideversion);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icon\\Documents Folder.png"));
		label.setBackground(Color.BLUE);
		label.setForeground(Color.BLUE);
		label.setBounds(204, 11, 214, 107);
		panel_1.add(label);
		
		JButton btnCliquerIci = new JButton("Cliquer Ici");
		
		btnCliquerIci.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCliquerIci.setBounds(20, 69, 149, 54);
		btnCliquerIci.setMnemonic('C'); // on rajoute un raccourci clavier  
		
		btnCliquerIci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Desktop d=Desktop.getDesktop();
				try {
					d.open(new File("aide\\MANUEL.pdf"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
					
			}});
		
	
		
		panel_1.add(btnCliquerIci);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tutoriel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsulterLaideAvec = new JLabel("Consulter l'aide avec Video ");
		lblConsulterLaideAvec.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblConsulterLaideAvec.setBounds(10, 33, 172, 35);
		panel.add(lblConsulterLaideAvec);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icon\\1 (232).png"));
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(206, 11, 214, 107);
		panel.add(lblNewLabel);
		
		JButton button = new JButton("Cliquer Ici");
		
		button.setMnemonic('l'); // on rajoute un raccourci clavier  
		
		button.setFont(new Font("Times New Roman", Font.BOLD, 12));
		button.setBounds(20, 63, 144, 55);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Desktop d=Desktop.getDesktop();
				try {
					d.open(new File("aide\\ihm.avi"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}});
		
	
		
		panel.add(button);
	}

}
