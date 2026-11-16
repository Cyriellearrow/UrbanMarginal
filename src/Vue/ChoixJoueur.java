package Vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChoixJoueur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPseudo;
	
	/**
	 * frame de Arene
	 */
	private Arene frmArene;
	/**
	 * objet permettant de communiquer avec le contrôleur
	 */

	
	private void lblPrecedent_clic() {}
	private void lblSuivant_clic() {}
	private void lblGo_clic() {
		this.dispose();
		this.frmArene = new Arene();
		this.frmArene.setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setTitle("Choice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(143, 247, 120, 18);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			
		});
		lblPrecedent.setBounds(59, 137, 44, 53);
		contentPane.add(lblPrecedent);
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
			}
			
		});
		lblSuivant.setBounds(292, 137, 44, 53);
		contentPane.add(lblSuivant);
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			
		});
		lblGo.setBounds(302, 200, 77, 65);
		contentPane.add(lblGo);
		
		JLabel lblFond = new JLabel("");
		String chemin = "fonds/fondchoix.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		lblFond.setBounds(0, 0, 400, 275);
		contentPane.add(lblFond);

	}

}
