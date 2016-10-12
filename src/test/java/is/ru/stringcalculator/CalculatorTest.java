package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
}
