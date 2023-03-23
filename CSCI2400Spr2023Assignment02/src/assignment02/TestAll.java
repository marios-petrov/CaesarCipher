package assignment02;

import encryption_algorithm.*;
import input_output_handling.*;

/**
 * @authors Marios Petrov / Megan Pelletier
 * @version 1.0
 * @since March 2023
 */

public class TestAll {

	public static void main(String[] args) {
		//a)
		MyFileReader fr = new MyFileReader("src/assignment02/sample_input.txt","src/assignment02/sample_output.txt");

		//b)
		fr.writeData(fr.readData("src/assignment02/sample_input.txt"),"src/assignment02/sample_output.txt");

		//c)
		CaesarCipher cc1 = new CaesarCipher(1);

		String testString = "good morning";
		String testEncrypt = cc1.encrypt(testString);
		String testDecrypt = cc1.decrypt(testEncrypt);

		System.out.println(testString);
		System.out.println(testEncrypt);
		System.out.println(testDecrypt);

		//d)
		CaesarCipher cc10 = new CaesarCipher(10);
		MyFileReader r2 = new MyFileReader("src/assignment02/sample_input.txt","src/assignment02/processed_output.txt", cc10);

		//e)
		r2.readData();
		r2.processData();
		r2.writeData();

		r2.printData(r2.rawData);
		r2.printData(r2.processedData);

		/*
		Sample Outputs:
		encrypt: There he goes. One of God's own prototypes. A high-powered mutant of some kind never even considered for mass production. Too weird to live, and too rare to die.

		 drobo ro qyoc. yxo yp qyn'c ygx zbydydizoc. k rsqr-zygobon wedkxd yp cywo usxn xofob ofox myxcsnobon pyb wkcc zbynemdsyx. dyy gosbn dy vsfo, kxn dyy bkbo dy nso.

		decrypt: drobo ro qyoc. yxo yp qyn'c ygx zbydydizoc. k rsqr-zygobon wedkxd yp cywo usxn xofob ofox myxcsnobon pyb wkcc zbynemdsyx. dyy gosbn dy vsfo, kxn dyy bkbo dy nso.

         there he goes. one of god's own prototypes. a high-powered mutant of some kind never even considered for mass production. too weird to live, and too rare to die.
		*/
	}
}
