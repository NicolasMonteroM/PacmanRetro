import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	static Pacman pacman;

	ArrayList<Cookie> cookies;

	int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 } };

	int mazeMY;
	int mazeMX;

	public void settings() {
		size(1240, 840);
	}

	public void setup() {

		pacman = new Pacman(this);

		cookies = new ArrayList<Cookie>();

		for (int matY = 0; matY < 21; matY++) {
			for (int matX = 0; matX < 31; matX++) {
				if (maze[matY][matX] == 0) {
					mazeMY = matY;
					mazeMX = matX;
				}
			}
		}
	}

	public void draw() {

		background(100);

		int posPacX, posPacY;

		posPacX = mazeMX * 40;
		posPacY = mazeMY * 40;

		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 0) {
					noStroke();
					fill(40);
				}

				if (maze[fila][col] == 1) {
					stroke(1);
					fill(255);
				}

				if (maze[fila][col] == 2) {
					noStroke();
					fill(40);
				}

				rect(col * 40, fila * 40, 40, 40);

			}
		}

		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 0) {
					Cookie cookie = new Cookie(this);
					cookie.crear(fila * 40, col * 40);

					if (cookie.x == posPacX && cookie.y == posPacY) {
						cookies.add(cookie);
					}
				}
			}
		}

		for (int i = 0; i < cookies.size(); i++) {
			Cookie cookie = cookies.get(i);
			maze[cookie.x / 40][cookie.y / 40] = 2;
		}

		fill(255, 255, 0);

		pacman.crear(posPacX + 20, posPacY + 20);

		fill(255);
		

	}

	public void keyPressed() {

		// Movement
		if (keyCode == LEFT) {
			if (mazeMX - 1 > -1 && (maze[mazeMX - 1][mazeMY] == 0 || maze[mazeMX - 1][mazeMY] == 2)) {
				mazeMX--;
			}
		}

		if (keyCode == UP) {
			if (mazeMY - 1 > -1 && (maze[mazeMX][mazeMY - 1] == 0 || maze[mazeMX][mazeMY - 1] == 2)) {
				mazeMY--;
			}
		}

		if (keyCode == RIGHT) {
			if (mazeMX + 1 < maze.length && (maze[mazeMX + 1][mazeMY] == 0 || maze[mazeMX + 1][mazeMY] == 2)) {
				mazeMX++;
			}
		}

		if (keyCode == DOWN) {
			if (mazeMY + 1 < maze.length && (maze[mazeMX][mazeMY + 1] == 0 || maze[mazeMX][mazeMY + 1] == 2)) {
				mazeMY++;
			}
		}
	}
}
