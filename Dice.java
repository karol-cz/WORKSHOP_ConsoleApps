package package1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dice {
	
	static List<Integer> allowedTypes = Arrays.asList(3,4,6,8,10,12,20,100);

	public static int rollDice(String command) {

		String[] commandParts = command.split("D|\\+|\\-");
		System.out.println(Arrays.toString(commandParts));

		// int diceType = commmandParts[]

		

		int rollsNumber =commandParts[0].isEmpty() ? 1 : Integer.parseInt(commandParts[0]);
		int diceType = Integer.parseInt(commandParts[1]);
		if(!allowedTypes.contains(diceType)) {
			throw new IllegalArgumentException("Invalid dice size");
		}
		int additionalMove = 0;
		if (command.contains("+")) {
			additionalMove = Integer.parseInt(commandParts[2]);
		} else if (command.contains("-")) {
			additionalMove = -Integer.parseInt(commandParts[2]);
		}

		Random rd = new Random();
		int rollDiceResult = rd.nextInt(Math.abs(diceType)) + 1;

		System.out.println("rollsNumber: " + rollsNumber);
		System.out.println("diceType: " + diceType);
		System.out.println("rollDiceResult: " + rollDiceResult);
		System.out.println("additionalMove: " + additionalMove);

		int result = rollsNumber * rollDiceResult + additionalMove;
		System.out.println(command + " powoduje przesunięcie o: " + result);

		return result;
	}

	public static void main(String[] args) {
		String testInput = "D7-1";
		System.out.println(testInput);
		rollDice(testInput);
	}
}