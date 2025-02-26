package Tugas;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        player1 = new Player("Player 1 (O)", 'O');
        player2 = new Player("Player 2 (X)", 'X');
    }

    public void playGame() {
        board.printBoard();
        boolean gameWon = false;
        int movesCount = 0;

        while (!gameWon && movesCount < 9) {
            Player currentPlayer = (movesCount % 2 == 0) ? player1 : player2;
            System.out.println(currentPlayer.getName() + " turn. Enter your move (row and column) [1-3]:");

            int row, col;
            while (true) {
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;

                if (board.isValidMove(row, col)) {
                    board.makeMove(row, col, currentPlayer.getSymbol());
                    break;
                } else {
                    System.out.println("Invalid move. Try again!");
                }
            }

            board.printBoard();
            movesCount++;

            if (board.checkWin(currentPlayer.getSymbol())) {
                gameWon = true;
                System.out.println(currentPlayer.getName() + " wins!");
            }
        }

        if (!gameWon) {
            System.out.println("Draw!");
        }
    }
}
