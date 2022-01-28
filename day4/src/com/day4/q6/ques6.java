package com.day4.q6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ques6 {
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
					throw new CustomException(100);
				}
				if (n % 2 == 0) {
					System.out.println("You have entered an even number ..");

				} else {
					System.out.println("You have entered an odd number ..");
				}

			} catch (InputMismatchException ex) {
				System.out.println("You must enter an integer ..");

			} catch (CustomException ex) {
				System.out.println(ex.getMessage());
			}

		} while (n != -1);
	}
}
