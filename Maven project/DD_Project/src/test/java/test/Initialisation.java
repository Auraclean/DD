package test;

import java.util.ArrayList;
import java.util.List;

import metier.Archetype;
import metier.Item;
import metier.Marchand;
import metier.Question;
import metier.Reponse;
import metier.Role;
import util.Context;

public class Initialisation {
	
	static Context ct = Context.get_instance();
	
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
		Item i26 	= new Item("Morpho Hache", "Pour tuer des dragons avec des décharges élementaires", 77);
		Item i27 	= new Item("Volto Hache", "Pour tuer des dragons avec des super décharges élementaires amplifiées", 80);
		Item i28 	= new Item("Grande Epee", "Pour tuer des dragons comme Guts", 35);
		Item i29 	= new Item("Epee Bouclier", "Sword and Shield, SnS, sneeesss, Swag and Style!", 47);
		Item i30 	= new Item("Double Lames", "Pour les edge lords", 36);
		Item i31 	= new Item("Longue Epée", "The weeb stick", 38);
		Item i32 	= new Item("Insecto-Glaive", "Le french Stick, Je SuiS mOnté!", 55);
		Item i33 	= new Item("Marteau", "Corne de chasse inférieure, tourbilol", 34);
		Item i34 	= new Item("Lance Canon", "Une lance avec un flingue encore plus lent qu'une lance", 56);
		Item i35	= new Item("Lance", "L'arme la moins aimée du jeu alors que c'est pas la plus défensive", 49);
		Item i36 	= new Item("L'Arc", "Pour les indécis entre le CaC et la distance", 18);
		Item i37 	= new Item("Fusarbalète Lourd", "La meilleure arme pour tuer des dragons en speedrun", 69);
		Item i38 	= new Item("Fusarbalète Léger", "La meilleure arme pour tuer des dragons à distance de fragile", 63);
		Item i39 	= new Item("Piège à Foudre", "Un foudrinsecte permet de paralyser une créature à l'intérieur", 16);
		Item i40 	= new Item("Carnet de Notes", "Pour prendre des notes, duh!", 10);
		Item i41 	= new Item("Stylo à encre", "Pour écrire tête de noeud!", 7);
		Item i42 	= new Item("Plume et Encrier", "Pour encrer ta légende!", 12);
		Item i43 	= new Item("Papyrus", "Pour laisser des messages aux dieux, se lit 'papier russe'...", 15);
		Item i44 	= new Item("Baguette Magique", "Pour jouer aux apprentis Sorciers!", 34);
		Item i45 	= new Item("Sceau", "Peut contenir des trucs liquides et te faire voler", 24);
		Item i46 	= new Item("Lyre", "Inutile au possible mais peut faire du bruit", 83);
		Item i47 	= new Item("Canard", "Adorable, protéger le au péril de votre vie", 88);
		Item i48 	= new Item("Chat", "Mignon mais peut disparaitre de votre inventaire sans raison...", 53);
		Item i49 	= new Item("Nintendo Switch", "Pour jouer à des jeux plus intéressants que celui-ci", 100);
		Item i50 	= new Item("PC", "Félicitations, vous avez gagné car vous pouvez hacker ce jeu à la noix...ou pas", 200);
		Item i51 	= new Item("Orange", "L'orange du marchand", 6);
		Item i52 	= new Item("Grimoire", "Ca sent le vieux", 35);
		Item i53 	= new Item("Clef", "Que peut elle bien ouvrir", 12);
		Item i54 	= new Item("Peluche", "C'est surement infesté de puce", 3);
		Item i55 	= new Item("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 33);
		Item i56 	= new Item("Pomme", "Une pomme", 2);
		Item i57 	= new Item("Caleçon usagé", "Vous ne savez pas d'où il sort mais laissez le plus d'espace possible entre vous et lui.", 4);
		Item i58 	= new Item("Arrosoir", "Qui vous a dit que vous n'aviez pas la main verte ?", 8);
		

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
		i26 = ct.getDaoItem().save(i26);
		i27 = ct.getDaoItem().save(i27);
		i28 = ct.getDaoItem().save(i28);
		i29 = ct.getDaoItem().save(i29);
		i30 = ct.getDaoItem().save(i30);
		i31 = ct.getDaoItem().save(i31);
		i32 = ct.getDaoItem().save(i32);
		i33 = ct.getDaoItem().save(i33);
		i34 = ct.getDaoItem().save(i34);
		i35 = ct.getDaoItem().save(i35);
		i36 = ct.getDaoItem().save(i36);
		i37 = ct.getDaoItem().save(i37);
		i38 = ct.getDaoItem().save(i38);
		i39 = ct.getDaoItem().save(i39);
		i40 = ct.getDaoItem().save(i40);
		i41 = ct.getDaoItem().save(i41);
		i42 = ct.getDaoItem().save(i42);
		i43 = ct.getDaoItem().save(i43);
		i44 = ct.getDaoItem().save(i44);
		i45 = ct.getDaoItem().save(i45);
		i46 = ct.getDaoItem().save(i46);
		i47 = ct.getDaoItem().save(i47);
		i48 = ct.getDaoItem().save(i48);
		i49 = ct.getDaoItem().save(i49);
		i50 = ct.getDaoItem().save(i50);
		i51 = ct.getDaoItem().save(i51);
		i52 = ct.getDaoItem().save(i52);
		i53 = ct.getDaoItem().save(i53);
		i54 = ct.getDaoItem().save(i54);
		i55 = ct.getDaoItem().save(i55);
		i56 = ct.getDaoItem().save(i56);
		i57 = ct.getDaoItem().save(i57);
		i58 = ct.getDaoItem().save(i58);

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
		List<Item> catalogue3 = new ArrayList<Item>();
		catalogue3.add(i51);
		catalogue3.add(i7);
		catalogue3.add(i13);
		catalogue3.add(i10);
		catalogue3.add(i47);
		catalogue3.add(i37);
		catalogue3.add(i34);
		catalogue3.add(i19);

		Marchand m1 = new Marchand("HALVAR LE FORGERON", 300, catalogue1, "Les Forges Infernalles", 50);
		m1.setBonjour("Bonjour et bienvenue dans ma modeste forge! Prenez votre temps pour choisir ce qu'il y a de mieux pour vous.");
		m1.setAurevoir("A la revoyure aventurier!");
		m1.setBonneReponse("C'est une réponse intéressante.");
		m1.setMauvaiseReponse("Médiocre. Je m'attendais à mieux de votre part.");
		m1.setVenteOk("Un plaisir de faire affaire avec vous!");
		m1.setVenteNope("Désolé, je n'ai pas assez d'argent pour ça. J'ai une famille à nourrir.");
		m1.setStock("Voici l'ensemble de mes produits, la fierté de mon établissement!");
		m1.setAchatOk("Merci pour votre achat !");
		m1.setAchatNope("Désolé, la maison ne fait pas crédit. Revenez quand vous aurez la somme nécessaire.");
		
		Marchand m2 = new Marchand("THORVALD LE VOYAGEUR", 200, catalogue2, "Boutique de Souvenirs du Monde", 66, 0.2);
		m2.setBonjour("Bienvenue dans l'échoppe la plus excentrique du confins de ces terres étranger!");
		m2.setAurevoir("Reviens vite l'étranger...");
		m2.setBonneReponse("Hum je vois... tu n'es pas un voyageur comme les autres...");
		m2.setMauvaiseReponse("AH! Tu n'es rien de spécial pauvre sot!");
		m2.setVenteOk("Hé hé hé...une affaire rondement menée!");
		m2.setVenteNope("Tu crois vraiment que je vais t'acheter ta camelotte? Ma marchandise est de bien meilleure facture!");
		m2.setStock("Ouvre grand tes mirettes et observe les plus précieux trésors de cette contrée!");
		m2.setAchatOk("Hé hé, une transaction réglée en monnaie sonnante et trébuchante!");
		m2.setAchatNope("Passe ton chemin manant, je n'accepte pas les sans-le-sous dans mon havre de curiosités.");
		
		Marchand m3 = new Marchand("GREGORY LE CHANTEUR", 275, catalogue3, "Boutique du Dragon Chantant", 35, 0.5);
		m3.setBonjour(null);
		m3.setBonneReponse("Bonne réponse !");
		m3.setMauvaiseReponse("Mauvaise réponse.");
		m3.setVenteOk(null);
		m3.setVenteNope(null);
		m3.setStock(null);
		m3.setAchatOk("Merci pour votre achat !");
		m3.setAchatNope("Désolé, la maison ne fait pas crédit. Reviens quand tu disposeras de la somme nécessaire.");
		
		m1 = ct.getDaoMar().save(m1);
		m2 = ct.getDaoMar().save(m2);
		m3 = ct.getDaoMar().save(m3);

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
		Reponse r13 = new Reponse("Un monstre", false);
		Reponse r14 = new Reponse("Un menteur", true);
		Reponse r15 = new Reponse("Un fou", false);
		Reponse r16 = new Reponse("La soupe d'artichaut", false);
		Reponse r17 = new Reponse("Une orange", true);
		Reponse r18 = new Reponse("Une entrecote d'orc", false);
		

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
		List<Reponse> reponses5 = new ArrayList<Reponse>();
		reponses5.add(r13);
		reponses5.add(r14);
		reponses5.add(r15);
		List<Reponse> reponses6 = new ArrayList<Reponse>();
		reponses6.add(r16);
		reponses6.add(r17);
		reponses6.add(r18);

		//Création des questions + marchands qui en disposent
		Question q1 = new Question("Que penses-tu de notre village aventurier?", reponses1,m1);
		Question q2 = new Question("As-tu déjà connu la peur l'étranger??", reponses2,m2);
		Question q3 = new Question("Holà qui va là!?", reponses3,m2);
		Question q4 = new Question("Quel est ton plus grand désir l'aventurier?", reponses4,m1);
		Question q5 = new Question("j'ai 2 pieds, 6 jambes, 8 bras, 2 têtes et un oeil, qui suis-je ?", reponses5,m3);
		Question q6 = new Question("Quel est mon plat préféré?", reponses6,m3);

		ct.getDaoQues().save(q1);
		ct.getDaoQues().save(q2);
		ct.getDaoQues().save(q3);
		ct.getDaoQues().save(q4);
		ct.getDaoQues().save(q5);
		ct.getDaoQues().save(q6);
	}
}
