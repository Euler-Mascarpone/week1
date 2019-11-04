package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ClassObjects
 * - MethodsArrObj (just objects)
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Code here
    out.println("Choose your first hero!");
    Hero H1 = getHero();
    out.println("Choose your second hero!");
    Hero H2 = getHero();

    if (H1.strength < H2.strength){
        out.println(H2.name + " is stronger!");
    } else if (H2.strength < H1.strength) {
        out.println(H1.name + " is stronger!");
    } else {
            out.print("The heroes are equally strong.");
    }




    }

    Hero getHero(){
        Hero H1 = new Hero();
        out.print("What's the name of the hero? ");
        H1.name = sc.nextLine();
        out.print("How strong is " + H1.name + "? ");
        H1.strength = sc.nextInt();
        sc.nextLine();
        return H1;
    }

    }


    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }




