package encryption_algorithm;

import java.util.Scanner;

/**
 * @author Fahmida Hamid
 * @version 1.1
 * @since March 2023
 */

public interface Encryption {

	public String encrypt(String plainText);
	public String decrypt(String encryptText);
}
