package Vue;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import Controleur.Controle;


public class ChoixJoueur extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPseudo;
	private Controle controle;
	private EntreeJeu frmEntreeJeu;
	private JLabel lblPersonnage;
	private int numPerso = 1;
	private static final int MAXPERSO = 3;

	/**
	 * frame de Arene
	 */
	private Arene frmArene;

	/**
	 * objet permettant de communiquer avec le contrôleur
	 */

	private void lblPrecedent_clic() {
		if (numPerso==1) {
			numPerso = MAXPERSO;
		}
		else {
			numPerso -= 1;
		}
		affichePerso();
	}
	private void lblSuivant_clic() {
		if (numPerso==MAXPERSO) {
			numPerso = 1;
		}
		else {
			numPerso += 1;
		}
		affichePerso();
	}
	private void lblGo_clic() {
		if (txtPseudo.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
		txtPseudo.requestFocus();
		}
		else {
		controle.evenementChoixJoueur(txtPseudo.getText().toString(),numPerso);
		}
	}

	/**
	 * Set the Perso
	 */
	private void affichePerso() {
		String chemin = "personnages/perso"+numPerso+"marche1d1.gif";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblPersonnage.setIcon(new ImageIcon(resource));

	}


	/**
	 * Create the frame.
	 * @param controle
	 */
	public ChoixJoueur(Controle controle) {
		setTitle("Choice");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(143, 115, 120, 118);
		contentPane.add(lblPersonnage);


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
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

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
			@Override
			public void mouseEntered(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
		this.controle = controle;
		affichePerso();

	}


}
