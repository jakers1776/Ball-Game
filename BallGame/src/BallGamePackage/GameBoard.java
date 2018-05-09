package BallGamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import java.awt.event.MouseAdapter;


@SuppressWarnings( "serial" )
public class GameBoard extends JPanel 
{
	public GameBoard() 
	{
		addMouseListener( new MouseAdapter() 
		{
			@Override
			public void mouseClicked( MouseEvent e ) 
			{
				if( tBall.xS > 0 && tBall.yS > 0 )
				{
					tBall.xS = 25;
					tBall.yS = 25;
				}
				if( tBall.xS < 0 && tBall.yS < 0 )
				{ 
					tBall.xS = -25;
					tBall.yS = -25;
				}
				if( tBall.xS < 0 && tBall.yS > 0 )
				{
					tBall.xS = -25;
					tBall.yS = 25;
				}
				if( tBall.xS > 0 && tBall.yS < 0 )
				{
					tBall.xS = 25;
					tBall.yS = -25;
				}
			}
		} );
	}
	Ball tBall = new Ball( this );
	Goal tGoal = new Goal( this );
	
	int tAgility = 1;
	
	private int Points() 
	{
		return tAgility - 1;
	}
	
	private void move() 
	{
		tBall.move();
	}

	@Override
	public void paint( Graphics g ) 
	{
		super.paint( g );
		Graphics2D g2d = ( Graphics2D ) g;
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON );
		tBall.paint( g2d );
		tGoal.paint( g2d );
		
		g2d.setColor(Color.RED);
		g2d.setFont(new Font("Aria", Font.BOLD, 30));
		g2d.drawString(String.valueOf( Points() ), 20, 40);
	}
    
	public static void main( String[] args ) throws InterruptedException 
	{
		JFrame frame = new JFrame( "Ball Game" );
		GameBoard Gb = new GameBoard();
		frame.getContentPane().add( Gb );
		frame.setSize( 500, 500 );
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		while ( true ) 
		{
			Gb.move();
			Gb.repaint();
			Thread.sleep( 25 );
		}
	}
}