package com.anavi.olinuxinoromannumbers;

public class RomanConverter 
{
    	
	//Array with Roman values
    private static final String[] RCODE = {"M", "CM", "D", "CD", "C", "XC", "L",
                                           "XL", "X", "IX", "V", "IV", "I"};
    
    // Array with decimal values
    private static final int[]    BVAL  = {1000, 900, 500, 400,  100,   90,  50,
                                           40,   10,    9,   5,   4,    1};
        
    /**
     * Convert binary value to Roman number and return it as a string
     * 
     * @param nValue decimal value to be converted
     * 
     * @return String Roman number as a string
     * @throws IllegalArgumentException if value is out of range
     */
    public static String toRoman(int nValue) 
    {
    	//Validate input value
        if ( (0 >= nValue) || (4000 <= nValue) ) 
        {
            throw new IllegalArgumentException("Out of range.");
        }
        
        //Loop through values starting from the highest value 
        //subtracting from the binary value while adding to the string
        //with the Roman number
        String sRoman = "";
        for (int nIter = 0; nIter < RCODE.length; nIter++) 
        {
            while (nValue >= BVAL[nIter]) 
            {
                nValue -= BVAL[nIter];
                sRoman  += RCODE[nIter];
            }
        }
        return sRoman;
    }
    //------------------------------------------------------------------------------

}
