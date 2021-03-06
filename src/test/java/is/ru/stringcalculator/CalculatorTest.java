package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	

	public static void main(String args[]) {
        org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Test
	public void testEmptyString() {
	    assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testAnotherNumber() {
		assertEquals(5, Calculator.add("5"));
	}

	@Test 
	public void testTwoNumbers() {
		assertEquals(4, Calculator.add("1,3"));
	}

	@Test
	public void testTreeNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testFourNumbers() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testOneNegativeNumber() {
    	thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: -1");
 
    	Calculator.add("-1");
	}

	@Test 
	public void testAnotherNegativeNumber() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: -2");
 
    	Calculator.add("-2");
	}

	@Test
	public void testNegativeNumberAndPositiveNumber() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: -1");
 
    	Calculator.add("-1,2");
	}

	@Test
	public void testTwoNegativesAndTwoPositives() {
		thrown.expect(IllegalArgumentException.class);
    	thrown.expectMessage("Negatives not allowed: -4,-5");
 
    	Calculator.add("2,-4,3,-5");
	}

	@Test
	public void testBigNumber() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testSingleBigNumber() {
		assertEquals(0, Calculator.add("1001"));
	}

	@Test 
	public void testMultipleBigNumbers() {
		assertEquals(0, Calculator.add("1001,1003"));
	}

	@Test
	public void testMultipleBigNumbersAndSmallOnes() {
		assertEquals(3, Calculator.add("1,1001,2,1003"));
	}

	@Test
	public void testDifferentDelimeter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDifferentDelimeterAndNewline() {
		assertEquals(8, Calculator.add("//;\n2;2;4"));
	}

}
