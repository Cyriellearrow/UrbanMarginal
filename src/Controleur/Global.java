package Controleur;

public interface Global {

	// ----- Réseau -----
	int PORT = 6666;
	String SERVEUR = "serveur";
	String CLIENT = "client";

	// ----- Ordres reçus de la classe Connection -----
	String CONNEXION = "connexion";
	String RECEPTION = "reception";
	String DECONNEXION = "deconnexion";

	// ----- Messages échangés entre client et serveur -----
	String SEPARATOR = "~";
	String PSEUDO = "pseudo";

	// ----- Chemins vers les fichiers du dossier media -----
	String CHEMIN = "media/";
	String CHEMINFONDS = CHEMIN + "fonds/";
	String CHEMINPERSONNAGES = CHEMIN + "personnages/";
	String CHEMINBOULES = CHEMIN + "boules/";
	String CHEMINSONS = CHEMIN + "sons/";

	//----Les Murs ----
	int HAUTEURARENE = 600;
	int LARGEURARENE = 800;
	int HAUTEURMUR = 35;
	int LARGEURMUR = 34;
	String CHEMINSEPARATOR = "/";
	String CHEMINMURS = "murs"+CHEMINSEPARATOR;
	String MUR = CHEMINMURS+"mur.gif";
	int NBMURS=20;
	String AJOUTMUR = "ajout mur";
	String AJOUTPANELMURS = "ajout panel murs";

}