DATA STRUCTURES & ALGORITHMS ASSIGNMENT - "RAPID ENCRYPTION AND DECRYPTION USING THE FOURSQUARE CIPHER"
=======================================================================================================
Student: Kevin Niland
Student number: G00342279

For my project, I have decided to use for loops to encrypt and decrypt the file. The project utilises four
different classes: FileHandler, FourSquareCipherNestedFor, Menu, and Runner. While for loops aren't the most 
efficient way of doing this project, they are very simple to implement. 

FileHandler reads in the file, adds the file to a String list, removes all spaces, commas, etc. and replaces any J's with I's,
converts the characters to uppercase and converts it to a character array. It does this for both the pre encrypted file 
and the encrypted file.

FourSquareCipherNestedFor takes in the file and splits it into bigrams, as per the project spec. It then encrypts/decrypts the file 
using nested for loops and adds the encryption to a list. 

Menu creates a primitve UI that the user can interact with. It allows the user to encypt and decrypt a file, and quit out of the program. 

Runner creates a Menu object and calls it. 

N.B
====
To measure the time taken, I have included a measuring system in the Menu class in each of the cases. However, I have noticed the amount
of time taken increases the more I encrypt and decrypt. Therefore, I have included a commented method of measuring the time taken. This is
incase I have measured the time taken incorrectly in the Menu class. 

If you have any trouble with running this project, please free to e-mail me: G00342279@gmit.ie
