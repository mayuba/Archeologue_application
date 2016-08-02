package Version1_3;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Terrain extends JFrame {
	/*
	 * La classe Terrain est la classe qui vous fournira une interface (voir
	 * annexe 1) vous permettant de faire afficher les archéologues sur
	 * différents carrés. Les fonctionnalités que vous devez implémenter sont
	 * les suivantes : Terrain(int x, int y), boolean entre(int x, int y), void
	 * sort(int x, int y), boolean trouvePoterie(int x, int y)
	 * 
	 * Terrain(int x, int y) Initialisation; le constructeur prend en paramètres
	 * la taille du site de fouilles (longueur et largeur.) La position de la
	 * poterie sera déterminée lors de l'initialisation (veuillez la mettre au
	 * même endroit que dans le diagramme). Vous devez représenter graphiquement
	 * la poterie dans votre interface (ex. : symbole, fond ou bordure de
	 * couleur différente, etc.)
	 */
	JPanel[][] listeCases;
	JPanel mainPanneau = new JPanel();
	int x, y;
	int xPoterie = 3; // position de la poterie
	int yPoterie = 6;// position de la poterie
	Color color[] = { Color.MAGENTA, Color.BLUE, Color.pink, Color.lightGray, Color.GREEN, Color.RED, Color.YELLOW };

	public Terrain() {

	}
	/**
	 * Terrain de fouille constituer de deux coordonner
	 * 
	 * @param x
	 * @param y
	 */
	public Terrain(int x, int y) {
		this.x = x;
		this.y = y;
	} 
	/**
	 * Methode affiche la cate de poterie
	 */
	public void afficher() {
		listeCases = new JPanel[x][y];
		mainPanneau.setBounds(0, 0, 500, 500);
		mainPanneau.setLayout(new GridLayout(x, y));
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				listeCases[i][j] = new JPanel();
				listeCases[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				listeCases[i][j].setBackground(Color.WHITE);
				mainPanneau.add(listeCases[i][j]);
			}
		}
		listeCases[xPoterie][yPoterie].setBackground(Color.black);
		getContentPane().add(mainPanneau);
		// initialisation des objets cases

	}
	// Afficher le JFrame, établir sa taille et l'opération de fermeture
	public void entre(int x, int y, int no) {
		/*
		 * Méthode permettant de placer un archéologue sur une case dont les
		 * coordonnées sont spécifiées en paramètre.
		 */
		 
		listeCases[x][y].setBackground(color[no]);
		 
	}

	public void sort(int x, int y) {
		/*
		 * Méthode permettant de faire sortir un archéologue d'une case dont les
		 * coordonnées sont passées en paramètre.
		 */
		listeCases[x][y].setBackground(Color.WHITE);

	}

	boolean Etatpoterie = false; // etat de poterie pour limiter le poterie

	public boolean trouvePoterie(int x, int y) {
		/*
		 * Méthode permettant de savoir si la poterie se trouve sur la case dont
		 * les coordonnées sont spécifiées en paramètre. Si tel est le cas, la
		 * méthode retourne true, sinon, elle retourne false.
		 */
		if (x == xPoterie && y == yPoterie && Etatpoterie == false) {
			Etatpoterie = true;
			return true;
		} else
			return false;
	}

}
