/* Kevin Niland
 * G00342279
 * Data Structures & Algorithms Project - Rapid Encryption using the Four-Square Cipher
 * 'Runner.java' - This is the project runner class. It allows the user to use the menu created in the Menu 
 * class
*/

package ie.gmit.sw;

import java.io.IOException;

public class Runner {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// long startTime = System.nanoTime();
		
		Menu menu = new Menu();
		
		System.out.println("------ Rapid Encryption Using the Four-Square Cipher ------\n");
		
		try {
			menu.showMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time taken(s): " + (double) endTime / 1000000000.0);*/
	}
}