package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import metier.*;
import util.Context;

public class App {

	static LocalDateTime start;
	static long h = 0, min = 0, s = 0;
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
	private static void ecrire(String chemin) {
		File f = new File(chemin);
		try(FileWriter fw = new FileWriter(f);) { 
			fw.write("Félicitations " + ct.getP().getNom() + " ! Vous avez réussi à terminer le Projet DD. \n \nVous avez mis "
		+ h + " h " + min + " min " + s + " s avec la classe " + ct.getP().getJob().getNom() +" ! \nMerci d'avoir joué ! \nThomas, Yann, Nicola" ); 
		} catch(IOException ioe) { 
			ioe.printStackTrace(); 
		}
	}

	/* ------------------------------------ MAIN ------------------------------------ */
	public static void main(String[] args) {

		Initialisation.init();
		startJeu();
		ct.getEmf().close();

	}

	/* ------------------------------------ Start Jeu ------------------------------------ */
	public static void startJeu() {
		start = LocalDateTime.now();
		System.out.println("");
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
		System.out.println("Dans ce village, ton but sera d'obtenir tous les objets de ta classe ainsi que "+ct.getP().getObjectif()+" de pièces d'or.");
		System.out.println("Ce n'est qu'une fois ce but atteint qu'il te sera possible de commencer ta propre aventure dans ce monde !");
		System.out.println("A présent, va et montre-moi tes capacités de marchand.");
		System.out.println("");
		menu();
	}

	// Initialise les attributs (nom, classe, solde, inventaire) du joueur 
	public static void creationJoueur() {
		ct.getP().setNom(saisieString("Comment t'appelles-tu ?"));
		choisirClasse();
		System.out.println("");
		System.out.println("Voici ta bourse, aventurier !");
		ct.getP().setSolde(0);
		System.out.println("*Vous ouvrez la bourse et constatez que cette dernière est vide.*");
		System.out.println("Tu ne t'attendais tout de même pas à ce qu'elle contienne quelque chose ! *rire*");
		System.out.println("En revanche, voici un sac avec des objets choisis par mes soins.");
		System.out.println("*Vous avez obtenu un inventaire (plein)!*");
		System.out.println("");
		donneInventaire();
		objectifMonetaire();
		ct.setP( ct.getDaoP().save( ct.getP() ) );
	}

	public static void choisirClasse() {
		String choix = null;
		Archetype classe = null;
		do {
			System.out.println("");
			System.out.println("Avant tout, quelle est ta classe ?");
			//Montre les classes disponibles
			int i = 0;
			for( Archetype a : ct.getDaoArc().findAll() ) {
				i++;
				System.out.println(i + " - " + a.getNom());
			}
			System.out.println("");
			classe = ct.getDaoArc().findById( saisieInt("") );
			//Montre les objectifs liés à la classe choisie
			System.out.println("Voici les objets correspondant à cette classe :");
			for( Item it : classe.getObjectifs() ) System.out.println("- " + it);	
			System.out.println("");
			choix = saisieString("Es-tu certain de ton choix ? (Oui/Non)");
		} while( !(choix.equalsIgnoreCase("Oui")) );
		ct.getP().setJob(classe);
	}

	public static void donneInventaire() {
		List<Item> allItems = ct.getDaoItem().findAll();
		List<Item> inventaire = new ArrayList<Item>();
		List<Item> catalogue = new ArrayList<Item>();
		List<Marchand> marchands = ct.getDaoMar().findAll();
		for (Marchand m : marchands ) {
			m=ct.getDaoMar().findByIdWithInventaire(m.getId());
			for (Item item : m.getInventaire()) {
				catalogue.add(item);
			}
		}
		Item it = null;
		List<Item> obj = ct.getP().getJob().getObjectifs();

		// 10 est le nb d'items max dans l'inventaire
		for(int i=1;i<=10;i++) {
			do {
				Random rand = new Random();
				it = allItems.get( rand.nextInt( allItems.size() ) );
			} while( obj.contains(it) || inventaire.contains(it) || catalogue.contains(it));
			inventaire.add(it);
		}
		ct.getP().setInventaire(inventaire);
	}
	public static void objectifMonetaire() {
		List<Item> inventaire = ct.getP().getInventaire();
		List<Item> obj = ct.getP().getJob().getObjectifs();
		int sum = 0;
		int objectifs = 0;
		for (Item it : inventaire) sum+=it.getValeur();
		//On soustrait la somme des valeurs des objets a acheter
		for(Item it : obj) objectifs+=it.getValeur();
		List<Marchand> marchands =ct.getDaoMar().findAll();
		int argentDispo = 0;
		for (Marchand m : marchands) argentDispo+=m.getSolde();
		//On ne peut pas gagner plus d'argent que la somme présente dans les bourses des marchands presents
		if(sum > argentDispo) sum = argentDispo - objectifs -30;
		//On laisse une marge d'erreur si le joueur rate les questions
		else sum = sum - objectifs - 30;
		ct.getP().setObjectif(sum);
	}

