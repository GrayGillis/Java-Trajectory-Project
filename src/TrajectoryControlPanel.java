// The TrajectoryControlPanel class creates 3 buttons and 2 sliders to
//  to control the movement of trajectories, and also contains a panel
//  displaying trajectories.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TrajectoryControlPanel extends JPanel{//components of the panel
    private TrajectoryPanel tPanel;
    private JButton start, clear, colorButton;
    private JSlider velocity, angle;
    private JLabel label1, label2;
    private JColorChooser chooser;
    private JPanel buttons1;
    private int width, height;
    private Color color;

    //Constructor to create all components, add their listener to them,
    //and arrange them using a layout.
    public TrajectoryControlPanel(int width, int height, Color initialColor){
        //create a color chooser with the specified initial color
        chooser = new JColorChooser(initialColor);
        color = initialColor;
        this.width = width;
        this.height = height;
        
        //create a panel displaying trajectories, with the specified color
        tPanel = new TrajectoryPanel(initialColor);
        
        //create 3 buttons, start, clear, and color chooser
        start = new JButton("Start");
        clear = new JButton("Clear");
        colorButton = new JButton("Color");
        
        //add a listener to each button
        start.addActionListener(new ButtonListener());
        clear.addActionListener(new ButtonListener());
        colorButton.addActionListener(new ButtonListener());
        
        buttons1 = new JPanel();
        buttons1.setLayout(new GridLayout(3,1));
        buttons1.add(start);
        buttons1.add(clear);
        buttons1.add(colorButton);
        
        //create a slider for the delay with major tick spacing 10,
        //minor tick spacing 5. The minimum value is 10, the maximum
        //is 100, and the initial set value is 50.
        velocity = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
        velocity.setMajorTickSpacing(10);
        velocity.setMinorTickSpacing(5);
        velocity.setPaintTicks(true);
        velocity.setPaintLabels(true);
        velocity.setAlignmentX(Component.LEFT_ALIGNMENT);
        velocity.addChangeListener(new VelocityListener());
        
        //create a label for the delay
        label1 = new JLabel("Initial Velocity");
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(label1, BorderLayout.NORTH);
        panel3.add(velocity, BorderLayout.CENTER);
        
        //create a slider for the number of angles with major tick spacing 10,
        //minor tick spacing 5. The minimum value is 5, the maximum
        //is 84, and the initial set value is 45.
        angle = new JSlider(JSlider.HORIZONTAL, 5, 85, 45);
        angle.setMajorTickSpacing(10);
        angle.setMinorTickSpacing(5);
        angle.setPaintTicks(true);
        angle.setPaintLabels(true);
        angle.setAlignmentX(Component.LEFT_ALIGNMENT);
        angle.addChangeListener(new AngleListener());
        
        //create a label for the number of angles
        label2 = new JLabel("Initial Angle");
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout());
        panel4.add(label2, BorderLayout.NORTH);
        panel4.add(angle, BorderLayout.CENTER);
        
        JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayout(2,1));//sets a GridLayout for the panel
        panel6.add(panel3);
        panel6.add(panel4);
        
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());//sets a BorderLayout for the panel
        panel5.add(buttons1, BorderLayout.CENTER);
        panel5.add(panel6, BorderLayout.EAST);
        
        setLayout(new BorderLayout());
        tPanel.setPreferredSize(new Dimension((width*2)/3, height));
        add(tPanel, BorderLayout.CENTER);
        add(panel5, BorderLayout.WEST);
    }

	//ButtonListener defines actions to be performed when each button
	//is pushed.
	private class ButtonListener implements ActionListener{
	     public void actionPerformed(ActionEvent event){
	          Object action = event.getSource();
	          if (action == start){
	           	   tPanel.resume();//starts the timer
	           	   tPanel.repaint();//calls the repaint of trajectory panel   	
	           }
	          
	           if (action == clear){	
		           tPanel.getPointList().clear();//clear arraylist
		           tPanel.repaint();//call repaint of trajectory panel
	           }
	           
	           if (action == colorButton){//if color is pushed
	               color = chooser.showDialog(null, "Change trajectory color", color);//shows the color panel
	               tPanel.changeColor(color);//changes the color 
	           }
	        }
	} //end of ButtonListener
	
	  //VelocityListener adjusts the initial velocity based on
	  //the chosen integer in the corresponding slider.
	private class VelocityListener implements ChangeListener{
	     public void stateChanged(ChangeEvent event){
	          int velocity2 = velocity.getValue();//sets the new velocity of the JSlider to velocity2
	          tPanel.setVelocity(velocity2);//sets velocity2 to the new velocity of tPanel
	     }
	}
	
	//AngleListener adjusts the initial angle based on
	//the chosen integer in the corresponding slider.
	private class AngleListener implements ChangeListener{
	     public void stateChanged(ChangeEvent event){
	    	  int angle2 = angle.getValue();//sets the new angle of the JSlider to angle2
	   	  	  tPanel.setAngle(angle2);//sets angle2 to the new angle of tPanel
	     }
	}
}