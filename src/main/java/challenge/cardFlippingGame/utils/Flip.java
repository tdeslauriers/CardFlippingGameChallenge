package challenge.cardFlippingGame.utils;

public class Flip {

	public String pullCard(Integer index, String challenge) {
		
		StringBuilder sb = new StringBuilder(challenge);
		sb.setCharAt(index, '.');
		
		return sb.toString();
	}

	public String turnRightCard(Integer index, String challenge) {
		
		
		if ((index + 1) > challenge.length()) {
			
			return "No right card to turn over.";
		} else {
		
			Character rightCardState = challenge.charAt(index + 1);
			Character turnover;
			if (rightCardState.equals('1')) {
				turnover = '0';
			} else if (rightCardState.equals('0')) {
				turnover = '1';
			} else {
				turnover = '.';
			}
			
			StringBuilder sb = new StringBuilder(challenge);
			sb.setCharAt(index + 1, turnover);
			
			return sb.toString();
		}
	}

	public String turnLeftCard(Integer index, String challenge) {
		
		if ((index - 1) < 0) {
			
			return "No left card to turn over.";
		} else {
			Character leftCardState = challenge.charAt(index -1);
			Character turnover;
			if (leftCardState.equals('1')) {
				turnover = '0';
			} else if (leftCardState.equals('0')) {
				turnover = '1';
			} else {
				turnover = '.';
			}
			
			StringBuilder sb = new StringBuilder(challenge);
			sb.setCharAt(index - 1, turnover);
			
			return sb.toString();
		}
	}

}
