import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Application de visualisation et d'achat de formations
 * @author Stagiaires03P
 *
 */

public class AppliFormation {

	private static Scanner scan = new Scanner (System.in);

	//Les formations sont découpées en Nom, Durée, Description, Prix et Quantité afin de faciliter l'ajout et le retrait de formations

	private static String[] NOMFORMATION = {"Cours","Java","Java avancé","Spring","Php framworks","C#"};
	private static String[] DUREEFORMATION = {"NB/JOURS","20","20","20","15","20","0","30","40"};
	private static String[] DESCRIPTIONFORMATION = {"Description","Java SE 8 : Syntaxe & Poo","Exceptions, fichiers, Jdbc, thread ","Spring core/Mvc/Security","Symphony","DotNetCore"};
	private static String[] PRIXFORMATION = {"Prix","3000","5000","5000","2500","5000"};
	private static String[] QUANTITE = {"Quantité","0","0","0","0","0"};

	private static String[] NOMFORMATIONAVENIR = {"Cours","Git","C++"};
	private static String[] DUREEFORMATIONAVENIR = {"NB/JOURS","30","40"};
	private static String[] DESCRIPTIONFORMATIONAVENIR = {"Description","Git et GitHub","POO"};
	private static String[] PRIXFORMATIONAVENIR = {"Prix","5500","3450"};

	/**
	 * CART est le panier de l'utilisateur
	 */

	public static HashMap<Integer, ArrayList<String>> CART = new HashMap<Integer, ArrayList<String>>();

	/**
	 * LISTEFORMATIONS est la liste de toutes les formations actuellement disponible
	 */

	public static HashMap<Integer, ArrayList<String>> LISTEFORMATIONS = new HashMap<Integer, ArrayList<String>>();

	/**
	 * UPCOMINGCOURSES est la liste des formations à venir
	 */

	public static HashMap<Integer, ArrayList<String>> FORMATIONSAVENIR = new HashMap<Integer, ArrayList<String>>();

	/**
	 * Rempli la table avec les formations renvoyées par returnFormation
	 */

	public static void createCourseList () {

		for (int i = 0 ; i < NOMFORMATION.length ; i ++) {
			
			LISTEFORMATIONS.put(i, returnFormation(i));
		}
	}

	/**
	 * Créé le panier
	 */

	public static void createCart() {

		for (int i = 0 ; i < NOMFORMATION.length ; i ++) {

			CART.put(i, returnFormation(i));
		}

	}

	/**
	 * Créé la liste des formations à venir
	 */

	public static void createUpcomingCourses() {

		for (int i = 0 ; i < NOMFORMATIONAVENIR.length ; i ++) {
			FORMATIONSAVENIR.put(i, returnFormationAVenir(i));
		}
	}

	/**
	 * Renvoie une formation à venir pour la rentrer dans une table
	 * @param index - l'index de la formation
	 * @return formation : une ArrayList complète représentant une formation
	 */

	public static ArrayList<String> returnFormationAVenir(int index){

		ArrayList<String> formation = new ArrayList<String>();

		formation.add(NOMFORMATIONAVENIR[index]);
		formation.add(DUREEFORMATIONAVENIR[index]);
		formation.add(DESCRIPTIONFORMATIONAVENIR[index]);
		formation.add(PRIXFORMATIONAVENIR[index]);

		return formation;
	}

	/**
	 * Renvoie une formation pour la rentrer dans une table
	 * @param index - l'index de la formation
	 * @return formation : une ArrayList complète représentant une formation
	 */

	public static ArrayList<String> returnFormation(int index){

		ArrayList<String> formation = new ArrayList<String>();

		formation.add(NOMFORMATION[index]);
		formation.add(DUREEFORMATION[index]);
		formation.add(DESCRIPTIONFORMATION[index]);
		formation.add(PRIXFORMATION[index]);
		formation.add(QUANTITE[index]);

		return formation;
	}


