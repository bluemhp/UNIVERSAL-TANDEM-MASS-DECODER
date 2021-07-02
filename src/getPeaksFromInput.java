import java.util.ArrayList;

public class getPeaksFromInput {
    ArrayList<Integer> peakArr = new ArrayList<Integer>();
    ArrayList<Integer> posArr = new ArrayList<Integer>(); 
    ArrayList<Double> originalposArr = new ArrayList<Double>(); 

	//public ArrayList<Integer> getPeaks(int[] arr) 
	public void getPeaks(int[] arr) 
	{
 
	    //Get the size of the Array
	    int sizeArr = arr.length;
	    //System.out.println("Input sizeArr >> " + sizeArr + " Input sizeArr-1 >> " + (sizeArr-1)); 
/*    
	    for ( int index = 1; index < sizeArr-1; index++)
	    {	        
	    	
	    	if((arr[index]) < (arr[index-1]) && (index == 1))
	    	{	          
	    		//System.out.println(" Peak >>> " + arr[index-1] + "   Position >>> " + (index-1));  
	    		posArr.add(index-1);
	    		peakArr.add(arr[index-1]); 
	    		// Dealing with plateaus        
	    	}
	    	if((arr[index]) > (arr[index-1]) && (arr[index+1]) <  (arr[index]))
	    	{	          
	    		//System.out.println(" Peak >>> " + arr[index] + "   Position >>> " + index);  
	    		posArr.add(index);
	    		peakArr.add(arr[index]); 
	    		// Dealing with plateaus        
	    	}
	    	else if ((arr[index]) > (arr[index-1]) && (arr[index+1]) ==  (arr[index]))
	    	{
	    		//System.out.println(" Peak >>> " + arr[index] + "   Position >>> " + index);  
	    		posArr.add(index);
	    		peakArr.add(arr[index]);     
	    	}
	    	else if ((arr[index]) < (arr[index+1]) && ((index+1) == (sizeArr-1)))
	    	{
	    		//System.out.println(" Peak >>> " + arr[index+1] + "   Position >>> " + (index+1));  
	    		posArr.add(index+1);
	    		peakArr.add(arr[index+1]);     
	    	}
	    }
	    
*/	    

		for ( int index = 0; index <= sizeArr-1; index++)
	    {	        
	    	
	    	if((index == 0) && (arr[index+1]) < (arr[index]))
	    	{	          
	    		//System.out.println(" Peak >>> " + arr[index] + "   Position >>> " + (index));  
	    		posArr.add(index);
	    		peakArr.add(arr[index]); 
	    		// Dealing with plateaus        
	    	}
	    	else if (0 < index && index < sizeArr-1)
	    	{
	    		if((arr[index]) > (arr[index-1]) && (arr[index+1]) < (arr[index]))
	    		{	          
	    			//System.out.println(" Peak >>> " + arr[index] + "   Position >>> " + index);  
	    			posArr.add(index);
	    			peakArr.add(arr[index]); 
	    			// Dealing with plateaus        
	    		}
	    		else if ((arr[index]) > (arr[index-1]) && (arr[index]) ==  (arr[index+1]))
	    		{
	    			//System.out.println(" Peak >>> " + arr[index] + "   Position >>> " + index);  
	    			posArr.add(index);
	    			peakArr.add(arr[index]);     
	    		}
	    	}
	    	else if (index == (sizeArr-1))
	    	{
	    		if ((arr[index]) > (arr[index-1]))
	    		{
	    			//System.out.println(" Peak >>> " + arr[index+1] + "   Position >>> " + (index+1));  
	    			posArr.add(index);
	    			peakArr.add(arr[index]);     
	    		}
	    	}
	    }
	    
	    
 
	    
	    
	    
	   // System.out.println("First Peak Pos Array >> "+ posArr);
	    //System.out.println("First Peak value Array >> " + peakArr);
	    //return posArr;
	}
	
	public ArrayList<Integer> getPeaksArray() 
	{
		return peakArr;
	}
	
	public ArrayList<Integer> getPeaksXaxis() 
	{
		return posArr;
	}
	
	public ArrayList<Double> OrigianlPeaksXaxis(double[] originalAxis) 
	{
		for (int i=0; i<posArr.size();i++)
		{
			originalposArr.add(originalAxis[posArr.get(i)]);
		}
		return originalposArr;
	}


}
