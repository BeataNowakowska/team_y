package virtual.friend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FriendRunner {
	public static String PROGRAM_ARGUMENTS_ERROR_MESSAGE = "Program should be started with data file.";

	public void runApplication(String[] args) {
		try {
			if (args.length == 1) {
				FriendDataDecoder data = encryptData(new String(Files.readAllBytes(Paths.get(args[0]))));
				RunUI(data);
			} else {
				System.out.println(PROGRAM_ARGUMENTS_ERROR_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println(PROGRAM_ARGUMENTS_ERROR_MESSAGE + "\nDebug message:\n" + e.getMessage());
		}
	}

	private FriendDataDecoder encryptData(String rowdata) {
		FriendDataDecoder data = new FriendDataDecoder();
		data.getData(rowdata);
		return data;
	}

	private void RunUI(FriendDataDecoder data) {
		ConsoleBox console = new ConsoleBox();
		QuestionsPrinter basicFunctionality = new QuestionsPrinter(console);
		basicFunctionality.setData(data.questions);
		
		QuotesPrinter quotesPrinter = new QuotesPrinter(console);
		quotesPrinter.setDataArrays(data.quotes);
		
		ScienceTestPrinter scienceTestPrinter = new ScienceTestPrinter(console);
		scienceTestPrinter.setDataArrays(data.scienceTest);
		
		PuzzlesPrinter puzzlesPrinter = new PuzzlesPrinter(console);
		puzzlesPrinter.setDataArrays(data.puzzles);
		
		FriendUI friend = new FriendUI(new ConsoleBox(), basicFunctionality, quotesPrinter, scienceTestPrinter, puzzlesPrinter);
		
		friend.run();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		new FriendRunner().runApplication(args);
	}
}
