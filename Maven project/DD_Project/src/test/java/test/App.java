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


	/* ------------------------------------ Initialisation ------------------------------------ */
	public static void init() {
		//Creation des Objets
		Item i1 	= new Item("Chaussures", "elles puent", 5);
		Item i2 	= new Item("Baton magique", "Il y a un caillou bleu dessus", 50);
		Item i3 	= new Item("Cape d'invisibilite", "Elle permet de se rendre invisible", 100);
		Item i4 	= new Item("Epee longue", "Acier trempe rouille pas vite", 20);
		Item i5 	= new Item("Chapeau de paille", "Inutile mais swag pour Jordan", 1);
		Item i6 	= new Item("Armure de cuir", "Legere, ideale pour les freles magiciens", 10);
		Item i7 	= new Item("Armure de metal", "Lourde, ideale pour les grosses brutes suicidaires", 20);
		Item i8 	= new Item("Cotte de mailles", "Du metal porte pour pas mourir", 15);
		Item i9 	= new Item("Bottes de sept lieues", "Des godasses qui ont la classe", 30);
		Item i10 	= new Item("Havresac", "objet inutile du jeu, stockage infini", 100);
		Item i11 	= new Item("Sabre Laser", "artefact perdu des temps anciens", 75);
		Item i12 	= new Item("Bouclier de bois", "Craint le feu", 10);
		Item i13 	= new Item("Bouclier de metal", "Craint le feu tres chaud", 20);
		Item i14 	= new Item("Dagues d'argent", "Ce ne sont pas des shurikens", 15);
		Item i15 	= new Item("Marteau", "A rendre au forgeron qui l'a perdu", 0);
		Item i16 	= new Item("Potion de soin", "pour soigner les blessures non-lethales", 10);
		Item i17 	= new Item("Fiole d'alchimie", "concoction obscure et odorante", 7);
		Item i18 	= new Item("Herbes de provence", "pour cuisiner de bons petits plats", 3);
		Item i19 	= new Item("Kamoulox", "pour gagner un argument", 13);
		Item i20 	= new Item("Pistolet a poudre", "Et paf ca fait pan", 43);
		Item i21 	= new Item("Arbalete", "Plus puissante mais plus lente qu'un arc", 36);
		Item i22 	= new Item("Arc", "Plus rapide mais plus faible qu'une arbalete", 20);
		Item i23 	= new Item("Fleches", "Vendues par 12", 12);
		Item i24 	= new Item("Piege a fosse", "Les monstres tombent dans un trou et peuvent etre captures", 28);
		Item i25 	= new Item("Corne de Chasse", "La meilleure arme pour tuer des dragons en musique", 66);

		//Enregistre les objets
		// mettre le i1 = au début évite d'avoir des objets en plusieurs exemplaires
		i1 = ct.getDaoItem().save(i1);
		i2 = ct.getDaoItem().save(i2);
		i3 = ct.getDaoItem().save(i3);
		i4 = ct.getDaoItem().save(i4);
		i5 = ct.getDaoItem().save(i5);
		i6 = ct.getDaoItem().save(i6);
		i7 = ct.getDaoItem().save(i7);
		i8 = ct.getDaoItem().save(i8);
		i9 = ct.getDaoItem().save(i9);
		i10 = ct.getDaoItem().save(i10);
		i11 = ct.getDaoItem().save(i11);
		i12 = ct.getDaoItem().save(i12);
		i13 = ct.getDaoItem().save(i13);
		i14 = ct.getDaoItem().save(i14);
		i15 = ct.getDaoItem().save(i15);
		i16 = ct.getDaoItem().save(i16);
		i17 = ct.getDaoItem().save(i17);
		i18 = ct.getDaoItem().save(i18);
		i19 = ct.getDaoItem().save(i19);
		i20 = ct.getDaoItem().save(i20);
		i21 = ct.getDaoItem().save(i21);
		i22 = ct.getDaoItem().save(i22);
		i23 = ct.getDaoItem().save(i23);
		i24 = ct.getDaoItem().save(i24);
		i25 = ct.getDaoItem().save(i25);

		//Creation des listes correspondant aux Archetypes
		List<Item> objectifSorcier = new ArrayList<Item>();
		objectifSorcier.add(i2);
		objectifSorcier.add(i6);
		objectifSorcier.add(i17);
		List<Item> objectifGuerrier = new ArrayList<Item>();
		objectifGuerrier.add(i4);
		objectifGuerrier.add(i7);
		objectifGuerrier.add(i8);
		objectifGuerrier.add(i13);
		List<Item> objectifBarde = new ArrayList<Item>();
		objectifBarde.add(i9);
		objectifBarde.add(i16);
		objectifBarde.add(i25);
		List<Item> objectifChasseur = new ArrayList<Item>();
		objectifChasseur.add(i14);
		objectifChasseur.add(i22);
		objectifChasseur.add(i23);
		objectifChasseur.add(i24);

		Archetype a1 = new Archetype(Role.Sorcier, objectifSorcier);
		Archetype a2 = new Archetype(Role.Guerrier, objectifGuerrier);
		Archetype a3 = new Archetype(Role.Barde, objectifBarde);
		Archetype a4 = new Archetype(Role.Chasseur, objectifChasseur);

		//Enregistre les Archetypes
		ct.getDaoArc().save(a1);
		ct.getDaoArc().save(a2);
		ct.getDaoArc().save(a3);
		ct.getDaoArc().save(a4);

		//Creation des inventaires des marchands
		List<Item> catalogue1 = new ArrayList<Item>();
		catalogue1.add(i14);
		catalogue1.add(i22);
		catalogue1.add(i23);
		catalogue1.add(i24);
		catalogue1.add(i4);
		catalogue1.add(i7);
		catalogue1.add(i8);
		catalogue1.add(i13);
		List<Item> catalogue2 = new ArrayList<Item>();
		catalogue2.add(i2);
		catalogue2.add(i6);
		catalogue2.add(i17);
		catalogue2.add(i9);
		catalogue2.add(i16);
		catalogue2.add(i25);

		Marchand m1 = new Marchand("Halvar le Forgeron", 100, catalogue1, "Les Forges Infernalles", 50);
		Marchand m2 = new Marchand("Thorvald le Voyageur", 70, catalogue2, "Boutique de Souvenirs du Monde", 66);

		m1 = ct.getDaoMar().save(m1);
		m2 = ct.getDaoMar().save(m2);

		//Creation Reponses
		Reponse r1 = new Reponse("Charmant et rustisque comme je les aime", false);
		Reponse r2 = new Reponse("Petit mais convivial", false);
		Reponse r3 = new Reponse("Il sent un peu le souffre quand meme", true);
		Reponse r4 = new Reponse("Oui, en ce moment meme je parle a quelque chose d'effrayant", false);
		Reponse r5 = new Reponse("Non, jamais je n'ai tremble face au danger!", false);
		Reponse r6 = new Reponse("Bien sur! Et je peux meme te l'enseigner si tu insistes!", true);
		Reponse r7 = new Reponse("Inspecteur Gadget! Go-go-gadgeto mawashi-geri dans les valseuses!", true);
		Reponse r8 = new Reponse("C'est moi abruti", false);
		Reponse r9= new Reponse("Juste un simple aventurier a la recherche d'equipement de noob pour partir faire les quetes niveau 1", false);
		Reponse r10 = new Reponse("Fonder une famille et vivre paisiblement", false);
		Reponse r11 = new Reponse("Decouvrir la verite de ce monde", true);
		Reponse r12 = new Reponse("Combattre les injustices de la société", false);

		/*		ct.getDaoRep().save(r1);
				ct.getDaoRep().save(r2);
				ct.getDaoRep().save(r3);
				ct.getDaoRep().save(r4);
				ct.getDaoRep().save(r5);
				ct.getDaoRep().save(r6);
				ct.getDaoRep().save(r7);
				ct.getDaoRep().save(r8);
				ct.getDaoRep().save(r9);
				ct.getDaoRep().save(r10);
				ct.getDaoRep().save(r11);
				ct.getDaoRep().save(r12);*/


		//Creation des listes de réponses associées aux Questions
		List<Reponse> reponses1 = new ArrayList<Reponse>();
		reponses1.add(r1);
		reponses1.add(r2);
		reponses1.add(r3);
		List<Reponse> reponses2 = new ArrayList<Reponse>();
		reponses2.add(r4);
		reponses2.add(r5);
		reponses2.add(r6);
		List<Reponse> reponses3 = new ArrayList<Reponse>();
		reponses3.add(r7);
		reponses3.add(r8);
		reponses3.add(r9);
		List<Reponse> reponses4 = new ArrayList<Reponse>();
		reponses4.add(r10);
		reponses4.add(r11);
		reponses4.add(r12);

		//Création des questions + marchands qui en disposent
		Question q1 = new Question("Que penses-tu de notre village aventurier?", reponses1,m1);
		Question q2 = new Question("As-tu déjà connu la peur l'étranger??", reponses2,m2);
		Question q3 = new Question("Holà qui va là!?", reponses3,m2);
		Question q4 = new Question("Quel est ton plus grand désir l'aventurier?", reponses4,m1);

		ct.getDaoQues().save(q1);
		ct.getDaoQues().save(q2);
		ct.getDaoQues().save(q3);
		ct.getDaoQues().save(q4);
	}

	/* ------------------------------------ MAIN ------------------------------------ */
	public static void main(String[] args) {

		init();
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
			System.out.println( classe.getObjectifs() ); 
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
		System.out.println(Duration .between(start, pause).toMinutes()+" minutes "+ Duration .between(start, pause).toSecondsPart()+" secondes");
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
			System.out.println("Id :"+ it.getId() +", Nom : "+ it.getNom() +", Prix : "+ it.getValeur() +" PO");
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
		
		if( m.getInventaire().contains(it) ) {
			if( ct.getP().getSolde() < it.getValeur() ) {
				System.out.println("Désolé, la maison ne fait pas crédit. Reviens quand tu disposeras de la somme nécessaire.");
				showInventaireMarchand(m);
			}
			//retire l'item de l'inventaire du marchand + gère son argent
			inv_marchand.remove(it); m.setInventaire(inv_marchand);
			m.setSolde( m.getSolde() + it.getValeur() );
			//ajoute l'item à l'inventaire du joueur + gère son argent
			inv_joueur.add(it); ct.getP().setInventaire(inv_joueur);
			ct.getP().setSolde( ct.getP().getSolde() - it.getValeur() );
		}
	}

	public static void vendreObjet(Marchand m) {
		for (Item it : ct.getP().getInventaire() )
			//Attention, il faut modifier le prix selon le marchand...
			System.out.println("Id :"+ it.getId() +", Nom : "+ it.getNom() +", Prix : "+ it.getValeur() +" PO");
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
		Item it = ct.getDaoItem().findById(id_objet);
		double valeur = it.getValeur();
		if(m.getAffinite()<=25) valeur=valeur-it.getValeur()*0.1;
		if(m.getAffinite()<=50) valeur=valeur-it.getValeur()*0.1;
		if(m.getAffinite()>50) valeur=valeur+it.getValeur()*0.1;
		if(m.getAffinite()>75) valeur=valeur+it.getValeur()*0.1;
		int val = (int) Math.round(valeur);
		List<Item> inv_joueur = ct.getP().getInventaire();
		List<Item> inv_marchand = m.getInventaire();
		if( ct.getP().getInventaire().contains(it) ) {
			// Valeur de l'objet à modifier selon l'affinité
			if( m.getSolde() < val ) {
				System.out.println("Désolé, je n'ai pas assez d'argent pour ça. J'ai une famille à nourrir.");
				vendreObjet(m);
			}
			//retire l'item de l'inventaire du joueur + gère son argent
			inv_joueur.remove(it); ct.getP().setInventaire(inv_joueur);
			ct.getP().setSolde( ct.getP().getSolde() + val);
			//ajoute l'item à l'inventaire du marchand + gère son argent
			inv_marchand.add(it); m.setInventaire(inv_marchand);
			m.setSolde( m.getSolde() - val );
			ct.getDaoMar().save(m);
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