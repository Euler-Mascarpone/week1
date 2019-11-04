package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here

        int s = 0;
        int avg = 0;
        int i = 1;
        int k = 0;
        out.println("Enter the positive whole integers you want to sum, one at a time, end with -1");

        // -- Input (and bookkeeping)

        while (true) {
            k = sc.nextInt();
            if (k < 0) {        //If you entera negative number, stop
                break;
            }
            s = s + k;
            i++;
        }

        // -- Process---
        if (i == 0){
            avg = 0;
        } else {
            avg = s / i;
        }


        // -- Output ----
        out.println("Sum = " + s + " Avg = " + avg);
    }

}
