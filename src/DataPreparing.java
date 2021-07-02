import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataPreparing {
	
	ArrayList<Integer> ints = new ArrayList<Integer>(); 
	ArrayList<Double> Xaxis = new ArrayList<Double>(); 
	
	ArrayList<Integer> priInts = new ArrayList<Integer>(); 
	ArrayList<Integer> posInts = new ArrayList<Integer>();
	ArrayList<Double> priXaxis = new ArrayList<Double>(); 
	ArrayList<Double> posXaxis = new ArrayList<Double>();

	public void DataLoad(int[] Xvalue, double[] Oaxis) throws IOException 
	{
        double[] axis= Oaxis;
        int[] value = Xvalue;
        
        System.out.println("Input Data Xaxis       >> "+ Arrays.toString(axis));
        System.out.println("include negative Value >> "+ Arrays.toString(value));
        
//-----------------------Negative to Zero--------------------------------------        
        //negative to zero
        for (int i=0;i<value.length;i++)
        {
        	if (value[i]<0)
        		value[i]=0;
        	ints.add(value[i]);
        }
        
        for (int i=0;i<axis.length;i++)
        {
        	Xaxis.add(axis[i]);
        }
        
        System.out.println("Exclude negative Value >> "+ Arrays.toString(value));
        System.out.println("Input Value Size       >> "+ value.length);
        System.out.println();  
	}
	
	
	public void DataDivision(int position)
	{
 //-------------------------divide the input into two parts----------------------
		ArrayListToIntArray toArray = new ArrayListToIntArray();
		
		int[] value = toArray.ListToIntArray(ints);
        double[] axis = toArray.ListToDoubleArray(Xaxis);

		
		
        int pricount = 0;
        int poscount = 0;
        int defaultposition = 1790;
        float divideposition = 0;
        
        if (position == 0)
        {
        	divideposition = (float) (defaultposition*100.0/2000);
        }
        else
        {
        	divideposition = (float) (position*100.0/2000);
        }
        System.out.println("divide position: " + divideposition + "      axis length:>> " + axis.length);

        int index = (int) (axis.length * divideposition/100.0);
        System.out.println("dividing position:>> " + index);
        System.out.println("dividing position axis:>> " + axis[index]);

        for (int i=0;i<axis.length;i++)
        {
        	if (axis[i]<=axis[index])  //the position for dividing
        	{
        		pricount++;
        	}
        	else
        	{
        		poscount++;
        	}
        }
        System.out.println("Pricount:>> "+pricount + "     poscount:" + poscount);

        
        
        for (int i=0;i<pricount;i++)
        {

        	priInts.add(value[i]);
        	priXaxis.add(axis[i]);

        }
        
        
        for (int i=0;i<poscount;i++)
        {
        	posInts.add(value[i+pricount]);
        	posXaxis.add(axis[i+pricount]);
        }
        

        System.out.println("priInts size:>> " + priInts.size() + "     posints size:" + posInts.size());
	}
	

	public double[] returnPriaxis() 
	{
		ArrayListToIntArray toArray = new ArrayListToIntArray();
        double[] axis = toArray.ListToDoubleArray(priXaxis);
		return axis;
	}
	
	
	public double[] returnPosaxis() 
	{
		ArrayListToIntArray toArray = new ArrayListToIntArray();
        double[] axis = toArray.ListToDoubleArray(posXaxis);
		return axis;
	}
	
	public int[] returnPriInts() 
	{
		ArrayListToIntArray toArray = new ArrayListToIntArray();
		int[] value = toArray.ListToIntArray(priInts);
		return value;
	}
	
	public int[] returnPosInts() 
	{
		ArrayListToIntArray toArray = new ArrayListToIntArray();		
		int[] value = toArray.ListToIntArray(posInts);
		return value;
	}
	
	public void ListInitialize()
	{
		ints.clear(); 
		Xaxis.clear(); 
		
		priInts.clear(); 
		posInts.clear();
		priXaxis.clear(); 
		posXaxis.clear();
	}
	

	
}
