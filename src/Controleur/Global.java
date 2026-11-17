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
	String CHEMINMURS = CHEMIN + "murs/";
	String CHEMINPERSONNAGES = CHEMIN + "personnages/";
	String CHEMINBOULES = CHEMIN + "boules/";
	String CHEMINSONS = CHEMIN + "sons/";
}