import java.util.ArrayList;
import java.math.BigDecimal;

public class CheckZeroOne 
{
	ArrayList<Double> peakAxis = new ArrayList<Double>();
	ArrayList<Integer> peakValue = new ArrayList<Integer>();
	ArrayList<Integer> ReversepeakValue = new ArrayList<Integer>();

	
	ArrayList<Double> ReversepeakAxis = new ArrayList<Double>();
	ArrayList<Double> fianlPeakAxisValue = new ArrayList<Double>();


    ArrayList<Double> CutIntervalList = new ArrayList<Double>(); 
    ArrayList<Double> IntervalList = new ArrayList<Double>(); 

    ArrayList<Integer> amount1List = new ArrayList<Integer>();
    ArrayList<Integer> amount2List = new ArrayList<Integer>();
    ArrayList<Integer> amountList = new ArrayList<Integer>();

	ArrayList<Double> tempPeakAxis = new ArrayList<Double>();
    
	ArrayList<Integer> codeList = new ArrayList<Integer>();
	
	int TheAxis = 0;
	int i,j = 0;

    double fistZeroLower = 0; //default
    double fistZeroUpper =  0;
    double fistOneLower = 0;
    double fistOneUpper = 0;
    double fiZeroLower = 0;
    double fiZeroUpper = 0;
    double fiOneLower = 0;
    double fiOneUpper = 0;
	
    
    public void GetZeroOne(int[] priints, double[] priaxis, int[] posints, double[] posaxis, int sizeOfpoints, double stZeroLower, double stZeroUpper, double stOneLower, double stOneUpper, double ZeroLower, double ZeroUpper, double OneLower, double OneUpper)
    {
		FinalPeakPoints GetInterval = new FinalPeakPoints();
		GetInterval.prifinalPeaks(priints, priaxis, sizeOfpoints);
		GetInterval.posfinalPeaks(posints, posaxis);
		GetInterval.combinePriPos();

		peakAxis = GetInterval.getOrigianlPeaksXaxis();
		peakValue = GetInterval.getOrigianlPeakValue();

		System.out.println();
		System.out.println("---Initial Peak XAxis---  >> "+ peakAxis);

		TheAxis = peakAxis.size();
		

		for (int i=TheAxis-1; i>=0; i--)
		{
			ReversepeakAxis.add(peakAxis.get(i));
			ReversepeakValue.add(peakValue.get(i));
		}
		System.out.println("------Reverse Peak XAxis------  >> "+ ReversepeakAxis);
		System.out.println("------Reverse Peak Value------  >> "+ ReversepeakValue);


//================ Interval Calculation ================
		int start = 0;
		while (CutIntervalList.isEmpty()) //if the interval list is null, start from next point
		{
			intervalCalculation(start++, stZeroLower, stZeroUpper, stOneLower, stOneUpper, ZeroLower, ZeroUpper, OneLower, OneUpper);
		}
		
//======================================================		
		
		
		System.out.println();
		System.out.println("------CutInterval of Peak XAxis------  >> "+ CutIntervalList);
		System.out.println("------Interval of Peak XAxis------  >> "+ IntervalList);
		System.out.println("------amount1 Peak XAxis------  >> "+ amount1List);
		System.out.println("------amount2 Peak XAxis------  >> "+ amount2List);
		
		amount1List.addAll(amount2List);
	
		for (int ii=amount1List.size()-1; ii>=0; ii--)
		{
			System.out.println("------Reverse Peak XAxis------  >> "+ ReversepeakAxis.get(amount1List.get(ii)));
			fianlPeakAxisValue.add(ReversepeakAxis.get(amount1List.get(ii)));
		}
		System.out.println("------Final Peak Axis value------  >> "+ fianlPeakAxisValue);

		
	
    }
    
    
  //============== Interval Calculation ======================
    public void intervalCalculation(int start, double stZeroLower, double stZeroUpper, double stOneLower, double stOneUpper, double ZeroLower, double ZeroUpper, double OneLower, double OneUpper)
    {
    	int st = start;
    	
        double destZeroLower = 412; //default
        double destZeroUpper = 417;
        double destOneLower = 406;
        double destOneUpper = 410;
        double deZeroLower = 334;
        double deZeroUpper = 337;
        double deOneLower = 328.1;
        double deOneUpper = 333;
        
        if (stZeroLower==0 && stZeroUpper==0 && stOneLower==0 && stOneUpper==0 && ZeroLower==0 && ZeroUpper==0 && OneLower==0 && OneUpper==0)
        {
            fistZeroLower = destZeroLower; //default
            fistZeroUpper =  destZeroUpper;
            fistOneLower = destOneLower;
            fistOneUpper = destOneUpper;
            fiZeroLower = deZeroLower;
            fiZeroUpper = deZeroUpper;
            fiOneLower = deOneLower;
            fiOneUpper = deOneUpper;
        }
        else
        {
            fistZeroLower = stZeroLower; 
            fistZeroUpper =  stZeroUpper;
            fistOneLower = stOneLower;
            fistOneUpper = stOneUpper;
            fiZeroLower = ZeroLower;
            fiZeroUpper = ZeroUpper;
            fiOneLower = OneLower;
            fiOneUpper = OneUpper;
        }
        
  	

 		for (i=st; i<TheAxis; i++)
		{
			bb:
			for (j=i+1; j<TheAxis; j++)
			{				
				if (i==st)
				{
					BigDecimal amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
					BigDecimal amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
					BigDecimal minus = amount1.subtract(amount2);
					
					double temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
					
					System.out.println("------temp:>> "+ temp + "      i:>> "+ i + "   j:>> " + j);
					if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
					{
						if (ReversepeakValue.get(j)<=ReversepeakValue.get(j+1))
						{
							int tempj = j;

							while(ReversepeakValue.get(j)<ReversepeakValue.get(j+1))
							{
								j = j+1;
							}
							int peakj = j;

							
							for (int k=1; k<=3; k++)
							{
								if ((j+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									peakj = j+k;
								}
							}
							
							j = peakj;
							
							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else if (ReversepeakValue.get(j)>=ReversepeakValue.get(j+1))
						{
							int tempj = j;
							int peakj = j;

							for (int k=1; k<=3; k++)
							{
								if ((j+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									peakj = j+k;
								}
							}
							
							j = peakj;

							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else
						{
							IntervalList.add(Math.abs(minus.doubleValue()));
							CutIntervalList.add(Math.abs(temp));

							amount1List.add(i);
							amount2List.add(j);
							break bb;
						}
					}

				}
				else
				{
					BigDecimal amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
					BigDecimal amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
					BigDecimal minus = amount1.subtract(amount2);
					double temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
					System.out.println("------temp:>> "+ temp + "      i:>> "+ i + "   j:>> " + j);
					if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
					{
						if (ReversepeakValue.get(j) <= ReversepeakValue.get(j+1))
						{
							int tempj = j;

							while(ReversepeakValue.get(j) < ReversepeakValue.get(j+1))
							{
								j = j+1;
							}
							int peakj = j;


							for (int k=1; k<=3; k++)
							{
								if ((j+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									peakj = j+k;
								}
							}
							
							j = peakj;

							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
								if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}

						}
						else if (ReversepeakValue.get(j)>=ReversepeakValue.get(j+1))
						{
							int tempj = j;
							int peakj = j;

							for (int k=1; k<=3; k++)
							{
								if ((j+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									peakj = j+k;
								}
							}
							
							j = peakj;

							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else
						{
							IntervalList.add(Math.abs(minus.doubleValue()));
							CutIntervalList.add(Math.abs(temp));

							amount1List.add(i);
							amount2List.add(j);
							break bb;
						}

					}
				}
			}	
			i = j-1;
			j = i;
		}


/*
    	
 //============== Final Working Code===================   	
for (i=st; i<TheAxis; i++)
		{
			bb:
			for (j=i+1; j<TheAxis; j++)
			{				
				if (i==st)
				{
					BigDecimal amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
					BigDecimal amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
					BigDecimal minus = amount1.subtract(amount2);
					
					double temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
					
					System.out.println("------temp:>> "+ temp + "      i:>> "+ i + "   j:>> " + j);
					if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
					{
						if (ReversepeakValue.get(j)<=ReversepeakValue.get(j+1))
						{
							int tempj = j;

							while(ReversepeakValue.get(j)<ReversepeakValue.get(j+1))
							{
								j = j+1;
							}
							
							
							for (int k=1; k<=2; k++)
							{
								if ((tempj+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									tempj = j+k;
								}
							}
							


							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else if (ReversepeakValue.get(j)>=ReversepeakValue.get(j+1))
						{
							int tempj = j;

							for (int k=1; k<=2; k++)
							{
								if ((tempj+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									tempj = j+k;
								}
							}
							


							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fistZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistZeroUpper)) || (fistOneLower <= Math.abs(temp) &&  (Math.abs(temp) <= fistOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else
						{
							IntervalList.add(Math.abs(minus.doubleValue()));
							CutIntervalList.add(Math.abs(temp));

							amount1List.add(i);
							amount2List.add(j);
							break bb;
						}
					}

				}
				else
				{
					BigDecimal amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
					BigDecimal amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
					BigDecimal minus = amount1.subtract(amount2);
					double temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
					System.out.println("------temp:>> "+ temp + "      i:>> "+ i + "   j:>> " + j);
					if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
					{
						if (ReversepeakValue.get(j) <= ReversepeakValue.get(j+1))
						{
							int tempj = j;

							while(ReversepeakValue.get(j) < ReversepeakValue.get(j+1))
							{
								j = j+1;
							}
							

							for (int k=1; k<=2; k++)
							{
								if ((tempj+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									tempj = j+k;
								}
							}
							


							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
								if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}

						}
						else if (ReversepeakValue.get(j)>=ReversepeakValue.get(j+1))
						{
							int tempj = j;

							for (int k=1; k<=2; k++)
							{
								if ((tempj+k) >= ReversepeakValue.size())
								{
									break;
								}
								else if (ReversepeakValue.get(j) < ReversepeakValue.get(j+k))
								{
									tempj = j+k;
								}
							}
							


							while(j >=tempj)
							{
								amount1 = BigDecimal.valueOf(ReversepeakAxis.get(i));
								amount2 = BigDecimal.valueOf(ReversepeakAxis.get(j));
								minus = amount1.subtract(amount2);
								temp = Math.round(Math.abs(minus.doubleValue())*1)/1.0;
							
								if ((fiZeroLower <= Math.abs(temp) &&  (Math.abs(temp) <= fiZeroUpper))  || (fiOneLower <= Math.abs(temp) &&  (Math.abs(temp) <=  fiOneUpper)) )
								{
									IntervalList.add(Math.abs(minus.doubleValue()));
									CutIntervalList.add(Math.abs(temp));

									amount1List.add(i);
									amount2List.add(j);
									break bb;
								}
								else
								{
									j = j-1;
								}
							}
						}
						else
						{
							IntervalList.add(Math.abs(minus.doubleValue()));
							CutIntervalList.add(Math.abs(temp));

							amount1List.add(i);
							amount2List.add(j);
							break bb;
						}

					}
				}
			}	
			i = j-1;
			j = i;
		}
*/

    }
    
    
    
    public void checkFinalPeak()
    {
		
		for (Double value : peakAxis)
		{
			tempPeakAxis.add(fianlPeakAxisValue.contains(value)?value:0);
		}
		
		System.out.println("Peak XAxis------  >> "+ peakAxis);
		System.out.println("Temp Peak XAxis------  >> "+ tempPeakAxis);
		System.out.println("Temp Peak Value------  >> "+ peakValue);

    }
    
    
// ================Convert the interval into CODE===============================================    
    
    public void FinalCodeList()
    {
		
		for (int i=0; i<CutIntervalList.size(); i++)
		{
			if ((fistZeroLower <= CutIntervalList.get(i) &&  CutIntervalList.get(i) <= fistZeroUpper)) 
			{
				codeList.add(0);
			}
			else if ((fistOneLower <= CutIntervalList.get(i) &&  CutIntervalList.get(i) <= fistOneUpper))
			{
				codeList.add(1);
			}
			else if ((fiZeroLower <=  CutIntervalList.get(i) &&   CutIntervalList.get(i) <= fiZeroUpper))
			{
				codeList.add(0);
			}
			else if ((fiOneLower <= CutIntervalList.get(i) &&  CutIntervalList.get(i) <=  fiOneUpper))
			{
				codeList.add(1);
			}
		}
		
		System.out.println("=====CODE LIST  >> "+ codeList);

    }
    
	public ArrayList<Integer> returnCodeList() 
	{
		return codeList;
	}
	
	public ArrayList<Double> returnPeakAxis() 
	{
		return peakAxis;
	}
	
	public ArrayList<Double> returntempPeakAxis() 
	{
		return tempPeakAxis;
	}
	
	public ArrayList<Integer> returnpeakValue() 
	{
		return peakValue;
	}
	


}
