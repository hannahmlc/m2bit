package ss.week6.dictionaryattack;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename the full path to the file
	 */
	public void readPasswords(String filename) throws IOException {
		this.passwordMap = new HashMap<String, String>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String username = line.split(": ")[0];
			String password = line.split(": ")[1];
			passwordMap.put(username, password);
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password String
	 * @return MD5 hash of given password
	 */
	public String getPasswordHash(String password) {
		byte[] passwordHash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			passwordHash = md.digest(password.getBytes());
			return Hex.encodeHexString(passwordHash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        String passwordHash =getPasswordHash(password);
		if(!(passwordMap.containsKey(user))){ //user doesnt exist
			return false;
		}else if(passwordMap.get(user).equals(passwordHash)){
			return true;
		}
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary (full path)
	 */
    	public void addToHashDictionary(String filename) {
        // To implement        
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
