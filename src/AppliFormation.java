import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AppliFormation {

	public static Scanner scan = new Scanner (System.in);

	/*
	private static String[] MENUFORMATIONS = {"0","COURS          ", "NB/JOURS", "DESCRIPTION                       ","PRIX"};
	private static String[] FORMATION1     = {"1","Java           ", "   20   ", "Java SE 8 : Syntaxe & Poo         ","3000"};
	private static String[] FORMATION2     = {"2","Java avancé    ", "   20   ", "Exceptions, fichiers, Jdbc, thread","5000"};
	private static String[] FORMATION3     = {"3","Spring         ", "   20   ", "Spring core/Mvc/Security          ","5000"};
	private static String[] FORMATION4     = {"4","Php frameworks ", "   15   ", "Symphony                          ","2500"};
	private static String[] FORMATION5     = {"5","C#             ", "   20   ", "DotNetCore                        ","5000"};
	public static String[][] LISTEFORMATIONS = new String [][] {MENUFORMATIONS,FORMATION1,FORMATION2, FORMATION3,FORMATION4,FORMATION5};
	 */

	private static String[] NOMFORMATION = {"Cours","Java","Java avancé","Spring","Php framworks","C#"};
	private static String[] DUREEFORMATION = {"NB/JOURS","20","20","20","15","20"};
	private static String[] DESCRIPTIONFORMATION = {"Description","Java SE 8 : Syntaxe & Poo","Exceptions, fichiers, Jdbc, thread ","Spring core/Mvc/Security","Symphony","DotNetCore"};
	private static String[] PRIXFORMATION = {"Prix","3000","5000","5000","2500","5000"};
	private static String[] QUANTITE = {"Quantité","0","0","0","0","0"};

	public static HashMap<Integer, ArrayList<String>> CART = new HashMap<Integer, ArrayList<String>>();

	public static HashMap<Integer, ArrayList<String>> LISTEFORMATIONS = new HashMap<Integer, ArrayList<String>>();

	/**
	 * Rempli la table avec les formations renvoyées par createFormation
	 * @see createFormation
	 */

	public static void createCourseList () {

		for (int i = 0 ; i < NOMFORMATION.length ; i ++) {

			LISTEFORMATIONS.put(i, returnFormation(i));
		}
	}

	/**
	 * Instancie le panier
	 */

	public static void createCart() {

		for (int i = 0 ; i < NOMFORMATION.length ; i ++) {

			CART.put(i, returnFormation(i));
		}

	}

	/**
	 * Renvoie une formation pour la rentrer dans une table
	 * @param index
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

		if(courseList.size()>0) {

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

		if(courseList.size()>0) {

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

	}

	/**
	 * Retirer une formation du panier
	 * @param index - l'index de la formation à retirer
	 */
	public static void removeCourseFromCart(int index) {

		ArrayList<String> formation = new ArrayList<String>();

		formation.add( CART.get(index).get(0));
		formation.add( CART.get(index).get(1));
		formation.add( CART.get(index).get(2));
		formation.add( CART.get(index).get(3));
		formation.add( CART.get(index).get(4));

		int quantite = Integer.parseInt(formation.get(4));

		if( quantite > 1 ) {

			quantite -=1;

			formation.set( 4 , String.valueOf(quantite));

			CART.put(index, formation);
		}else if (quantite == 1 ) {

			formation.set( 4 , "0");

			CART.put(index, formation);
		}else {
			System.out.println("Cette formation n'est pas présente dans votre panier");
		}

	}

	/**
	 * Renvoie l'index de la formation selectionnée par l'utilisateur
	 * @return index : entier représentant la clef de la formation dans la HashMap LISTEFORMATIONS
	 */
	public static int selectCourse()
	{

		int input = -1;

		displayCourseList(LISTEFORMATIONS);

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

		int input = -1;

		displayCourseList(CART);

		System.out.println("Entrez l'ID de la formation que vous souhaitez retirer");

		displayCartWithID(CART);

		while(!scan.hasNextInt())scan.next();

		input = scan.nextInt();

		return input;

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
	 * 
	 */

	public static void checkout() {

		displayCart(CART);

		System.out.println( "Le prix total de votre commande est de : " + getPrice() + " euros.");

		CART.clear();

		createCart();

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
					+ "| 6 : Quitter l'application                                                   |\n"
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

				System.out.println("Merci d'avoir utilisé AppliFormation, bonne journée!");

				leaving = true;

				break;

			default:

				System.out.println("Veuillez entrer une valeur comprise entre 1 et 6");
			}
		}
	}

	/**
	 * Main du programme
	 * @param args
	 */

	public static void main (String[] args) {

		createCourseList();

		createCart();

		afficherMessageBienvenue();

		mainMenu();

		scan.close();

	}


}
