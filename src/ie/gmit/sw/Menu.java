/* Kevin Niland
 * G00342279
 * Data Structures & Algorithms Project - Rapid Encryption using the Four-Square Cipher
 * 'Menu.java' - This class creates a primitive UI that allows the user to read in a file, 
 * encrypt/decrypt a file, and quit out of the program
*/

package ie.gmit.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu {
	/* Lets the user encrypt, decrypt, or quit out of the program using a primitive UI
	 * Running time: O(n^2) - The running time of this method will vary depending on how many 
	 * cases, and subsequently how many for loops and if statements, there are. In this case there are
	 * two cases with for loops and an inner if statement, the running time will be O(n) x O(n) = O(n^2).
	 * The .write() method of the BufferedWriter objects are constant so this will not affect the running 
	 * time. The if-else statements after the switch statement are also O(1) since they are just printing
	 * plain text to the screen
	 */
	public static void showMenu() throws IOException {
		String encryptionFile = "EncryptionOutput.txt";
		String decryptionFile = "DecryptionOutput.txt";

		FileHandler fileHandler = new FileHandler();
		BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(encryptionFile));
		BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(decryptionFile));
		FourSquareCipherNestedFor fourSquareCipherNestedFor = new FourSquareCipherNestedFor();
		//FourSquareCipherLinearEquation fourSquareCipherLinearEquation = new FourSquareCipherLinearEquation();

		String fileName = "WarAndPeace-LeoTolstoy.txt";

		Scanner console = new Scanner(System.in);

		int optionOne;
		//int optionTwo; // Used for selecting which method of encryption user wants to use
		boolean keepRunning = true;

		System.out.println("1. Encrypt file (for loops), 2. Decrypt file (for loops)");
		// System.out.println("3. Encrypt file (Mathematics). 4. Decrypt file (Mathematics)");
		System.out.println("5. Quit");
		System.out.println("Select an option: ");

		while (keepRunning) {
			optionOne = console.nextInt();

			switch (optionOne) {
			case 1:
				long encryptionStartOne = System.nanoTime();
				
				fileHandler.preEncryptionFile(fileName);
				fourSquareCipherNestedFor.encryptionBigram(fileHandler.fileToChar);

				/*
				 * for loop to only print a certain number of characters per line:- With this
				 * form of encryption and decryption, this shaves off ~0.5 seconds off the
				 * encryption. If you were to omit this piece of code, the encryption would
				 * take, on average, 1.5 seconds since the program tries to print the entire
				 * encryption on one line.
				 * 
				 * Average encryption time: 
				 * Time complexity:
				 */
				for (int i = 0; i < fourSquareCipherNestedFor.encryptionList.size(); i++) {
					if (i % 75 == 74) {
						bufferedWriter1.write("\n");
					}

					bufferedWriter1.write(fourSquareCipherNestedFor.encryptionList.get(i));
				}

				long encryptionFinishOne = System.nanoTime();
				long encryptionTakenOne = encryptionFinishOne - encryptionStartOne;

				System.out.println("Encryption time (s): " + (double) encryptionTakenOne / 1000000000.0);
				break;
			case 2:
				long decryptionStart = System.nanoTime();
				fileHandler.postEncryptionFile(encryptionFile);

				fourSquareCipherNestedFor.decryptionBigram(fileHandler.fileToChar);

				/*
				 * for loop to only print a certain number of characters per line:- With this
				 * form of encryption and decryption, this shaves off ~1 second off the
				 * decryption. If you were to omit this piece of code, the decryption would
				 * take, on average, 2 seconds since the program tries to print the entire
				 * decryption on one line.
				 * 
				 * Average decryption time: 
				 * Time complexity:
				 */
				for (int i = 0; i < fourSquareCipherNestedFor.decryptionList.size(); i++) {
					if (i % 75 == 74) {
						bufferedWriter2.write("\n");
					}

					bufferedWriter2.write(fourSquareCipherNestedFor.decryptionList.get(i));
				}

				long decryptiponFinish = System.nanoTime();
				long decryptionTaken = decryptiponFinish - decryptionStart;

				System.out.println("Decryption time (s): " + (double) decryptionTaken / 1000000000.0);

				System.out.println();
				break;
			/*case 3:
				long encryptionStartOne1 = System.nanoTime();
				
				fileHandler.preEncryptionFile(fileName);
				fourSquareCipherLinearEquation.encryptionBigram(fileHandler.fileToChar);

				
				 * for loop to only print a certain number of characters per line:- With this
				 * form of encryption and decryption, this shaves off ~0.5 seconds off the
				 * encryption. If you were to omit this piece of code, the encryption would
				 * take, on average, 1.5 seconds since the program tries to print the entire
				 * encryption on one line.
				 * 
				 * Average encryption time: 
				 * Time complexity:
				 
				for (int i = 0; i < fourSquareCipherLinearEquation.encryptionList.size(); i++) {
					if (i % 75 == 74) {
						bufferedWriter1.write("\n");
					}

					bufferedWriter1.write(fourSquareCipherLinearEquation.encryptionList.get(i));
				}

				long encryptionFinishOne1 = System.nanoTime();
				long encryptionTakenOne1 = encryptionFinishOne1 - encryptionStartOne1;

				System.out.println("Encryption time (s): " + (double) encryptionTakenOne1 / 1000000000.0);
				break;
			case 4:
				long decryptionStart1 = System.nanoTime();
				fileHandler.postEncryptionFile(encryptionFile);

				fourSquareCipherLinearEquation.decryptionBigram(fileHandler.fileToChar);

				
				 * for loop to only print a certain number of characters per line:- With this
				 * form of encryption and decryption, this shaves off ~1 second off the
				 * decryption. If you were to omit this piece of code, the decryption would
				 * take, on average, 2 seconds since the program tries to print the entire
				 * decryption on one line.
				 * 
				 * Average decryption time: 
				 * Time complexity:
				 
				for (int i = 0; i < fourSquareCipherLinearEquation.decryptionList.size(); i++) {
					if (i % 75 == 74) {
						bufferedWriter2.write("\n");
					}

					bufferedWriter2.write(fourSquareCipherLinearEquation.decryptionList.get(i));
				}

				long decryptiponFinish1 = System.nanoTime();
				long decryptionTaken1 = decryptiponFinish1 - decryptionStart1;

				System.out.println("Decryption time (s): " + (double) decryptionTaken1 / 1000000000.0);

				System.out.println();
				break;*/
			case 3:
				keepRunning = false;
				break;
			}

			if (optionOne == 3) {
				System.out.println();
			} else if (optionOne < 1 || optionOne > 3) {
				System.out.println("This option is not valid. Please try again.");
				System.out.println("1. Encrypt file, 2. Decrypt file,");
				System.out.println("3. Quit");
				System.out.println("Select an option: ");
			} else {
				System.out.println();
				System.out.println("1. Encrypt file, 2. Decrypt file,");
				System.out.println("3. Quit");
				System.out.println("Select an option: ");
			}
		}

		console.close();
		bufferedWriter1.close();
		bufferedWriter2.close();
	}
}