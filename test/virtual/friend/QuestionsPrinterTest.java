package virtual.friend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuestionsPrinterTest {
	
	SystemConsoleStub stub;
	QuestionsPrinter dataChooser;
	ArrayList<String> data;

	
	@Before
	public void before(){
		data = new ArrayList<String>();
		stub = new SystemConsoleStub();
		dataChooser = new QuestionsPrinter(stub);
		dataChooser.setData(data);
	}
	
	@Test
	public void printNoDataWhenListEmpty() {
		// given
		// when
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		// then
		Assert.assertEquals(FunctionalityRunner.NODATA, stub.getProgramResponseAtt(0));
		Assert.assertEquals(FunctionalityRunner.NODATA, stub.getProgramResponseAtt(1));
		Assert.assertEquals(FunctionalityRunner.NODATA, stub.getProgramResponseAtt(2));
		Assert.assertEquals(FunctionalityRunner.NODATA, stub.getProgramResponseAtt(3));
	}
	
	@Test
	public void constantlyReturnTheSameWhenOneElement() {
		// given
		String string1 = "String1";
		data.add(string1);
		// when
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		// then
		Assert.assertEquals(string1, stub.getProgramResponseAtt(0));
		Assert.assertEquals(string1, stub.getProgramResponseAtt(1));
		Assert.assertEquals(string1, stub.getProgramResponseAtt(2));
		Assert.assertEquals(string1, stub.getProgramResponseAtt(3));
	}

	@Test
	public void returnAllElementsInRightOrder() {
		// given
		String string1 = "String1";
		String string2 = "String2";
		String string3 = "String3";
		data.add(string1);
		data.add(string2);
		data.add(string3);
		// when
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		// then
		Assert.assertEquals(string2, stub.getProgramResponseAtt(0));
		Assert.assertEquals(string3, stub.getProgramResponseAtt(1));
		Assert.assertEquals(string1, stub.getProgramResponseAtt(2));
		Assert.assertEquals(string2, stub.getProgramResponseAtt(3));
	}
}
