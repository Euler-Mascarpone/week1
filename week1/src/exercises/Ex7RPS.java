package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex7RPS {

    public static void main(String[] args) {
        new Ex7RPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds
        int roundHuman = 0; //Move of the human
        int roundComputer = 0; //Move of the computer

        // All code here ... (no method calls)

        out.println("Welcome to Rock, Scissors and Paper");

        // Here the game loop starts

            // -------- Input --------------

            for(int i = 0; i < maxRounds;i++){
                out.println("Select 1, 2 or 3 (for R, P or S)");
                roundHuman = sc.nextInt();
                sc.nextLine();
                roundComputer = rand.nextInt(3); //Number between 0 och 2) strict inequality for 3
                roundComputer = roundComputer + 1; //Want number between 1 and 3
                out.println("Computer choose " + roundComputer);
                if(roundHuman == roundComputer - 1){
                    total = total - 1; //Computer gets a point
                    out.println("Computer won");
                } else if (roundComputer == roundHuman - 1){
                    total = total + 1;
                    out.println("You won");
                } else if (roundComputer == 3 && roundHuman == 1){
                    total = total + 1; //Rock beats scissors
                    out.println("You won");
                }else if(roundHuman == 3 && roundComputer == 1){
                    total = total - 1; //Rock beats scissors
                    out.println("Computer won");
                }else if(roundHuman == roundComputer) {
                    out.println("Draw");
                }
                out.println("Result is " + total);
            }




            // ----- Process -----------------


            // ---------- Output --------------


          //--------  End Game loop

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
