import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;


class LargestFibboSubSeq {
	public static void main (String[] args) {
	    Scanner cin = new Scanner(System.in);
	    int totalTestCase = cin.nextInt();
	    cin.nextLine(); 
	    int arrayLength=0;
	    String inputArrayStr;
	    for(int i=0;i<totalTestCase;++i)
	    {
	         arrayLength = cin.nextInt();
	         cin.nextLine(); 
	         inputArrayStr = cin.nextLine();
	         
	         BigInteger[] inputArr = getIntArrayFromString(inputArrayStr);
	         BigInteger[] fibbo = getFibonacci(arrayLength);
	         printResult(fibbo,inputArr);
	    }
	}
	
	public static BigInteger[] getFibonacci(int upperLimit)
	{

	    BigInteger[] result = new BigInteger[upperLimit];

	    BigInteger a = BigInteger.valueOf(0); 
        BigInteger b = BigInteger.valueOf(1); 
	    
        for(int i=0;i<upperLimit;++i)
        {
            result[i] = a;
            BigInteger sumOfPrevTwo = a.add(b);
            a = b;
            b = sumOfPrevTwo;
        }
	    
	   // System.out.println(java.util.Arrays.toString(result));
	    return result;
	}
	
	public static BigInteger[] getIntArrayFromString(String inputStr)
	{
	   // System.out.println(inputStr);
	    String[] str = inputStr.split(" ");
	    BigInteger[] result = new BigInteger[str.length];
        for (int i=0; i<str.length; i++)
            result[i] = BigInteger.valueOf(Long.parseLong(str[i]));
            
 	  //  System.out.println(java.util.Arrays.toString(result));
	    return result;
	}
	
	public static void printResult(BigInteger[] fibSeries, BigInteger[] inputArr)
	{
	   System.out.println(java.util.Arrays.toString(fibSeries));
	   // System.out.println(java.util.Arrays.toString(inputArr));
	    
	    for(int i=0; i<inputArr.length;++i)
	    {
	        if (binarySearch(fibSeries,0,inputArr.length-1,inputArr[i]))
	            System.out.print(inputArr[i] +" ");
	    }
	    System.out.print("\n");
	}
	
	public static boolean binarySearch(BigInteger[] arr, int l,int r,BigInteger x)
	{
	    
        if (r >= l) 
        { 
            int mid = l + (r - l) / 2; 
  
            if (arr[mid].compareTo(x)==0) 
                return true; 
  
            if (arr[mid].compareTo(x) > 0) 
                return binarySearch(arr, l, mid - 1, x);
            else
                return binarySearch(arr, mid + 1, r, x); 
        } 
  
        return false; 
	    
	}
	
}
