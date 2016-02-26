package virtual.friend;

import java.util.ArrayList;
import java.util.Base64;


public class FriendDataDecoder {

	public ArrayList<String []> quotes;
	public ArrayList<String> questions;
	public ArrayList<String []> scienceTest;
	public ArrayList<String []> puzzles;
	
	//Gets data from encoded in base 64 string into data structure
	public void getData(String codedData) {
		byte [] codedBytes = Base64.getDecoder().decode(codedData);

		String coded = new String(codedBytes);
		
		// splits with "#"
		String[] words = coded.split("#");

		quotes = new ArrayList<String []>();
		questions = new ArrayList<String>();
		scienceTest = new ArrayList<String []>();
		puzzles = new ArrayList<String []>();
		
		for (int i = 0; i < words.length; i++) {
			// Stupid but works
			if (i % 4 == 0) {
				int indexOfLastDot = words[i].lastIndexOf('.');
				quotes.add(new String [] {words[i].substring(1, indexOfLastDot),words[i].substring(indexOfLastDot+1).trim()});
			} else if (i % 4 == 1) {
				questions.add(words[i].substring(1, words[i].length()));
			} else if (i % 4 == 2) {
				String [] partsOfQuestions = words[i].split("\\?");
				String [] possibleAnswers = partsOfQuestions[1].split("\\,");
 				String [] result = new String[possibleAnswers.length + 2];
 				result[0] = partsOfQuestions[0].substring(1, partsOfQuestions[0].length()) + "?";
 				result[result.length-1] = partsOfQuestions[partsOfQuestions.length-1];
 				for(int j = 0; j<possibleAnswers.length; j++){
 					result[j+1] = possibleAnswers[j];
 				}
 				scienceTest.add(result);
			} else {
				String [] result = words[i].split("\\?");
				result[0] = result[0].substring(1, result[0].length()) + "?";
				result[1] = result[1].trim();
				puzzles.add(result);
			}
		}
	}
}
