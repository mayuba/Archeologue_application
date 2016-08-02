package Version1_3;

import javax.swing.JFrame;

/*
 * La classe Fouilles
 Dans cette classe, vous devrez créer un terrain de fouilles de taille 8 par 8 
 et 5 archéologues que vous placerez sur le terrain (attention, pas tous au même endroit)
 et que vous ferez fouiller en même temps. Votre main devra attendre 
 (utilisez la méthode join() des threads) que tous aient trouvé la poterie, 
 puis, devra afficher un message indiquant que tous ont terminé dans la console.
 Attention que votre programme termine de manière propre! 
 Évitez les interblocages, évidemment!
 Bien évidement, vous devrez utiliser les classes Case et Terrain 
 ainsi que les méthodes de la classe Terrain décrites ci-dessus 
 pour déplacer et faire fouiller vos archéologues. 

 */
public class Fouilles {
	// Contient tous les archeologues créés
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

		// Créer les Archeologues

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
