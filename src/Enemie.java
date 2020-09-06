import processing.core.PApplet;

public class Enemie {

	int size;
	int x;
	int y;
	PApplet app;
	boolean state;
	
	public Enemie(PApplet app) {
		size = 15;
		this.app = app;
	}
	
	public void create(int posX, int posY) {
		
		app.ellipse(posX, posY, size, size);
		
	}
	
	public void vulnerable() {
		
		
	}

}
