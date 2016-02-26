package virtual.friend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuotesPrinterTest {
	
	SystemConsoleStub stub;
	QuotesPrinter dataChooser;
	ArrayList<String []> data;

	
	@Before
	public void before(){
		data = new ArrayList<String []>();
		stub = new SystemConsoleStub();
		dataChooser = new QuotesPrinter(stub);
		dataChooser.setDataArrays(data);
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
		String quota = "quota";
		String author = "author";
		String string1[] = new String [] {quota,author};
		data.add(string1);
		// when
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		// then
		String expectedAnswer = quota+"\n"+author;
		Assert.assertEquals(expectedAnswer, stub.getProgramResponseAtt(0));
		Assert.assertEquals(expectedAnswer, stub.getProgramResponseAtt(1));
		Assert.assertEquals(expectedAnswer, stub.getProgramResponseAtt(2));
		Assert.assertEquals(expectedAnswer, stub.getProgramResponseAtt(3));
	}

	@Test
	public void returnAllElementsInRightOrder() {
		// given
		String string1 [] = new String [] {"q1","s1"};
		String string2 [] = new String [] {"q2","s2"};
		String string3 [] = new String [] {"q3","s3"};
		data.add(string1);
		data.add(string2);
		data.add(string3);
		// when
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		dataChooser.next();
		// then
		Assert.assertEquals(string2[0]+"\n"+string2[1], stub.getProgramResponseAtt(0));
		Assert.assertEquals(string3[0]+"\n"+string3[1], stub.getProgramResponseAtt(1));
		Assert.assertEquals(string1[0]+"\n"+string1[1], stub.getProgramResponseAtt(2));
		Assert.assertEquals(string2[0]+"\n"+string2[1], stub.getProgramResponseAtt(3));
	}
}
