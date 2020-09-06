import processing.core.PApplet;

public class Score {

	int size;
	int x;
	int y;
	String score;
	PApplet app;
	
	public Score(String score, PApplet app) {
		this.app = app;
		size = 40;
	}
	
/*	public void centeredScore(String score){
		app.textAlign(app.CENTER);
		app.noStroke();
		app.fill(255);
		app.text(score, app.width/2, app.height/2);
	}*/
}
