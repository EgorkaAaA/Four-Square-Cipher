/* Kevin Niland
 * G00342279
 * Data Structures & Algorithms Project - Rapid Encryption using the Four-Square Cipher
 * 'FourSquareCipherNestedFor.java' - This class encrypts and decrypts a file using nested for loops
*/

package ie.gmit.sw;

import java.util.*;

public class FourSquareCipherNestedFor {
	List<Character> encryptionList = new ArrayList<Character>();
	List<Character> decryptionList = new ArrayList<Character>();
	
	private char[][] matrix = { 
			{ 'A', 'B', 'C', 'D', 'E', 'Z', 'G', 'P', 'T', 'F' },
			{ 'F', 'G', 'H', 'I', 'K', 'O', 'I', 'H', 'M', 'U' }, 
			{ 'L', 'M', 'N', 'O', 'P', 'W', 'D', 'R', 'C', 'N' },
			{ 'Q', 'R', 'S', 'T', 'U', 'Y', 'K', 'E', 'Q', 'A' }, 
			{ 'V', 'W', 'X', 'Y', 'Z', 'X', 'V', 'S', 'B', 'L' },
			{ 'M', 'F', 'N', 'B', 'D', 'A', 'B', 'C', 'D', 'E' }, 
			{ 'C', 'R', 'H', 'S', 'A', 'F', 'G', 'H', 'I', 'K' },
			{ 'X', 'Y', 'O', 'G', 'V', 'L', 'M', 'N', 'O', 'P' }, 
			{ 'I', 'T', 'U', 'E', 'W', 'Q', 'R', 'S', 'T', 'U' },
			{ 'L', 'Q', 'Z', 'K', 'P', 'V', 'W', 'X', 'Y', 'Z' } };

	/* Splits the file into bigrams
	 * Running time: O(n) - This is because there is only one for loop in this method. This very good in
	 * terms of running time
	 */
	public void encryptionBigram(char[] fileToText) {
		int i;
		char x, y;
		
		for (i = 0; i < fileToText.length - 1; i += 2) {
			x = fileToText[i];
			y = fileToText[i + 1];

			encryption(x, y);
		}
	}

	/* Takes in the bigrams created in the above method and encrypts them
	 * Running time: O(n^2) - This is because of the two nested loops in this method. This isn't very good
	 * in terms of running time. The .add() methods after the for loops run at constant time and therfore
	 * don'taffect the running time: O(n^2) x O(1) = O(n^2).
	 */
	private void encryption(char x, char y) {
		int i, j;
		int a, b, c, d;
		a = b = c = d = 0;

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 5; j++) {
				if (x == matrix[i][j]) {
					a = i;
					b = j;
					break; // Using break here allows you do the minimum number of comparisons
				}
			}
		}

		for (i = 5; i < 10; i++) {
			for (j = 5; j < 10; j++) {
				if (y == matrix[i][j]) {
					c = i;
					d = j;
					break; // Using break here allows you do the minimum number of comparisons
				}
			}
		}

		encryptionList.add(matrix[a][d]);
		encryptionList.add(matrix[c][b]);
	}
	
	/* Splits the encrypted file into bigrams
	 * Running time: O(n) - This is because there is only one for loop in this method. This very good in
	 * terms of running time
	 */
	public void decryptionBigram(char[] encryptionText) {
		int i;
		char x, y;

		for (i = 0; i < encryptionText.length - 1; i += 2) {
			x = encryptionText[i];
			y = encryptionText[i + 1];

			decryption(x, y);
		}
	}
	
	/* Takes in the bigrams created in the above method and decrypts them
	 * Running time: O(n^2) - This is because of the two nested loops in this method. This isn't very good in
	 * terms of running time. The .add() methods after the for loops run at constant time and therfore
	 * don'taffect the running time: O(n^2) x O(1) = O(n^2).
	 */
	private void decryption(char x, char y) {
		int i, j;
		int a, b, c, d;
		
		a = b = c = d = 0;
		
		for (i = 5; i < 10; i++) {
			for (j = 0; j < 5; j++) {
				if (x == matrix[i][j]) {
					a = i;
					b = j;
				}
			}
		}
		
		for (i = 0; i < 5; i++) {
			for (j = 5; j < 10; j++) {
				if (y == matrix[i][j]) {
					c = i;
					d = j;
				}
			}
		}
		
		decryptionList.add(matrix[a][b]);
		decryptionList.add(matrix[c][d]);
	}
}