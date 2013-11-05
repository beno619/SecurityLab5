package fidel.benson.lab5;

import java.math.BigInteger;
import java.util.Random;

public class LinearFeedbackSR {
	
	private BigInteger p;
	char[] tempTapArray;
	int[] tapArray;
	private String binaryString;
	int numLength;
	char[] charArray;
	
	public LinearFeedbackSR()
	{
		// generate random seed that is probably prime
		Random gene = new Random(System.currentTimeMillis());
		p = BigInteger.probablePrime(1024, gene);
		
		System.out.print(p + "\n");

		// set up storage variable / arrays
		// .toString gives binary representation of my random BigInteger p
		
		binaryString = p.toString(2);
		tempTapArray = new char[10];
		tapArray = new int[10];
		numLength = binaryString.length();
		
		
		// generate 10 random tap bits from binaryString and store in char array.
		
		for(int i =0; i<10;i++)
		{
		
			Random gene2 = new Random();
			int ranNum = gene2.nextInt((binaryString.length() - 0) + 1) + 0;
			tempTapArray[i] = binaryString.charAt(ranNum);
			
		}	
		
		
		// convert to char array for easy comparison with tap values
		charArray = binaryString.toCharArray();
		
		generateLFSR(tempTapArray,charArray,numLength);
		
	}

	private BigInteger generateLFSR(char[] tempTapArray2, char[] charArray2, int numLength2) {
		
		char next;
		double tmp;
		char[] a = new char[numLength2];
		next = charArray2[numLength2 - 1];
		
		// array xor's most significant bit against 10 tap's
		for(int i = 0; i < 1;i++)
		{
			for(int j = 0; j < 10;j++)
			{
				if((next ==  tempTapArray2[i]))
				{
					next = '0';
				}
				else
				{
					next = '1';
				}
				
						
			}
		}
		
		// Array shifts bit sequence to the left 
		for(int x = numLength2 - 1; x > 0; x--)
		{
			a[x] = charArray2[x - 1];
		}
		
		// shift xor'd most significant bit to beginning of bit sequence 
		a[0] = next;
		
		
		String temp = new String(a);
		
		BigInteger l = new BigInteger(temp, 2);

		System.out.println(l);
		return l;
	}
	
	public static int integerfrmbinary(String str){
	    double j=0;
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)== '1'){
	         j=j+ Math.pow(2,str.length()-1-i);
	     }

	    }
	    return (int) j;
	}
	

}

