package assignments.product;

import jdk.internal.util.xml.impl.Input;

import java.util.*;

import static java.lang.System.*;

/*

 * Nim Game
 * See https://en.wikipedia.org/wiki/Nim
 *
 * Plan and process: Compare Rock, Paper Scissor from exercises !
 */
public class Nim {

    public static void main(String[] args) {
        new Nim().program();
    }

    void program() {
        Scanner inp = new Scanner(in);      //Create scanner object to read
        Random rand = new Random();         //Create random object to generate random integers for gameplay

        while (true) {
            //Start
            int coins = rand.nextInt(40) + 10;              //Randomize the initial number of coins
            int maxdraw = rand.nextInt(coins / 5 + 1) + 2;  //Randomize the allowed number of coins to be taken
            int player_input = 0;                           //Variable to store player input integer
            int other_move = 0;                             //The computer's "input"
            int error_count = 0;                            //To prevent total fuck up
            boolean try_success = false;                    //Switches to true if inp.nextInt() is successful

            while (coins > 0) { //Main gameplay loop
                out.print("There are " + coins + " coins in the pile, take 1 to " + maxdraw + " coins > ");

                error_count = 0;
                //Input, loop until a valid input is given (or until 5 errors occurr, but should never happen)
                while (!try_success && error_count < 5) {
                    try_success = false;
                    try {
                        player_input = inp.nextInt();
                        while (!(player_input > 0 && player_input < maxdraw + 1 && coins >= player_input)) {
                            out.print("Input is OOB (1 to " + maxdraw +") > ");
                            player_input = inp.nextInt();
                            try_success = true;
                        }
                    } catch (InputMismatchException e) {
                        error_count++;
                        out.print("Non-integer input > ");
                        inp.nextLine();
                    }
                }
                coins -= player_input; //Player done, check win-con
                if (coins <= 0) {
                    out.print("Player wins!\n\n\n\n");
                    break;
                }

                other_move = coins % maxdraw + 1;   //Always tries to do the optimal move
                if (other_move == 0)                //If the optimal is to not take any, randomize the action
                    other_move = rand.nextInt(maxdraw) + 1;
                out.println("The computer takes " + other_move + " coins");
                coins -= other_move % (maxdraw + 1);    //Computer done,
                if (coins <= 0) {
                    out.print("Computer wins!\n\n\n\n");
                    break;
                }
            }
        }
    }
}
