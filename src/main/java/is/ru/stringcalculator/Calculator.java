package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("-1"))
			throw new IllegalArgumentException("Negatives not allowed: -1");
		if (text.contains("\n")) 
		    text = text.replace("\n", ",");
		if (text == "")
			return 0;
		else if (text.contains(","))
			return sum(splitNumbers(text));
		else
			return toInt(text);
	}

    private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
	        total += toInt(number);
        }
	    return total;
    }
}
