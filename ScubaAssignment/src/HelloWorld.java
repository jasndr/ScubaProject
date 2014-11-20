import java.util.*;
import java.io.*;

public class HelloWorld { 
 public static void main (String[] args){
	 
	 boolean run = true;
	 String userChoice;
	 
	 System.out.println("DISCLAIMER:  NOT TO BE USED ON REAL DIVES!");
	 System.out.println("Hello World!");
    
	 ArrayList<DiveStruct> userTable = new ArrayList<DiveStruct>();
    
	 Scanner input = new Scanner(System.in);
	 
	 while(run == true){
		 System.out.println("Select menu option (this wont be printed on the GUI)");
		 userChoice = input.nextLine();
		 
		 switch(userChoice){
		 	case "HOME":      homePage();
		 					  break;
		 	
		 	case "DIVELOG":   diveLog(userTable);
		 					  break;
		 					  
		 	case "DIVETABLE": diveTable();
		 					  break;
		 					  
		 	case "SETTINGS":  settings();
		 					  break;
		 					  
		 	default:		  System.out.println("Invalid Choice (this message shoudln't be in GUI)");
		 					  break;
		 }
	 }
	 //Testing
 }
 
 public static void homePage(){
	 //Just display a bunch of info.  Purely graphical page
 }
 
 public static void diveLog(ArrayList<DiveStruct> userTable){
	 boolean run = true;
	 String userChoice;
	 Scanner input = new Scanner(System.in);
	 
	 while(run){
		 userChoice = input.nextLine();
		 if(userChoice.equals("CREATE")){
			 addTable(userTable);
		 }
		 else if(userChoice.equals("EDIT")){
			 editTable(userTable);
		 }
		 else if(userChoice.equals("BACK")){
			 run = false;
		 }
	 }
 }
 
 public static void diveTable(){
 
 }
 
 public static void settings(){
 
 }
 
 public static void addTable(ArrayList<DiveStruct> userTable){
	 
	 boolean isValid = false;
	 int diveNum = userTable.size()+1;
	 int rNitrogen = 0;
	 int userDepth;
	 int maxDepthIndex = -1;
	 int userTime;
	 int bottomTimeIndex = -1;
	 int userInterval;
	 int surfaceIntervalIndex = -1;
	 	 
	 Scanner input = new Scanner(System.in);
	 
	 while(isValid == false){
		 try{	
			 if(diveNum == 0){			 
				 System.out.println("Dive number: " + diveNum);
			 
				 System.out.println("Enter your max dive depth in meters."); //When user clicks on the depth area
				 userDepth = input.nextInt();
				 maxDepthIndex = maxDepthIndex(userDepth);
				 if(userDepth <= 0){
					 //Prints message saying you cannot dive that value. (too large or negative value)
					 userDepth = 0;
				 }
				 else{
					 //Allow the value to be saved
				 }
			 
				 //FORCE USERS TO ENTER THINGS IN ORDER
				 System.out.println("Enter bottom time in minutes."); //When user clicks on the bottom time area
				 userTime = input.nextInt();
				 bottomTimeIndex = diveTimeIndex(maxDepthIndex, userTime);
				 if(userTime <= 0){
					 //Prints message saying invalid time (too large or negative value)
					 userTime = 0;
				 }
				 else{
					 //Allow the value to be saved
				 }
				 
				 System.out.println("Enter surface interval in minutes."); //When user clicks on surface interval area
				 userInterval = input.nextInt();
				 surfaceIntervalIndex = surfaceIndex(bottomTimeIndex, userInterval);
				 if(userInterval < 10 || userInterval > 1440){
					 //prints out message saying time is too short or too long (within 24 hours)
				 }
				 else{
					 //Allow the value to be stored
				 }
			 
				 DiveStruct dives = new DiveStruct(diveNum, userDepth, userTime, userInterval, surfaceIntervalIndex);
			 
				 isValid = true; //if user clicks on the save button
				 userTable.add(dives); //if user clicks on the save button
			 }
			 else{
				 try{
					 System.out.println("Dive number: " + diveNum);
		 
					 System.out.println("Enter your max dive depth in meters."); //When user clicks on the depth area
					 userDepth = input.nextInt();
					 maxDepthIndex = maxDepthIndex(userDepth);
					 if(userDepth <= 0){
						 //Prints message saying you cannot dive that value. (too large or negative value)
						 userDepth = 0;
					 }
					 else{
						 //Allow the value to be saved
					 }
					 rNitrogen = FinalValues.nitrogenTable[userTable.get(diveNum-2).getSurfaceIntervalIndex()][maxDepthIndex];
					 
					 //FORCE USERS TO ENTER THINGS IN ORDER
					 System.out.println("Enter bottom time in minutes (if drop down menu, we have to tell user to round up)"); //When user clicks on the bottom time area
					 userTime = input.nextInt();
					 bottomTimeIndex = diveTimeIndex(maxDepthIndex, userTime+rNitrogen);
					 if(userTime <= 0){
						 //Prints message saying invalid time (too large or negative value)
						 userTime = 0;
					 }
					 else{
						 //Allow the value to be saved
					 }
			 
					 System.out.println("Enter surface interval in minutes."); //When user clicks on surface interval area
					 userInterval = input.nextInt();
					 surfaceIntervalIndex = surfaceIndex(bottomTimeIndex, userInterval);
					 if(userInterval < 10 || userInterval > 1440){
						 //prints out message saying time is too short or too long (within 24 hours)
					 }
					 else{
						 //Allow the value to be stored
					 }
		 
					 DiveStruct dives = new DiveStruct(diveNum, userDepth, userTime, userInterval, surfaceIntervalIndex);
		 
					 isValid = true; //if user clicks on the save button
					 userTable.add(dives); //if user clicks on the save button
				 }
			 }
		 }
		 catch(InputMismatchExeption e){
			 System.out.println("Enter only integers (will not need if drop down");
		 }
	 }
	 //Kris testing.  For example if user enters max dive as 35 and dive time as 37, we should do something like
	 //some function that rounds up the user's max depth to the next max depth up to 140feet
	 //Does this whole thing go into a while loop?  I'm not sure how GUI code for menus work with code...
	 
 
 public static void editTable(ArrayList<DiveStruct> userTable){
	 boolean isValid = false;
	 int diveNum = 1;
	 
	 while(isValid == false){
		 System.out.println("Which dive would you like to edit?");
		 //let user pick dive number with scroll down

		 //if user selects delete
		 userTable.removeRange(diveNum-1, userTable.size());
	 }
 }
 
 public static int maxDepthIndex(int userDepth){
	 for(int i = 0; i < FinalValues.maxDepth.length; i++){
		 if(FinalValues.maxDepth[i] >= userDepth){
			 return i;
		 }
	 }
    return -1;
 }
 
 public static int diveTimeIndex(int maxDepthIndex, int userTime){
	 for(int i = 0; i < FinalValues.timeTable[maxDepthIndex].length; i++){
		 if(FinalValues.timeTable[maxDepthIndex][i] >= userTime){
			 return i;
		 }
	 }
	 return -1;
 }
 
 public static int surfaceIndex(int bottomTimeIndex, int userInterval){
	 for(int i = (FinalValues.intervalTable[bottomTimeIndex].length - 1); i >= 0; i--){
		 if(FinalValues.intervalTable[bottomTimeIndex][i] >= userTime){
			 return i;
		 }
	 }
	 return -1;
 }
}
