package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        Player actual; //The one whose turn it is?
        Player winner = null;
        char[] board = createBoard();  // alt. { EMPTY, EMPTY, ... }

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        if (rand.nextBoolean()) { //Deciding who starts
            actual = p1;
        } else {
            actual = p2;
        }

        // Game loop

            // -- Input ----------



        // --- Process ----------
        boolean winState = false;
        int round = 1; //Current round
        int markspot = -1; // Spot where mark is placed
        while (!winState && round <= 9){ //While nobody has won
            if (actual == p1){ //Changes player
                actual = p2;
            }else {
                actual = p1;
            }
            markspot = getPlayerSelection(actual);
            board[markspot] = actual.mark;
            winState = hasWon(board,actual.mark); //Checks if player won
            plotBoard(board);

            round++;
        }

            // -- Output --------

        // End game loop
        if(winState){
            winner = actual;
        }
        out.println("Game over!");
        plotBoard(board);

        if (winner != null) {
            out.println("Winner is " + actual.name);
        } else {
            out.println("Draw");
        }
    }


    // ---------- Methods below this ----------------


    // TODO

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String name, char mark) {  // A constructor to initialize
            this.name = name;  // "this" is the actual object we're initializing
            this.mark = mark;  // Used here because of name clashes parameters/instance variables
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);

        // "Hard coded" test boards
        char[] testBoard1 = {'X', 'X', 'X', '0', 'O', 'X', 'O', '0', 'O'};
        char[] testBoard2 = {'-', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] testBoard3 = {'-', 'X', '0', '-', 'X', '-', 'O', 'X', 'O'};
        char[] testBoard4 = {'X', 'X', 'X', '-', 'O', '-', 'O', '-', 'O'};
        char[] testBoard5 = {'X', '0', '-', '-', 'X', '0', 'O', '-', 'X'};

        // TODO Tests

        exit(0);
    }
    boolean hasWon(char[] board,char mark){ //Checks if the player won
        for(int i = 0;i < 3;i++){
            if((mark == board[i] && mark == board[i+3] && mark == board[i+6])){ //If you have a column of three
                return true;
            }else if(mark == board[i] && mark == board[i+1] && mark == board[i+2]){ //If you have a row of three
                return true;
            }
        }
        if ((mark == board[0] && mark == board[4] && mark == board[8]) || (mark == board[2] && mark == board[4] && mark == board[6])){ //Checks if we have three in a row in diagonals
            return true;
        }else{
            return false; //If none of the above, return false
        }

    }
}