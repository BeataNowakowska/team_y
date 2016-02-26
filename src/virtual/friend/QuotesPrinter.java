package virtual.friend;

import java.util.ArrayList;

public class QuotesPrinter extends FunctionalityRunner {

	public QuotesPrinter(ConsoleBox box) {
		super(box);
	}

	@Override
	public void next() {
		if (hasNextElement()) {
			String quota[] = arrayData.get(getNextElementIndex());
			console.write(quota[0] + "\n" + quota[1]);
		} else
			console.write(NODATA);
	}

	@Override
	public void setDataArrays(ArrayList<String[]> list) {
		this.arrayData = list;
	}
}
