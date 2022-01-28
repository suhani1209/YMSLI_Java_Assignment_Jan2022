package com.day4.q5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ques5 {
	public static void main(String[] args) {
		int n=0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			try {

				System.out.println("Please enter a number or enter -1 if you want to quit .");
				n = scanner.nextInt();
				if (n == -1) {
					System.out.println("Exit application..");
					System.exit(0);
				}
				if (n > 100) {
					throw new Exception();
				}
				if (n % 2 == 0) {
					System.out.println("You have entered an even number ..");

				} else {
					System.out.println("You have entered an odd number ..");
				}

			} catch (InputMismatchException ex) {
				System.out.println("You must enter an integer ..");

			} catch (Exception ex) {
				System.out.println("Number cant be greater than 100..");
			}

		} while (n != -1);
	}
}
