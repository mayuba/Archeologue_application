package Version1_3;

public class Case {
	/*
	 * La classe Case La classe Case est directement utilis�e par la classe
	 * Terrain. Chaque case poss�de des coordonn�es. Vous devez y impl�menter
	 * les m�thodes n�cessaires au bon fonctionnement du programme en
	 * consid�rant les autres classes et leurs m�thodes.
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
