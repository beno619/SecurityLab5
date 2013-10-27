package fidel.benson.lab5;

import java.math.BigInteger;
import java.util.Random;

public class SolovayStrassen {
	
	public static boolean PrimeTest(BigInteger num)
	{
		
		for(int i = 0;i<50;i++)
		{
			BigInteger a;
			
			while(true)
			{
				a = new BigInteger(num.bitLength(),new Random(System.currentTimeMillis()));
				
				if(a.compareTo(num) == 0 || a.compareTo(num) == 1)
				{
					continue;
				}
				else
				{
					 SolovayStrassenRound(a,num);
				}
			}
		
		
		
		}
		
		return false;
		
		}
	

	

	private static boolean SolovayStrassenRound(BigInteger a, BigInteger n) {
	
		boolean check1,check2 = true;
		BigInteger val1,val2;
		
		// (n - 1) / 2	
		BigInteger exponent = n.subtract(BigInteger.ONE).divide(new BigInteger("2"));
		
		//System.out.print(legendre(exponent,n));
		
		val1 = a.modPow(exponent, n);
		
		//System.out.print(legendre(val1,n));
		
		val2 = a.divide(n).mod(n);
		//System.out.print(legendre(val2,n));
		
		System.out.println(val1 +"\n"+ val2);
		
		
		return true;
	}
	public static int legendre(BigInteger x,BigInteger n)
	{
		if (x.equals(BigInteger.ONE)) {
		      return 1;
		    } else if (x.equals(n.subtract(BigInteger.ONE))) {
		      return -1;
		    } else {
		      throw new ArithmeticException("Error computing the Legendre symbol.");
		    }
	}
}
