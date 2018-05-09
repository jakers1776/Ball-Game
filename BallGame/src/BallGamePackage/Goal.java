package BallGamePackage;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Goal 
{
	private static final int WIDTH = 60;
	private static final int HEIGHT = 1;
	
	//random integers
	Random tRand = new Random();
	int RandLat = tRand.nextInt( 333 ) - 60;
	int RandVert = tRand.nextInt( 333 ) + 2;
	
	//coordinates
	int xM = RandLat;
	int yM = RandVert;
	
	private GameBoard Gb;

	public Goal( GameBoard Gb ) 
	{
		this.Gb= Gb;
	}
	
	public void paint( Graphics2D g ) 
	{
		g.fillRect( xM, yM, 60, 10 );
	}

	public Rectangle getBounds() 
	{
		return new Rectangle( xM, yM, WIDTH, HEIGHT );
	}
	
	public int getTopY() 
	{
		return yM;
	}
}
