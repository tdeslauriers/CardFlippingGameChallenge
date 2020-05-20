package challenge.cardFlippingGame.utils;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FlipTest {
	
	Flip testFlip = new Flip();
	String testChallenge = "0100110";
	Integer testIndex = 1;
	
	@Test
	public void pullCardReplacesIndexWithPeriodTest() {
		
		assertEquals("0.00110", testFlip.pullCard(testIndex, testChallenge));
	}
	
	@Test
	public void turnRightCardReplacesRightValueTest() {
		
		assertEquals("0110110", testFlip.turnRightCard(testIndex, testChallenge));
		assertEquals("No right card to turn over.", 
				testFlip.turnRightCard(testChallenge.length(), testChallenge));
		assertEquals("01.0110", testFlip.turnRightCard(testIndex, "01.0110"));
	}
	
	@Test
	public void turnLeftCardReplacesLeftValueTest() {
		
		assertEquals("1100110", testFlip.turnLeftCard(testIndex, testChallenge));
		assertEquals("No left card to turn over.",
				testFlip.turnLeftCard(0, testChallenge));
		assertEquals(".100110", testFlip.turnLeftCard(testIndex, ".100110"));
	}
}
