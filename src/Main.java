import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}

	static Pacman pacman;
	public int move;

	ArrayList<Cookie> cookies;

	int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1 },
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

	public void settings() {
		size(1240, 840);
	}

	public void setup() {

		pacman = new Pacman(this);

		move = 1;

		cookies = new ArrayList<Cookie>();

		for (int matY = 0; matY < 21; matY++) {
			for (int matX = 0; matX < 31; matX++) {

				pacmanMY = 14;
				pacmanMX = 14;

			}
		}
	}

	public void draw() {

		background(100);

		int posPacX, posPacY;

		posPacX = pacmanMX * 40;
		posPacY = pacmanMY * 40;

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
					fill(40, 0, 0);
				}

				rect(col * 40, fila * 40, 40, 40);

			}
		}

		for (int fila = 0; fila < 21; fila++) {
			for (int col = 0; col < 31; col++) {

				if (maze[fila][col] == 0) {
					Cookie cookie = new Cookie(this);
					cookie.crear(col * 40, fila * 40);

					if (cookie.x == posPacX && cookie.y == posPacY) {
						cookies.add(cookie);
					}
				}
			}
		}

		for (int i = 0; i < cookies.size(); i++) {
			Cookie cookie = cookies.get(i);
			maze[cookie.y / 40][cookie.x / 40] = 2;
		}

		fill(255, 255, 0);
		
		pacman.crear(posPacX + 20, posPacY + 20);
		
		/*pacman.movement(move, pacmanMX, pacmanMY, maze);
		println(pacmanMX);*/

		fill(255);
	}

	public void keyPressed() {

	/*	if (keyCode == LEFT) {
			move = 1;
		}
		
		if (keyCode == UP) {
			move = 2;
		}
		
		if (keyCode == RIGHT) {
			move = 3;
		}
		
		if (keyCode == DOWN) {
			move = 4;
		}*/
		
		// Movement
		
		  if (keyCode == LEFT) { if (pacmanMX - 1 > -1 && (maze[pacmanMY][pacmanMX - 1] == 0 || maze[pacmanMY][pacmanMX - 1] == 2)) { pacmanMX--; } }
		  
		  if (keyCode == UP) { if (pacmanMY - 1 > -1 && (maze[pacmanMY - 1][pacmanMX] == 0 || maze[pacmanMY - 1][pacmanMX] == 2)) { pacmanMY--; } }
		  
		  if (keyCode == RIGHT) { if (pacmanMX + 1 < 31 && (maze[pacmanMY][pacmanMX + 1] == 0 || maze[pacmanMY][pacmanMX + 1] == 2)) { pacmanMX++; } }
		  
		  if (keyCode == DOWN) { if (pacmanMY + 1 < 21 && (maze[pacmanMY + 1][pacmanMX]== 0 || maze[pacmanMY + 1][pacmanMX] == 2)) { pacmanMY++; } }
		 
	}
}
