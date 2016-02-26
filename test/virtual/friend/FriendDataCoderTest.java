package virtual.friend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class FriendDataCoderTest {

	
	public String dataCoder() throws IOException {
		
		List<String> quotes = Files.readAllLines(Paths.get("F:\\BrassWillow\\PST\\PSD\\GIT\\team_x\\team_x\\exampleData\\quotes.txt"));
		List<String> questions = Files.readAllLines(Paths.get("F:\\BrassWillow\\PST\\PSD\\GIT\\team_x\\team_x\\exampleData\\questions.txt"));
		List<String> sciencequestions = Files.readAllLines(Paths.get("F:\\BrassWillow\\PST\\PSD\\GIT\\team_x\\team_x\\exampleData\\sciencequestions.txt"));
		List<String> puzzles = Files.readAllLines(Paths.get("F:\\BrassWillow\\PST\\PSD\\GIT\\team_x\\team_x\\exampleData\\puzzles.txt"));
		
		
		String resultBeforeCoding = "";

		for (int i = 0; i < quotes.size(); i++) {
			resultBeforeCoding = resultBeforeCoding + "C" + quotes.get(i) + "#" + 
					"A" + questions.get(i) + "#" +
					"S" + sciencequestions.get(i)+ "#" +
					"P" + puzzles.get(i) + "#";
		}

		String resultAfterCoding = Base64.getEncoder().encodeToString(resultBeforeCoding.getBytes());
		return resultAfterCoding;
	}
	
	@Test
	public void testDecodeString() throws IOException{
		String codedData = dataCoder();
		FriendDataDecoder friendDataCoder = new FriendDataDecoder();
		friendDataCoder.getData(codedData);
		
		Assert.assertEquals("Just think how happy you would be if you lost everything you have right now, and then got it back again", friendDataCoder.quotes.get(0)[0]);
		Assert.assertEquals("Frances Rodman", friendDataCoder.quotes.get(0)[1]);
		Assert.assertEquals("What would your friend do?", friendDataCoder.questions.get(0));
		Assert.assertEquals("Brass gets discoloured in the air because of the presence of which of the following gases in air?", friendDataCoder.scienceTest.get(0)[0]);
		Assert.assertEquals("Oxygen", friendDataCoder.scienceTest.get(0)[1]);
		Assert.assertEquals("Hydrogen sulphide", friendDataCoder.scienceTest.get(0)[2]);
		Assert.assertEquals("Carbon dioxide", friendDataCoder.scienceTest.get(0)[3]);
		Assert.assertEquals("Nitrogen", friendDataCoder.scienceTest.get(0)[4]);
		Assert.assertEquals("2", friendDataCoder.scienceTest.get(0)[5]);
		Assert.assertEquals("A man has a wolf, a goat, and a cabbage. He must cross a river with the two animals and the cabbage. There is a small rowing boat, in which he can take only one thing with him at a time. If, however, the wolf and the goat are left alone, the wolf will eat the goat. If the goat and the cabbage are left alone, the goat will eat the cabbage. How can the man get across the river with the two animals and the cabbage?", friendDataCoder.puzzles.get(0)[0]);
		Assert.assertEquals("Don't know", friendDataCoder.puzzles.get(0)[1]);

	}
	
}
