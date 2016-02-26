package virtual.friend;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class PuzzlePrinterTest {

	SystemConsoleStub stub;
	PuzzlesPrinter dataChooser;
	ArrayList<String []> data;

	
	@Before
	public void before(){
		data = new ArrayList<String []>();
		stub = new SystemConsoleStub();
		dataChooser = new PuzzlesPrinter(stub);
	}
	
	@Test
	public void noDataIsPrintedWhenThereIsNoData() {
		//given
		//when
		dataChooser.next();
		//then
		Assert.assertEquals(FunctionalityRunner.NODATA, stub.getProgramResponseAtt(0));
	}
	
	@Test
	public void userIsGivenTheQuestion() {
		//given
		data.add(new String [] {"P","A"});
		dataChooser.setDataArrays(data);
		stub.addUserAction(PuzzlesPrinter.YES);
		//when
		dataChooser.next();
		//then
		Assert.assertEquals("P", stub.getProgramResponseAtt(0));
	}
	
	@Test
	public void userWantsToKnowTheAnswer(){
		//given
		data.add(new String [] {"P","A"});
		dataChooser.setDataArrays(data);
		stub.addUserAction(PuzzlesPrinter.YES);
		//when
		dataChooser.next();
		//then
		Assert.assertEquals(PuzzlesPrinter.GIVE_ANSWER_QUESTION, stub.getProgramResponseAtt(1));
		Assert.assertEquals("A",stub.getProgramResponseAtt(2));
	}
	
	@Test
	public void userDoesntWantToKnowTheAnswer(){
		//given
		data.add(new String [] {"P","A"});
		dataChooser.setDataArrays(data);
		stub.addUserAction("No");
		//when
		dataChooser.next();
		//then
		Assert.assertEquals(PuzzlesPrinter.TOUGH,stub.getProgramResponseAtt(2));
	}

}
