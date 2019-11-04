package exercises;

import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (normally print true)
 *
 * See:
 * - MethodsBasics
 * - MethodsArrObj  (just arrays)
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);

        int[] arr = {10, 20, 30, 40, 50};

        out.println(next(arr, 2) == 40);    // Find *next* value given index
                                                   // Index 2 is 30 so next is 40.
        out.println(next(arr, 4) == 10);    // Index 4 is 50 so next is 10 (circular).

        String winner = "Olle";
        // A special case, should print: "Winner is Olle" (or whatever name)
        winnerMsg(winner);
    }

    // ------ Write methods below this  -----------

    int sumTo(int n){
        int k=0;
        for (int i = 1;i <= n;i++){
            k = k + i;
        }
        return k;
    }
    int factorial(int n){
        int k = 1;
        for (int i = 1;i <= n;i++){
            k = k * i;
        }
        return k;

    }
    int digitSum(int digit){
        int k = 1; //Positive number at first
        int i = 10; //start with mod 10
        int s = 0; // sum

        s = digit % 10 - 1; //In order to be able to add k first time below, subtract 1
        while (k > 0){
            s = s + k  ;
            i = i * 10;
            k = (digit % i) / (i / 10); // Getting the correct numbers, remember % is remainder
        }
        return s;


    }
    int next(int[] arr, int n){
        if (n+1 < arr.length){      //Indexing starts at 0
            return arr[n+1];
        }else {
            return arr[0];
        }

    }
    void winnerMsg(String winner){
        out.print("Winner is " + winner);
    }
}
