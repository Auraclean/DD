package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metier.*;

public class App {

	/* ------------------------------------ Variables globales ------------------------------------ */
	static Joueur p = new Joueur();
	static Marchand m = new Marchand(); 
	static Archetype classe = new Archetype();
	
	
	static List<Archetype> arc = new ArrayList<Archetype>();
	
	static List<Marchand> marchands = new ArrayList<Marchand>();
	
	static List<Item> allItems = new ArrayList<Item>();
	static List<Item> m1_inventaire = new ArrayList<Item>();
	static List<Item> m2_inventaire = new ArrayList<Item>();
	static List<Item> inventaire = new ArrayList<Item>();
	static List<Item> a1_inventaire = new ArrayList<Item>();
	static List<Item> a2_inventaire = new ArrayList<Item>();
	
	static List<Question> m1_questions = new ArrayList<Question>();
	static List<Question> m2_questions = new ArrayList<Question>();
	
	static List<Reponse> q1_reponses = new ArrayList<Reponse>();
	static List<Reponse> q2_reponses = new ArrayList<Reponse>();
	static List<Reponse> q3_reponses = new ArrayList<Reponse>();
	static List<Reponse> q4_reponses = new ArrayList<Reponse>();

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
		
		initListArchetype();
		initListItems();
		initListQuestions();
		initListMarchands();

	}

	private static void initListArchetype() {
		Archetype a1 = new Archetype(1, "Chevalier", a1_inventaire);
		Archetype a2 = new Archetype(2, "Sorcier", a2_inventaire);
		arc.add(a1);
		arc.add(a2);
	}

	private static void initListItems() {
		Item i1 	= new Item(1,	"a"	, "C'est la lettre a."	, 2		);
		Item i2 	= new Item(2, 	"b"	, "C'est la lettre b."	, 4		);
		Item i3 	= new Item(3,	"c"	, "C'est la lettre c."	, 6		);
		Item i4 	= new Item(4,	"d"	, "C'est la lettre d."	, 8		);
		Item i5 	= new Item(5,	"e"	, "C'est la lettre e."	, 10	);
		Item i6 	= new Item(6,	"f"	, "C'est la lettre f."	, 12	);
		Item i7 	= new Item(7,	"g"	, "C'est la lettre g."	, 14	);
		Item i8 	= new Item(8,	"h"	, "C'est la lettre h."	, 16	);
		Item i9 	= new Item(9,	"i"	, "C'est la lettre i."	, 18	);
		Item i10 	= new Item(10,	"j"	, "C'est la lettre j."	, 20	);

		allItems.add(i1); 
		allItems.add(i2);
		allItems.add(i3);
		allItems.add(i4);
		allItems.add(i5);
		allItems.add(i6);
		allItems.add(i7);
		allItems.add(i8);
		allItems.add(i9);
		allItems.add(i10);
	
		m1_inventaire.add(i1);
		m1_inventaire.add(i2);
		m1_inventaire.add(i3);
		m1_inventaire.add(i4);
		m1_inventaire.add(i5);
		
		m2_inventaire.add(i6);
		m2_inventaire.add(i7);
		m2_inventaire.add(i8);
		m2_inventaire.add(i9);
		m2_inventaire.add(i10);
		
		a1_inventaire.add(i2);
		a1_inventaire.add(i4);
		
		a2_inventaire.add(i5);
		a2_inventaire.add(i7);
	
	}
	
	private static void initListQuestions() {
		Question q1 = new Question(1, "Ceci est une question 1", q1_reponses);
		Question q2 = new Question(2, "Ceci est une question 2", q2_reponses);
		m1_questions.add(q1);
		m1_questions.add(q2);
		
		Question q3 = new Question(3, "Ceci est une question 3", q3_reponses);
		Question q4 = new Question(4, "Ceci est une question 4", q4_reponses);
		m2_questions.add(q3);
		m2_questions.add(q4);
		
		Reponse r1 = new Reponse(1, "Ceci est une réponse 1", true);
		Reponse r2 = new Reponse(2, "Ceci est une réponse 2", false);
		q1_reponses.add(r1);
		q1_reponses.add(r2);
		
		Reponse r3 = new Reponse(3, "Ceci est une réponse 3", true);
		Reponse r4 = new Reponse(4, "Ceci est une réponse 4", false);
		q2_reponses.add(r3);
		q2_reponses.add(r4);
				
		Reponse r5 = new Reponse(5, "Ceci est une réponse 5", true);
		Reponse r6 = new Reponse(6, "Ceci est une réponse 6", false);
		q3_reponses.add(r5);
		q3_reponses.add(r6);
		
		Reponse r7 = new Reponse(7, "Ceci est une réponse 7", true);
		Reponse r8 = new Reponse(8, "Ceci est une réponse 8", false);
		q4_reponses.add(r7);
		q4_reponses.add(r8);
		
	}
	
	private static void initListMarchands() {
		Marchand m1	= new Marchand(1, "Alchimiste", 100, m1_inventaire, "Alchimie", 0, m1_questions);
		Marchand m2	= new Marchand(2, "Forgeron", 100, m2_inventaire, "Forge", 0, m2_questions);
		marchands.add(m1);
		marchands.add(m2);
		
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
		System.out.println("*Que faire ?*");
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
		System.out.println("Une fois ce but atteint, il te sera possible de commencer ta propre aventure dans ce monde !");
		System.out.println("A présent, va et montre-moi tes capacités de marchand.");
		menu();
	}

	// Initialise les attributs (id, nom, classe, solde, inventaire) du joueur 
	public static void creationJoueur() {
		p.setId(0);
		p.setNom(saisieString("Avant tout, quel est ton nom ?"));
		choisirClasse();
		System.out.println("Voici ta bourse, aventurier !");
		p.setSolde(0);
		System.out.println("*Vous ouvrez la bourse et constatez que cette dernière est vide.*");
		System.out.println("Tu ne t'attendais tout de même pas à ce qu'elle contienne quelque chose ! *rire*");
		System.out.println("En revanche, voici un sac avec des objets choisis par mes soins.");
		donneInventaire();
		for (Item it : p.getInventaire()) System.out.println(it);
	}
	
	public static void choisirClasse() {
		String choix = null;
		
		do {
			System.out.println("Quel type d'aventurier es-tu ?");
			//Montre les classes disponibles
			for (Archetype a : arc) System.out.println(a);
			int i = saisieInt("");
			for (Archetype a : arc) if (i == a.getId()) classe = a;
			System.out.println("Voici les objets correspondant à cette classe :");
			//Montre les objectifs liés à la classe choisie
			for (Item it : classe.getObjectifs() ) System.out.println(it);
			choix = saisieString("Es-tu certain de ton choix ? (Oui/Non)");
		} while( !(choix.equalsIgnoreCase("Oui")) );

		p.setJob(classe);
	}

	public static void donneInventaire() {
		Item it = null;
		Object[] allIt = allItems.toArray();
		Random rand = new Random();
		// 5 est le nb d'items max dans l'inventaire
		for(int i=1;i<=5;i++) {
			do {
				it = (Item) allIt[ rand.nextInt(allIt.length) ];
			} while( p.getJob().getObjectifs().contains(it) ||  inventaire.contains(it) );
			inventaire.add(it);
		}
		p.setInventaire(inventaire);
	}

	/* ------------------------------------ Menu de base ------------------------------------ */
	public static void menu() {
		
		if( inventaire.containsAll( p.getJob().getObjectifs() ) && p.getSolde() >= 100 ) victoryScreen();
		
		System.out.println("*Vous venez d'atteindre la place du village*");
		System.out.println("*Que faire ?*");
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
		for (Marchand ma : marchands) System.out.println(ma);
		int choix = saisieInt("");
		// ???
		if( choix >= 1 && choix <= marchands.size() ) {
			for (Marchand ma : marchands) if (choix == ma.getId()) m = ma;
			menuMarchand();
		}
		else menu();
	}

	public static void showObjectifs() {
		System.out.println("--- Objectifs pour la classe "+ p.getJob().getNom() +" ---");
		for( Item i : p.getJob().getObjectifs() )
			System.out.println(" - Se procurer un "+i.getNom());
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
			if(r.equalsIgnoreCase("Oui")) {
				p.getInventaire().clear();
				startJeu();
			}
			break;
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