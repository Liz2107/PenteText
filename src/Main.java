
public class Main {
	static boolean gameOver = false;
	public static void main(String[] args) {
		Grid.printGrid();
		while(!gameOver)
		{
			UserPlay.playerOneMove();
			Grid.printGrid();
			UserPlay.checkWin(UserPlay.pOneRow, UserPlay.pOneCol);
			UserPlay.checkSteal(UserPlay.pOneRow - 1, UserPlay.pOneCol - 1);
			if(!gameOver)
			{
				UserPlay.playerTwoMove();
				Grid.printGrid();
				UserPlay.checkWin(UserPlay.pTwoRow, UserPlay.pTwoCol);
				UserPlay.checkSteal(UserPlay.pTwoRow - 1, UserPlay.pTwoCol - 1);
			}
		}
		System.out.println("Game over.");
	}

}
