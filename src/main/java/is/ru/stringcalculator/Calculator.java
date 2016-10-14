package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text == "" ||((!text.contains(",")) && toInt(text) > 1000))
			return 0;
		if (text.contains("\n")) 
		    text = text.replace("\n", ",");
		//if (text == "")
		//	return 0;
		if (text.contains(",") || text.contains("-"))
			return sum(splitNumbers(text));
		else
			return toInt(text);
	}

    private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    String[] splitNumbers = numbers.split(",");
	    if(numbers.contains("-")) {
			String negatives = findNegatives(splitNumbers);
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}
	    return splitNumbers;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if (toInt(number) < 1000)
	        	total += toInt(number);
        }
	    return total;
    }

   private static String findNegatives(String[] numbers) {
   		String negatives = "";
   		int counter = 0;
   		for (int i = 0; i < numbers.length; i++) {
   			if(numbers[i].contains("-")) {
   				if (counter > 0)
   				    negatives += "," + numbers[i];
   				else
   					negatives += numbers[i];
   				counter++;
   			}
   		}

   		return negatives;
   }
}
