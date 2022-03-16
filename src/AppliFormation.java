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

	public static HashMap<Integer, ArrayList<String>> LISTEFORMATIONS = new HashMap<Integer, ArrayList<String>>();

	/**
	 * Rempli la table avec les formations renvoyées par createFormation
	 * @see createFormation
	 */

	public static void createCourseList () {

		for (int i = 0 ; i < NOMFORMATION.length ; i ++) {
			
			LISTEFORMATIONS.put(i, createFormation(i));
		}
	}
	
	/**
	 * Créée une formation pour la rentrer dans la table
	 * @param index
	 * @return formation : une ArrayList complète représentant une formation
	 */
	
	public static ArrayList<String> createFormation(int index){
		
		ArrayList<String> formation = new ArrayList<String>();
		
		formation.add(NOMFORMATION[index]);
		formation.add(DUREEFORMATION[index]);
		formation.add(DESCRIPTIONFORMATION[index]);
		formation.add(PRIXFORMATION[index]);
		
		return formation;
	}


	/**
	 * afficher un message de bienvenue
	 * 
	 */
	public static void afficherMessageBienvenue() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("|          Bonjour et bienvenue dans mon application AppliFormation         |");
		System.out.println("|Nous allons vous proposer une liste de formations actuellement disponnibles|");
		System.out.println("-----------------------------------------------------------------------------");
	}

	/**
	 * Affiche la liste des formations
	 * 
	 * 
	 */

	public static void displayCourseList() {
		
		displayCourse(LISTEFORMATIONS.get(0));
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		
		for(int i = 1 ; i < LISTEFORMATIONS.size() ; i++ ) {
			displayCourse(LISTEFORMATIONS.get(i));
			System.out.println();
		}
	}

	/**
	 * Affiche une formation
	 * @param formation : la formation à afficher
	 */
	public static void displayCourse(ArrayList<String> formation) {
		
			System.out.printf("%-15s | %-10s | %-40s |%-4s |",formation.get(0), formation.get(1),formation.get(2),formation.get(3));
		//	System.out.print(formation.get(i) + " | ");
		
	}
	
	/**
	 * Affiche le menu principal
	 */
	
	public static void displayMenu() {
		
		System.out.println("-----------------------------------------------------------------------------");
		
		System.out.println("Que souhaitez-vous faire?");
		System.out.println("1 : Ajouter une formation à mon panier");
		System.out.println("2 : Retirer une formation de mon panier");
		System.out.println("3 : Afficher mon panier");
		System.out.println("4 : Quitter");
		
		
		
	}

	/**
	 * Main du programme
	 * @param args
	 */

	public static void main (String[] args) {
		
		createCourseList();

		afficherMessageBienvenue();

		displayCourseList();
		
		displayMenu();
		
		scan.close();

	}


}
