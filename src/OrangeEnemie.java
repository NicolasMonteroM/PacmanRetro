import processing.core.PApplet;

public class OrangeEnemie extends Enemie{

	public OrangeEnemie(PApplet app, int posX, int posY) {
		super (app, posX, posY);
	}

	public void create(int posX, int posY) {

		app.fill(255, 58, 0);
		app.ellipse( posX, posY, size, size);
	}

}
