package ie.gmit.sw;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char[][] plot = new char[3][25];
		char remove = 'Q';

		// Inputs should be in UPPERCASE
		String key_1;
		String key_2;
		String encryptedText = "";

		System.out.println("4-х квадратный шифр");
		// Scanners
		Scanner in = new Scanner(System.in);
		System.out.print("Первый ключ: ");
		key_1 = in.nextLine().toUpperCase();
		System.out.print("Второй ключ: ");
		key_2 = in.nextLine().toUpperCase();

		String process;
		String plainText = "";
		while (true) {
			System.out.print("E чтобы маскировать D чтобы рассекречивать: ");
			process = in.next().toUpperCase();

			if (process.equals("E")) {
				System.out.print("Текст для зашифровки: ");
				in = new Scanner(System.in);
				plainText = in.nextLine().toUpperCase();
				break;
			}

			if (process.equals("D")) {
				System.out.print("Зашифрованный текст: ");
				in = new Scanner(System.in);
				encryptedText = in.nextLine().toUpperCase();
				break;
			}
		}

		String filtered_key_1 = removeDuplicates(key_1);
		String filtered_key_2 = removeDuplicates(key_2);

		System.out.println("Подредактированный первый ключ: " + filtered_key_1);
		System.out.println("Подредактированный второй ключ: " + filtered_key_2);

		plotAlphabets(plot[0], remove);
		plotKey(plot[1], filtered_key_1, remove);
		plotKey(plot[2], filtered_key_2, remove);

		if (process.equals("E")) {
			encrypt(plot, plainText);
		}

		if (process.equals("D")) {
			decrypt(plot, encryptedText);
		}
	}

	private static void decrypt(char[][] plot, String encryptedText) {
		char[] pairs = new char[2];
		String plainText = "";
		String[] pEncryptText = new String[encryptedText.length() / 2];

		int cursor = 0;
		for (int i = 0; i < pEncryptText.length; i++) {
			pEncryptText[i] = "" + encryptedText.charAt(cursor) + encryptedText.charAt(cursor + 1);
			cursor = cursor + 2;
		}

		for (String s : pEncryptText) {
			int column_a = 0;
			int row_a = 0;
			int column_b = 0;
			int row_b = 0;

			pairs[0] = s.charAt(0);
			pairs[1] = s.charAt(1);

			if(pairs[0]==' ' || pairs[1] == ' ') {
				plainText += pairs[0];
				plainText += pairs[1];
			}
			else {
				for (int j = 0; j < plot[0].length; j++) {
					if (pairs[0] == plot[1][j]) {
						row_a = (j / 5) * 5;
						column_a = j % 5;
					}

					if (pairs[1] == plot[2][j]) {
						row_b = (j / 5) * 5;
						column_b = j % 5;
					}
				}
				plainText += plot[0][row_a + column_b]; // В нормальном алфавите
				plainText += plot[0][row_b + column_a]; // В нормальном алфавите
			}
		}

		if (encryptedText.length() % 2 != 0) {
			plainText += encryptedText.charAt(encryptedText.length() - 1);
		}
		System.out.println("Замаскированный текст: " + plainText);
	}

	private static void encrypt(char[][] plot, String plainText) {
		char[] bykva12 = new char[2];
		String encryptedText = "";
		String[] pEncryptText = new String[plainText.length() / 2];

		int cursor = 0;
		for (int i = 0; i < pEncryptText.length; i++) {
			pEncryptText[i] = "" + plainText.charAt(cursor) + plainText.charAt(cursor + 1);
			// step by two
			cursor = cursor + 2;
		}

		for (String s : pEncryptText) {
			int column_a = 0;
			int row_a = 0;
			int column_b = 0;
			int row_b = 0;

			bykva12[0] = s.charAt(0);
			bykva12[1] = s.charAt(1);
			if(bykva12[0]==' ' || bykva12[1] == ' ') {
				encryptedText += bykva12[0]; // По 1 ключу
				encryptedText += bykva12[1];
			} else {
				for (int j = 0; j < plot[0].length; j++) {
					if (bykva12[0] == plot[0][j]) {
						row_a = (j / 5) * 5;
						column_a = j % 5;
					}

					if (bykva12[1] == plot[0][j]) {
						row_b = (j / 5) * 5;
						column_b = j % 5;
					}
				}
				encryptedText += plot[1][row_a + column_b]; // По 1 ключу
				encryptedText += plot[2][row_b + column_a];  // По 2 ключу
			}
		}
		if (plainText.length() % 2 != 0) {
			encryptedText += plainText.charAt(plainText.length() - 1);
		}
		System.out.println("Замаскированный текст: " + encryptedText);
	}


	private static void plotAlphabets(char[] plot, char remove) {
		int cursor = 0;
		for (int i = 0; i < plot.length; i++) {
			if ((char) ('A' + i) != remove) {
				plot[i] = (char) ('A' + cursor);
			} else {
				cursor++;
				plot[i] = (char) ('A' + cursor);
			}
			cursor++;
		}
	}

	private static String removeDuplicates(String string) {
		char[] characters = string.toCharArray();
		String filterd = "";
		for (int i = 0; i < characters.length; i++) {
			// iterate each char on the list
			boolean isReapeated = false;
			for (int j = 0; j < i; j++) {
				// compare one char (current) to all chars
				if (characters[i] == characters[j]) {
					isReapeated = true;
					break;
				}
			}

			if (!isReapeated) { // if the char is not repeated then add to output
				filterd += characters[i];
			}
		}
		return filterd; // sample input: LOLEEOEO, output: LEO
	}


	private static void plotKey(char[] plot, String key, char remove) {
		int cursor = 0; // additional counter
		char[] ckey = key.toCharArray(); // fastest way to convert String to char array

		// plot initial key
		for (int i = 0; i < ckey.length; i++) {
			plot[i] = ckey[i];
		}

		for (int i = ckey.length; i < plot.length; i++) {

			if ((char) ('A' + cursor) == remove) {
				// if the current letter is the one which be remove then skip
				cursor++;
			}

			int checks = 2; // number of checks
			for (int j = 0; j < checks; j++) {
				for (int k = 0; k < ckey.length; k++) {
					// iterate to the key and compare each to the current character
					if (ckey[k] == (char) ('A' + cursor)) {
						cursor++;
						break;
					}
				}
			}

			if ((char) ('A' + cursor) == remove) { // recheck
				// if the current letter is the one which be remove then skip
				cursor++;
			}

			plot[i] = (char) ('A' + cursor);
			cursor++;

		}
	}

}
