package main;

import java.util.ArrayList;
import java.util.List;

/**
 * This program counts the sum and the number of prime (int) numbers in interval
 * 0-1000
 */
public class Prime {

	private List<Integer> primes;
	private int numberOfPrimes = 0;
	private int sumOfPrimes = 0;
	public int firstNumber;
	public int lastNumber;

	private Prime(int firstNumber, int lastNumber) {
		primes = new ArrayList<>();
		this.firstNumber = firstNumber;
		this.lastNumber = lastNumber;
		calculatePrimes(firstNumber, lastNumber);
	}

	public static Prime createPrime(int firstNumber, int lastNumber) {
		String controlInputResult = controlInput(firstNumber, lastNumber);
		if (controlInputResult.equals("Valid Input")) {
			Prime prime = new Prime(firstNumber, lastNumber);
			return prime;
		} else {
			Prime prime = null;
			return prime;
		}
	}

	public static String controlInput(int firstNumber, int lastNumber) {
		if (lastNumber > 1000 || firstNumber < 0 || lastNumber < firstNumber) {
			String errorMessage = "Hoppsan, fel intervall angivet!";
			System.out.println(errorMessage);
			return errorMessage;
		} else {
			String validInput = "Valid Input";
			return validInput;
		}
	}

	public boolean numIsPrime(int current) {
		if (current <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(current); i++) {
			if (current % i == 0) {
				return false;
			}
		}

		return true;

	}

	private void calculatePrimes(int current, int stop) {
		if (current > stop) {
			return;
		} else if (numIsPrime(current)) {
			primes.add(current);
			++numberOfPrimes;
			sumOfPrimes += current;
			calculatePrimes(++current, stop);
		} else {
			calculatePrimes(++current, stop);
		}
	}

	public int getNumberOfPrimes() {
		return numberOfPrimes;
	}

	public Object getSumOfPrimes() {
		return sumOfPrimes;
	}

	public String printCount() {
		String output = "Hej, det finns " + getNumberOfPrimes() + " primtal mellan " + this.firstNumber + " och "
				+ this.lastNumber;
		System.out.println(output);
		return output;
	}

	public String printSum() {
		String output = "Den totala summan av dessa primtal är " + getSumOfPrimes();
		System.out.println(output);
		return output;
	}

//    public static void main(String[] args) {
//        Prime prime = new Prime(0, 1000);
//
//        System.out.println("Antal primtal mellan 0 och 1000: " + prime.getCount());
//    }
}
