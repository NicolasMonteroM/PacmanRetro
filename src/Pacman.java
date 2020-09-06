import processing.core.PApplet;

public class Pacman {

	int size;
	PApplet app;

	public Pacman (PApplet app) {	
		size = 20;
		this.app = app;	
	}
	
	public void crear(int posX, int posY) {
		app.ellipse(posX, posY, size, size);	
	}

}
