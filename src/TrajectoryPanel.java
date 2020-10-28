// Sets the trajectory panel to have the velocity and angles with the coordinating color for the dots
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.*;

public class TrajectoryPanel extends JPanel{
	private Color color;
	private Timer timer;
	private int initialY;
	private double velocity;
	private double time;
	private int delay;
	private double step;
	private int angle;
	private final double GRAVITY;
	private ArrayList<Dot> ptList;
	
	public TrajectoryPanel(Color color){
		initialY = 100;//initializes initalY
		velocity = 50.0;//initializes velocity
		time = 0.0;//initializes time
		delay = 50;//initializes delay
		this.color = color;//initializes color
		step = delay * 0.001;//initializes step
		angle = 45;//initializes angle
		GRAVITY = 9.8;//initializes GRAVITY
		timer = new Timer(delay, new MoveListener());//initializes timer
		setBackground(Color.BLACK);//initializes background color
		setPreferredSize(new Dimension());//initializes size
		timer.start();//initializes timer start
		ptList = new ArrayList<Dot>();//initializes ptList
	}
	
	public void resume(){
		time = 0.0;//time at 0
		timer.start();//starts timer
	}
	
	public void clearPanel(){
		time = 0.0;//time at 0
		ptList.clear();//clears ptList
	}
	
	public void changeColor(Color anotherColor){
		color = anotherColor;//instantiates color
	}
	
	public ArrayList<Dot> getPointList(){
		return ptList;//returns ptList
	}
	
	public void setAngle(int angle1){
			angle = angle1;//instantiates angle
	}
	
	public void setVelocity(int velocity1){
		velocity = velocity1;//instantiates velocity
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);//calls super to the paintComponent()
	    for(int i = 0; i < ptList.size(); i++)//begins for loop
	    {
	    	ptList.get(i).draw(page);//begins to draw the dots
	    }//end for loop
	}
	
	private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			time = time + step;//increments time
			int x = (int) (velocity*time*Math.cos((angle/180.0)*Math.PI));//sets x
			int y = initialY - ((int) (velocity*time*Math.sin((angle/180.0)*Math.PI)-(0.5*GRAVITY*time*time))); //sets y
			Dot dot = new Dot(x, y, color);//creates a dot object
			ptList.add(dot);//adds the dot object to the array list
			repaint();//calls the paint method again
		}
	}
}