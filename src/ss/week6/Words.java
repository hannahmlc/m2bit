package ss.week6;

import java.util.Scanner;

public class Words {

	private static final String END_WORD = "end";

	public static void main(String[] args) {
		boolean end = false;
		while(!end){
			System.out.print("Line (or \"end\"): ");
			String Line = new Scanner(System.in).nextLine();

			if(Line.equals(END_WORD)){
				System.out.print("End of programme.");
				end = true;
			}else{
				String[] words = Line.split(" ");
				for (int i=0; i<words.length ;i ++){
					System.out.println("Word" + (i+1) + ": " + words[i]);
				}
			}
		}
	}
}
