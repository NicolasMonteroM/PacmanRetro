import processing.core.PApplet;

public class Cookie {

	int size;
	int x;
	int y;
	PApplet app;


	public Cookie (PApplet app) {	
		size = 10;
		this.app = app;	
	}
	
	public void crear(int posX, int posY) {
		app.fill(255);
		app.ellipse(posX+10, posY+10, size, size);	
		x=posX;
		y= posY;
	}

}
