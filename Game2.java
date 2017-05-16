package package1;

import java.util.Scanner;

public class Game2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max 10 próbach");

		int min = 0;
		int max = 1000;

		askingLoop: do {
			int guess = (int) (max - min) / 2 + min;
			System.out.println("Zgaduję: " + guess);

			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();

			if (answer.equals("zgadłeś")) {
				System.out.println("Wygrałem");
				break;
			} else if (answer.equals("za dużo")) {
				max = guess;
				continue askingLoop;
			} else if (answer.equals("za mało")) {
				min = guess;
				continue askingLoop;
			} else {
				System.out.println("nie oszukuj");
			}
		} while (true);
	}
}