	/**
	 * afficher un message de bienvenue
	 * 
	 */
	public static void afficherMessageBienvenue() {
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("|           Bonjour et bienvenue dans mon application AppliFormation          |");
		System.out.println("| Nous allons vous proposer une liste de formations actuellement disponnibles |");
		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * Affiche la liste des formations
	 * @param courseList : les formations à afficher
	 * 
	 */

	public static void displayCourseList(HashMap<Integer, ArrayList<String>> courseList) {

		System.out.println("-------------------------------------------------------------------------------");
		
		displayCourse(courseList.get(0));
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------------------------------");

		for(int i = 1 ; i < courseList.size() ; i++ ) {
			
			displayCourse(courseList.get(i));
			
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	/**
	 * Affiche les formations contenues dans le panier
	 * @param courseList - le panier à afficher
	 */

	public static void displayCart(HashMap<Integer, ArrayList<String>> courseList) {

		if(getPrice()!=0) {

			System.out.println("--------------------------------------------------------------------------------------------");
			
			displayCourseWithQuantity(LISTEFORMATIONS.get(0));

			System.out.println();
			
			System.out.println("--------------------------------------------------------------------------------------------");

			for(int i = 1 ; i < courseList.size() ; i++ ) {
				
				if(courseList.get(i).get(4) != "0") {
					
					displayCourseWithQuantity(courseList.get(i));
					System.out.println();
				}
			}
			System.out.println("--------------------------------------------------------------------------------------------");
		}else {
			System.out.println("Votre panier est vide");
		}
	}
	/**
	 * Affiche l'intégralité du panier, avec les ID de chaque formation
	 * @param courseList - le panier à afficher (pas forcément utile de le passer en paramètre dans la version actuelle de l'app)
	 */
	public static void displayCartWithID (HashMap<Integer, ArrayList<String>> courseList) {

		if(getPrice()!=0) {

			System.out.println("---------------------------------------------------------------------------------------------------------");
			
			displayCourseWithQuantity(LISTEFORMATIONS.get(0));

			System.out.println();
			
			System.out.println("---------------------------------------------------------------------------------------------------------");

			for(int i = 1 ; i < courseList.size() ; i++ ) {
				
				if(courseList.get(i).get(4) != "0") {
					
					displayCourseFromCartWithID(courseList.get(i), i);
					
					System.out.println();
				}
			}
			System.out.println("---------------------------------------------------------------------------------------------------------");
			
		}else {
			
			System.out.println("Votre panier est vide");
		}
	}
	/**
	 * Affiche une formation du panier avec son ID
	 * @param formation - la formation à afficher
	 * @param index - l'index de la formation, c'est à dire sa clef dans la HashMap
	 */

	public static void displayCourseFromCartWithID(ArrayList<String> formation, int index) {

		if(index!=0) {
			System.out.printf("| %-4s | %-15s | %-10s | %-38s | %-4s | %-10s |", index, formation.get(0), formation.get(1),formation.get(2),formation.get(3),formation.get(4));

		}else
			System.out.printf("| %-4s | %-15s | %-10s | %-38s | %-4s | %-10s |", "ID",formation.get(0), formation.get(1),formation.get(2),formation.get(3),formation.get(4));


	}

	/**
	 * Affiche la liste des formations avec leur ID
	 * @param courseList : les formations à afficher
	 */
	public static void displayCourseListWithID(HashMap<Integer, ArrayList<String>> courseList) {


		System.out.println("-------------------------------------------------------------------------------");

		displayCourseWithID(courseList.get(0), 0);

		System.out.println();

		System.out.println("-------------------------------------------------------------------------------");

		for(int i = 1 ; i < courseList.size() ; i++ ) {

			displayCourseWithID(courseList.get(i), i);
			System.out.println();
		}

		System.out.println("-------------------------------------------------------------------------------");
	}

	/**
	 * Affiche une formations avec son identifiant
	 * @param formation - la formation à afficher
	 * @param index - l'index de la formation, c'est à dire sa clef dans la HashMap
	 */

	public static void displayCourseWithID(ArrayList<String> formation, int index) {

		if(index!=0) {
			System.out.printf("| %-4s | %-15s | %-10s | %-38s | %-4s |", index, formation.get(0), formation.get(1),formation.get(2),formation.get(3));
		}else
			System.out.printf("| %-4s | %-15s | %-10s | %-38s | %-4s |", "ID",formation.get(0), formation.get(1),formation.get(2),formation.get(3));

	}


	/**
	 * Affiche une formation
	 * @param formation : la formation à afficher
	 */
	public static void displayCourse(ArrayList<String> formation) {

		System.out.printf("| %-15s | %-10s | %-38s |%-4s |",formation.get(0), formation.get(1),formation.get(2),formation.get(3));

	}
	
	/**
	 * Affiche une formation ainsi que sa quantité dans le panier
	 * @param formation : la formation à afficher
	 */

	public static void displayCourseWithQuantity(ArrayList<String> formation) {

		if(formation.get(4) != "0") {

			System.out.printf("| %-15s | %-10s | %-38s |%-4s | %-10s |",formation.get(0), formation.get(1),formation.get(2),formation.get(3),formation.get(4));
		}

	}

	/**
	 * Ajouter une formation au panier
	 * @param index - l'index de la formation à ajouter
	 */

	public static void addCourseToCart(int index) {

		if(index < LISTEFORMATIONS.size() && index > 0) {

			ArrayList<String> formation = new ArrayList<String>();

			formation.add( CART.get(index).get(0));
			formation.add( CART.get(index).get(1));
			formation.add( CART.get(index).get(2));
			formation.add( CART.get(index).get(3));
			formation.add( CART.get(index).get(4));

			int quantite = Integer.parseInt(formation.get(4));

			quantite +=1;

			formation.set( 4 , String.valueOf(quantite));

			CART.put(index, formation);

		}else {
			System.out.println("L'ID entré ne correspond à aucune formation");
		}

	}

	/**
	 * Retirer une formation du panier
	 * @param index - l'index de la formation à retirer
	 */
	public static void removeCourseFromCart(int index) {
		
		if (getPrice()!=0) {
		
			int quantite = 0;
			
		if(index < LISTEFORMATIONS.size() && index > 0) {

		ArrayList<String> formation = new ArrayList<String>();

		formation.add( CART.get(index).get(0));
		formation.add( CART.get(index).get(1));
		formation.add( CART.get(index).get(2));
		formation.add( CART.get(index).get(3));
		formation.add( CART.get(index).get(4));

		quantite = Integer.parseInt(formation.get(4));
		
		if( quantite > 1 ) {

			quantite -=1;

			formation.set( 4 , String.valueOf(quantite));

			CART.put(index, formation);

		}else if (quantite == 1 ) {

			formation.set( 4 , "0" );

			CART.put(index, formation);
		}

		}else {
			System.out.println("Cette formation n'est pas présente dans votre panier");
		}
		}else {
			System.out.println("Votre panier est vide");
		}

	}

	/**
	 * Renvoie l'index de la formation selectionnée par l'utilisateur
	 * @return index : entier représentant la clef de la formation dans la HashMap LISTEFORMATIONS
	 */
	public static int selectCourse()
	{

		int input = -1;

		System.out.println("Entrez l'ID de la formation que vous souhaitez ajouter");

		displayCourseListWithID(LISTEFORMATIONS);

		while(!scan.hasNextInt())scan.next();

		input = scan.nextInt();

		return input;
	}

	/**
	 * Permet à l'utilisateur de choisir une formation en entrant son ID
	 * @return input - le choix de l'utilisateur en entier
	 */
	public static int selectCourseFromCart() {
		
		if (getPrice()!=0) {

		int input = -1;

		System.out.println("Entrez l'ID de la formation que vous souhaitez retirer");

		displayCartWithID(CART);

		while(!scan.hasNextInt())scan.next();

		input = scan.nextInt();
		

		return input;
		} else {
			return 0;
		}

	}

	/**
	 * Calcule et renvoie le prix total du panier
	 * @return prixTotal - le prix total du panier en entier
	 */

	public static int getPrice() {

		int prix = 0;
		int prixTotal = 0;

		for(int i = 1 ; i < CART.size() ; i ++) {

			if (CART.get(i).get(4) != "0") {

				prix = Integer.parseInt(CART.get(i).get(3)) * Integer.parseInt(CART.get(i).get(4));

				prixTotal += prix;
			}


		}

		return prixTotal;
	}

	/**
	 * Permet à l'utilisateur de passer commande
	 */

	public static void checkout() {

		if(getPrice()==0) {
			
			System.out.println("Votre panier est vide");
			
		} else {

			displayCart(CART);

			System.out.println( "Le prix total de votre commande est de : " + getPrice() + " euros.");

			System.out.println("Tapez 1 pour passer commande, 2 pour annuler");

			while(!scan.hasNextInt())scan.next();

			int input = scan.nextInt();

			if (input == 1) {
				
				System.out.println("Tapez 1 pour confirmer votre achat");

				while(!scan.hasNextInt())scan.next();

				input = scan.nextInt();
				
				if (input == 1) {
					
				System.out.println("Merci de votre achat, retour au menu principal");
	

				CART.clear();

				createCart();
				
				} else {
					
					System.out.println("Opération annulée, retour au menu principal");
					
					input = 0;
				}
				

			} else if (input == 2) {

				System.out.println("Retour au menu principal");

			} else {
				System.out.println("Mauvaise saisie, retour au menu principal");
			}
		}

	}

	/**
	 * Affiche la liste des formations à venir
	 */

	public static void displayUpcomingCourses() {

		displayCourseList(FORMATIONSAVENIR);

	}

	/**
	 * Affiche le menu principal
	 */

	public static void mainMenu() {

		boolean leaving = false;

		int input;

		while(!leaving) {
			System.out.println(""
					+ "-------------------------------------------------------------------------------\n"
					+ "|          Que souhaitez-vous faire?                                          |\n"
					+ "| 1 : Afficher la liste des formations                                        |\n"
					+ "| 2 : Ajouter une formation à mon panier                                      |\n"
					+ "| 3 : Retirer une formation de mon panier                                     |\n"
					+ "| 4 : Afficher mon panier                                                     |\n"
					+ "| 5 : Passer commande                                                         |\n"
					+ "| 6 : Afficher la liste des formations à venir                                |\n"
					+ "| 7 : Quitter l'application                                                   |\n"
					+ "-------------------------------------------------------------------------------");

			while(!scan.hasNextInt())scan.next();

			input = scan.nextInt();

			switch(input) {

			case 1 :

				displayCourseList(LISTEFORMATIONS);

				break;

			case 2 :

				addCourseToCart(selectCourse());

				break;

			case 3 : 		

				removeCourseFromCart(selectCourseFromCart());

				break;

			case 4 :

				displayCart(CART);

				break;

			case 5 :

				checkout();

				break;

			case 6 : 

				displayUpcomingCourses();

				break;

			case 7 :

				System.out.println("Merci d'avoir utilisé AppliFormation, bonne journée!");

				leaving = true;

				break;

			default:

				System.out.println("Veuillez entrer une valeur comprise entre 1 et 7");
			}
		}
	}

	/**
	 * Main du programme
	 * @param args - arguments (non utilisé)
	 */

	public static void main (String[] args) {

		createCourseList();

		createCart();

		createUpcomingCourses();

		afficherMessageBienvenue();

		mainMenu();

		scan.close();

	}


}
