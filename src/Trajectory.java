// creates a ControlPanel and adds it as its JApplet content and also sets its size.
import javax.swing.*;

public class Trajectory extends JApplet{
	private final int WIDTH = 800;
	private final int HEIGHT = 340;

	public void init(){
	    ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
	    getContentPane().add(panel);
	    setSize(WIDTH,HEIGHT);
	}
}