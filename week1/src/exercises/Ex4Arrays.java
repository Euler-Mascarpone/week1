package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ArrayBasics
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write code here
        // code

        int[] arr = {1, 2, 3, 4, 5};
        char[] s;
        out.println("Write your 5 favourite numbers, enter after each"); // Don't know how to read everything at once

        //Input

        for(int i = 0; i < 5; i++ ){
            arr[i]=sc.nextInt();
            sc.nextLine();
        }
        out.println("Your array is " + Arrays.toString(arr));
        out.println("What number do you want to find?");
        int f = sc.nextInt();
        sc.nextLine();


        //Processing

        for(int i = 0;i < 5;i++){
            if (arr[i] == f) {
                out.println("Your number was found at index " + i);
                break;
            } else if (i == 4){
                out.println("Your number was not found");
            }

        }


        //Output
    }
}
