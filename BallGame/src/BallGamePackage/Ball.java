package BallGamePackage;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Ball 
{	
	private static final int DIAMETER = 50;
	
	private GameBoard Gb;
	
	//random numbers
	Random tRand = new Random();
	int RandLat = tRand.nextInt( 500 );
	int RandVert = tRand.nextInt( 500 );
	
	//movement
	int xM = RandLat;
	int yM = RandVert;
	
	//speed
	int xS = 10;
	int yS = 10;

	public Ball( GameBoard Gb ) 
	{
		this.Gb= Gb;
	}

	void move() 
	{
	if ( xM + xS < 0 )
	{
		xS = 10;
	}
	if ( yM + yS < 0 )
	{
		yS = 10;
	}
	if ( xM + xS > Gb.getWidth() - 50 )
	{
		xS = -10;
	}
	if ( yM + yS > Gb.getHeight() - 50 )
	{
		yS = -10;
	}
	if ( GoalHit() )
	{
		yS = -Gb.tAgility;
		yM = Gb.tGoal.getTopY() - DIAMETER;
		Gb.tGoal.xM = tRand.nextInt( 400 ) + 60;
		Gb.tGoal.yM = tRand.nextInt( 500 ) - 2;
		Gb.tAgility++;
	}
	xM = xM + xS;
	yM = yM + yS;
	}

	private boolean GoalHit() 
	{
		return Gb.tGoal.getBounds().intersects( getBounds() );
	}
	
	public Rectangle getBounds() 
	{
		return new Rectangle( xM, yM, DIAMETER, DIAMETER );
	}
	
	public void paint( Graphics2D g ) 
	{
		g.fillOval( xM, yM, 50, 50 );
	}
}