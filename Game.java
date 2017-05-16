package package1;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Random rd = new Random();
		int randNumber = rd.nextInt(99) + 1;
		//System.out.println(randNumber);

		Scanner sc = new Scanner(System.in);
		int number;

		do {
			// Sprawdzanie czy uzytkownik podał liczbę
			System.out.print("Zgadnij liczbe: ");
			while (!sc.hasNextInt()) {
				System.out.print("To nie jest liczba ");
				sc.next();
			}

			number = sc.nextInt();

			if (number > randNumber) {
				System.out.println("Za dużo!");
			} else if (number < randNumber) {
				System.out.println("Za mało!");
			} else {
				System.out.println("Zgadłeś!");
			}
		} while (number != randNumber);

	}

}
