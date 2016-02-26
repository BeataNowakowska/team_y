package virtual.friend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScienceTestPrinterTest {
	SystemConsoleStub stub;
	ScienceTestPrinter dataChooser;
	ArrayList<String []> data;

	
	@Before
	public void before(){
		data = new ArrayList<String []>();
		stub = new SystemConsoleStub();
		dataChooser = new ScienceTestPrinter(stub);
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
		data.add(new String [] {"Q","A1","A2","A3","2"});
		dataChooser.setDataArrays(data);
		//when
		stub.addUserAction("1");
		dataChooser.next();
		//then
		Assert.assertEquals("Q"+"\n"+"A1"+"\n"+"A2"+"\n"+"A3", stub.getProgramResponseAtt(0));
		Assert.assertEquals(ScienceTestPrinter.GIVEMEANSWER, stub.getProgramResponseAtt(1));
		
	}
	
	@Test
	public void userDoesntKnowTheAnswer(){
		//given
		data.add(new String [] {"Q","A1","A2","A3","2"});
		dataChooser.setDataArrays(data);
		//when
		stub.addUserAction("1");
		dataChooser.next();
		//then
		Assert.assertEquals(ScienceTestPrinter.WRONGANSWER,stub.getProgramResponseAtt(2));
	}
	
	@Test
	public void userKnowsTheAnswer(){
		//given
		data.add(new String [] {"Q","A1","A2","A3","2"});
		dataChooser.setDataArrays(data);
		//when
		stub.addUserAction("2");
		dataChooser.next();
		//then
		Assert.assertEquals(ScienceTestPrinter.CORRECT,stub.getProgramResponseAtt(2));
	}
}
