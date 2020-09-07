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

		move = 1;

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

	}

	public void draw() {

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
		// enemie2 = new Enemie(this, enemieMX2, enemieMY2);
		// enemie3 = new Enemie(this, enemieMX3, enemieMY3);
		// enemie4 = new Enemie(this, enemieMX4, enemieMY4);

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
		/*
		 * enemie2.create(posEnemieX2 + 15, posEnemieY2 + 15);
		 * enemie3.create(posEnemieX3 + 15, posEnemieY3 + 15);
		 * enemie4.create(posEnemieX4 + 15, posEnemieY4 + 15);
		 */

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

		if (frameCount % 5 == 0) {

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

	}

	public void movementEnemie(int posX, int posY) {

		boolean moveLeft = false;
		boolean moveRight = false;
		boolean moveUp = false;
		boolean moveDown = false;

		int randomDirection = (int) (Math.random() * 4);

		if (posX - 1 > -1 && (maze[posY][posX - 1] == 0 || maze[posY][posX - 1] == 2)) {

			moveLeft = true;
		}

		if (posY - 1 > -1 && (maze[posY - 1][posX] == 0 || maze[posY - 1][posX] == 2)) {

			moveUp = true;
		}

		if (posX + 1 < 31 && (maze[posY][posX + 1] == 0 || maze[posY][posX + 1] == 2)) {

			moveRight = true;
		}

		if (posY + 1 < 21 && (maze[posY + 1][posX] == 0 || maze[posY + 1][posX] == 2)) {

			moveDown = true;
		}

		if (moveLeft && randomDirection == 0) {

			posX--;
		}

		if (moveRight && randomDirection == 1) {

			posX++;
		}
		if (moveUp && randomDirection == 2) {

			posY--;
		}
		if (moveDown && randomDirection == 3) {

			posY++;
		}

	}

	public void keyPressed() {

		// Movement

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
