
public class AppliFormation {
	
	private static String[] MENUFORMATIONS = {"0","COURS          ", "NB/JOURS", "DESCRIPTION                       ","PRIX"};
	private static String[] FORMATION1     = {"1","Java           ", "   20   ", "Java SE 8 : Syntaxe & Poo         ","3000"};
	private static String[] FORMATION2     = {"2","Java avancé    ", "   20   ", "Exceptions, fichiers, Jdbc, thread","5000"};
	private static String[] FORMATION3     = {"3","Spring         ", "   20   ", "Spring core/Mvc/Security          ","5000"};
	private static String[] FORMATION4     = {"4","Php frameworks ", "   15   ", "Symphony                          ","2500"};
	private static String[] FORMATION5     = {"5","C#             ", "   20   ", "DotNetCore                        ","5000"};
	public static String[][] LISTEFORMATIONS = new String [][] {MENUFORMATIONS,FORMATION1,FORMATION2, FORMATION3,FORMATION4,FORMATION5};
	
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
	
	public static void afficherListeFormations() {
		for(int i = 0 ; i < LISTEFORMATIONS.length ; i++ ) {
			afficherUneFormation(LISTEFORMATIONS[i]);
			System.out.println();
		}
	}
	
	/**
	 * Affiche une formation
	 * @param formation : la formation à afficher
	 */
	public static void afficherUneFormation(String[] formation) {
		for(int i = 1 ; i < formation.length ; i++ ) {
			System.out.print(formation[i] + " | ");
		}
	}
	
	/**
	 * Main du programme
	 * 
	 * @param args
	 */

	public static void main (String[] args) {
		
		afficherMessageBienvenue();
		
		afficherListeFormations();
		
	}
	
	
}
