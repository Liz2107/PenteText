import java.util.Scanner;
public class UserPlay 
{
	static int pOneCol, pOneRow, pTwoCol, pTwoRow;
	public static void playerOneMove()
	{
		System.out.println("Player 1's turn. Enter the preferred location in row space coulumn format.");
		Scanner pOneMoveInput = new Scanner(System.in);
		pOneRow = pOneMoveInput.nextInt();
		pOneCol = pOneMoveInput.nextInt();
		if(Grid.grid[pOneRow - 1][pOneCol - 1] != '+' || pOneRow <= 0 || pOneRow >= 19 || pOneCol >= 19 || pOneCol <= 0)
		{
			System.out.println("Illegal move. Try again.");
			playerOneMove();
		}
		else
		{
			Grid.grid[pOneRow - 1][pOneCol - 1] = 'O';
		}
			
		//checkWin(pOneRow - 1, pOneCol - 1);
	}
	public static void playerTwoMove()
	{
		System.out.println("Player 2's turn. Enter the preferred location in row space coulumn format.");
		Scanner pTwoMoveInput = new Scanner(System.in);
		pTwoRow = pTwoMoveInput.nextInt();
		pTwoCol = pTwoMoveInput.nextInt();
		System.out.println(pTwoRow + " " + pTwoCol);
		if(Grid.grid[pTwoRow - 1][pTwoCol - 1] != '+')
		{
			System.out.println("Illegal move. Try again.");
		}
		else
		{
			Grid.grid[pTwoRow - 1][pTwoCol - 1] = 'X';
		}
		
		//checkWin(pTwoRow, pTwoCol);
	}
	public static void checkSteal(int row, int col)
	{
		//check corners
		if((row == 1 && col == 1) || (row == 18 && col == 1) || (col == 18 && row == 1) || (col == 18 && row == 18))
		{
			
		}
		//check sides
		else if(row < 4)
		{
			for(int i = 0; i < 4; i++)
			{
				
			}
			if(Grid.grid[row][col + 1] != Grid.grid[row][col] && Grid.grid[row][col + 1] != '+' && Grid.grid[row][col + 2] != Grid.grid[row][col] && Grid.grid[row][col + 2] != '+' && Grid.grid[row][col + 3] == Grid.grid[row][col])
			{		
				System.out.println("R Hor Win");
			}
			}
			
		else if(row > 4)
		{
			
		}
		else if(col > 4)
		{
			
		}
		else if(col < 4)
		{
			
		}
		//check middle
		else
		{
			
		}
	}
	public static void checkWin(int row, int col)
	{
		//hor check- loop through row and check if matches input symbol 4+ consecutive times
		int horCount = 0;
		for(int i = 0; i <= 17; i++)
		{
			if(Grid.grid[row - 1][i] == Grid.grid[row - 1][col - 1])
				horCount ++;
			else
				horCount = 0;
			
			if(horCount >= 5)
				Main.gameOver = true;
		}
		
		//vert check- loop through col and check if matches input symbol 4+ consecutive times
		int vertCount = 0;
		for(int j = 0; j <= 17; j++)
		{
			if(Grid.grid[j][col - 1] == Grid.grid[row - 1][col - 1])
				vertCount ++;
			else
				vertCount = 0;
			
			if(vertCount >= 5)
				Main.gameOver = true;
		}
		
		//diag l -> h check
		int diagHLCount = 0; 
		int startRow = row - 1;
		int startCol = col - 1;
		//find the starting diag
		for(int k = 0; k <= 17; k++)
		{
			if(startRow == 0 || startCol == 0)
			{
				k = 17;
			}
			else
			{
				startRow --;
				startCol --;
			}
		}
		//System.out.println("Row: " + startRow + " Col: " + startCol);
		//loop through l -> h diag and check if input symbol matches 4+ times
		int start;
		if(startRow > startCol)
			start = startRow;
		else
			start = startCol;
		for(int l = start; l <= 17; l++)
		{
			if(Grid.grid[row - 1][col - 1] == Grid.grid[startRow][startCol])
				diagHLCount ++;
			else
				diagHLCount = 0;
			if(diagHLCount >= 5)
				Main.gameOver = true;
			startRow++;
			startCol++;
		}
		
		
		
		
		//diag h -> l check
		startRow = row - 1;
		startCol = col - 1;
		int diagLHCount = 0;
		//find starting row and col values
		if(!(startRow >= 15 && startCol >= 15) || (startRow < 4 && startCol < 4))
		{
			for(int m = 0; m <= 17; m++)
			{
				if(startRow == 0)
				{
					m = 17;
				}
				else if(startCol == 17 || startRow == 17)
				{
					m = 17;
				}
				else
				{
					startRow --;
					startCol ++;
				}
			}
			
			//set limits so that it can't get out of bounds rows or cols
			System.out.println("Row: " + startRow + " Col: " + startCol);
			if(startRow == 17)
			{
				start = startCol;
				for(int n = start; n < 18; n++)
				{
					System.out.println(startRow + " " + startCol);
					if(startRow < 0 || startCol < 0)
					{
						n = 18;
					}
					else
					{
					if(Grid.grid[row - 1][col - 1] == Grid.grid[startRow][startCol])
						diagHLCount ++;
					else
						diagHLCount = 0;
					if(diagHLCount >= 5)
						Main.gameOver = true;
					startRow--;
					startCol++;
					}
				}
			}
			else
			{
				if(startRow > startCol)
					start = startRow;
				else
					start = startCol;
				if(startCol == 17)
				{
					start = startRow;
				}
				for(int n = start; n < 18; n++)
				{
					System.out.println(startRow + " " + startCol);
					if(startRow < 0 || startCol < 0)
					{
						n = 18;
					}
					else
					{
					if(Grid.grid[row - 1][col - 1] == Grid.grid[startRow][startCol])
						diagHLCount ++;
					else
						diagHLCount = 0;
					if(diagHLCount >= 5)
						Main.gameOver = true;
					startRow++;
					startCol--;
					}
				}
			}
			
		}
		
		
	}
}
