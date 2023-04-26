	
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends Canvas{
	/** extremal coordinates of the field itself */
	protected int minX, minY;
	private BufferStrategy strategy;
	protected String message = "";
	Graphics2D g;
	private int boxLength=20;
	ImageIcon img;
	private Snake snake=new Snake();
	public MainFrame(int minX, int minY,Snake snake) {
		this.minX = minX; this.minY = minY;
	    // create a frame to contain our game
	    JFrame container = new JFrame("snake!");
	    container.add(this);
	    // get the content of the frame and set up the resolution of the game
	    JPanel panel = (JPanel) container.getContentPane();
	    panel.setPreferredSize(new Dimension(minX,minY));
	    panel.setLayout(null);
	    
	    // set up our canvas size and put it into the content of the frame
	    setBounds(0,0,minX,minY );
	    panel.add(this);
	    
	    // Tell AWT not to bother repainting our canvas since we're
	    // going to do that our self in accelerated mode
	    setIgnoreRepaint(true);
	    
	    // finally make the window visible 
	    container.pack();
	    container.setResizable(false);
	    container.setVisible(true);
	    img = new ImageIcon("src/Icon.png");
	    container.setIconImage(img.getImage());
	}
	public void setBackGround() {
	    // add a listener to respond to the user closing the window. If they
	    // do we'd like to exit the game
		// create the buffering strategy which will allow AWT
	    // to manage our accelerated graphics
	    createBufferStrategy(2);
	    strategy = getBufferStrategy();
	    
	    g = (Graphics2D) strategy.getDrawGraphics();
	    img = new ImageIcon("src/BackGround.png");
	    
	    g.drawImage(img.getImage(), 0, 0, null);
	    
	    int temp=minY/boxLength;
	    for(int index=0;index<temp;index++)
	    	g.drawLine(index*boxLength, 0,index*boxLength,600);
	    temp=minX/boxLength;
	    for(int index=0;index<temp;index++)
	    	g.drawLine(0, index*boxLength, 600, index*boxLength);
	    strategy.show();
	}
	public void drawSnake(Snake snake) {
		LinkedList <Dot> body=snake.getBody();
		for(Dot dot : body) {
	    	g.setColor(Color.LIGHT_GRAY);
	    	if(dot==body.getFirst())
	    		g.setColor(Color.GRAY);
	    	int x=boxLength*dot.getxValue();
	    	int y=boxLength*dot.getyValue();
	        g.fillRoundRect(x,y, boxLength, boxLength,15,15);	
	    }
	    strategy.show();
	}
	public void drawApple(Snake snake) {
		Dot apple= snake.getApple();
	    	g.setColor(Color.red);
	    	int x=boxLength*apple.getxValue();
	    	int y=boxLength*apple.getyValue();
	        g.fillRoundRect(x,y, boxLength, boxLength,15,15);	
	    strategy.show();
	}
}