	/* ------------------------------------ Menu de base ------------------------------------ */
	public static void menu() {

		if( ct.getP().getInventaire().containsAll( ct.getP().getJob().getObjectifs() ) && ct.getP().getSolde() >= ct.getP().getObjectif()) 
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
		for( Marchand m : ct.getDaoMar().findAll() ) System.out.println(m);
		int choix = saisieInt("");
		if( choix >= 1 && choix <= ct.getDaoMar().findAll().size() ) {
			Marchand m = ct.getDaoMar().findById(choix);
			menuMarchand(m);
		}
		else menu();
	}

	public static void showObjectifs() {
		for( Item i : ct.getP().getJob().getObjectifs() )
			System.out.println("- Se procurer un(e) "+i);
		System.out.println("- Obtenir "+ct.getP().getObjectif()+" pièces d'or");
		System.out.println("");
	}

	public static void showInventaire() {
		System.out.println("Vous possédez "+ ct.getP().getSolde() +" PO.");
		System.out.println("");
		int i = 0;
		int[] ind = new int[ ct.getP().getInventaire().size() ];
		for( Item it : ct.getP().getInventaire() ) {
			i++;
			ind[i-1] = it.getId();
			System.out.println( i + " - " + it);
		}
		System.out.println("");
		
		System.out.println("Que faire ?");
		System.out.println("1 - Voir la description d'un objet");
		System.out.println("2 - Retour");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : decrireObjet(ind);break;
		case 2 : menu();break;
		}
		showInventaire();
	}

	public static void decrireObjet(int[] ind) {
		int n = saisieInt("Saisir le numéro de l'objet");
		Item it = ct.getDaoItem().findById( ind[n-1] ); 
		if( ct.getP().getInventaire().contains(it) ) System.out.println( it.getNom() + " : " + it.getDescription() );
		System.out.println("");
	}

	/* ------------------------------------ Pause ------------------------------------ */   
	public static void pause() {
		System.out.println("--- PAUSE ---");
		gestionTime();
		System.out.println("");
		System.out.println("1 - Reprendre le jeu");
		System.out.println("2 - Réinitialiser la partie");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : 
			start = LocalDateTime.now();
			menu();break;
		case 2 : 
			String r = saisieString("Veux-tu vraiment arrêter la partie en cours ? (Oui/Non)");
			if(r.equalsIgnoreCase("Oui")) startJeu();break;
		}
		pause();
	}

	/* ------------------------------------ Menu Marchand ------------------------------------ */
	public static void menuMarchand(Marchand m) {
		System.out.println( m.getNom() + " : " + "Bonjour aventurier, prends ton temps et regarde tout ce qui t'intéresse.");
		System.out.println("1 - Discuter");
		System.out.println("2 - Voir les objets en vente");
		System.out.println("3 - Vendre un objet");
		System.out.println("4 - Partir");

		int choix = saisieInt("");
		switch(choix) {
		case 1 : discuter(m);break;
		case 2 : showInventaireMarchand(m);break;
		case 3 : vendreObjet(m);break;
		case 4 :
			System.out.println(m.getNom() + " : A la prochaine !");
			System.out.println("");
			menu();break;
		}
		menuMarchand(m);
	}



	public static void discuter(Marchand m) {
		int question = 0;
		int nb_questions = 2; // nb de questions totales par marchand
		// On ne peut pas importer directement du marchand les questions avec m.getQuestions car lazy...
		List<Question> questions = ct.getDaoQues().findByIdMarchand( m.getId() );
		// ajouter un attribut aux questions pour vérifier si elle a déjà été posée.
		// hashMap pour gérer les questions.
		for( Question q : questions ) {
			question++;
			if(q.isRepondue()) continue;
			q.setRepondue(true);
			int i = -1;
			System.out.println(m.getNom()+" : " + q.getLibelle() );
			for( Reponse r : q.getReponses() ) {
				i++;
				System.out.println( (i+1) +" - "+ r.getLibelle() );
			}
			int choix = saisieInt("");
			//Trouver un moyen de sélectionner une réponse
			Reponse rep_player = q.getReponses().get( choix-1 );
			if( rep_player.isValid() ) {
				System.out.println(m.getNom() + " : Bonne réponse !");
				m.setAffinite(m.getAffinite()+15);
			}
			else {
				System.out.println(m.getNom() + " : Mauvaise réponse.");
				m.setAffinite(m.getAffinite()-15);
			}
			System.out.println("");
			m = ct.getDaoMar().save(m);
			q = ct.getDaoQues().save(q);


			if( question < nb_questions ) {
				String papoter = saisieString("Continuer de discuter ? (Oui/Non)");
				if(papoter.equalsIgnoreCase("Non")) menuMarchand(m); 
			}
		}
		System.out.println(m.getNom() + " : Je n'ai plus envie de discuter.");
		System.out.println("");
	}

	public static void showInventaireMarchand(Marchand m) {
		m = ct.getDaoMar().findByIdWithInventaire( m.getId() );
		if( m.getInventaire().isEmpty() ) {
			System.out.println(m.getNom() + " : Vous avez dévalisé mon magasin, revenez plus tard.");
			System.out.println("");
			menuMarchand(m);
		}
		System.out.println("Vous possédez "+ ct.getP().getSolde() +" PO.");
		System.out.println("");
		System.out.println(m.getNom() + " : Voici tout les objets en ma possession :");
		int i = -1;
		int[] ind = new int[ m.getInventaire().size() ];
		for (Item it : m.getInventaire() )
		{
			double valeur = it.getValeur();
			if(m.getAffinite()<=25) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()<=50) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()>66) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()>80) valeur=valeur-it.getValeur()*m.getModPrix();
			int val = (int) Math.round(valeur);
			i++;
			ind[i] = it.getId();
			System.out.println( (i+1) + " - " + it.getNom() + " : " + val + " PO");
		}
		System.out.println("");
		System.out.println(m.getNom()+" : Y a-t-il quelque chose que tu aimerais acheter ?");
		System.out.println("1 - Acheter un objet");
		System.out.println("2 - Retour");

		int choix = saisieInt("");
		switch(choix) {
		case 1 :
			int id_objet = saisieInt("Sélectionner le numéro de l'objet à acheter :");
			acheter(m, ind[ id_objet-1 ]);break;
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
				System.out.println(m.getNom() + " : Désolé, la maison ne fait pas crédit. Reviens quand tu disposeras de la somme nécessaire.");
				System.out.println("");
				showInventaireMarchand(m);
			}
			//retire l'item de l'inventaire du marchand + gère son argent
			inv_marchand.remove(it); m.setInventaire(inv_marchand);
			m.setSolde( m.getSolde() + val );
			m = ct.getDaoMar().save(m);
			//ajoute l'item à l'inventaire du joueur + gère son argent
			inv_joueur.add(it); ct.getP().setInventaire(inv_joueur);
			ct.getP().setSolde( ct.getP().getSolde() - val );
			ct.setP( ct.getDaoP().save( ct.getP() ) );
			System.out.println("Merci pour votre achat !");
			System.out.println("");
		}
	}

	public static void vendreObjet(Marchand m) {
		if( ct.getP().getInventaire().isEmpty() ) {
			System.out.println("*Apparemment, vous n'avez plus rien a vendre...*");
			System.out.println("");
			menuMarchand(m);
		}
		System.out.println("Vous possédez "+ ct.getP().getSolde() +" PO.");
		System.out.println("");
		System.out.println("Objets contenus dans l'inventaire :");
		int i = -1;
		int[] ind = new int[ ct.getP().getInventaire().size() ];
		for (Item it : ct.getP().getInventaire() ) 
		{
			//Attention, il faut modifier le prix selon le marchand...
			double valeur = it.getValeur();
			if(m.getAffinite()<=25) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()<=50) valeur=valeur-it.getValeur()*m.getModPrix();
			if(m.getAffinite()>66) valeur=valeur+it.getValeur()*m.getModPrix();
			if(m.getAffinite()>80) valeur=valeur+it.getValeur()*m.getModPrix();
			int val = (int) Math.round(valeur);
			i++;
			ind[i] = it.getId();
			System.out.println( (i+1) + " - " + it.getNom() + " : " + val + " PO");
		}
		System.out.println("");
		System.out.println(m.getNom()+" : Y a-t-il quelque chose que tu voudrais me vendre ?");
		System.out.println("1 - Vendre un objet");
		System.out.println("2 - Retour");

		int choix = saisieInt("");
		switch(choix) {
		case 1 :
			int id_objet = saisieInt("Sélectionner le numéro de l'objet à vendre :");
			vendre(m, ind[ id_objet-1 ]);break;
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
				System.out.println(m.getNom()+" : Désolé, je n'ai pas assez d'argent pour ça. J'ai une famille à nourrir.");
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
			m = ct.getDaoMar().save(m);
			ct.setP( ct.getDaoP().save(j) );
			System.out.println(m.getNom()+" : C'est toujours un plaisir de faire affaire avec vous aventurier !");
			System.out.println("");
		}
	}
	
	public static void gestionTime() {
		LocalDateTime t = LocalDateTime.now();
		h += Duration.between(start, t).toHours();
		min += Duration.between(start, t).toMinutesPart();
		s += Duration.between(start, t).toSecondsPart();
		if( s > 59 ) {
			s = s%60;
			min++;		
		}
		if( min > 59 ) {
			min = min%60;
			h++;
		}
		System.out.println("Temps de jeu : " + h + " h " + min + " min " + s + " s");
	}

	/* ------------------------------------ Ecran de victoire ------------------------------------ */
	public static void victoryScreen() {
		System.out.println(" !!! ");
		System.out.println("");
		System.out.println("Je t'attendais aventurier !");
		System.out.println("Je te félicite ! Tu es parvenu à réunir les objets et l'argent nécessaires à ton périple.");
		System.out.println("J'espère que ton séjour ici a été plaisant. N'hésite pas à revenir me voir !");
		System.out.println("");
		gestionTime();
		System.out.println("***Bravo, vous avez accompli vos objectifs avec brio !***");
		ecrire("Félicitations.txt");
		System.exit(0);
	}

}