package Version1_3;
/*
 * Au d�but, chaque arch�ologue se place � une case arbitraire 
 * choisie par un g�n�rateur de nombre al�atoires. 
 * Les arch�ologues doivent se d�placer de mani�re al�atoire
 *  et ne peuvent se d�placer que d'une case � la fois, dans n'importe quelle direction (les d�placements en diagonale sont permis). Lorsqu'un arch�ologue ne peut aller sur une case parce qu'elle est d�j� prise ou parce que ses coordonn�es sont invalides, il doit simplement essayer de se d�placer dans une autre direction. En arrivant sur une nouvelle case qui n�a pas �t� fouill�e par lui, l'arch�ologue doit regarder si la poterie s'y trouve (pour simuler une fouille, vous le ferez dormir entre 0 et 100 millisecondes en utilisant sleep), si c'est le cas, son travail est termin�, sinon, il doit continuer.  Lorsqu�un arch�ologue se trouve sur une case qu�il a d�j� fouill�, il doit simplement continuer de se d�placer sans fouiller. 
 */

public class Archeologue extends Thread {
	// Contient tous les philosophes cr��s
	private static Archeologue[] archeologue = new Archeologue[5];

	// carte de l'archeologue
	int[][] carteArcheologue = new int[8][8];

	// �tats possibles des archeologues
	private static enum Etat {
		TERMINE, CONTINU
	};

	// Le num�ro et l'�tat de l'Archeologue
	private int no;
	private Etat etat;
	private int x, y;

	public Archeologue(int x, int y, int no) {
		super("Archeologue #" + no);
		this.x = x;
		this.y = y;
		this.no = no;
	}

	public Archeologue(int no) {
		this.no = no;
		archeologue[no] = this;
	}

	public void initCarte() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				carteArcheologue[i][j] = 0;
			}
		}
	}

	// L'archeologue fouille
	public void enFouille(int x, int y) throws InterruptedException {
		Thread.sleep(1000);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public void estSorti(int x, int y) {
		// tester l'etat de la case
		Case c = new Case(x, y);
		fouilles.sort(c);
		System.out.println(this.getName() + " est sorti de la case (" + x + "," + y + ")");
		 
	}

	/**
	 * dejaFouille verifier si l'arcgeologue a deja fouille la case
	 * 
	 * @return
	 */
	public boolean dejaFouiller() {
		if (carteArcheologue[x][y] == this.no) {
			System.out.println(this.getName() + " entre dans case  (" + x + "," + y + ") d�j� fouill�e");
			return true;
		} else
			return false;

	}

	 

	/**
	 * methode sePositionne permet a l'archeologue de se positionnner sur une
	 * direction et entrer
	 */
	public void sePositionne() {
		// tester l'etat de la case
		// faire le deplacement
		boolean valide = false;

		while (valide == false) { // sort de la boucle quand le deplacement est
									// valide
			int direction = (int) (8 * Math.random());
			switch (direction) { // choisie le chemin prochain aleatoirement
			case 0:
				if (x - 1 >= 0) {
					if (!fouilles.estOccuper(x - 1, y)) {
						x--;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
			case 1:
				if (x + 1 < 8) {
					if (!fouilles.estOccuper(x + 1, y)) {

						x++;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
			case 2:
				if (y - 1 >= 0) {
					if (!fouilles.estOccuper(x, y - 1)) {

						y--;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
			case 3:
				if (y + 1 < 8) {
					if (!fouilles.estOccuper(x, y + 1)) {

						y++;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
				// NE

			case 4:
				if (y + 1 < 8 && x - 1 >= 0) {
					if (!fouilles.estOccuper(x - 1, y + 1)) {

						x--;
						y++;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
							
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}

			case 5:
				if (x - 1 >= 0 && y - 1 >= 0) {
					if (!fouilles.estOccuper(x - 1, y - 1)) {

						x--;
						y--;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}

				// SE

			case 6:
				if (x + 1 < 8 && y + 1 < 8) {
					if (!fouilles.estOccuper(x + 1, y + 1)) {

						x++;
						y++;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
				// SW
			case 7:
				if (x + 1 < 8 && y - 1 >= 0) {
					if (!fouilles.estOccuper(x + 1, y - 1)) {

						x++;
						y--;
						if (!dejaFouiller()) {
							carteArcheologue[x][y] = this.no; 
							valide = true;
							System.out.println(this.getName() + " est entre dans la case (" + x + "," + y + ")");
						}
					} else {
						System.out.println(this.getName() + " veut entrer dans case (" + x + "," + y + ") occup�e");
						valide = false;
					}
					break;
				}
			}

		}
		valide = false;
		etat = Etat.TERMINE;
		for (int i = 0; i < carteArcheologue.length; i++) { //lors qu'il reste de case non fouiller
			for (int j = 0; j < carteArcheologue.length; j++) {
				if (carteArcheologue[i][j] == 0)
					etat = Etat.CONTINU; //l'etat de l'archeologue devient continu
			}

		} 

	}

	Fouilles fouilles = new Fouilles();
	Terrain t = new Terrain();
/**
 * Methode verifie si l'archeologue a trouver la poterie.
 * @param c
 * @throws InterruptedException
 */
	public void aTrouverpoterie(Case c) throws InterruptedException {

		if (fouilles.trouvePoterie(c)) {
			etat = Etat.TERMINE;
			System.out.println(this.getName() + " a trouv� la poterie � la case  (" + x + "," + y + ")");
			estSorti(x, y);
		 
		}
	}

	/**
	 * Execute le programme
	 */
	public void run() {
		while (etat != Etat.TERMINE) { // tant qu'un processus n'est pas termine
			try {
				sePositionne(); // entre
				System.out.println(this.getName() + " va fouiller dans (" + x + "," + y + ")");
				fouilles.entre(x, y, this.no);
				enFouille(x, y);
				Case c = new Case(x, y);
				aTrouverpoterie(c);
				estSorti(x, y);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(this.getName() + " a fini."); 
	}

}
