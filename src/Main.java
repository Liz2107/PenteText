
public class Main {
	static boolean gameOver = false;
	public static void main(String[] args) {
		Grid.printGrid();
		while(!gameOver)
		{
			UserPlay.playerOneMove();
			Grid.printGrid();
			UserPlay.checkWin(UserPlay.pOneRow, UserPlay.pOneCol);
			if(!gameOver)
			{
				UserPlay.playerTwoMove();
				Grid.printGrid();
				UserPlay.checkWin(UserPlay.pTwoRow, UserPlay.pTwoCol);	
			}
		}
		System.out.println("Game over.");
	}

}
