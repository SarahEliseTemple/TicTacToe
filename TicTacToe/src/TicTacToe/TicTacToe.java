package TicTacToe;
/*
 * Name:Sarah Temple
 * Date: 
 */
import java.util.Scanner;
public class TicTacToe {

	int[][] board = new int[3][3];
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE =2;
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN;
	Scanner scanner;
	String input = "";
	
	public TicTacToe() {
		
		while (true) {
			printBoard();
			scanner = new Scanner(System.in);
			input = scanner.nextLine();
			if (input.length() != 2) {
				System.out.println("Enter a letter followed by a number");
			}
			else if (input.charAt(0)!= 'a' &&
					input.charAt(0)!= 'b' &&
					input.charAt(0)!= 'c') {
						System.out.println("Row must be a, b, or c.");
			}
			else if (input.charAt(1)!= '1' &&
					input.charAt(1)!= '2' &&
					input.charAt(1)!= '3') {
				System.out.println("Column must be 1, 2, or 3.");
			}
			else {
				int row = input.charAt(0) - 'a';
				int column = input.charAt(1) - '1'; 
				System.out.println(row+", "+ column);
				if (turn == X_TURN) {
					board[row][column] = X_MOVE;
					turn = O_TURN;
				}
				else {
					board[row][column] = O_MOVE;
					turn =  X_TURN;
				}
				
			}
		}
	}

	
	public static void main(String[] args) {
		new TicTacToe();
	}

	public void printBoard() {
		//board[1][2] = X_MOVE; -- tests
		//board[0][0] = O_MOVE;
		System.out.println("\t1\t2\t3");
		for (int row = 0; row < board.length; row++) {
			String output = (char)('a'+row)+"\t";
			for (int column = 0; column < board[0].length; column++) {
				if (board[row][column]== BLANK) {
					output += "\t";
				}
				else if (board[row][column] == X_MOVE) {
					output += "X\t";
				}
				else if (board[row][column] == O_MOVE) {
					output +="O\t";
				}
			}
			System.out.println(output);
			
			
		}
	}
}

