/* Kevin Niland
 * G00342279
 * Data Structures & Algorithms Project - Rapid Encryption using the Four-Square Cipher
 * 'FileHandler.java' - This class reads in both the pre-encrypted file for encryption and the 
 * post-encrypted file for decryption
*/

package ie.gmit.sw;

import java.io.*;
import java.util.*;

public class FileHandler {
	private List<String> characters = new ArrayList<String>();
	public char fileToChar[];
	
	/* Reads in the file in its original state i.e before enryption
	 * Running time: O(n) - This is because of the while loop (and the subsequent .add() method).
	 * A while loop, like a for loop, is linear. A .add() method in regards to a list is constant time. 
	 * Therefore the running time would be O(n) x O(1) = O(n)
	 */
	public void preEncryptionFile(String fileText) throws IOException {
		String line;
		
		FileInputStream fileReader = new FileInputStream(fileText);
		DataInputStream dataInputStream = new DataInputStream(fileReader);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

		while ((line = bufferedReader.readLine()) != null) {
			characters.add(line);
		}
		
		String charsToString = characters.toString();
		
		charsToString = charsToString.replaceAll("[^a-zA-Z]", "").replace('J', 'I').toUpperCase();
		
		fileToChar = charsToString.toCharArray();
		
		bufferedReader.close();
	}
	
	/* Reads in the file in its new state i.e after enryption
	 * Running time: O(n) - This is because of the while loop (and the subsequent .add() method).
	 * A while loop, like a for loop, is linear. A .add() method in regards to a list is constant time. 
	 * Therefore the running time would be O(n) x O(1) = O(n)
	 */
	public void postEncryptionFile(String encryptionText) throws IOException {
		String line;
		
		FileInputStream fileReader = new FileInputStream(encryptionText);
		DataInputStream dataInputStream = new DataInputStream(fileReader);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
		
		while ((line = bufferedReader.readLine()) != null) {
			characters.add(line);
		}
		
		String charsToString = characters.toString();
		
		charsToString = charsToString.replaceAll("[^a-zA-Z]", "").replace('J', 'I').toUpperCase();
		
		fileToChar = charsToString.toCharArray();
		
		bufferedReader.close();
	}
}