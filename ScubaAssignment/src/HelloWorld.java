import java.util.*;

public class HelloWorld {
 public static void main (String[] args){
	 
	 boolean run = true;
	 String userChoice;
	 
	 System.out.println("DISCLAIMER:  NOT TO BE USED ON REAL DIVES!");
	 System.out.println("Hello World!");
	 DiveStruct Dives = new DiveStruct();
	 ArrayList<Dives> userTable = new ArrayList<Dives>();
	 Scanner input = new Scanner(System.in);
	 
	 while(run == true){
		 System.out.println("Select menu option (this wont be printed on the GUI");
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
		 					  
		 	default:		  System.out.println("Invalid Choice (shoudln't be in GUI");
		 					  break;
		 }
	 }
	 //Testing
 }
 
 public void homePage(){
	 
 }
 
 public void diveLog(ArrayList<Dives> userTable){
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
 
 public void addTable(ArrayList<Dives> userTable){
	 
	 int rNitrogen = 0;
	 int maxDepth = 0;
	 int maxDepthIndex = -1;
	 int diveTime = 0;
	 int pGroupIndex = -1;
	 char pGroup = null;
	 char newpGroup = null;
	 
	 //Kris testing.  For example if user enters max dive as 35 and dive time as 37, we should do something like
	 //some function that rounds up the user's max depth to the next max depth up to 140feet
	 //Does this whole thing go into a while loop?  I'm not sure how GUI code for menus work with code...
	 //
	 //
	 //for(int i = 0; i < 12; i++) {
	 //    if(FinalValues.maxDepth[i] <= maxDepth) {
	 //        maxDepthIndex = i;
	 //if(maxDepthIndex > 0) {
	 //    if(first dive) {
	 //        for(int i = 0; i < 26; i++) {
	 //            if(FinalValues.nitrogenTable[maxDepthIndex][i] <= diveTime) {
	 //                pGroupIndex = i;
     //            }
	 //			   else
	 //                System.out.println("Invalid input or max time is too long.");
	 //            }
	 //        }
	 //    }
	 //    else {
	 //        newpGroup = FinalValues.tablethatdoesntexistyet[pGroup][dive interval];
	 //    }
	 //}
	 //else {
	 //    System.out.println("Invalid input or max depth is too deep (max is 140 feet/42.6 meters)");
	 //    System.out.println("Please reinput a valid depth.");
	 //}
 }
 
 public void editTable(ArrayList<Dives> userTable){
	 
 }
}
