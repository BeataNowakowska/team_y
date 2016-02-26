package virtual.friend;

import java.util.ArrayList;

public class PuzzlesPrinter extends FunctionalityRunner{

	public static String GIVE_ANSWER_QUESTION = "Do you want to know the answer? Yes/Not yet";
	public static String YES = "Yes";
	public static String TOUGH = "You're tough, that's good."; 
	
	public PuzzlesPrinter(ConsoleBox box) {
		super(box);
	}

	@Override
	public void next() {

		if (!hasNextElement()){
			console.write(FunctionalityRunner.NODATA);
			return;
		}
		
		String puzzle [] = arrayData.get(getNextElementIndex());
		
		console.write(puzzle[0]);
		console.write(GIVE_ANSWER_QUESTION);
		if(YES.equals(console.readline())){
			console.write(puzzle[1]);
		} else {
			console.write(TOUGH);
		}
	}

	@Override
	public void setDataArrays(ArrayList<String []> list) {
		this.arrayData = list;
	}
}
