package assignments.product;

import java.util.Random;
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

    int AITurn(int pile, int minTake, int maxTake){
        // Algorithm for optimal(?) play by the AI
        return minTake + (pile % (minTake + maxTake));
    }

    int playerTurn(int pile, int minTake, int maxTake){
        int take = 0;
        Boolean success = false;

        Scanner input = new Scanner(in);

        while(!success)
            try {
                while ((take = input.nextInt()) < minTake || take > maxTake)
                    out.print("Illegal amount! Take coins ( " + minTake + " - " + maxTake + " ) > ");
                success = true;
            }

            catch(InputMismatchException e){
                input.nextLine();
                out.print("Not an integer! Take coins ( " + minTake + " - " + maxTake + " ) > ");
            }

        return take;
    }

    Boolean restart(){
        int again = -1;
        Boolean success = false;

        Scanner input = new Scanner(in);

        while(!success) {
            try {
                while ((again = input.nextInt()) < 0 || again > 1)
                    out.print("Illegal input! Do you want to play again? ( 0 = no, 1 = yes) > ");
                success = true;
            } catch (InputMismatchException e) {
                input.nextLine();
                out.print("Not an integer! Do you want to play again? ( 0 = no, 1 = yes) > ");
            }
        }

        if(again == 1)
            return true;
        return false;
    }

    void program() {
        boolean play = true;
        while (play) {
            int pile = 13;
            int maxTake = 3;
            int minTake = 1;
            int take;
            Boolean turn = true; // true = AI, false = human

            out.println("Welcome to NIM");

            while (pile > 0) {
                if (pile == 1)
                    out.println("There's 1 coin in the pile");
                else
                    out.println("There's " + pile + " coins in the pile");

                turn = !turn;

                // AI's turn
                if (turn) {
                    // AI take function call
                    take = AITurn(pile, minTake, maxTake);

                    pile -= take;
                    if (take == 1)
                        out.println("AI took 1 coin");
                    else
                        out.println("AI took " + take + " coins");
                }

                // Player's turn
                else {
                    out.print("Take coins > ");

                    // Input -- makes sure the amount taken is not too big/small
                /*while((take = input.nextInt()) < minTake || take > maxTake)
                    out.print("Illegal amount! Take coins ( " + minTake + " - " + maxTake + " ) > ");*/

                    take = playerTurn(pile, minTake, maxTake);

                    pile -= take;
                    if (take == 1)
                        out.println("Player took 1 coin");
                    else
                        out.println("Player took " + take + " coins");
                }
            }

            out.println();
            out.print("The winner is the ");
            if (turn)
                out.println("AI!");
            else
                out.println("player!");
            out.println();

            out.print("Do you want to play again? (0 = no, 1 = yes) > ");
            play = restart();
        }
    }
}
