package ss.week7.hotel.server;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Hotel Server TUI for user input and user messages
 * 
 * @author Wim Kamerman
 */
public class HotelServerTUI implements HotelServerView {
	
	/** The PrintWriter to write messages to */
	private PrintWriter console;

	/**
	 * Constructs a new HotelServerTUI. Initializes the console.
	 */
	public HotelServerTUI() {
		console = new PrintWriter(System.out, true);
	}

	@Override
	public void showMessage(String message) {
		console.println(message);
	}

	@Override
	public String getString(String question) {
		System.out.println(question);
		return new Scanner(System.in).nextLine();
	}

	@Override
	public int getInt(String question) {
		System.out.println(question);
		return Integer.parseInt(new Scanner(System.in).nextLine());
	}

	@Override
	public boolean getBoolean(String question) {
		System.out.println(question);
		return Boolean.parseBoolean(new Scanner(System.in).nextLine());
	}

}

