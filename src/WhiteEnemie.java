import processing.core.PApplet;

public class WhiteEnemie extends Enemie{

	public WhiteEnemie(PApplet app, int posX, int posY) {
		super (app, posX, posY);
	}

	public void create(int posX, int posY) {

		app.fill(255);
		app.ellipse( posX, posY, size, size);
	}
}
