import java.util.List;
public class ArrayListToIntArray 
{
	public int[] ListToIntArray(List<Integer> list)
	{
		int[] arr = new int[list.size()];
		int index= 0;
		for(int a : list)
		{
			arr[index++] = a;
		}
		return arr;
	}
	
	public double[] ListToDoubleArray(List<Double> list)
	{
		double[] arr = new double[list.size()];
		int index= 0;
		for(double a : list)
		{
			arr[index++] = a;
		}
		return arr;
	}

}
