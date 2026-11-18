package Vue;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controleur.Global;

public class Arene extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpnMurs;
	private JTextField txtSaisie;

	/**
	 * Affichage d'un mur
	 * @param unMur
	 */
	public void ajoutMurs(Object unMur) {
		jpnMurs.add((JLabel)unMur);
		jpnMurs.repaint();
	}
	
	public JPanel getJpnMurs() {
		return this.jpnMurs;
	}
	
	public void setJpnMurs(JPanel jpnMurs) {
		this.jpnMurs.add(jpnMurs);
		this.jpnMurs.repaint();
	}


	/**
	 * Create the frame.
	 */
	public Arene() {
		setTitle("Arena");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800, 600 + 25 + 140));
		this.pack();
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, LARGEURARENE, HAUTEURARENE);
		jpnMurs.setOpaque(false);
		jpnMurs.setLayout(null);
		contentPane.add(jpnMurs);

		JLabel lblFond = new JLabel("");
		String chemin = "fonds/fondarene.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);

		txtSaisie = new JTextField();
		txtSaisie.setBounds(0, 600, 800, 25);
		contentPane.add(txtSaisie);
		txtSaisie.setColumns(10);

		JScrollBar jspChat = new JScrollBar();
		jspChat.setBounds(769, 620, 31, 145);
		contentPane.add(jspChat);

		JTextArea textChat = new JTextArea();
		textChat.setBounds(0, 625, 800, 140);
		contentPane.add(textChat);

	}
}
