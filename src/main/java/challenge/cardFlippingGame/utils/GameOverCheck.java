package challenge.cardFlippingGame.utils;

public class GameOverCheck {
	
	public boolean noMovesRemain(String scenario) {
		
		for (int i = 0; i < scenario.length(); i++) {
			
			if (canPull(i, scenario) || canflip(i, scenario )) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFirstCharacter(Integer index) {
		
		if (index <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean isLastCharacter(Integer index, String string) {
		
		//need the + 1 for extra position in string array length
		if (index + 1 == string.length()) {
			return true;
		} 
		return false;
	}
	
	public boolean canPull(Integer index, String scenario) {
		
		Character checkCharacter = scenario.charAt(index);
		if (checkCharacter.equals('1')) {
			return true;
		}
		return false;
	}
	
	public boolean canflip(Integer index, String scenario) {
		
		Character checkCharacter = scenario.charAt(index);
		Character leftCharacter = '0';
		if (!isFirstCharacter(index)) {
			leftCharacter = scenario.charAt(index - 1);
		}
		Character rightCharacter = '0';
		if(!isLastCharacter(index, scenario)) {
			rightCharacter = scenario.charAt(index + 1); 
		}

		//middle characters
		if(checkCharacter.equals('0') && 
				!isFirstCharacter(index) &&
				!isLastCharacter(index, scenario) &&
				(leftCharacter.equals('1') || rightCharacter.equals('1'))) {
			return true;
		}
		
		//first character
		if (isFirstCharacter(index) &&
				checkCharacter.equals('0') &&
				rightCharacter.equals('1')) {
			return true;
		}
		
		//last character
		if (isLastCharacter(index, scenario) &&
				checkCharacter.equals('0') &&
				leftCharacter.equals('1')) {
			return true;
		}

		return false;
	}	
}
