package love.code.test;

public class ActiveAndInactive {

	// cells[] - store current status  
	// of cells n - Number of cells 
	// temp[] - to perform intermediate operations 
	// k - number of days 
	// active - count of active cells after k days 
	// inactive - count of active cells after k days 
	static void activeAndInactive(boolean cells[],   int n, int k) 
	{ 
	    // copy cells[] array into temp [] array 
	    boolean temp[] = new boolean[n]; 
	    for (int i = 0; i < n; i++) 
	    temp[i] = cells[i]; 
	  
	    // Iterate for k days 
	    while (k-- > 0) { 
	          
	    // Finding next values for corner cells 
	    temp[0] = false ^ cells[1]; 
	    temp[n - 1] = false ^ cells[n - 2]; 
	  
	    // Compute values of intermediate cells 
	    // If both cells active or inactive, then  
	    // temp[i]=0 else temp[i] = 1. 
	    for (int i = 1; i <= n - 2; i++) 
	        temp[i] = cells[i - 1] ^ cells[i + 1]; 
	  
	    // Copy temp[] to cells[] for next iteration 
	    for (int i = 0; i < n; i++) 
	        cells[i] = temp[i]; 
	    } 
	  
	    // count active and inactive cells 
	    int active = 0, inactive = 0; 
	    for (int i = 0; i < n; i++) 
	    if (cells[i] == true) 
	        active++; 
	    else
	        inactive++; 
	  
	    System.out.print("Active Cells = " + active + ", " +  
	                     "Inactive Cells = " + inactive); 
	} 
	
	
	// Driver code 
	public static void main(String[] args)  
	{ 
	    boolean cells[] = {false, true, false, true, 
	                       false, true, false, true}; 
	    int k = 3; 
	    int n = cells.length; 
	    activeAndInactive(cells, n, k); 
	} 
}
