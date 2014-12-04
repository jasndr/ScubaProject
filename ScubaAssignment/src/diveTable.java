import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class diveTable extends JFrame implements ActionListener{

	//used for the main gui interface
	private Container mainWindow;
	private JPanel  buttonGroup, table;
	private JButton createDive , deleteDive;
	private JLabel diveNum, depth, botTime, surfInt, resNitro, decompStop;
	private JLabel diveNum1, depth1, botTime1, surfInt1, resNitro1, decompStop1;
	private JLabel diveNum2, depth2, botTime2, surfInt2, resNitro2, decompStop2;
	private JLabel diveNum3, depth3, botTime3, surfInt3, resNitro3, decompStop3;
	private JLabel diveNum4, depth4, botTime4, surfInt4, resNitro4, decompStop4;
	private JLabel diveNum5, depth5, botTime5, surfInt5, resNitro5, decompStop5;
	
	//used for the create dive popup
	private int diveCounter = 0;
	private JTextField userDepthTxt, userBotTimeTxt, userSurfIntTxt; //the arrays of numbers for the list
	private JLabel userDepthLbl, userBotTimeLbl, userSurfIntLbl;
	private JPanel createDepthPopup, createBotPopup, createSurfPopup;
	@SuppressWarnings("rawtypes")

	   
   //Accessing the dive functions and storing data
   diveFunctions dFunctions = new diveFunctions();
   ArrayList<DiveStruct> userTable = new ArrayList<DiveStruct>();
   
	public diveTable(final JButton button){
		//set the title of the main gui frame
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");
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
      
		//add event listener
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				button.setEnabled(true);
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
		decompStop = new JLabel("<html>Decompression Stop<br>(5 meter depth)</html>", SwingConstants.CENTER);
		decompStop.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		decompStop1 = new JLabel("" ,SwingConstants.CENTER);
		decompStop1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		decompStop2 = new JLabel("" ,SwingConstants.CENTER);
		decompStop2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		decompStop3 = new JLabel("" ,SwingConstants.CENTER);
		decompStop3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		decompStop4 = new JLabel("" ,SwingConstants.CENTER);
		decompStop4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		decompStop5 = new JLabel("" ,SwingConstants.CENTER);
		decompStop5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		table.add(decompStop);
		
		table.add(diveNum1); //1st row
		table.add(depth1);
		table.add(botTime1);
		table.add(surfInt1);
		table.add(resNitro1);
		table.add(decompStop1);
		
		table.add(diveNum2); //2nd row
		table.add(depth2);
		table.add(botTime2);
		table.add(surfInt2);
		table.add(resNitro2);
		table.add(decompStop2);
		
		table.add(diveNum3); //3rd row
		table.add(depth3);
		table.add(botTime3);
		table.add(surfInt3);
		table.add(resNitro3);
		table.add(decompStop3);
		
		table.add(diveNum4); //4th row
		table.add(depth4);
		table.add(botTime4);
		table.add(surfInt4);
		table.add(resNitro4);
		table.add(decompStop4);
		
		table.add(diveNum5); //5th row
		table.add(depth5);
		table.add(botTime5);
		table.add(surfInt5);
		table.add(resNitro5);
		table.add(decompStop5);
		
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
    	boolean isValidDepth, isValidBTime, isValidITime;
    	int userDepth, userBotTime, userSurfInt; //Moved these values here since don't need to use them outside of this method
    	int rNitrogen = 0;
    	int maxDepthIndex = -1;
    	int bottomTimeIndex = -1;
    	int surfaceIntervalIndex = -1;
    	int decompressionMins;

    	if(diveCounter < 5){
    		//System.out.println("you are on dive number" +diveCounter); //check to see what dive 
    		//create the depth popup
    		userDepthTxt = new JTextField();
    		userDepthLbl = new JLabel("Enter your desired DEPTH in meters.");
    		createDepthPopup = new JPanel(new GridLayout(0,1));
    		createDepthPopup.add(userDepthLbl);
    		createDepthPopup.add(userDepthTxt);

    		//create the bottom time popup
    		userBotTimeTxt = new JTextField();
    		userBotTimeLbl = new JLabel("Enter your desired BOTTOM TIME in minutes."); //lol you had meters here instead of minutes.
    		createBotPopup = new JPanel(new GridLayout(0,1));
    		createBotPopup.add(userBotTimeLbl);
    		createBotPopup.add(userBotTimeTxt);

    		//create the surface interval popup
    		userSurfIntTxt = new JTextField();
    		userSurfIntLbl = new JLabel("Enter your desired SURFACE INTERVAL in minutes.");
    		createSurfPopup = new JPanel(new GridLayout(0,1));
    		createSurfPopup.add(userSurfIntLbl);
    		createSurfPopup.add(userSurfIntTxt);

    		//opens the depth popup
    		isValidDepth = false;
    		while(!isValidDepth){
    			int depthResult = JOptionPane.showConfirmDialog(null, createDepthPopup, 
    					"Create Dive #" + (diveCounter + 1) + ": DEPTH", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

    			if(depthResult == JOptionPane.OK_OPTION){//so if the user clicks OK
    				//have to do a check if input is valid number
    				try{
    					userDepth = Integer.parseInt(userDepthTxt.getText());
    					//System.out.println("This is the depth " + userDepth); just a check to see if input is correct
    					maxDepthIndex = dFunctions.maxDepthIndex(userDepth);

    					if(userDepth > 0 && maxDepthIndex >= 0){ //checks if positive and if the value is valid on the chart
    						isValidDepth = true;
    						isValidBTime = false;
    						//opens the bottom time popup
    						while(!isValidBTime){
    							int botTimeResult = JOptionPane.showConfirmDialog(null, createBotPopup, 
    									"Create Dive #" + (diveCounter + 1) + ": BOTTOM TIME", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

    							if(botTimeResult == JOptionPane.OK_OPTION){//if OK 

    								//parse input into a int
    								userBotTime = Integer.parseInt(userBotTimeTxt.getText());
    								//System.out.println("This is the bottom time " + userBotTime); just a check to see input
    								if(diveCounter > 0){
    									rNitrogen = FinalValues.nitrogenTable[userTable.get(diveCounter-1).getSurfaceIntervalIndex()][maxDepthIndex];
    									bottomTimeIndex = dFunctions.diveTimeIndex(maxDepthIndex, userBotTime+rNitrogen);
    								}
    								else{
    									bottomTimeIndex = dFunctions.diveTimeIndex(maxDepthIndex, userBotTime);
    								}

    								if(userBotTime > 0 && bottomTimeIndex >= 0){//if positive and time isn't too long
    									isValidBTime = true;
    									isValidITime = false;
    									//opens surface interval popup
    									while(!isValidITime){
    										int surfIntResult = JOptionPane.showConfirmDialog(null, createSurfPopup, 
    												"Create Dive #" + (diveCounter + 1)+ ": SURFACE INTERVAL", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

    										if(surfIntResult == JOptionPane.OK_OPTION){ //if OK

    											//parse input into an int
    											userSurfInt = Integer.parseInt(userSurfIntTxt.getText());
    											//System.out.println("This is the surface interval " + userSurfInt); just a check to see input
    											surfaceIntervalIndex = dFunctions.surfaceIndex(bottomTimeIndex, userSurfInt);

    											if(userSurfInt >= 10 && surfaceIntervalIndex >= 0){
    												isValidITime = true;
    												//all input is valid!!!!!!!!!!!!!!!!!!!!!!! <Midpoint of giant code lol

    												decompressionMins = dFunctions.decompStopMins(maxDepthIndex, bottomTimeIndex);
    												DiveStruct dives = new DiveStruct(diveCounter+1, userDepth, userBotTime, userSurfInt, rNitrogen, surfaceIntervalIndex, decompressionMins); //store dive information
    												userTable.add(dives);
    												setTable(diveCounter);
    												diveCounter += 1; //increment dive counter
    											}
    											else{
    												//when the surface interval isnt positive
    												if(userSurfInt < 10){
    													JOptionPane.showMessageDialog(null, "Must have at least 10min interval! (for single dive, simply enter 10)", 
    															"ERROR", JOptionPane.ERROR_MESSAGE);
    												}
    												else
    												{
    													JOptionPane.showMessageDialog(null, "Interval is too long! Maximum is 24hrs (1440mins)", 
    															"ERROR", JOptionPane.ERROR_MESSAGE);
    												}
    											}	
    										}
    										else{
    											//when cancel is pressed from the surface popup
    											//JOptionPane.showMessageDialog(null, "You have the CANCELLED current dive, no information will be saved", "CANCEL", JOptionPane.WARNING_MESSAGE);
    											isValidBTime = false;
    											isValidITime = true;
    										}
    									}
    								}
    								else{
    									//when bottom time isnt positive
    									if(userBotTime <= 0){
    										JOptionPane.showMessageDialog(null, "You have entered a non-positive number!", 
    												"ERROR", JOptionPane.ERROR_MESSAGE);
    									}
    									else{
    										JOptionPane.showMessageDialog(null, "Bottom time is too long!  Please enter a shorter time or shallower depth.  Otherwise, enter a longer surface interval for previous dive.", 
    												"ERROR", JOptionPane.ERROR_MESSAGE);
    									}
    								}
    							}
    							else{
    								//when cancel is pressed from the bottom time popup
    								//JOptionPane.showMessageDialog(null, "You have the CANCELLED current dive, no information will be saved", "CANCEL", JOptionPane.WARNING_MESSAGE);
    								isValidDepth = false;
    								isValidBTime = true;
    							}
    						}
    					}
    					else{
    						//when depth isnt positive or depth is too deep
    						if(userDepth <= 0){
    							JOptionPane.showMessageDialog(null, "You have entered a non-positive number!", 
    									"ERROR", JOptionPane.ERROR_MESSAGE);
    						}
    						else{
    							JOptionPane.showMessageDialog(null, "Too deep for depth! Max depth is 40 meters.", 
    									"ERROR", JOptionPane.ERROR_MESSAGE);
    						}
    					}
    				}catch(NumberFormatException e){
    					//error message for all popups if not a number
    					JOptionPane.showMessageDialog(null, "You have not entered an actual number!", "ERROR", JOptionPane.ERROR_MESSAGE);
    				}
    				catch(ArrayIndexOutOfBoundsException e){
    					//error message for residual nitrogen if diving too deep from previous dive
    					JOptionPane.showMessageDialog(null, "Cannot dive this deep with amount of residual nitrogen left from last dive!  Please enter shallower depth.", "ERROR", JOptionPane.ERROR_MESSAGE);
    					isValidBTime = true;
    					isValidITime = false;
    				}
    			}
    			else{
    				//when cancel is pressed from the depth popup
    				JOptionPane.showMessageDialog(null, "You have the CANCELLED current dive, no information will be saved", "CANCEL", JOptionPane.WARNING_MESSAGE);
    				isValidDepth = true;
    			}
    		}
    	}
    	else{
    		//you have made too many dives
    		JOptionPane.showMessageDialog(null, "You have the created TOO MANY DIVES, if you would like to create more, please delete dives", "WARNING", JOptionPane.ERROR_MESSAGE);
    	}
    }
   
   public void deleteDive(){
    	
    	JLabel deleteLbl = new JLabel("This will delete the newest dive.  Are you sure you would like to delete dive number " + (diveCounter) + "?");
    	
    	if(diveCounter <= 0){
			JOptionPane.showMessageDialog(null, "You HAVE NOT CREATED any dives", "WARNING", JOptionPane.ERROR_MESSAGE);

    	}
    	else{
        	
        	int deleteResult = JOptionPane.showConfirmDialog(null, deleteLbl, 
    				"Delete Dive Number: " + (diveCounter), JOptionPane.OK_CANCEL_OPTION,
    				JOptionPane.OK_OPTION);
        	
        	//can probably use a switch statement maybe?
        	if(deleteResult == JOptionPane.OK_OPTION) //if the user is sure that the want to delete
        	{
        		userTable.remove(diveCounter-1);
        		if(diveCounter == 1){ //if you are on dive 1 set everything on dive 1 to empty
        			diveNum1.setText("");
        			depth1.setText("");
        			botTime1.setText("");
        			surfInt1.setText("");
        			resNitro1.setText("");
        			decompStop1.setText("");
        		}
        		else if(diveCounter == 2){
        			diveNum2.setText("");
        			depth2.setText("");
        			botTime2.setText("");
        			surfInt2.setText("");
        			resNitro2.setText("");
        			resNitro1.setText("N/A till next dive info");
        			decompStop2.setText("");
        		}
        		else if(diveCounter == 3){
        			diveNum3.setText("");
        			depth3.setText("");
        			botTime3.setText("");
        			surfInt3.setText("");
        			resNitro3.setText("");
        			resNitro2.setText("N/A till next dive info");
        			decompStop3.setText("");
        		}
        		else if(diveCounter == 4){
        			diveNum4.setText("");
        			depth4.setText("");
        			botTime4.setText("");
        			surfInt4.setText("");
        			resNitro4.setText("");
        			resNitro3.setText("N/A till next dive info");
        			decompStop4.setText("");
        		}
        		else if(diveCounter == 5){
        			diveNum5.setText("");
        			depth5.setText("");
        			botTime5.setText("");
        			surfInt5.setText("");
        			resNitro5.setText("");
        			resNitro4.setText("N/A till next dive info");
        			decompStop5.setText("");
        		}
        		JOptionPane.showMessageDialog(null, "Dive number " + diveCounter + " was deleted!", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
        		diveCounter -= 1;
        	}
    	}		
   }
    
	public void setTable(int diveNumber){
      switch(diveNumber){
         case 0 : diveNum1.setText(userTable.get(diveNumber).getDiveNum() + "");
                  depth1.setText(userTable.get(diveNumber).getMaxDepth() + "");
                  botTime1.setText(userTable.get(diveNumber).getBottomTime() + "");
                  surfInt1.setText(userTable.get(diveNumber).getSurfaceInterval() + "");
                  resNitro1.setText("N/A till next dive info");
                  decompStop1.setText(userTable.get(diveNumber).getDecompressionMins() + " mins");
                  break;

         case 1 : diveNum2.setText(userTable.get(diveNumber).getDiveNum() + "");
                  depth2.setText(userTable.get(diveNumber).getMaxDepth() + "");
                  botTime2.setText(userTable.get(diveNumber).getBottomTime() + "");
                  surfInt2.setText(userTable.get(diveNumber).getSurfaceInterval() + "");
                  resNitro1.setText(userTable.get(diveNumber).getResNitrogen() + "");
                  resNitro2.setText("N/A till next dive info");
                  decompStop2.setText(userTable.get(diveNumber).getDecompressionMins() + " mins");
                  break;
                  
         case 2 : diveNum3.setText(userTable.get(diveNumber).getDiveNum() + "");
                  depth3.setText(userTable.get(diveNumber).getMaxDepth() + "");
                  botTime3.setText(userTable.get(diveNumber).getBottomTime() + "");
                  surfInt3.setText(userTable.get(diveNumber).getSurfaceInterval() + "");
                  resNitro2.setText(userTable.get(diveNumber).getResNitrogen() + "");
                  resNitro3.setText("N/A till next dive info");
                  decompStop3.setText(userTable.get(diveNumber).getDecompressionMins() + " mins");
                  break;

         case 3 : diveNum4.setText(userTable.get(diveNumber).getDiveNum() + "");
                  depth4.setText(userTable.get(diveNumber).getMaxDepth() + "");
                  botTime4.setText(userTable.get(diveNumber).getBottomTime() + "");
                  surfInt4.setText(userTable.get(diveNumber).getSurfaceInterval() + "");
                  resNitro3.setText(userTable.get(diveNumber).getResNitrogen() + "");
                  resNitro4.setText("N/A till next dive info");
                  decompStop4.setText(userTable.get(diveNumber).getDecompressionMins() + " mins");
                  break;
                  
         case 4 : diveNum5.setText(userTable.get(diveNumber).getDiveNum() + "");
                  depth5.setText(userTable.get(diveNumber).getMaxDepth() + "");
                  botTime5.setText(userTable.get(diveNumber).getBottomTime() + "");
                  surfInt5.setText(userTable.get(diveNumber).getSurfaceInterval() + "");
                  resNitro4.setText(userTable.get(diveNumber).getResNitrogen() + "");
                  resNitro5.setText("N/A till next dive info");
                  decompStop5.setText(userTable.get(diveNumber).getDecompressionMins() + " mins");
                  break;
      }
   }
   
	//if you would just like to test the diveTable
	//comment out other main methods in other class
 /*  public static void main(String[] args){
		diveTable scuba = new diveTable();
        JOptionPane.showMessageDialog(null, "This program is a prototype and CANNOT "
        		+ "be used for ACTUAL DIVES.", "PROTOTYPE!!", 
        		JOptionPane.WARNING_MESSAGE);
		scuba.setSize(800, 300);
		scuba.setVisible(true);
		scuba.setDefaultCloseOperation(EXIT_ON_CLOSE);
   }*/

   @Override
   public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
   }
	
}
