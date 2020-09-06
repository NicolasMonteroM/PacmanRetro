import processing.core.PApplet;

public class Cookie {

	int size;
	int x;
	int y;
	PApplet app;

	public Cookie(PApplet app) {
		size = 3;
		this.app = app;
	}

	public void crear(int posX, int posY) {
		app.noStroke();
		app.fill(255,0,244);
		app.ellipse(posX + 15, posY + 15, size, size);
		x = posX;
		y = posY;
	}

}
