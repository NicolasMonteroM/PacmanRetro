import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	public Enemie enemie1;
	public Enemie enemie2;
	public Enemie enemie3;
	public Enemie enemie4;

	public Pacman pacman;

	Timer sw;
	Score score;
	String scoreString;

	public int move;
	PImage mazeImage;
	PFont MagicHat;

	ArrayList<Cookie> cookies;
	ArrayList<Enemie> enemies;

	int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 } };

	public int pacmanMY;
	public int pacmanMX;
	public int enemieMX1;
	public int enemieMY1;
	public int enemieMX2;
	public int enemieMY2;
	public int enemieMX3;
	public int enemieMY3;
	public int enemieMX4;
	public int enemieMY4;
	public int scoreNumber;

	public void settings() {
		size(930, 630);
	}

	public void setup() {

		sw = new Timer();

		mazeImage = loadImage("./images/maze.jpg");
		MagicHat = loadFont("./fonts/MagicHat.vlw");

		cookies = new ArrayList<Cookie>();

		for (int matY = 0; matY < 21; matY++) {
			for (int matX = 0; matX < 31; matX++) {

				// Initial PacMan location
				pacmanMY = 14;
				pacmanMX = 15;

				// Enemies' initial locations
				enemieMX1 = 11;
				enemieMY1 = 7;

				enemieMX2 = 10;
				enemieMY2 = 12;

				enemieMX3 = 19;
				enemieMY3 = 7;

				enemieMX4 = 20;
				enemieMY4 = 12;
			}
		}
		
		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 2) {
					maze[fila][col] = 0;

				}
			}
		}
	}

	public void draw() {
		
		//sw.start();
		
		image(mazeImage, 0, 0, 930, 630);

		int posPacX, posPacY;
		int posEnemieX1, posEnemieY1, posEnemieX2, posEnemieY2, posEnemieX3, posEnemieY3, posEnemieX4, posEnemieY4;

		posPacX = pacmanMX * 30;
		posPacY = pacmanMY * 30;

		posEnemieX1 = enemieMX1 * 30;
		posEnemieY1 = enemieMY1 * 30;

		posEnemieX2 = enemieMX2 * 30;
		posEnemieY2 = enemieMY2 * 30;

		posEnemieX3 = enemieMX3 * 30;
		posEnemieY3 = enemieMY3 * 30;

		posEnemieX4 = enemieMX4 * 30;
		posEnemieY4 = enemieMY4 * 30;

		pacman = new Pacman(this);
		enemie1 = new Enemie(this, enemieMX1, enemieMY1);
		enemie2 = new Enemie(this, enemieMX2, enemieMY2);
		enemie3 = new Enemie(this, enemieMX3, enemieMY3);
		enemie4 = new Enemie(this, enemieMX4, enemieMY4);

		// grid
		/*
		 * for (int fila = 0; fila < 21; fila++) { for (int col = 0; col < 31; col++) {
		 * 
		 * if (maze[fila][col] == 0) { noStroke(); fill(40); }
		 * 
		 * if (maze[fila][col] == 1) { noStroke(); fill(255); }
		 * 
		 * if (maze[fila][col] == 2) { noStroke(); fill(40); }
		 * 
		 * rect(col * 40, fila * 40, 40, 40); } }
		 */

		// creating cookies where there's no barrier
		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 0) {
					Cookie cookie = new Cookie(this);
					cookie.crear(col * 30, fila * 30);

					if (cookie.x == posPacX && cookie.y == posPacY) {
						cookies.add(cookie);
					}
				}
			}
		}

		// changing grid state when eating each cookie
		for (int i = 0; i < cookies.size(); i++) {
			Cookie cookie = cookies.get(i);
			maze[cookie.y / 30][cookie.x / 30] = 2;
		}

		// PacMan creation
		fill(255, 255, 0);
		pacman.create(posPacX + 15, posPacY + 15);

		// Enemies creation
		fill(255, 0, 0);

		enemie1.create(posEnemieX1 + 15, posEnemieY1 + 15);
		enemie2.create(posEnemieX2 + 15, posEnemieY2 + 15);
		enemie3.create(posEnemieX3 + 15, posEnemieY3 + 15);
		enemie4.create(posEnemieX4 + 15, posEnemieY4 + 15);

		fill(255);

		scoreNumber = -1;

		// Score number
		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 2) {

					scoreNumber++;
				}

				scoreString = Integer.toString(scoreNumber);
				// println(scoreNumber);
			}
		}

		textAlign(CENTER);
		noStroke();
		textFont(MagicHat);
		fill(255);
		text(scoreString, width / 2, 80);

		// score.centeredScore(scoreString);

		boolean moveLeft = false;
		boolean moveRight = false;
		boolean moveUp = false;
		boolean moveDown = false;

		int randomDirection = (int) (Math.random() * 4);

		boolean moveLeft1 = false;
		boolean moveRight1 = false;
		boolean moveUp1 = false;
		boolean moveDown1 = false;

		int randomDirection1 = (int) (Math.random() * 4);

		boolean moveLeft2 = false;
		boolean moveRight2 = false;
		boolean moveUp2 = false;
		boolean moveDown2 = false;

		int randomDirection2 = (int) (Math.random() * 4);

		boolean moveLeft3 = false;
		boolean moveRight3 = false;
		boolean moveUp3 = false;
		boolean moveDown3 = false;

		int randomDirection3 = (int) (Math.random() * 4);

		if (enemieMX1 - 1 > -1 && (maze[enemieMY1][enemieMX1 - 1] == 0 || maze[enemieMY1][enemieMX1 - 1] == 2)) {
			moveLeft = true;
		}

		if (enemieMY1 - 1 > -1 && (maze[enemieMY1 - 1][enemieMX1] == 0 || maze[enemieMY1 - 1][enemieMX1] == 2)) {
			moveUp = true;
		}

		if (enemieMX1 + 1 < 31 && (maze[enemieMY1][enemieMX1 + 1] == 0 || maze[enemieMY1][enemieMX1 + 1] == 2)) {
			moveRight = true;
		}

		if (enemieMY1 + 1 < 21 && (maze[enemieMY1 + 1][enemieMX1] == 0 || maze[enemieMY1 + 1][enemieMX1] == 2)) {
			moveDown = true;
		}

		if (frameCount % 3 == 0) {

			if (moveLeft && randomDirection == 0) {
				enemieMX1--;
			}

			if (moveRight && randomDirection == 1) {
				enemieMX1++;
			}

			if (moveUp && randomDirection == 2) {
				enemieMY1--;
			}

			if (moveDown && randomDirection == 3) {
				enemieMY1++;
			}
		}

		if (enemieMX2 - 1 > -1 && (maze[enemieMY2][enemieMX2 - 1] == 0 || maze[enemieMY2][enemieMX2 - 1] == 2)) {
			moveLeft1 = true;
		}

		if (enemieMY2 - 1 > -1 && (maze[enemieMY2 - 1][enemieMX2] == 0 || maze[enemieMY2 - 1][enemieMX2] == 2)) {
			moveUp1 = true;
		}

		if (enemieMX2 + 1 < 31 && (maze[enemieMY2][enemieMX2 + 1] == 0 || maze[enemieMY2][enemieMX2 + 1] == 2)) {
			moveRight1 = true;
		}

		if (enemieMY2 + 1 < 21 && (maze[enemieMY2 + 1][enemieMX2] == 0 || maze[enemieMY2 + 1][enemieMX2] == 2)) {
			moveDown1 = true;
		}

		if (frameCount % 3 == 0) {

			if (moveLeft1 && randomDirection1 == 0) {
				enemieMX2--;
			}

			if (moveRight1 && randomDirection1 == 1) {
				enemieMX2++;
			}

			if (moveUp1 && randomDirection1 == 2) {
				enemieMY2--;
			}

			if (moveDown1 && randomDirection1 == 3) {
				enemieMY2++;
			}
		}

		if (enemieMX3 - 1 > -1 && (maze[enemieMY3][enemieMX3 - 1] == 0 || maze[enemieMY3][enemieMX3 - 1] == 2)) {
			moveLeft2 = true;
		}

		if (enemieMY3 - 1 > -1 && (maze[enemieMY3 - 1][enemieMX3] == 0 || maze[enemieMY3 - 1][enemieMX3] == 2)) {
			moveUp2 = true;
		}

		if (enemieMX3 + 1 < 31 && (maze[enemieMY3][enemieMX3 + 1] == 0 || maze[enemieMY3][enemieMX3 + 1] == 2)) {
			moveRight2 = true;
		}

		if (enemieMY3 + 1 < 21 && (maze[enemieMY3 + 1][enemieMX3] == 0 || maze[enemieMY3 + 1][enemieMX3] == 2)) {
			moveDown2 = true;
		}

		if (frameCount % 3 == 0) {

			if (moveLeft2 && randomDirection2 == 0) {
				enemieMX3--;
			}

			if (moveRight2 && randomDirection2 == 1) {
				enemieMX3++;
			}

			if (moveUp2 && randomDirection2 == 2) {
				enemieMY3--;
			}

			if (moveDown2 && randomDirection2 == 3) {
				enemieMY3++;
			}
		}

		if (enemieMX4 - 1 > -1 && (maze[enemieMY4][enemieMX4 - 1] == 0 || maze[enemieMY4][enemieMX4 - 1] == 2)) {
			moveLeft3 = true;
		}

		if (enemieMY4 - 1 > -1 && (maze[enemieMY4 - 1][enemieMX4] == 0 || maze[enemieMY4 - 1][enemieMX4] == 2)) {
			moveUp3 = true;
		}

		if (enemieMX4 + 1 < 31 && (maze[enemieMY4][enemieMX4 + 1] == 0 || maze[enemieMY4][enemieMX4 + 1] == 2)) {
			moveRight3 = true;
		}

		if (enemieMY4 + 1 < 21 && (maze[enemieMY4 + 1][enemieMX4] == 0 || maze[enemieMY4 + 1][enemieMX4] == 2)) {
			moveDown3 = true;
		}

		if (frameCount % 3 == 0) {

			if (moveLeft3 && randomDirection3 == 0) {
				enemieMX4--;
			}

			if (moveRight3 && randomDirection3 == 1) {
				enemieMX4++;
			}

			if (moveUp3 && randomDirection3 == 2) {
				enemieMY4--;
			}

			if (moveDown3 && randomDirection3 == 3) {
				enemieMY4++;
			}
		}

		dead();
	}

	/*
	 * public void movementEnemie(int posX, int posY) {
	 * 
	 * boolean moveLeft = false; boolean moveRight = false; boolean moveUp = false;
	 * boolean moveDown = false;
	 * 
	 * int randomDirection = (int) (Math.random() * 4);
	 * 
	 * if (posX - 1 > -1 && (maze[posY][posX - 1] == 0 || maze[posY][posX - 1] ==
	 * 2)) {
	 * 
	 * moveLeft = true; }
	 * 
	 * if (posY - 1 > -1 && (maze[posY - 1][posX] == 0 || maze[posY - 1][posX] ==
	 * 2)) {
	 * 
	 * moveUp = true; }
	 * 
	 * if (posX + 1 < 31 && (maze[posY][posX + 1] == 0 || maze[posY][posX + 1] ==
	 * 2)) {
	 * 
	 * moveRight = true; }
	 * 
	 * if (posY + 1 < 21 && (maze[posY + 1][posX] == 0 || maze[posY + 1][posX] ==
	 * 2)) {
	 * 
	 * moveDown = true; }
	 * 
	 * if (moveLeft && randomDirection == 0) {
	 * 
	 * posX--; }
	 * 
	 * if (moveRight && randomDirection == 1) {
	 * 
	 * posX++; } if (moveUp && randomDirection == 2) {
	 * 
	 * posY--; } if (moveDown && randomDirection == 3) {
	 * 
	 * posY++; }
	 * 
	 * }
	 */

	public void dead() {

		if (enemieMX1 == pacmanMX && enemieMY1 == pacmanMY) {

			restart();
		}

		if (enemieMX2 == pacmanMX && enemieMY2 == pacmanMY) {

			restart();
		}

		if (enemieMX3 == pacmanMX && enemieMY3 == pacmanMY) {

			restart();
		}

		if (enemieMX4 == pacmanMX && enemieMY4 == pacmanMY) {

			restart();
		}
	}

	public void restart() {

		setup();
		
	}
	
	public void timer() {
		
		
		
	}

	public void keyPressed() {

		// PacMan movement

		if (keyCode == LEFT) {
			if (pacmanMX - 1 > -1 && (maze[pacmanMY][pacmanMX - 1] == 0 || maze[pacmanMY][pacmanMX - 1] == 2)) {
				pacmanMX--;
			}
		}

		if (keyCode == UP) {
			if (pacmanMY - 1 > -1 && (maze[pacmanMY - 1][pacmanMX] == 0 || maze[pacmanMY - 1][pacmanMX] == 2)) {
				pacmanMY--;
			}
		}

		if (keyCode == RIGHT) {
			if (pacmanMX + 1 < 31 && (maze[pacmanMY][pacmanMX + 1] == 0 || maze[pacmanMY][pacmanMX + 1] == 2)) {
				pacmanMX++;
			}
		}

		if (keyCode == DOWN) {
			if (pacmanMY + 1 < 21 && (maze[pacmanMY + 1][pacmanMX] == 0 || maze[pacmanMY + 1][pacmanMX] == 2)) {
				pacmanMY++;
			}
		}

	}
}
