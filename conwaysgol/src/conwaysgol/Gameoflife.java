package conwaysgol;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;


public class Gameoflife extends PApplet {
	public static void main(String[] args) {
		PApplet.main("Gameoflife");
	}
	
	public void settings() 
	{
		size(10,10);
	}

	public void draw() 
	{
		background(0);
	}
}
