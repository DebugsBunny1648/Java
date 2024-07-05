import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to Tic Tac Toe!");
        game.printBoard();

        while (!game.isGameOver()) {
            System.out.print("Player " + game.getCurrentPlayer() + ", enter your move (row[1-3] col[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (game.isValidMove(row, col)) {
                game.makeMove(row, col);
                game.printBoard();
                game.checkWinner();
                game.switchPlayer();
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        if (game.getWinner() == '-') {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + game.getWinner() + " wins!");
        }

        scanner.close();
    }
}
