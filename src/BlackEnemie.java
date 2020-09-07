import processing.core.PApplet;

public class BlackEnemie extends Enemie{

	public BlackEnemie(PApplet app, int posX, int posY) {
		super (app, posX, posY);
	}

	public void create(int posX, int posY) {
		
		app.fill(0);
		app.ellipse( posX, posY, size, size);

	}

}
