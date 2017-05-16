package package1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Clasa LOTTO symuluje grę w LOTTO. Z konsoli pobierane jest 6 liczb i są one
 * porównywane z 6-ścioma liczbami wylosowanymi z puli liczb 1-49
 */
public class LOTTO {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// tablica, do przechowywania liczb pobranych z konsoli
		Integer[] arrUser = new Integer[6];

		// tablic z pulą liczb do losowania
		Integer[] arr = new Integer[49];

		// uzupelniennie tablicy kolejnymi liczbami z zakresu 1-49
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		// wczytanie 6-ściu liczb z konsoli
		for (int i = 0; i < arrUser.length; i++) {
			loop: do {
				System.out.print("Podaj liczbę nr " + (i + 1) + ": ");

				// sprawdzenie warunku czy w konsoli została podana liczba
				if (!sc.hasNextInt()) {
					String in = sc.next();
					System.out.println("'" + in + "' To nie jest liczba ");
					continue;
				}
				int t = sc.nextInt();

				// sprawdzenie czy podana liczba mieści się w zakresie
				// losowanych liczb
				if (t < 1 || t > 49) {
					System.out.println("Liczba jest poza przedziałem 1-49, ");
					continue;
				}

				for (int j = 0; j < i; j++) {
					if (arrUser[j] == t) {
						System.out.println("Ta liczba juz zostala podana");
						continue loop;
					}
				}
				arrUser[i] = t;
				break;
			} while (true);

		}

		System.out.println(Arrays.toString(arrUser));
		// sortowanie i wyświetlanie tablicy z wczytanymi liczbami
		Arrays.sort(arrUser);
		System.out.println(Arrays.toString(arrUser));

		// losowanie 6 liczb z puli 1-49
		Collections.shuffle(Arrays.asList(arr));
		Integer[] arrResults = Arrays.copyOf(arr, 6);
		Arrays.sort(arrResults);

		System.out.println("Szczęśliwe numery to" + "\n" + Arrays.toString(arrResults));

		// sprawdzanie ile wylosowanych liczb jest równe liczbom podanym
		int wins = 0;
		for (int i : arrResults) {
			for (int j : arrUser) {
				if (i == j) {
					wins++;
				}
			}
		}

		if (wins >= 3) {
			System.out.println("Liczba trafień: " + wins);
		} else {
			System.out.println("Sproboj jeszcze raz");
		}

		/*
		 * CIEKAWOSTKA
		 * 1) Po ilu losowaniach pada 6-tka
		 * 2) Ile trzeba zainwestować, żeby wygrać
		 * 3) Ile można zarobić:)
		 */
		Random rd = new Random();

		int numberOfTries = 0;
		int[] eachCount = new int[7];
		while (true) {
			wins = 0;
			for (int i = 0; i < 6; i++) {
				stepBack: while (true) {
					int randomNumber = rd.nextInt(49) + 1;
					for (int j = 0; j < i; j++) {
						if (arrResults[j] == randomNumber)
							continue stepBack;
					}
					arrResults[i] = randomNumber;
					break;
				}
			}

			for (int i : arrResults) {
				for (int j : arrUser) {
					if (i == j) {
						wins++;
					}
				}
			}
			numberOfTries++;
			eachCount[wins]++;
			//System.out.println(numberOfTries);
			if (wins == 6) {
				break;
			}
		}
		System.out.println("after");
		System.out.println("Te liczby padną dopiero po: " + numberOfTries + " losowaniach");
		System.out.println("Wydano na kupony: " + numberOfTries*3);
		System.out.println("Łączne wygrane: " 
				+ (eachCount[3]*10 + eachCount[4]*100 + eachCount[5]*3500 + 1_000_000));
		
	}

}
