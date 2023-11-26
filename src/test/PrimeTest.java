package test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

public class PrimeTest {
	
	@Test
	@DisplayName("Control that the constructor is never reached with invalid numbers")
	void createPrime2() {
		Prime prime = Prime.createPrime(0,10000);
		assertNull(prime);
	}
	
	@Test
	@DisplayName("Control that the constructor is reached with valid numbers")
	void createPrime() {
		Prime prime = Prime.createPrime(0,1000);
		assertNotNull(prime);
	}
	
	@Test
	@DisplayName("Control that the constructor is never reached with non int input")
	void controlInputTest4() {
	    assertThrows(NumberFormatException.class, () -> Prime.createPrime(Integer.parseInt("F"), 10000));
	}

	@Test
	@DisplayName("Test controlInput with invalid lastNumber")
    void controlInputTest3() {
        String expectedString = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedString, Prime.controlInput(0, 10000));
    }
	
	@Test
	@DisplayName("Test controlInput with invalid firstNumber")
    void controlInputTest2() {
        String expectedString = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedString, Prime.controlInput(-2, 1000));
    }
	
	@Test
	@DisplayName("Test controlInput where the first number is bigger than the last")
    void controlInputTest() {
        String expectedString = "Hoppsan, fel intervall angivet!";
        assertEquals(expectedString, Prime.controlInput(1000, 0));
    }
	
	@Test
	void printCountTest() {
		Prime prime = Prime.createPrime(0,10);
		String expectedOutput = "Hej, det finns " + prime.getNumberOfPrimes() + " primtal mellan " + prime.firstNumber + " och " + prime.lastNumber;               
		assertEquals(expectedOutput, prime.printCount());
	}
	
	@Test 
	void printSumTest(){
		Prime prime = Prime.createPrime(0,10);
		String expectedOutput = "Den totala summan av dessa primtal är " + prime.getSumOfPrimes();
		assertEquals(expectedOutput, prime.printSum());
	}
	
	@Test
	@DisplayName("Confirm that the sum of primes are being stored and that the method stops when current > stop")
	void calculatePrimesTest() {
		Prime prime = Prime.createPrime(0,2);
		assertEquals(2, prime.getSumOfPrimes());
	}

	@Test
	@DisplayName("Test the getNumberOfPrimes method")
    void getNumberOfPrimesTest() {
		Prime prime = Prime.createPrime(0, 10);
        int expectedCount = 4;
        assertEquals(expectedCount, prime.getNumberOfPrimes());
    }
	
	@Test
	@DisplayName("Confirm that getSumOfPrimes returns valid sum")
	void getSumOfPrimesTest() {
		Prime prime = Prime.createPrime(0,10);
		assertEquals(17, prime.getSumOfPrimes());
	}
	
	@Test
	@DisplayName("Test numIsPrime with prime number")
    void numIsPrimeTest4() {
		Prime prime = Prime.createPrime(1, 10);
        assertTrue(prime.numIsPrime(7)); 
    }

    @Test
    @DisplayName("Test numIsPrime with non prime number")
    void numIsPrimeTest3() {
    	Prime prime = Prime.createPrime(1, 10);
        assertFalse(prime.numIsPrime(8));
    }
	
	@Test
	@DisplayName("Test numIsPrime with negative number")
    void numIsPrimeTest2() {
		Prime prime = Prime.createPrime(1, 10);
        assertFalse(prime.numIsPrime(-3)); 
        }
	
	@Test
	@DisplayName("Confirm that numIsPrime returns false if number is less than 2")
	void numIsPrimeTest() {
		assertFalse(Prime.createPrime(0, 1000).numIsPrime(0));
		assertFalse(Prime.createPrime(0, 1000).numIsPrime(1));
	}

	
}
