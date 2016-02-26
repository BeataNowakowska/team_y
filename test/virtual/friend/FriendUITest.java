package virtual.friend;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import virtual.friend.FriendUI;

public class FriendUITest {

	SystemConsoleStub systemConsole;
	ScienceTestPrinter scienceTestPrinter;
	PuzzlesPrinter puzzlesPrinter;
	ArrayList<String> questionsList;
	ArrayList<String []> quotasArrayList;
	
	FriendUI friend;

	@Before
	public void before() {
		systemConsole = new SystemConsoleStub();
		questionsList = new ArrayList<String>();
		questionsList.add("CheerUp1");
		questionsList.add("CheerUp2");
		quotasArrayList = new ArrayList<String []>();
		quotasArrayList.add(new String [] {"Q1","A1"});
		quotasArrayList.add(new String [] {"Q1","A1"});
		QuestionsPrinter basicFunctionality = new QuestionsPrinter(systemConsole);
		basicFunctionality.setData(questionsList);
		QuotesPrinter quotesPrinter = new QuotesPrinter(systemConsole);
		quotesPrinter.setDataArrays(quotasArrayList);
		puzzlesPrinter = new PuzzlesPrinter(systemConsole);
		scienceTestPrinter = new ScienceTestPrinter(systemConsole);
		friend = new FriendUI(systemConsole, basicFunctionality, quotesPrinter, scienceTestPrinter, puzzlesPrinter);
	}

	@Test
	public void userIsProperlyWelcomed() {
		// given
		systemConsole.addUserAction("q");
		// when
		friend.run();
		// then
		Assert.assertEquals(FriendUI.GREETING, systemConsole.getProgramResponseAtt(0));
	}

	@Test
	public void userIsProperlyGoodbye() {
		// given
		systemConsole.addUserAction("q");
		// when
		friend.run();
		// then
		Assert.assertEquals(FriendUI.BYEBYE, systemConsole.getProgramResponseAtt(1));
	}

	@Test
	public void userIsCheeredUp() {
		// given
		systemConsole.addUserActions(new String[] { "c", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(quotasArrayList.get(0)[0] + "\n" + quotasArrayList.get(0)[1] , systemConsole.getProgramResponseAtt(1));
	}

	@Test
	public void userIsAskedQuestion() {
		// given
		systemConsole.addUserActions(new String[] { "a", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(questionsList.get(1), systemConsole.getProgramResponseAtt(1));
	}
	
	@Test
	public void userIsAskedScienceQuestion() {
		// given
		ArrayList<String []> scienceQuestions = new ArrayList<String []>();
		scienceQuestions.add(new String []{"Q","A","1"});
		scienceTestPrinter.setDataArrays(scienceQuestions);
		systemConsole.addUserActions(new String[] { "s", "1", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(scienceQuestions.get(0)[0]+"\n"+scienceQuestions.get(0)[1], systemConsole.getProgramResponseAtt(1));
	}
	
	@Test
	public void userIsGivenPuzzle() {
		// given
		ArrayList<String []> puzzles = new ArrayList<String []>();
		puzzles.add(new String []{"P","A","1"});
		puzzlesPrinter.setDataArrays(puzzles);
		systemConsole.addUserActions(new String[] { "p", "Yes", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(puzzles.get(0)[0], systemConsole.getProgramResponseAtt(1));
	}

	@Test
	public void userCanDisplayHelp() {
		// given
		systemConsole.addUserActions(new String[] { "h", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(FriendUI.HELP, systemConsole.getProgramResponseAtt(1));
	}

	@Test
	public void userCanSwitchBetweenOperations() {
		// given
		systemConsole.addUserActions(new String[] { "e", "h", "a", "c", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(FriendUI.NOT_IMPLEMENTED_YET, systemConsole.getProgramResponseAtt(1));
		Assert.assertEquals(FriendUI.HELP, systemConsole.getProgramResponseAtt(2));
		Assert.assertEquals(questionsList.get(1), systemConsole.getProgramResponseAtt(3));
		Assert.assertEquals(quotasArrayList.get(0)[0] + "\n" + quotasArrayList.get(0)[1], systemConsole.getProgramResponseAtt(4));
	}

	@Test
	public void userCanChooseTheSameOperation() {
		// given
		systemConsole.addUserActions(new String[] { "a", "a", "a", "q" });
		// when
		friend.run();
		// then
		Assert.assertEquals(questionsList.get(1), systemConsole.getProgramResponseAtt(1));
		Assert.assertEquals(questionsList.get(0), systemConsole.getProgramResponseAtt(2));
		Assert.assertEquals(questionsList.get(1), systemConsole.getProgramResponseAtt(3));
	}

}
