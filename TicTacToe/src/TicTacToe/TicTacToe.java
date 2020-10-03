package TicTacToe;
/* Name:Sarah Temple
 * Date: October 2
 * This should be a tictactoe game for the user to play with themselves
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
	boolean stillPlaying = true;
	boolean askToPlayAgain = false;
	
	public TicTacToe() {
		while (stillPlaying == true) {
			while (checkWin(X_MOVE) == false && checkWin(O_MOVE)==false && checkTie() == false) {
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
			if (checkWin(X_MOVE) == true) {
				System.out.println("X wins!!");
				askToPlayAgain = true;
			}
			else if (checkWin(O_MOVE) == true) {
				System.out.println("O wins!!");
				askToPlayAgain = true;
			}
			else if (checkTie() == true) {
				System.out.println("Its a tie!");
				askToPlayAgain = true;
			}
			if (askToPlayAgain == true) {
				System.out.println("Do you want to play again? Type Y for yes and N for no.");
				scanner = new Scanner(System.in);
				String yesno = scanner.nextLine();
				if (yesno == "Y") {
					askToPlayAgain = false;
					stillPlaying = true;
				}
				else if (yesno =="N") {
					askToPlayAgain = false;
					stillPlaying = false;
				}

			}
		}
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}

	public void printBoard() {// This is where we 
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
	public boolean checkWin(int player) {
		if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
			return true;
		}
		if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			return true;
		}
		if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			return true;
		}
		if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		
		return false;
	}
	public boolean checkTie() {
		for(int row = 0; row < board.length; row++) {
			for (int column = 0; column < board.length; column++) {
				if (board[row][column] == BLANK) {
					return false;
				}
			}
		}
		return true;
	}
}

