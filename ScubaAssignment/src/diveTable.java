import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class diveTable extends JFrame implements ActionListener{

	//used for the main gui interface
	private Container mainWindow;
	private JPanel  buttonGroup, table;
	private JButton createDive , deleteDive;
	private JLabel diveNum, depth, botTime, surfInt, resNitro;
	private JLabel diveNum1, depth1, botTime1, surfInt1, resNitro1;
	private JLabel diveNum2, depth2, botTime2, surfInt2, resNitro2;
	private JLabel diveNum3, depth3, botTime3, surfInt3, resNitro3;
	private JLabel diveNum4, depth4, botTime4, surfInt4, resNitro4;
	private JLabel diveNum5, depth5, botTime5, surfInt5, resNitro5;
	
	//used for the create dive popup
	private int diveCounter = 1;
	private Integer[] userDepth, userBotTime, userSurfInt; //the arrays of numbers for the list
	private JLabel userDepthLbl, userBotTimeLbl, userSurfIntLbl;
	private JPanel createDepthPopup, createBotPopup, createSurfPopup;
	@SuppressWarnings("rawtypes")
	private JComboBox depthList, botTimeList, surfIntList; //creates the actual drop down list
															//need to still implement the surf int list
	
	
	public diveTable(){
		
		//creates the buttons to click
		createDive = new JButton("Create Dive");
		createDive.addActionListener(new ActionListener(){
			//this calls on the action when the create dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				createDive();
			}
		
		});
           
		//need to add action listener
		deleteDive = new JButton("Delete Dive");
		deleteDive.addActionListener(new ActionListener(){
			//this calls on the action when the delete dive button is pressed
			public void actionPerformed(ActionEvent e)
			{
				deleteDive();
			}
		
		});
		
		//sets the 2 buttons to the left side of the GUI
		buttonGroup = new JPanel();
		buttonGroup.setLayout(new GridLayout(0, 1));
		buttonGroup.add(createDive);
		buttonGroup.add(deleteDive);
		
		
		/**************************************************
		 * creating the table to store all the information
		 **************************************************/
		//this is the titles of the columns 
		diveNum = new JLabel("Dive Number", SwingConstants.CENTER);  //centers the words
		diveNum.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border around
		depth = new JLabel("Depth", SwingConstants.CENTER);
		depth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime = new JLabel("Bottom Time", SwingConstants.CENTER);
		botTime.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt = new JLabel("Surface Interval", SwingConstants.CENTER);
		surfInt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro = new JLabel("Residual Nitrogen", SwingConstants.CENTER);
		resNitro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//this creates the first row of input's components
		diveNum1 = new JLabel("" ,SwingConstants.CENTER); //centers the words
		diveNum1.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border
		depth1 = new JLabel("" ,SwingConstants.CENTER);
		depth1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime1 = new JLabel("" ,SwingConstants.CENTER);
		botTime1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt1 = new JLabel("" ,SwingConstants.CENTER);
		surfInt1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro1 = new JLabel("" ,SwingConstants.CENTER);
		resNitro1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//this creates the second row of input's components
		diveNum2 = new JLabel("" ,SwingConstants.CENTER); //centers the words
		diveNum2.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border
		depth2 = new JLabel("" ,SwingConstants.CENTER);
		depth2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime2 = new JLabel("" ,SwingConstants.CENTER);
		botTime2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt2 = new JLabel("" ,SwingConstants.CENTER);
		surfInt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro2 = new JLabel("" ,SwingConstants.CENTER);
		resNitro2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		//this creates the third row of input's components
		diveNum3 = new JLabel("" ,SwingConstants.CENTER); //centers the words
		diveNum3.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border
		depth3 = new JLabel("" ,SwingConstants.CENTER);
		depth3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime3 = new JLabel("" ,SwingConstants.CENTER);
		botTime3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt3 = new JLabel("" ,SwingConstants.CENTER);
		surfInt3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro3 = new JLabel("" ,SwingConstants.CENTER);
		resNitro3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//this creates the fourth row of input's components 
		diveNum4 = new JLabel("" ,SwingConstants.CENTER);//centers the words
		diveNum4.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border
		depth4 = new JLabel("" ,SwingConstants.CENTER);
		depth4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime4 = new JLabel("" ,SwingConstants.CENTER);
		botTime4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt4 = new JLabel("" ,SwingConstants.CENTER);
		surfInt4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro4 = new JLabel("" ,SwingConstants.CENTER);
		resNitro4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		//this creates the fifth row of input's components
		diveNum5 = new JLabel("" ,SwingConstants.CENTER); //centers the words
		diveNum5.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //creates the black border
		depth5 = new JLabel("" ,SwingConstants.CENTER);
		depth5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		botTime5 = new JLabel("" ,SwingConstants.CENTER);
		botTime5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		surfInt5 = new JLabel("" ,SwingConstants.CENTER);
		surfInt5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		resNitro5 = new JLabel("" ,SwingConstants.CENTER);
		resNitro5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		/******************************************
		 *creates a grid to add the components into 
		******************************************/
		table = new JPanel();
		table.setLayout(new GridLayout(6, 5));

		table.add(diveNum); //title
		table.add(depth);
		table.add(botTime);
		table.add(surfInt);
		table.add(resNitro);
		
		table.add(diveNum1); //1st row
		table.add(depth1);
		table.add(botTime1);
		table.add(surfInt1);
		table.add(resNitro1);
		
		table.add(diveNum2); //2nd row
		table.add(depth2);
		table.add(botTime2);
		table.add(surfInt2);
		table.add(resNitro2);
		
		table.add(diveNum3); //3rd row
		table.add(depth3);
		table.add(botTime3);
		table.add(surfInt3);
		table.add(resNitro3);
		
		table.add(diveNum4); //4th row
		table.add(depth4);
		table.add(botTime4);
		table.add(surfInt4);
		table.add(resNitro4);
		
		table.add(diveNum5); //5th row
		table.add(depth5);
		table.add(botTime5);
		table.add(surfInt5);
		table.add(resNitro5);
		
		/*****************************************************
		 * the main panel to put together the buttons and grid
		*****************************************************/
		mainWindow = getContentPane(); 
		mainWindow.setLayout(new BorderLayout());
		mainWindow.add(buttonGroup, BorderLayout.WEST); //puts the buttons to the left
		mainWindow.add(table, BorderLayout.CENTER); //puts the table in the middle


	}
	
	/*********************************************************
	 * Does the logic for creating a dive
	 * only currently works for 1 dive
	 * user is able to select input based on drop-down menus
	 *********************************************************/
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void createDive() {
    	if(diveCounter == 1){ //if this is the first dive
    		userDepth = new Integer[]{40, 50, 60, 70, 80, 90, 100, 110, 120, 130}; //the depths the user can pic
            depthList = new JComboBox(userDepth); //put them into a drop down menu
   
            userDepthLbl = new JLabel("Enter Depth: "); //creates prompt for the user to select a depth
    		createDepthPopup = new JPanel(new GridLayout(1,0)); //creating the popup as a grid
    		createDepthPopup.add(userDepthLbl); //adds the label to the popup
    		createDepthPopup.add(depthList); //adds the drop down menu to the popup
    		
    		//this displays the popup and gets the result of what the user selects based on OK or CANCEL
    		int depthResult = JOptionPane.showConfirmDialog(null, createDepthPopup, 
    				"Create Dive Number: " + diveCounter, JOptionPane.OK_CANCEL_OPTION,
    				JOptionPane.OK_OPTION);
    		
    		
    		userBotTimeLbl = new JLabel("Enter Bottom Time: "); //creates prompt for the user to select a depth
    		userSurfIntLbl = new JLabel("Enter Surface Time: "); //creates prompt for the user to select surface time
    		
    		//probably can change this to a switch statement
    		if(depthList.getSelectedItem().equals(40)) //if the user wants to go 40 ft
    		{	
    			//create userBotTime array for 40
    			userBotTime = new Integer[]{5, 15, 25, 30, 40, 50, 70, 80, 100, 110, 130}; //these are the choices they
    																					   //can select to stay at the bottom
    			botTimeList = new JComboBox(userBotTime); //put them into a drop down menu
    		}
    		else if(depthList.getSelectedItem().equals(50))
    		{	
    			//create userBotTime array for 50
    			userBotTime = new Integer[]{10, 15, 25, 30, 40, 50, 60, 70, 80};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(60))
    		{	
    			//create userBotTime array for 60
    			userBotTime = new Integer[]{10, 15, 20, 25, 30, 40, 50, 55};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(70))
    		{	
    			//create userBotTime array for 70
    			userBotTime = new Integer[]{5, 10, 15, 20, 30, 35, 40, 45};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(80))
    		{	
    			//create userBotTime array for 80
    			userBotTime = new Integer[]{5, 10, 15, 20, 25, 30, 35};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(90))
    		{	
    			//create userBotTime array for 90
    			userBotTime = new Integer[]{5, 10, 12, 15, 20, 25};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(100))
    		{	
    			//create userBotTime array for 100
    			userBotTime = new Integer[]{5, 7, 10, 15, 20, 22};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else if(depthList.getSelectedItem().equals(110))
    		{	
    			//create userBotTime array for 110
    			userBotTime = new Integer[]{5, 10, 13, 15};
    			botTimeList = new JComboBox(userBotTime); 
    		}
    		else if(depthList.getSelectedItem().equals(120))
    		{	
    			//create userBotTime array for 120
    			userBotTime = new Integer[]{5, 10, 12};
    			botTimeList = new JComboBox(userBotTime);
    		}
    		else
    		{	
    			//create userBotTime array for 130
    			userBotTime = new Integer[]{5, 8};
    			botTimeList = new JComboBox(userBotTime); 
    		}
    		
    		createBotPopup = new JPanel(new GridLayout(1,0)); //
    		createBotPopup.add(userBotTimeLbl);
    		createBotPopup.add(botTimeList);
    		
    		int botTimeResult = JOptionPane.showConfirmDialog(null, createBotPopup, 
    				"Create Dive Number: " + diveCounter, JOptionPane.OK_CANCEL_OPTION,
    				JOptionPane.OK_OPTION);
    		
    		
    		createSurfPopup = new JPanel(new GridLayout(1, 0));
    		createSurfPopup.add(userSurfIntLbl);
    		//createBotPopup.add(botSurfList);

    		int surfIntResult = JOptionPane.showConfirmDialog(null, createSurfPopup, 
    				"Create Dive Number: " + diveCounter, JOptionPane.OK_CANCEL_OPTION,
    				JOptionPane.OK_OPTION);
    		
    		


    		if(depthResult == JOptionPane.OK_OPTION && botTimeResult == JOptionPane.OK_OPTION 
    				&& surfIntResult == JOptionPane.OK_OPTION) //if all the popup options where selected as OK
    		{
    			System.out.println(diveCounter); //just a check to see what dive we are in..get rid of this later
    			diveNum1.setText(diveCounter + ""); //<--- the lazy way of turning an int into a string
    			depth1.setText(depthList.getSelectedItem().toString());
    			botTime1.setText(botTimeList.getSelectedItem().toString());
    			surfInt1.setText("need to find out surface interval time"); 
    			diveCounter += 1; 
    			
    		}
    	}
    	else if(diveCounter <= 5){ //didnt implements popups for dive 2-5
    		System.out.println(diveCounter);
    		diveCounter += 1;
    	}
    	else{ //if the user selects cancel just a check that if was actually selected
    		System.out.println("Cancelled"); //prints to the console
    	}               
   }
   
   public void deleteDive(){
    	
    	JLabel deleteLbl = new JLabel("Are you sure you would like to delete dive number " + (diveCounter - 1));
    	
    	int deleteResult = JOptionPane.showConfirmDialog(null, deleteLbl, 
				"Delete Dive Number: " + (diveCounter -1), JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.OK_OPTION);
    	
    	//can probably use a switch statement maybe?
    	if(deleteResult == JOptionPane.OK_OPTION) //if the user is sure that the want to delete
    	{
        	if((diveCounter -1) == 1){ //if you are on dive 1 set everything on dive 1 to empty
        		diveNum1.setText("");
        		depth1.setText("");
        		botTime1.setText("");
        		surfInt1.setText("");
        		resNitro1.setText("");
        	}
        	else if((diveCounter -1) == 2){
        		diveNum2.setText("");
        		depth2.setText("");
        		botTime2.setText("");
        		surfInt2.setText("");
        		resNitro2.setText("");
        	}
        	else if((diveCounter -1) == 3){
        		diveNum3.setText("");
        		depth3.setText("");
        		botTime3.setText("");
        		surfInt3.setText("");
        		resNitro3.setText("");
        	}
        	else if((diveCounter -1) == 4){
        		diveNum4.setText("");
        		depth4.setText("");
        		botTime4.setText("");
        		surfInt4.setText("");
        		resNitro4.setText("");
        	}
        	else if((diveCounter -1) == 5){
        		diveNum5.setText("");
        		depth5.setText("");
        		botTime5.setText("");
        		surfInt5.setText("");
        		resNitro5.setText("");
        	}
        	diveCounter -= 1;
        	System.out.println(diveCounter);
    	}

    		
   }
    
	
   public static void main(String[] args){
		diveTable scuba = new diveTable();
		scuba.setSize(800, 300);
		scuba.setVisible(true);
		scuba.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
   }
	
}
