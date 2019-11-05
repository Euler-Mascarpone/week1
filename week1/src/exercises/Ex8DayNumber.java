package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Program to calculate the day number for same day in a given year.
 *   - To check solution, see http://mistupid.com/calendar/dayofyear.htm
 *
 *   This is exercising functional decomposition
 *   Assume you have a top level method solving the problem. Break down
 *   top level method into smaller methods solving parts of the problem etc.
 *   During this we run tests to make sure the methods works as expected.
 *   Combine the method to solve the problem.
 *
 */
public class Ex8DayNumber {

    public static void main(String[] args) {
        new Ex8DayNumber().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
       // test();                // <--------- Uncomment to test only


        // -- In ----------------
        out.print("Input the year > ");
        int year = sc.nextInt();
        out.print("Input the month number > ");
        int month = sc.nextInt();
        out.print("Input the day number > ");
        int day = sc.nextInt();

        // --- Process ---------



        // Write the code to call top level method here
        // Then break the method down in smaller methods, call them etc.
        // Inside top level method etc.
        int dayNbr = 0;   // TODO call method for result
        dayNbr = getNbr(year,month,day);
        // ---- Out ----
        printResult(year, month, day, dayNbr);



    }


    // ------------ Write your methods below this ------

    // TODO



    void printResult(int year, int month, int day, int dayNbr) {

        out.println("Ordinal number for " + day + "/" + month + " in " + year + " is: " + dayNbr);
        if (leapYear(year)) {
            out.println(year + " is a leap year");
        } else {
            out.println(year + " is not a leap year");
        }


    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test(){
        printResult(2016,10,18,276);
        exit(0);
    }
    boolean leapYear(int year){ //Checks if the year is a leap year
        if(year % 4 == 0){
            return true;
        } else {
            return false;
        }
    }
    int[] modDays(int[] day,boolean leap){
        if (leap){
            day[1] = 29; //If it is a leap year, February has 29 days
        }
        return day; //Give back modified day array
    }

    int getNbr(int year, int month, int day){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31}; //Number of days a given month if not leap year
        boolean leap = leapYear(year);
        days = modDays(days,leap); //Changes the days array if it is leap year
        int k = day; //The day
        for (int i = 1;i < month;i++){
            k = k + days[i]; //Add all days in a month if it is less than current month
        }
        return k;


    }



}
