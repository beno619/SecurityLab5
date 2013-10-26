package fidel.benson.lab5;

import java.math.BigInteger;
import java.util.Random;

public class BlumBlum {
	
	private BigInteger p,q,n,s;
	public static BigInteger x;
	
	private boolean flag1 =false;
	private boolean flag2 = false;
	private boolean flag3 = false;
	
	private static BigInteger remainder = new BigInteger("3");
	private static BigInteger mod = new BigInteger("4");
	
	public BlumBlum()
	{
		
		Random gene = new Random(System.currentTimeMillis());
		p = BigInteger.probablePrime(1024, gene);
		
		// generate two prime numbers that have the same remainder 3 when devided by 4
		// Choose two large primes p and q such that p % 4 = q % 4 = 3.
		
		while(flag1 == false)
		{
			p = p.nextProbablePrime();
			
			if(p.mod(mod).equals(remainder))
					flag1 = true;
			
		}
		
		q = p;
		
		while(flag2 == false)
		{
			q = q.nextProbablePrime();
			
			if(q.mod(mod).equals(remainder))
					flag2 = true;	

		}
		
		// n = p * q
		
		n = p.multiply(q);
		
		Random gene2;
		
		// generate a random number s that is relatively prime (coprime)to n
		
		while(flag3 == false)
		{
			gene2 = new Random(System.currentTimeMillis());
			s = new BigInteger (1024, gene2);
			
			if(s.gcd(n).equals(BigInteger.ONE))
					flag3 = true;
		}
		
		// x is the seed and should be greater than the square root of n
		x = (s.multiply(s)).mod(n);
		
	}
	
	public BigInteger generateRondomNumber()
	{
		BigInteger x0 = (x.multiply(x)).mod(n);
		x = x0;
		return x0;
	}

}
