import java.util.*;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    String[] introText = {

        "=====Welcome to my FSM project for CS 506 at Pace University.=====\n" +
        "This project is implemented in Java attempts to create a \n" + 
        "\"set up\" wizard for creating a simple Deterministic Finite\n" +
        "Automata.\n",

        "==Background:==\n" +
        "FSM's are basically flowchart style collections of decisions used\n" + 
        "to represent pattern matching algorithms. Hit enter to continue.\n",


        "==Notation and Implementation:==\n" +
        "In computer science we use the following notation to describe FSMs:\n" + 
        "{Q, ∑, q, F, δ} (hit enter to continue after each line)", 

        " - Q: Finite set of states", 

        "    -> We will represent these states with various instances of \"Node\" objects.", 

        "    -> We will represent the set of states by placing the Node instances in an array.",

        " - ∑ : set of Input Symbols", 

        "    -> We will represent these sets with 2 arrays of characters.", 
        
        "    -> One array will contain binary values, and the other alphabetical characters.",

        "    -> The user can pick which \"language\" to use.",

        " - q : Initial state", 

        "    -> This will be the first Node instance in our array (index 0)!", 

        " - δ : Transition Function", 

        "    -> Each Node instance has a run() method in which there is a logic that will\n" + 
        "       determine (based on local data that the user sets for each Node)\n"+
        "       which next Node instance to point to (call run() on.).\n" +
        "\nReady? Hit enter to get started. "

    };

    private int textSpeed; 

    public Menu(int textSpeed) {

        this.textSpeed = textSpeed;

    }
    
    public void printIntro() {

        String input;

        Helpers.typeDelayEffect(textSpeed, "Skip Intro? [Yy/Nn]: ", 25);
        
        input = Character.toString(scanner.next().toLowerCase().charAt(0));

        if (input.equals("n")) {

            for (String introSection : introText) {

                Helpers.typeDelayEffect(textSpeed, introSection, 25);
    
                input = scanner.nextLine();
    
                if (!input.equals("")) {
    
                    break;
    
                }
    
                else {
    
                    System.out.println("");
    
                }
    
    
            }

        }

        else {

            return;

        }

    }

}