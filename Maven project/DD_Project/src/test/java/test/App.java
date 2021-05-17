package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import dao.*;
import metier.*;

public class App {

	/* ------------------------------------ Variables globales ------------------------------------ */
	static Joueur p = new Joueur();
	static Marchand m = new Marchand(); 
	static Archetype classe = new Archetype();

	static DAOArchetype daoArc = new DAOArchetype();
	static DAOItem daoItem = new DAOItem();
	static DAOMarchand daoMar = new DAOMarchand();
	
	static List<Marchand> marchands = new ArrayList<Marchand>();
	
	
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
		Item i1 	= new Item(	"a"	, "C'est la lettre a."	, 2		);
		Item i2 	= new Item(	"b"	, "C'est la lettre b."	, 4		);
		Item i3 	= new Item(	"c"	, "C'est la lettre c."	, 6		);
		Item i4 	= new Item(	"d"	, "C'est la lettre d."	, 8		);
		Item i5 	= new Item(	"e"	, "C'est la lettre e."	, 10	);
		Item i6 	= new Item(	"f"	, "C'est la lettre f."	, 12	);
		Item i7 	= new Item(	"g"	, "C'est la lettre g."	, 14	);
		Item i8 	= new Item(	"h"	, "C'est la lettre h."	, 16	);
		Item i9 	= new Item(	"i"	, "C'est la lettre i."	, 18	);
		Item i10 	= new Item(	"j"	, "C'est la lettre j."	, 20	);







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

	// Initialise les attributs (id, nom, classe, solde, inventaire) du joueur 
	public static void creationJoueur() {
		p.setId(0);
		p.setNom(saisieString("Quel est ton nom ?"));
		choisirClasse();
		System.out.println("Voici ta bourse, aventurier !");
		p.setSolde(0);
		System.out.println("*Vous ouvrez la bourse et constatez que cette dernière est vide.*");
		System.out.println("Tu ne t'attendais tout de même pas à ce qu'elle contienne quelque chose ! *rire*");
		System.out.println("En revanche, voici un sac avec des objets choisis par mes soins.");
		donneInventaire();
	}
	
	public static void choisirClasse() {
		String choix = null;
		System.out.println("Avant tout, quelle est ta classe ?");
		
		do {
			//Montre les classes disponibles
			daoArc.findAll(); 
			classe = daoArc.findById(saisieInt(""));
			System.out.println("Voici les objets correspondant à cette classe :");
			//Montre les objectifs liés à la classe choisie
			classe.getObjectifs().toString(); 
			choix = saisieString("Es-tu certain de ton choix ? (Oui/Non)");
		} while( !(choix.equalsIgnoreCase("Oui")) );
		
		p.setJob(classe);
	}

	public static void donneInventaire() {
		List<Item> allItems = daoItem.findAll();
		List<Item> inventaire = new ArrayList<Item>();
		Item it = null;

		// 10 est le nb d'items max dans l'inventaire
		for(int i=1;i<=10;i++) {
			do {
				Random rand = new Random();
				Item allIt[] = (Item[]) allItems.toArray();
				it = allIt[ rand.nextInt(allIt.length) ];
				// ???
			} while( p.getJob().getObjectifs().contains(it) ||  inventaire.contains(it) );
		}
	}

	/* ------------------------------------ Menu de base ------------------------------------ */
	public static void menu() {
		System.out.println("Que faire ?");
		System.out.println("1 - Aller voir un marchand");
		System.out.println("2 - Voir les objectifs");
		System.out.println("3 - Pause");
		
		int choix = saisieInt("");
		switch(choix) {
		case 1 : choisirMarchand();break;
		case 2 : showObjectifs();break;
		case 3 : pause();break;
		}
		menu();

	}

	/* ------------------------------------ Choisir Marchand ------------------------------------ */
	public static void choisirMarchand() {
		System.out.println("Choisis à présent le marchand chez lequel tu souhaites te rendre :");
		marchands = daoMar.findAll();
		int choix = saisieInt("");
		// ???
		if( choix >= 1 && choix <= marchands.size() ) {
			m = daoMar.findById(choix);
			menuMarchand();
		}
		else menu();
	}

	public static void showObjectifs() {
		for( Item i : p.getJob().getObjectifs() )
			System.out.println(" - Se procurer un(e) "+i);
		System.out.println(" - Obtenir une centaine de pièces d'or");
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
	public static void menuMarchand() {
		System.out.println("Bonjour aventurier, prends ton temps et regarde tout ce qui t'intéresse.");
		System.out.println("1 - Discuter");
		System.out.println("2 - Voir les objets en vente");
		System.out.println("3 - Vendre un objet");
		
	}
	
	public static void acheter(Marchand m) {
		int solde= ct.getP().getSolde();
		m = ct.getDaoMar().findByIdWithInventaire( m.getId() );
		for (Item it : m.getInventaire() ) {
			Item ValeurItem=ct.getDaoItem().findById(it.getValeur());
			int prix=ValeurItem.getValeur();
			int soldeRestant=solde-prix;
		}
	}

	public static void vendre(Marchand m) {
		int solde= ct.getP().getSolde();
		m = ct.getDaoMar().findByIdWithInventaire( m.getId() );
		for (Item it : m.getInventaire() ) {
			Item ValeurItem=ct.getDaoItem().findById(it.getValeur());
			int prix=ValeurItem.getValeur();
			int soldeRestant=solde+prix;
		}
	}
}