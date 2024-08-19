// CS210 Assignment #4 "Word Count"
// Andy Vargas Noesi
// Program accept input as String and count the words on the String

public class WordCount {

	public static int wordCount(String inputString) {
		int wordCounter = 0;
		inputString = inputString.toLowerCase();
		for (int start = 0; start < inputString.length(); start++) {//for loop from the beginning of the string
			if (!Character.isSpaceChar(inputString.charAt(start))) { //look for characters that are not space
				for (int spaceBar = start; spaceBar < inputString.length(); spaceBar++) {//when a space character is found it run a loop starting from that index
					char l = (inputString.charAt(spaceBar));
					if (Character.isSpaceChar(l) || spaceBar == inputString.length() - 1) { //if there is another space or last index of the string, then it means is 1 word was found
						wordCounter++;
						start = spaceBar;
						break;
					}
				}

			}

		}
		return wordCounter;
	}

}