// Creates a dot that will be used as the trajectory line
import java.awt.*;

public class Dot {
	private int x;
	private int y;
	private Color color;
	private final int RADIUS = 3;
	
	public Dot(int x1, int y1, Color color1){//constructor for instance variables
		x = x1;//initializes x
		y = y1;//initializes y
		color = color1;//initializes color
	}
	
	public int getX(){
		return x;//returns x
	}
	
	public int getY(){
		return y;//returns y
	}
	
	public int getRadius(){
		return RADIUS;//returns radius
	}
	
	public void draw(Graphics page){
		page.setColor(color);//sets the color
		page.fillOval(x, y, RADIUS, RADIUS);//fills in the dot
	}
}