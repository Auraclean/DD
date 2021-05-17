package test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metier.*;
import util.Context;

public class App {

	static LocalDateTime start = LocalDateTime.now();
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


	

	/* ------------------------------------ MAIN ------------------------------------ */
	public static void main(String[] args) {

		Initialisation.init();
		startJeu();
		ct.getEmf().close();

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
	// créer le joueur, lui explique les régles 
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
		ct.setP( ct.getDaoP().save( ct.getP() ) );
	}

	public static void choisirClasse() {
		String choix = null;
		Archetype classe = null;
		System.out.println("Avant tout, quelle est ta classe ?");

		do {
			//Montre les classes disponibles
			for( Archetype a : ct.getDaoArc().findAll())
				System.out.println(a);
			classe = ct.getDaoArc().findById( saisieInt("") );
			//Montre les objectifs liés à la classe choisie
			System.out.println("Voici les objets correspondant à cette classe :");
			//A modifier, il y a trop d'infos sur les items
			for( Item i : classe.getObjectifs() ) System.out.println(i);
			choix = saisieString("Es-tu certain de ton choix ? (Oui/Non)");
		} while( !(choix.equalsIgnoreCase("Oui")) );
		ct.getP().setJob(classe);
	}

	public static void donneInventaire() {
		List<Item> allItems = ct.getDaoItem().findAll();
		List<Item> inventaire = new ArrayList<Item>();
		Item it = null;
		List<Item> obj = ct.getP().getJob().getObjectifs();

		// 10 est le nb d'items max dans l'inventaire
		for(int i=1;i<=10;i++) {
			do {
				Random rand = new Random();
				it = allItems.get( rand.nextInt(allItems.size()) );
			} while( obj.contains(it) || inventaire.contains(it) );
			inventaire.add(it);
		}
		ct.getP().setInventaire(inventaire);
	}

