import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class mainHub extends JFrame implements ActionListener{

	private JButton mainDis, table, tableRef, settings;
	private JPanel panel;
	private Container container;
	
	/*
	private ImageIcon image; //if i had time i was going to add an image
	private JLabel lbl;
	*/
	public mainHub(){
		
		//image = new ImageIcon(getClass().getResource("turtle.jpg")); if i got time i was gonna add an image
		
		
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");
		
		/**
		 * this creates the button for the Main Display
		 * not yet a working button
		 */
		mainDis = new JButton("Main Display");
		mainDis.setEnabled(false); //set to false because not implemented yet
		mainDis.addActionListener(new ActionListener(){
			//this calls on the action when the create dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				//gui not yet implemented
				//function not yet implemented
			}
		
		});
		
		/**
		 * this creates the button for Dive Table: Create
		 * calls on diveTable.java to open
		 */
		table = new JButton("Dive Table: Create");
		table.addActionListener(new ActionListener(){
			//this calls on the action when the create dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				diveTable scuba = new diveTable();
				scuba.setSize(800, 300);
				scuba.setVisible(true);
				//table.setEnabled(false); to turn off button
											//cant seem to figure out how to turn it back on when window closed
			}
		});
		
		/**
		 * this creates the button for NAUI Table Reference
		 * a reference to the NAUI dive table
		 * calls on nauiReference.java to open
		 */
		tableRef = new JButton("NAUI Table Reference");
		tableRef.addActionListener(new ActionListener(){
			//this calls on the action when the create dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				nauiReference naui = new nauiReference();
				naui.setVisible(true);
				naui.setLocation(700,100);
				naui.pack();
				//tableRef.setEnabled(false); to turn of button
											//cant seem to figure out how to turn it back on when window closed
			}
		
		});
		tableRef.setEnabled(true);
		
		/**
		 * this creates the button for settings
		 * not yet a working button
		 */
		settings = new JButton("Settings");
		settings.setEnabled(false); //set to false because not implemented yet
		settings.addActionListener(new ActionListener(){
			//this calls on the action when the create dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				//gui not yet implemented
				//function not yet implemented
			}
		
		});
		
		panel = new JPanel(new GridLayout(2,2)); //creates the main hub
		panel.add(mainDis);  //adds all the components
		panel.add(table);
		panel.add(tableRef);
		panel.add(settings);
		
		container = getContentPane();
		container.add(panel);
	
	}
	
	   public static void main(String[] args){
			mainHub hub = new mainHub();
	        JOptionPane.showMessageDialog(null, "This program is a prototype and CANNOT "
	        		+ "be used for ACTUAL DIVES.", "PROTOTYPE!!", 
	        		JOptionPane.WARNING_MESSAGE);
			hub.setSize(700, 300);
			hub.setLocation(600, 300);
			hub.setVisible(true);
			hub.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}