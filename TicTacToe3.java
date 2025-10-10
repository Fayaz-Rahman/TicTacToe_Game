import java.util.Scanner;

public class TicTacToe3 {
    
        static String[] board = new String[9];
        static String turn = "x";


     public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String winner = null;
            
        for(int i = 0; i <9; i ++){
                board[i] = String.valueOf(i + 1);
            }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
            
        while(winner == null){
        System.out.println("Its" + turn + " 's turn. Enter a slot number to place " + turn + " in:");
        
        if(!in.hasNext()){
            System.out.println("Invalid input. Please enter a number.");
            in.next();
            continue;
        }

        int move = in.nextInt();
        if(move > 9 || move < 1){
            System.out.println("Invalid move. choose between 1 and 9.");
            continue;
        }

        if(!board[move -1].equals(String.valueOf(move))){
            System.out.println("Slot already taken. Try again.");
            continue;
        }

        board[move -1] = turn;
        printBoard();
        winner = checkWinner();

        if(winner == null){
            turn = turn.equals("X")?"O" :"X";
        }
            }

            System.out.println(winner.equals(draw) ? "Its a draw!" :"congratulations!" + winner + "wins");
            in.close();
        }

        static void printBoard(){
            System.out.println("\n /---/---/---/");
            for(int i =0; i <9; i+=3){
                System.out.println("|" + board[i] + " | " + board[i+1] + " | " + board[i+2] + " |");
                System.out.println("/-----------/");
            }
        }
        

}
