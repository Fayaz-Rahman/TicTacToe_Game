
    import java.util.Scanner;

public class TicTacToe2 {

    static String[] board = new String[9];
    static String turn = "X";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String winner = null;

        // Initialize board with slot numbers
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (winner == null) {
            System.out.print(turn + "'s turn. Choose slot (1-9): ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // discard invalid input
                continue;
            }

            int move = sc.nextInt();
            if (move < 1 || move > 9) {
                System.out.println("Invalid slot. Choose between 1 and 9.");
                continue;
            }

            if (!board[move - 1].equals(String.valueOf(move))) {
                System.out.println("Slot already taken. Try again.");
                continue;
            }

            board[move - 1] = turn;
            printBoard();
            winner = checkWinner();

            if (winner == null) {
                turn = turn.equals("X") ? "O" : "X";
            }
        }

        System.out.println(winner.equals("draw") ? "It's a draw!" : "Congratulations! " + winner + " wins!");
        sc.close();
    }

    static void printBoard() {
        System.out.println("\n|---|---|---|");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("|-----------|");
        }
    }

    static String checkWinner() {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] pattern : winPatterns) {
            String line = board[pattern[0]] + board[pattern[1]] + board[pattern[2]];
            if (line.equals("XXX")) return "X";
            if (line.equals("OOO")) return "O";
        }

        for (String cell : board) {
            if (cell.matches("\\d")) return null; // game still in progress
        }

        return "draw";
    }
}


