package Controleur;

import javax.swing.JPanel;

import Vue.Arene;
import Vue.ChoixJoueur;
import Vue.EntreeJeu;
import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;

public class Controle implements AsyncResponse, Global{

	private EntreeJeu frmEntreeJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private String typeJeu;
	private Jeu leJeu;
	private JeuClient JeuClient;

	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}

	/**
	 * Gère les demandes provenant de ChoixJoueur
	 * @param pseudo
	 * @param numPerso
	 */
	public void evenementChoixJoueur(String pseudo,int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
		((JeuClient)this.leJeu).envoi(PSEUDO + SEPARATOR + pseudo + SEPARATOR + numPerso);
	}

	/**
	 * Envoi d'une information vers l'ordinateur distant
	 * @param connection
	 * @param info
	 */
	public void envoi(Connection connection,Object info) {
		connection.envoi(info);
	}

	/**
	 * Gèe les demandes provenant de EntreeJeu
	 * @param info
	 */
	public void evenementEntreeJeu(String info) {
		if (info.equals(SERVEUR)) {
			this.typeJeu = SERVEUR;
			new ServeurSocket(this, PORT);
			this.leJeu = new JeuServeur(this);
			this.frmEntreeJeu.dispose();
			this.frmArene =  new Arene();
			((JeuServeur)leJeu).constructionMurs();
			this.frmArene.setVisible(true);

		}
		else {
			this.typeJeu = CLIENT;
			new ClientSocket(this,info,PORT);
		}


	}

	public void evenementJeuServeur(String ordre, Object info) {
		switch (ordre) {
			case AJOUTMUR:
				this.frmArene.ajoutMurs(info);
				break;
			case AJOUTPANELMURS:
				this.leJeu.envoi((Connection) info,this.frmArene.getJpnMurs());

		}
		}


	/**
	 * Méthode d'entrée dans l'application
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();

	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		switch (ordre){
			case CONNEXION:
				if (!(this.leJeu instanceof JeuServeur)) {
					this.frmEntreeJeu.dispose();
					this.frmChoixJoueur = new ChoixJoueur(this);
					this.frmArene = new Arene();
					this.frmChoixJoueur.setVisible(true);
					this.leJeu = new JeuClient(this);
					this.leJeu.connexion(connection);
				}
				else {
					this.leJeu.connexion(connection);
				}
					break;
			case RECEPTION:
				this.leJeu.reception(connection,info);
				break;
			case DECONNEXION:
					break;
		}

	}

	public void evenementJeuClient(String ordre, Object info) {
		switch (ordre) {
			case AJOUTPANELMURS:
				this.frmArene.setJpnMurs((JPanel) info);
				break;
	}
		
	}



}
