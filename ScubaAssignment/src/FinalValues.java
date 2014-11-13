
public interface FinalValues {

	//CHANGING MOST OF THESE VALUES.  DO NOT USE FOR FINAL TABLE!
	
	//Alphabet to let the program know which letter equals which array number
	public final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	//Max depth number to compare user input as well as knowing which depth equals which array number
	public final int[] maxDepth = {35, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
	
	//The dive table for seeing the amount of residual nitrogen based off of pressure group and max depth
	public final int[][] nitrogenTable = {{10, 19, 25, 29, 32, 36, 40, 44, 48, 52, 57, 62, 67, 73, 79, 85, 92, 100, 108, 117, 127, 139, 152, 168, 188, 205},
									{9, 16, 22, 25, 27, 31, 34, 37, 40, 44, 48, 51, 55, 60, 64, 69, 74, 79, 85, 91, 97, 104, 111, 120, 129, 140},
									{7, 13, 17, 19, 21, 24, 26, 28, 31, 33, 36, 39, 41, 44, 47, 50, 53, 57, 60, 63, 67, 71, 75, 80, null, null},
									{6, 11, 14, 16, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 42, 44, 47, 49, 52, 54, 55, null, null, null},
									{5, 9, 12, 13, 15, 16, 18, 19, 21, 22, 24, 26, 27, 29, 31, 33, 35, 36, 38, 40, null, null, null, null, null, null},
									{4, 8, 10, 11, 13, 14, 15, 17, 18, 19, 21, 22, 23, 25, 26, 28, 29, 30, null, null, null, null, null, null, null, null},
									{4}};
	
	//Dive interval portion of the table in minutes
	public final int[][] intervalTable = {{180},
											{47, 228}};
	}
}