package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metier.*;
import util.Context;

public class App {

	static Context ct = Context.get_instance();
	
	/* ------------------------------------ Fonctions d'entrées au clavier ------------------------------------ */
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	/* ------------------------------------ Fonctions I/O ------------------------------------ */


	/* ------------------------------------ Initialisation ------------------------------------ */
	public static void init() {

	}


	/* ------------------------------------ MAIN ------------------------------------ */
	public static void main(String[] args) {

		init();
		startJeu();

	}

	/* ------------------------------------ Start Jeu ------------------------------------ */
	public static void startJeu() {
		System.out.println("Salut à toi, aventurier !");
		System.out.println("Tu errais dans la forêt mais tu viens d'apercevoir un petit village.");
		System.out.println("Que décides-tu ?");
		System.out.println("1 - Visiter le village");
		System.out.println("2 - Ignorer le village et passer ton chemin");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : 
			jouer();break;
		case 2 :
			System.out.println("Bon vent !");
			System.exit(0);break;
		}
		startJeu();

	}

	/* ------------------------------------ Jouer ------------------------------------ */
	// créer le joueur, lui explique les règles 
	public static void jouer() {
		creationJoueur();
		System.out.println("Dans ce village, ton but sera d'obtenir tous les objets de ta classe ainsi qu'une centaine de pièces d'or. ");
		System.out.println("Ce n'est qu'une fois ce but atteint qu'il te sera possible de commencer ta propre aventure dans ce monde !");
		System.out.println("A présent, va et montre-moi tes capacités de marchand.");
		menu();
	}

	// Initialise les attributs (nom, classe, solde, inventaire) du joueur 
	public static void creationJoueur() {
		ct.getP().setNom(saisieString("Quel est ton nom ?"));
		choisirClasse();
		System.out.println("Voici ta bourse, aventurier !");
		ct.getP().setSolde(0);
		System.out.println("*Vous ouvrez la bourse et constatez que cette dernière est vide.*");
		System.out.println("Tu ne t'attendais tout de même pas à ce qu'elle contienne quelque chose ! *rire*");
		System.out.println("En revanche, voici un sac avec des objets choisis par mes soins.");
		donneInventaire();
	}
	
	public static void choisirClasse() {
		String choix = null;
		Archetype classe = null;
		System.out.println("Avant tout, quelle est ta classe ?");
		
		do {
			//Montre les classes disponibles
			System.out.println( ct.getDaoArc().findAll() ); 
			classe = ct.getDaoArc().findById(saisieInt(""));
			System.out.println("Voici les objets correspondant à cette classe :");
			//Montre les objectifs liés à la classe choisie
			//A modifier, il y a trop d'infos sur les items
			System.out.println( classe.getObjectifs() ); 
			choix = saisieString("Es-tu certain de ton choix ? (Oui/Non)");
		} while( !(choix.equalsIgnoreCase("Oui")) );
		ct.getP().setJob(classe);
	}

	public static void donneInventaire() {
		List<Item> allItems = ct.getDaoItem().findAll();
		List<Item> inventaire = new ArrayList<Item>();
		Item it = null;

		// 10 est le nb d'items max dans l'inventaire
		for(int i=1;i<=10;i++) {
			do {
				Random rand = new Random();
				Item allIt[] = (Item[]) allItems.toArray();
				it = allIt[ rand.nextInt(allIt.length) ];
			} while( ct.getP().getJob().getObjectifs().contains(it) ||  inventaire.contains(it) );
			inventaire.add(it);
		}
		ct.getP().setInventaire(inventaire);
	}

	/* ------------------------------------ Menu de base ------------------------------------ */
	public static void menu() {
		
		if( ct.getP().getInventaire().containsAll( ct.getP().getJob().getObjectifs() ) && ct.getP().getSolde() >= 100 ) victoryScreen();
		
		System.out.println("Que faire ?");
		System.out.println("1 - Aller voir un marchand");
		System.out.println("2 - Voir les objectifs");
		System.out.println("3 - Voir l'inventaire");
		System.out.println("4 - Pause");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1 : choisirMarchand();break;
		case 2 : showObjectifs();break;
		case 3 : showInventaire();break;
		case 4 : pause();break;
		}
		menu();

	}

	/* ------------------------------------ Choisir Marchand ------------------------------------ */
	public static void choisirMarchand() {
		System.out.println("Choisis à présent le marchand chez lequel tu souhaites te rendre :");
		System.out.println( ct.getDaoMar().findAll() );
		int choix = saisieInt("");
		if( choix >= 1 && choix <= ct.getDaoMar().findAll().size() ) {
			Marchand m = ct.getDaoMar().findById(choix);
			menuMarchand(m);
		}
		else menu();
	}

	public static void showObjectifs() {
		for( Item i : ct.getP().getJob().getObjectifs() )
			System.out.println(" - Se procurer un(e) "+i);
		System.out.println(" - Obtenir une centaine de pièces d'or");
	}

	public static void showInventaire() {
		System.out.println("Vous possédez "+ ct.getP().getSolde() );
		System.out.println( ct.getP().getInventaire() );
		
		System.out.println("Que faire ?");
		System.out.println("1 - Voir la description d'un objet");
		System.out.println("2 - Retour");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1 : decrireObjet();break;
		case 2 : menu();break;
		}
		showInventaire();
	}
	
	public static void decrireObjet() {
		String objet = saisieString("Saisir le nom de l'objet");
		for( Item it : ct.getP().getInventaire() )
			if( objet.equalsIgnoreCase( it.getNom() ) ) System.out.println( it.getDescription() ); 
	}

	/* ------------------------------------ Pause ------------------------------------ */
	public static void pause() {
		System.out.println("--- PAUSE ---");
		// afficher le timer (temps de jeu)?
		System.out.println("1 - Reprendre le jeu");
		System.out.println("2 - Réinitialiser la partie");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1 : 
			menu();break;
		case 2 : 
			String r = saisieString("Veux-tu vraiment arrêter la partie en cours ? (Oui/Non)");
			if(r.equalsIgnoreCase("Oui")) startJeu();break;
		}
		pause();
	}
	
	/* ------------------------------------ Menu Marchand ------------------------------------ */
	public static void menuMarchand(Marchand m) {
		System.out.println("Bonjour aventurier, prends ton temps et regarde tout ce qui t'intéresse.");
		System.out.println("1 - Discuter");
		System.out.println("2 - Voir les objets en vente");
		System.out.println("3 - Vendre un objet");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1 : discuter();break;
		case 2 : showInventaireMarchand();break;
		case 3 : vendre();break;
		}
		menuMarchand(m);
		
	}
	
	public static void discuter() {
		// TODO Auto-generated method stub
		
	}
	
	private static void showInventaireMarchand() {
		// TODO Auto-generated method stub
		
	}

	public static void vendre() {
		// TODO Auto-generated method stub
		
	}
	
	/* ------------------------------------ Ecran de victoire ------------------------------------ */
	public static void victoryScreen() {
		// remplir ici un fichier avec les données du joueur + remerciements. 
		System.out.println("Je t'attendais aventurier !");
		System.out.println("Je te félicite ! Tu es parvenu à réunir les objets et l'argent nécessaires à ton périple.");
		System.out.println("J'espère que ton séjour ici a été plaisant. N'hésite pas à revenir me voir !");
		System.out.println("");
		System.out.println("*Bravo, vous avez accompli vos objectifs avec brio !*");
		System.exit(0);
	}
	
}