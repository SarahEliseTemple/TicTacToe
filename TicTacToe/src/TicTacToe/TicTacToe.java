package TicTacToe;
/*
 * Name:Sarah Temple
 * Date: 
 */
public class TicTacToe {

	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE =2;
	
	
	public TicTacToe() {
		printBoard();
		
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}

	public void printBoard() {
		System.out.println("\t1\t2\t3");
		for (int row = 0; row < board.length; row++) {
			String output = "a\t";
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column]== BLANK) {
					output += "\t";
				}
			}
			System.out.println(output);
			
			
		}
	}
}
