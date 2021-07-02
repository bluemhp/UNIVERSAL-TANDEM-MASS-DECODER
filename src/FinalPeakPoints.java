import java.util.ArrayList;

public class FinalPeakPoints {
   
    ArrayList<Integer> pripeakValue = new ArrayList<Integer>();
    ArrayList<Integer> pripeakPosition = new ArrayList<Integer>(); 
    ArrayList<Double> pripeakOriginalAxis = new ArrayList<Double>(); 
    
    ArrayList<Integer> pospeakValue = new ArrayList<Integer>();
    ArrayList<Integer> pospeakPosition = new ArrayList<Integer>(); 
    ArrayList<Double> pospeakOriginalAxis = new ArrayList<Double>(); 

	
	public void prifinalPeaks(int[] ints, double[] axis, int sizeOfpoints)
	{  
		int[] inputvalue = ints;
		double[] inputaxis = axis;
		
		
		
		//int fisizeOfpoints = sizeOfpoints;

		
        while (true) 
        {
    		getPeaksFromInput get = new getPeaksFromInput();
    		
    		get.getPeaks(inputvalue);
    		pripeakValue = get.getPeaksArray();
            pripeakPosition = get.getPeaksXaxis();
            pripeakOriginalAxis = get.OrigianlPeaksXaxis(inputaxis); 
            
    		//System.out.println("Peak value Axis >> "+ peakPosition);
            //System.out.println("Peak Value      >> "+ peakValue);
    		//System.out.println("Original XAxis  >> "+ peakOriginalAxis);
            System.out.println(pripeakPosition.size() + "  " + pripeakValue.size() + "  " + pripeakOriginalAxis.size());
            System.out.println();

            // define number of generated peaks
            //*************************************************************************
        	if (pripeakPosition.size() <= sizeOfpoints)
        	{
        		break;
        	}
        	else
        	{
        		ArrayListToIntArray IntArray = new ArrayListToIntArray();
        		
        		inputvalue = IntArray.ListToIntArray(pripeakValue);
                inputaxis = IntArray.ListToDoubleArray(pripeakOriginalAxis);

                //peakPosition = get.getPeaks(newArray);
        	}
        }
	}
        
    public void posfinalPeaks(int[] ints, double[] axis)
    {  
    	int[] inputvalue = ints;
    	double[] inputaxis = axis;
    		
        while (true) 
        {
        	getPeaksFromInput get = new getPeaksFromInput();
        		
        	get.getPeaks(inputvalue);
        	pospeakValue = get.getPeaksArray();
        	pospeakPosition = get.getPeaksXaxis();
        	pospeakOriginalAxis = get.OrigianlPeaksXaxis(inputaxis); 
                
        	//System.out.println("Peak value Axis >> "+ peakPosition);
            //System.out.println("Peak Value      >> "+ peakValue);
        	//System.out.println("Original XAxis  >> "+ peakOriginalAxis);
            //System.out.println(pospeakPosition.size() + "  " + pospeakValue.size() + "  " + pospeakOriginalAxis.size());
            System.out.println();

            // define number of generated peaks
            //*************************************************************************
            if (pospeakValue.size()==1)
            {
                System.out.println("post value and axis"+ pospeakValue + "  " + pospeakOriginalAxis);

            	break;
            }
            else
            {
            	ArrayListToIntArray IntArray = new ArrayListToIntArray();
            		
            	inputvalue = IntArray.ListToIntArray(pospeakValue);
                inputaxis = IntArray.ListToDoubleArray(pospeakOriginalAxis);

                //peakPosition = get.getPeaks(newArray);
            }
            	//*************************************************************************           		
         }      
	}
	
    public void combinePriPos() 
    {
		pripeakValue.addAll(pospeakValue);
        pripeakPosition.addAll(pospeakPosition);
        pripeakOriginalAxis.addAll(pospeakOriginalAxis); 
        System.out.println("Combined last value: "+ pripeakValue.get(pripeakValue.size()-1) + "    last axis:" + pripeakOriginalAxis.get(pripeakValue.size()-1));

    }
    	
        
        
	
	public ArrayList<Double> getOrigianlPeaksXaxis() 
	{
		return pripeakOriginalAxis;
	}
	
	
	public ArrayList<Integer> getOrigianlPeakValue() 
	{
		return pripeakValue;
	}


}
