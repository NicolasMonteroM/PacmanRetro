import processing.core.PApplet;

public class GreenEnemie extends Enemie{

	public GreenEnemie(PApplet app, int posX, int posY) {
		super (app, posX, posY);
	}

	public void create(int posX, int posY) {

		app.fill(0, 200, 50);
		app.ellipse( posX, posY, size, size);
	}

}
