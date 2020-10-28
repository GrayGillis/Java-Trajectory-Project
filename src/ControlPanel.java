// The ControlPanel class creates 2 panels and control panels that control their movement.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel{
	private int width, height;
	private int panelNum;

	//The constructor creates creates 2 panels and
	//control panels that control their movement, and organize them using a layout
	public ControlPanel(int width, int height){//constructor
        this.width = width;
        this.height = height;
        panelNum = 2; //the number of panels is 2

        //create 2 panels to control the movements
        TrajectoryControlPanel[] trajectoryPanels;
        trajectoryPanels = new TrajectoryControlPanel[panelNum];//size of array is 2
        trajectoryPanels[0] = new TrajectoryControlPanel(width/panelNum, height, Color.RED);//sets the 1st trajectory red
        trajectoryPanels[1] = new TrajectoryControlPanel(width/panelNum, height, Color.BLUE);//sets the 2nd trajectory blue

        //add two panels into this control panel using GridLayout
        setLayout(new GridLayout(panelNum, 1));
        for (int i = 0; i < panelNum; i++){
            add(trajectoryPanels[i]);
        }
        setPreferredSize(new Dimension(width,height));//sets the size of the ControlPanel
    }
}