	/* ------------------------------------ Menu de base ------------------------------------ */
	public static void menu() {

		if( ct.getP().getInventaire().containsAll( ct.getP().getJob().getObjectifs() ) && ct.getP().getSolde() >= 100 ) 
			victoryScreen();

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
		System.out.println("Vous possédez "+ ct.getP().getSolde() +"PO.");
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
		LocalDateTime pause = LocalDateTime.now();
		System.out.println("Temps de jeu : " + Duration.between(start, pause).toHours() +
		" h " + Duration.between(start, pause).toMinutesPart() + " min "+ Duration.between(start, pause).toSecondsPart()+" sec");
		System.out.println("");
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
		System.out.println("4 - Partir");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : discuter(m);break;
		case 2 : showInventaireMarchand(m);break;
		case 3 : vendreObjet(m);break;
		case 4 : menu();break;
		}
		menuMarchand(m);
	}

	public static void discuter(Marchand m) {
		int[] rep = new int[3];
		// On ne peut pas importer directement du marchand les questions avec m.getQuestions car lazy...
		List<Question> questions = ct.getDaoQues().findByIdMarchand( m.getId() );
		// ajouter un attribut aux questions pour vérifier si elle a déjà été posée.
		// hashMap pour gérer les questions.
		for( Question q : questions ) {
			if(q.isRepondue()) continue;
			int i = -1;
			System.out.println( q.getLibelle() );
			//Une fois rentré dans cette boucle la question est consideree comme repondue
			q.setRepondue(true);
			for( Reponse r : q.getReponses() ) {
				i++;
				System.out.println( (i+1) +"- "+ r.getLibelle() );
				rep[i] = r.getId();	
			}
			int choix = saisieInt("");
			//Trouver un moyen de sélectionner une réponse
			Reponse rep_player = q.getReponses().get( choix-1 );
			if( rep_player.isValid() ) {
				System.out.println("Bonne réponse !");
				m.setAffinite(m.getAffinite()+15);
			}
			else {
				System.out.println("Mauvaise réponse.");
				m.setAffinite(m.getAffinite()-15);
			}
			ct.getDaoMar().save(m);
			//Il faut trouver un moyen de stocker le nombre de questions restantes pour reprendre si le joueur a envie 
			// LinkedList pour les questions ?
			String papoter = saisieString("Continuer de discuter ? (Oui/Non)");
			if(papoter.equalsIgnoreCase("Non")) menuMarchand(m); 
		}
		menuMarchandssQ(m);
	}

	public static void menuMarchandssQ(Marchand m) {
		System.out.println("Bonjour aventurier, prends ton temps et regarde tout ce qui t'intéresse.");
		System.out.println("1 - Voir les objets en vente");
		System.out.println("2 - Vendre un objet");
		System.out.println("3 - Partir");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : showInventaireMarchand(m);break;
		case 2 : vendreObjet(m);break;
		case 3 : menu();break;
		}
		menuMarchandssQ(m);
	}

	public static void showInventaireMarchand(Marchand m) {
		m = ct.getDaoMar().findByIdWithInventaire( m.getId() );
		System.out.println("Voici tout les objets en ma possession :");
		for (Item it : m.getInventaire() )
		{
			double valeur = it.getValeur();
			if(m.getAffinite()<=25) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()<=50) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()>66) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()>80) valeur=valeur-it.getValeur()*m.getModPrix();
			int val = (int) Math.round(valeur);
			System.out.println(it.getId()+" - " + it.getNom()+": "+ val +" PO");
			
		}
		System.out.println("Y a-t-il quelque chose que tu aimerais acheter ?");
		System.out.println("1 - Acheter un objet");
		System.out.println("2 - Retour");

		int choix = saisieInt("");
		switch(choix) {
		case 1 :
			int id_objet = saisieInt("Sélectionner l'Id de l'objet à acheter :");
			acheter(m, id_objet);break;
		case 2 : menuMarchand(m);break;
		}
		showInventaireMarchand(m);
	}

	public static void acheter(Marchand m, int id_objet) {
		Item it = ct.getDaoItem().findById(id_objet);
		List<Item> inv_marchand = m.getInventaire();
		List<Item> inv_joueur = ct.getP().getInventaire();
		
		double valeur = it.getValeur();
		if(m.getAffinite()<=25) valeur=valeur+it.getValeur()*m.getModPrix();
		if(m.getAffinite()<=50) valeur=valeur+it.getValeur()*m.getModPrix();
		if(m.getAffinite()>66) valeur=valeur-it.getValeur()*m.getModPrix();
		if(m.getAffinite()>80) valeur=valeur-it.getValeur()*m.getModPrix();
		int val = (int) Math.round(valeur);
		if( m.getInventaire().contains(it) ) {
			if( ct.getP().getSolde() < val ) {
				System.out.println("Désolé, la maison ne fait pas crédit. Reviens quand tu disposeras de la somme nécessaire.");
				showInventaireMarchand(m);
			}
			//retire l'item de l'inventaire du marchand + gère son argent
			inv_marchand.remove(it); m.setInventaire(inv_marchand);
			m.setSolde( m.getSolde() + val );
			//ajoute l'item à l'inventaire du joueur + gère son argent
			inv_joueur.add(it); ct.getP().setInventaire(inv_joueur);
			ct.getP().setSolde( ct.getP().getSolde() - val );
		}
	}

	public static void vendreObjet(Marchand m) {
		for (Item it : ct.getP().getInventaire() ) 
		{
			//Attention, il faut modifier le prix selon le marchand...
			double valeur = it.getValeur();
			if(m.getAffinite()<=25) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()<=50) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()>66) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()>80) valeur=valeur+it.getValeur()*m.getModPrix();
			int val = (int) Math.round(valeur);
			System.out.println(it.getId()+" - " + it.getNom()+": "+ val +" PO");
		}
		System.out.println("Y a-t-il quelque chose que tu voudrais me vendre ?");
		System.out.println("1 - Vendre un objet");
		System.out.println("2 - Retour");

		int choix = saisieInt("");
		switch(choix) {
		case 1 :
			int id_objet = saisieInt("Sélectionner l'Id de l'objet à vendre :");
			vendre(m, id_objet);break;
		case 2 : menuMarchand(m);break;
		}
		vendreObjet(m);
	}

	public static void vendre(Marchand m, int id_objet) {
		Joueur j = ct.getDaoP().findByIdWithInventaire( ct.getP().getId() );
		m = ct.getDaoMar().findByIdWithInventaire( m.getId() );
		Item it = ct.getDaoItem().findById(id_objet);
		double valeur = it.getValeur();
		if(m.getAffinite()<=25) valeur=valeur-it.getValeur()*m.getModPrix();
		if(m.getAffinite()<=50) valeur=valeur-it.getValeur()*m.getModPrix();
		if(m.getAffinite()>66) valeur=valeur+it.getValeur()*m.getModPrix();
		if(m.getAffinite()>80) valeur=valeur+it.getValeur()*m.getModPrix();
		int val = (int) Math.round(valeur);
		List<Item> inv_joueur = j.getInventaire();
		List<Item> inv_marchand = m.getInventaire();
		if( ct.getP().getInventaire().contains(it) ) {
			// Valeur de l'objet à modifier selon l'affinité
			if( m.getSolde() < val ) {
				System.out.println("Désolé, je n'ai pas assez d'argent pour ça. J'ai une famille à nourrir.");
				vendreObjet(m);
			}
			//retire l'item de l'inventaire du joueur + gère son argent
			inv_joueur.remove(it); j.setInventaire(inv_joueur);
			j.setSolde( j.getSolde() + val);
			//ajoute l'item à l'inventaire du marchand + gère son argent
			inv_marchand.add(it);
			m.setInventaire(inv_marchand);
			m.setSolde( m.getSolde() - val );
			//Problème au niveau du save marchand quand il y a 2 exemplaires du même objet (1 dans le joueur, 1 dans le marchand)
			ct.getDaoMar().save(m);
			ct.getDaoP().save(j);
		}
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
		LocalDateTime end = LocalDateTime.now();
		System.out.println(Duration .between(start, end).toMinutes()+" minutes "+ Duration .between(start, end).toSecondsPart()+" secondes");
	}
	
}