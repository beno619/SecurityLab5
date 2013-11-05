package fidel.benson.lab5;

import java.math.BigInteger;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearFeedbackSR newLFSR = new LinearFeedbackSR();
		
		BlumBlum number = new BlumBlum();
		SolovayStrassen check = new SolovayStrassen();
		BigInteger x = number.generateRondomNumber();
		
		System.out.println(SolovayStrassen.PrimeTest(x));
		
		System.out.print(x);;

	}

}
