public class Menu {

    public Menu() {

    }

    public void printIntro() {

        System.out.println(
            "=====Welcome to my FSM project for CS 506 at Pace University.=====\n" +
            "This project is implemented in Java attempts to create a \n" + 
            "\"set up\" wizard for creating simple a Non-Deterministic Finite\n" +
            "Automata. Enter \"go\" to continue.\n\n"
        );

        System.out.println(
            "==Background:==\n" +
            "FSM's are basically flowchart style collections of decisions used\n" + 
            "to represent pattern matching algorithms.\n\n"
        );

        System.out.println(
            "==Notation and Implementation:==\n" +
            "In computer science we use the following notation to describe FSMs:\n" + 
            "{Q, ∑, q, F, δ}\n" + 
            " - Q: Finite set of states\n" +
            "    -> We will represent these states with various instances of \"Node\" objects.\n" +
            "    -> We will represent the set of states by placing the Node instances in an array.\n" +
            " - ∑ : set of Input Symbols\n" +
            "    -> We will represent these states 2 arrays of characters (char).\n" +
            "    -> One array will contain binary values, and the other alphabetical characters." +
            " - q : Initial state\n" +
            "    -> This will be the first Node instance in our array (index 0)!\n" +
            " - δ : Transition Function\n" +
            "    -> Each Node instance has a run() method in which there is a logic that will\n" +
            "       determine (based on local data that the user sets for each Node)\n" +
            "       which next Node instance to point to (call run() on.)"
        );

    }

    

}