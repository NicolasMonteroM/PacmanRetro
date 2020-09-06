import processing.core.PApplet;

public class Pacman {

	int size;
	PApplet app;
	int lives;
	int speed;

	public Pacman(PApplet app) {
		size = 15;
		this.app = app;
		lives = 3;
		speed = 5;
	}

	public void create(int posX, int posY) {
		app.ellipse(posX, posY, size, size);
	}

	public void movement(int dir, int MX, int MY, int[][] maze) {

		if (app.keyPressed) {
			if (app.keyCode == app.LEFT) {
				if (MX - 1 > -1 && (maze[MY][MX - 1] == 0 || maze[MY][MX - 1] == 2)) {
					MX--;
				}
			}

			if (app.keyCode == app.UP) {
				if (MY - 1 > -1 && (maze[MY - 1][MX] == 0 || maze[MY - 1][MX] == 2)) {
					MY--;
				}
			}

			if (app.keyCode == app.RIGHT) {
				if (MX + 1 < 31 && (maze[MY][MX + 1] == 0 || maze[MY][MX + 1] == 2)) {
					MX++;
				}
			}

			if (app.keyCode == app.DOWN) {
				if (MY + 1 < 21 && (maze[MY + 1][MX] == 0 || maze[MY + 1][MX] == 2)) {
					MY++;
				}
			}
		}
	}
}
