public class diveFunctions{
   public diveFunctions(){
      //Default constructor
   }
   
   public int maxDepthIndex(int userDepth){  //Figures out the max depth index (row) based off of user entered depth
	   for(int i = 0; i < FinalValues.maxDepth.length; i++){
	      if(FinalValues.maxDepth[i] >= userDepth){
	         return i;
		   }
	   }
      return -1;
   }
 
   public int diveTimeIndex(int maxDepthIndex, int userTime){  //Figures out the dive time index (column) based off of user entered time
	   for(int i = 0; i < FinalValues.timeTable[maxDepthIndex].length; i++){
		   if(FinalValues.timeTable[maxDepthIndex][i] >= userTime){
		      return i;
		   }
	   }
	   return -1;
   }
 
   public int surfaceIndex(int bottomTimeIndex, int userInterval){  //Figures out the surface interval index (row) based off of user entered time
	   for(int i = (FinalValues.intervalTable[bottomTimeIndex].length - 1); i >= 0; i--){
	      if(FinalValues.intervalTable[bottomTimeIndex][i] >= userInterval){
	         return i;
	      }
	   }
	   return -1;
   }
}