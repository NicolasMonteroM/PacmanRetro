import processing.core.PApplet;

public class Timer {

	PApplet app;
	int startTime;
	int stopTime;
	boolean running;

	public Timer() {
		startTime = 0;
		stopTime = 0;
		running = false;
	}

	public void start() {
		startTime = app.millis();
		running = true;
	}

	public void stop() {
		stopTime = app.millis();
		running = false;
	}

	public int getElapsedTime() {
		int elapsed;
		if (running) {
			elapsed = (app.millis() - startTime);
		} else {
			elapsed = (stopTime - startTime);
		}
		return elapsed;
	}

	public int second() {
		return (getElapsedTime() / 1000) % 60;
	}

	public int minute() {
		return (getElapsedTime() / (1000 * 60)) % 60;
	}

	public int hour() {
		return (getElapsedTime() / (1000 * 60 * 60)) % 24;
	}
}
