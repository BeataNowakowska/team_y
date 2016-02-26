package virtual.friend;

public class ScienceTestPrinter extends FunctionalityRunner{

	public static String GIVEMEANSWER = "Which answer is correct, enter the number?";
	public static String WRONGANSWER = "The answer is wrong.";
	public static String CORRECT = "The answer is correct.";
	
	public ScienceTestPrinter(ConsoleBox box) {
		super(box);
	}

	@Override
	public void next() {
		if (!hasNextElement()){
			console.write(NODATA);
			return;
		}
		String [] question = arrayData.get(getNextElementIndex());		
		giveQuestion(question);
		checkAnswer(question);
	}

	private void giveQuestion(String [] question) {
		console.write(prepareQuestionString(question));
		console.write(GIVEMEANSWER);
	}

	private String prepareQuestionString(String [] data){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(data[0]);
		for (int i = 1; i<data.length-1; i++){
			stringBuilder.append("\n");
			stringBuilder.append(data[i]);
		}
		return stringBuilder.toString();
	}
	
	private void checkAnswer(String[] question) {
		if(question[question.length-1].equals(console.readline().trim()))
			console.write(CORRECT);
		else
			console.write(WRONGANSWER);
	}
	
	

}
