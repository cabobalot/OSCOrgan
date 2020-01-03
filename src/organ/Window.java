package organ;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

public class Window extends JPanel implements ItemListener {
	
    private ArrayList<JCheckBox> stops;
 
    private static Sender sender;
 
    public Window() {
    	super(new GridLayout(0, 1));
        
        readStopsFile2();
        
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    
    private void readStopsFile3() {
    	
    	ArrayList<JPanel> divisions = new ArrayList<JPanel>();
    	stops = new ArrayList<JCheckBox>();
    	
    	File file = new File("./Stops.txt");
    	Scanner sc;
	    try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	    
	    String curDivision = "";
	    String stopName = "";
	    String stopFeet = "";
	    
	    
	    stopName = sc.nextLine(); // read from file
    	stopFeet = sc.nextLine();
    	String myDivision = sc.nextLine();
    	String trash = sc.nextLine();
    	while (!trash.equals("=")) { // throw away unused info
    		trash = sc.nextLine();
    	}
    	
    	
	    while (sc.hasNext()) {
	    	
	    	curDivision = myDivision;

	    	JPanel stopGrid = new JPanel(new GridBagLayout()); // create new grid
	    	
	    	JPanel divisionPanel = new JPanel(new BorderLayout()); // create new division
	    	divisionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border
	    	divisionPanel.add(new JLabel(myDivision), BorderLayout.NORTH); // add label to division
	    	divisionPanel.add(stopGrid, BorderLayout.CENTER); // add grid to division
	    	
	    	divisions.add(divisionPanel); // add division to list
	    	
	    	JCheckBox nextStop = new JCheckBox(stopName + " : " + stopFeet); //create checkbox
	    	System.out.println(myDivision + " Stop:" + stopName + " " + stopFeet);
	    	nextStop.setSelected(false);
	        nextStop.addItemListener(this);
	        
	        stops.add(nextStop); // add check to list
	        
	        GridBagConstraints gb = new GridBagConstraints();
	        gb.gridy = GridBagConstraints.RELATIVE;
	        gb.gridx = GridBagConstraints.RELATIVE;
	        stopGrid.add(nextStop, gb); // add check to grid
	    	
	    	stopName = sc.nextLine(); // read next stop
	    	stopFeet = sc.nextLine();
	    	myDivision = sc.nextLine();
	    	trash = sc.nextLine();
	    	while (!trash.equals("=")) { // throw away unused info
	    		trash = sc.nextLine();
	    	}
	    	while (curDivision.equals(myDivision)) { // loop through division

		    	JCheckBox nextNextStop = new JCheckBox(stopName + " : " + stopFeet); // create checkbox
		    	System.out.println(myDivision + " Stop:" + stopName + " " + stopFeet);
		    	nextStop.setSelected(false);
		        nextStop.addItemListener(this);
		        
		        stops.add(nextNextStop); // add check to grid
		        
//		        gb.gridy = gb.gridy + 1;
//		        gb.gridx++;
		        stopGrid.add(nextStop, gb); // add check to grid
		    	
		        if (sc.hasNext()) {
			    	
		    	}
		    	if (sc.hasNext()) {
		    		stopName = sc.nextLine(); //read next stop
			    	stopFeet = sc.nextLine();
			    	myDivision = sc.nextLine();
			    	trash = sc.nextLine();
			    	while (!trash.equals("=")) { // throw away unused info
			    		trash = sc.nextLine();
			    	}
		    	}
		    	else {
		    		break;
		    	}
		    	
	    	}
	    	
	    	add(divisionPanel);
	    }
	    
	    
	    sc.close();
    }
    
    private void readStopsFile2() {
    	ArrayList<JPanel> divisions = new ArrayList<JPanel>();
    	stops = new ArrayList<JCheckBox>();
    	
    	File file = new File("./Stops.txt");
    	Scanner sc;
	    try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	    
	    String curDivision = "";
	    String stopName = "";
	    String stopFeet = "";
	    
	    
	    stopName = sc.nextLine(); // read from file
    	stopFeet = sc.nextLine();
    	String myDivision = sc.nextLine();
    	String trash = sc.nextLine();
    	while (!trash.equals("=")) { // throw away unused info
    		trash = sc.nextLine();
    	}
    	
    	
	    while (sc.hasNext()) {
	    	
	    	curDivision = myDivision;

	    	JPanel stopGrid = new JPanel(new GridLayout(5, 5)); // create new grid
	    	
	    	JPanel divisionPanel = new JPanel(new BorderLayout()); // create new division
	    	divisionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // border
	    	divisionPanel.add(new JLabel(myDivision), BorderLayout.NORTH); // add label to division
	    	divisionPanel.add(stopGrid, BorderLayout.CENTER); // add grid to division
	    	
	    	divisions.add(divisionPanel); // add division to list
	    	
	    	JCheckBox nextStop = new JCheckBox(stopName + " : " + stopFeet); //create checkbox
	    	System.out.println(myDivision + " Stop:" + stopName + " " + stopFeet);
	    	nextStop.setSelected(false);
	        nextStop.addItemListener(this);
	        
	        stops.add(nextStop); // add check to list
	        stopGrid.add(nextStop); // add check to grid
	    	
	    	stopName = sc.nextLine(); // read next stop
	    	stopFeet = sc.nextLine();
	    	myDivision = sc.nextLine();
	    	trash = sc.nextLine();
	    	while (!trash.equals("=")) { // throw away unused info
	    		trash = sc.nextLine();
	    	}
	    	while (curDivision.equals(myDivision)) { // loop through division

		    	JCheckBox nextNextStop = new JCheckBox(stopName + " : " + stopFeet); // create checkbox
		    	System.out.println(myDivision + " Stop:" + stopName + " " + stopFeet);
		    	nextStop.setSelected(false);
		        nextStop.addItemListener(this);
		        
		        stops.add(nextNextStop); // add check to grid
		        stopGrid.add(nextNextStop);
		    	
		        if (sc.hasNext()) {
			    	
		    	}
		    	if (sc.hasNext()) {
		    		stopName = sc.nextLine(); //read next stop
			    	stopFeet = sc.nextLine();
			    	myDivision = sc.nextLine();
			    	trash = sc.nextLine();
			    	while (!trash.equals("=")) { // throw away unused info
			    		trash = sc.nextLine();
			    	}
		    	}
		    	else {
		    		break;
		    	}
		    	
	    	}
	    	
	    	add(divisionPanel);
	    }
	    
	    
	    sc.close();
	    
    }
    
    private void readStopsFile() {
    	
    	//Put the check boxes in a grid in a panel
    	ArrayList<JPanel> panels = new ArrayList<JPanel>();
    	ArrayList<JPanel> divisions = new ArrayList<JPanel>();
    	
    	stops = new ArrayList<JCheckBox>();
    	
    	File file = new File("./Stops.txt");
    	Scanner sc;
	    try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	    
	    String curDivision = "";
	    String stopName = "";
	    String stopFeet = "";
	    
	    while (sc.hasNext()) {
	    	stopName = sc.nextLine();
	    	stopFeet = sc.nextLine();
	    	String myDivision = sc.nextLine();
	    	
	    	if (!curDivision.equals(myDivision)) {
	    		
	    		panels.add(new JPanel(new GridLayout(10, 10)));
	    		BorderLayout divisionLayout = new BorderLayout();
	    		divisionLayout.addLayoutComponent(new JLabel(myDivision), BorderLayout.NORTH);
	    		divisionLayout.addLayoutComponent(panels.get(panels.size() - 1), BorderLayout.CENTER);
	    		divisions.add(new JPanel(divisionLayout));

	    		panels.get(panels.size() - 1).setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    		
	    		add(divisions.get(divisions.size() - 1));
	    		
	    		curDivision = myDivision;
	    	}
	    	
	    	JCheckBox nextStop = new JCheckBox(stopName + " : " + stopFeet);
	    	System.out.println(myDivision + " Stop:" + stopName + " " + stopFeet);
	    	
	    	String trash = sc.nextLine();
	    	while (!trash.equals("=")) {
	    		trash = sc.nextLine();
	    	}
	    	
	        nextStop.setSelected(false);
	        nextStop.addItemListener(this);
	        
	        stops.add(nextStop);
	        panels.get(panels.size() - 1).add(nextStop);
	    }
	    add(panels.get(panels.size() - 1));
	    sc.close();
    }
 
    /** Listens to the check boxes. */
    public void itemStateChanged(ItemEvent e) {
        
        Object source = e.getItemSelectable();
        int stopNum = 0;
        
        for (int i = 0; i < stops.size(); i++) {
        	if (source == stops.get(i)) {
        		stopNum = i;
                System.out.print("stop " + i);
            }
        }

        if (e.getStateChange() == ItemEvent.DESELECTED) {
        	sender.sendMsg(new OSCMsg("/stop/set", stopNum, 0));
        	System.out.println(" off");
        }
        else {
        	sender.sendMsg(new OSCMsg("/stop/set", stopNum, 1));
        	System.out.println(" on");
        }
 
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Stop Jamb");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
            	sender.sendMsg(new OSCMsg("/stop/program", 0, 0));
                sender.close();
        		System.out.println("closed!");
            }
        });
 
        //Create and set up the content pane.
        JComponent newContentPane = new Window();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void startWindow() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public static void setSender(Sender s) {
    	sender = s;
    }
}
