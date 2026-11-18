package Vue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Controleur.Controle;
import Controleur.Global;

public class EntreeJeu extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private JPanel contentPane;
	private JTextField txtIp;
	private Controle controle;

	private void btnExit_clic() {
		System.exit(0);
	}

	private void btnConnect_clic() {
		this.controle.evenementEntreeJeu(txtIp.getText().toString());
	}
	private void btnStart_clic() {
		this.controle.evenementEntreeJeu(SERVEUR);
	}

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param controle
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 302,159);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Start a server :");
		lblNewLabel.setBounds(20, 10, 100, 12);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Connect an existing server :");
		lblNewLabel_1.setBounds(20, 32, 144, 12);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("IP serveur :");
		lblNewLabel_2.setBounds(20, 57, 84, 12);
		contentPane.add(lblNewLabel_2);

		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(82, 54, 96, 18);
		contentPane.add(txtIp);
		txtIp.setColumns(10);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnStart_clic();
			}
		});
		btnStart.setBounds(194, 6, 84, 20);
		contentPane.add(btnStart);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setBounds(194, 53, 84, 20);
		contentPane.add(btnConnect);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnExit_clic();
			}
		});
		btnExit.setBounds(194, 92, 84, 20);
		contentPane.add(btnExit);

		this.controle = controle;

	}

}
