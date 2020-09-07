import processing.core.PApplet;

public class Enemie {

	int size;
	int x;
	int y;
	PApplet app;
	boolean state;

	public Enemie(PApplet app, int posX, int posY) {
		x = posX;
		y = posY;
		size = 15;
		this.app = app;
	}

	public void create(int posX, int posY) {

		app.ellipse( posX, posY, size, size);

	}

/*	public void movement(int[][] maze, int posX, int posY) {

		boolean moveLeft = false;
		boolean moveRight = false;
		boolean moveUp = false;
		boolean moveDown = false;

		int randomDirection = (int) (Math.random() * 4);

		if (this.posX - 1 > -1 && (maze[this.posY][this.posX - 1] == 0 || maze[this.posY][this.posX - 1] == 2)) {

			moveLeft = true;
		}

		if (this.posY - 1 > -1 && (maze[this.posY - 1][this.posX] == 0 || maze[this.posY - 1][this.posX] == 2)) {

			moveUp = true;
		}

		if (this.posX + 1 < 31 && (maze[this.posY][this.posX + 1] == 0 || maze[this.posY][this.posX + 1] == 2)) {

			moveRight = true;
		}

		if (this.posY + 1 < 21 && (maze[this.posY + 1][this.posX] == 0 || maze[this.posY + 1][this.posX] == 2)) {

			moveDown = true;
		}

		if (app.frameCount % 5 == 0) {

			if (moveLeft && randomDirection == 0) {

				this.posX--;
			}

			if (moveRight && randomDirection == 1) {

				this.posX++;
			}
			if (moveUp && randomDirection == 2) {

				this.posY--;
			}
			if (moveDown && randomDirection == 3) {

				this.posY++;
			}
		}
	}*/

	public void vulnerable() {

	}
	
	

}
