package challenge.cardFlippingGame.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameOverCheckTest {
	
	GameOverCheck testGameOverCheck = new GameOverCheck();
	
	String testScenarioNoMovesLeft0 = "0.000000";
	String testScenarioNoMovesLeft1 = "........";
	String testScenarioNoMovesLeft2 = "00000000";
	String testScenarioMovesRemaining0 = "1.01.000";
	String testScenarioMovesRemaining1 = "00001000";
	String testScenarioMovesRemaining2 = "11111111";
	
	@Test
	public void checkIfThereAcutallyAreMoreMovesTest() {
		
		assertTrue(testGameOverCheck.noMovesRemain(testScenarioNoMovesLeft0));
		assertTrue(testGameOverCheck.noMovesRemain(testScenarioNoMovesLeft1));
		assertTrue(testGameOverCheck.noMovesRemain(testScenarioNoMovesLeft2));
		
		assertFalse(testGameOverCheck.noMovesRemain(testScenarioMovesRemaining0));
		assertFalse(testGameOverCheck.noMovesRemain(testScenarioMovesRemaining1));
		assertFalse(testGameOverCheck.noMovesRemain(testScenarioMovesRemaining2));
		
	}
	
	@Test
	public void isFirstCharacterCheckWorkingCorrectly() {
		
		assertTrue(testGameOverCheck.isFirstCharacter(0));
		assertFalse(testGameOverCheck.isFirstCharacter(4));
	}
	
	@Test
	public void isLastCharacterCheckWorkingCorrectly() {
		
		String testString = "test";
		
		assertTrue(testGameOverCheck.isLastCharacter(3, testString));
		assertFalse(testGameOverCheck.isLastCharacter(2, testString));
		assertFalse(testGameOverCheck.isLastCharacter(5, testString));
	}
	
	@Test
	public void canPullOnlyWorksWhenIndexValueIsOne() {
		
		assertTrue(testGameOverCheck.canPull(3, "00010000"));
		assertFalse(testGameOverCheck.canPull(1, "00000000"));
	}
	
	@Test 
	public void canFlipCorrectlyDeterminesIfValueCanFlip() {
		
		//first character test
		assertTrue(testGameOverCheck.canflip(0, "0100000"));
		assertFalse(testGameOverCheck.canflip(0, "0.000000"));
		assertFalse(testGameOverCheck.canflip(0,  "0000000"));
		
		//middle character test
		assertTrue(testGameOverCheck.canflip(1, "10000000"));
		assertTrue(testGameOverCheck.canflip(1, "10.00000"));
		assertTrue(testGameOverCheck.canflip(1, "00100000"));
		assertTrue(testGameOverCheck.canflip(1, ".0100000"));
		assertTrue(testGameOverCheck.canflip(1, "10100000"));
		
		assertFalse(testGameOverCheck.canflip(1, "00.0000"));
		assertFalse(testGameOverCheck.canflip(1, "0000000"));
		assertFalse(testGameOverCheck.canflip(1, ".000000"));
		
		//last character test
		assertTrue(testGameOverCheck.canflip(4, "00010"));
		assertFalse(testGameOverCheck.canflip(4, "000.0"));
		assertFalse(testGameOverCheck.canflip(4, "00000"));
	}
}
