package Version1_3;

public class Case {
	/*
	 * La classe Case La classe Case est directement utilisée par la classe
	 * Terrain. Chaque case possède des coordonnées. Vous devez y implémenter
	 * les méthodes nécessaires au bon fonctionnement du programme en
	 * considérant les autres classes et leurs méthodes.
	 *
	 * une case est definie par ses cordonnees et non numero
	 */

	public int x;
	public int y;

	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(Case c) {
		if (x == c.x && y == c.y)
			return true;
		else
			return false;
	}

}
