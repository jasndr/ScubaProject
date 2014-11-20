
public interface FinalValues {

	//CHANGING MOST OF THESE VALUES.  DO NOT USE FOR FINAL TABLE!
	
	//Alphabet to let the program know which letter equals which array number
	public final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};

	//Max depth number to compare user input as well as knowing which depth equals which array number
	public final int[] maxDepth = {12, 15, 18, 21, 24, 27, 30, 33, 36, 40};
	
	//The dive table for seeing the amount dive time based off of pressure group and max depth
	public final int[][] timeTable = {{5, 15, 25, 30, 40, 50, 70, 80, 100, 110, 130},
											{0}};
	
	//Dive interval portion of the table in minutes
	public final int[][] intervalTable = {{1440},
											{1440, 200}};
	
	//Residual nitrogen times
	public final int[][] nitrogenTable = {{7, 6, 5, 4, 4, 3, 3, 3, 3, 3},
											{17, 13, 11, 9, 8, 7, 7, 6, 6, 6}};		
	}
//}