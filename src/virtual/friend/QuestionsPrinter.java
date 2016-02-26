package virtual.friend;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionsPrinter extends FunctionalityRunner {

	public QuestionsPrinter(ConsoleBox box) {
		super(box);
	}

	@Override
	public void next() {		
		if (hasNextElement())
			console.write(data.get(getNextElementIndex()));
		else
			console.write(NODATA);
	}

	@Override
	public void setData(ArrayList<String> list) {
		this.data = list;
	}

}