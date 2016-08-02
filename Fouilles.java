package Version1_3;

import javax.swing.JFrame;

/*
 * La classe Fouilles
 Dans cette classe, vous devrez cr�er un terrain de fouilles de taille 8 par 8 
 et 5 arch�ologues que vous placerez sur le terrain (attention, pas tous au m�me endroit)
 et que vous ferez fouiller en m�me temps. Votre main devra attendre 
 (utilisez la m�thode join() des threads) que tous aient trouv� la poterie, 
 puis, devra afficher un message indiquant que tous ont termin� dans la console.
 Attention que votre programme termine de mani�re propre! 
 �vitez les interblocages, �videmment!
 Bien �videment, vous devrez utiliser les classes Case et Terrain 
 ainsi que les m�thodes de la classe Terrain d�crites ci-dessus 
 pour d�placer et faire fouiller vos arch�ologues. 

 */
public class Fouilles {
	// Contient tous les archeologues cr��s
	private static Archeologue[] archeologue = new Archeologue[5];

	// Terrain monTerrain = new Terrain();

	static Terrain monTerrain = new Terrain(8, 8);
	static int terrain[][] = new int[8][8];

	// initialisation de terrain de fouille
	public static void initCarteFouille() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				terrain[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		monTerrain.afficher();
		initCarteFouille(); // ini

		// Cr�er les Archeologues

		for (int i = 0; i < 5; i++) {

			new Archeologue(i);
			int x = (int) (8 * Math.random()); //choix aleatoire
			int y = (int) (8 * Math.random());
			archeologue[i] = new Archeologue(x, y, i + 1);
		}
		// Lancer les threads
		for (int i = 0; i < 5; i++) {
			archeologue[i].start(); 
		}

		monTerrain.setSize(600, 600);
		monTerrain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monTerrain.getContentPane().setLayout(null);
		monTerrain.setVisible(true);

	}

	/**
	 * La methode est occuper verifier si une case est occuper
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public synchronized boolean estOccuper(int x, int y) {
		if (terrain[x][y] != 0)
			return true;
		else
			return false;
	}

	/**
	 * Methode sort fait sortir l'archeologue
	 * 
	 * @param c
	 *            la case dont l'archeologue sort
	 */
	public synchronized void sort(Case c) {
		terrain[c.x][c.y] = 0;
		monTerrain.sort(c.x, c.y);
	}

	/**
	 * methode verifie si l'archeologue a trouver la poterie
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean trouvePoterie(Case c) {
		if (monTerrain.trouvePoterie(c.x, c.y))
			return true;
		else
			return false;
	}

	/**
	 * Methode entre permet a faire entrer l'archeologue dans le terrain de
	 * fouille
	 * 
	 * @param x
	 * @param y
	 * @param no
	 *            numero de l'archeologue
	 */
	public synchronized void entre(int x, int y, int no) {
		terrain[x][y] = no; // terrain ecrit le numero de l'archeologue
		monTerrain.entre(x, y, no);

	}
}
