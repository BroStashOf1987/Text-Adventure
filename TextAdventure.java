public class TextAdventure{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRows = 3;
		int numCols = 3;
		Room[][] gameBoard = new Room[numRows][numCols];
		
		// Set Up the game board
		for (int i=0; i<numRows; i++) {
			for (int j=0; j<numCols; j++) {
				
				gameBoard[i][j] = new Room();	
				
			}
		}
		TextAdventureCode t = new TextAdventureCode();
		t.startGame(gameBoard);
	}

}
