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

}
