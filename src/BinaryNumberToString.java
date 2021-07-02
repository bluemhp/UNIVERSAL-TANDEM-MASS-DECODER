import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryNumberToString 
{
	String codestring = "";
	String codeToText = "";
	int count = 0;

	public void CombineCodes(int[] code)
	{
		for(int ii : code) //the length of one code is 4
		{
			codestring+=Integer.toString(ii);
			count++;
        }

		if ((count % 8) == 0) //combine two codes into one, length is 8
		{
			codestring = codestring + " ";
		}
        System.out.println(codestring);

	}
	
//=============Binary to Text=======================
	
    public void CodeToText () {

        //String input = "01001000 01100101 01101100 01101100 01101111";

        // Java 8 makes life easier
        codeToText = Arrays.stream(codestring.split(" "))
                .map(binary -> Integer.parseInt(binary, 2))
                .map(Character::toString)
                .collect(Collectors.joining()); // cut the space

        System.out.println("Text:>>" + codeToText);

    }
    
	public String CheckCodes(int[] code)
	{
		String codeCheck="";
		for(int ii : code) //the length of one code is 4
		{
			codeCheck+=Integer.toString(ii);
        }

        return codeCheck;

	}
    
    public String returnCodeString()
    {
    	return codestring;
    }
    
    public String returnText()
    {
    	return codeToText;
    }
    
	public void CodeTextInitialize()
	{
		codestring = ""; 
		codeToText = ""; 
		count = 0;
		

	}

}
