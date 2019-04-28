import java.util.*;

public class FiniteAutomata {

    //Grab users input.
    private Scan scanner = new Scanner(System.in);

    //Variable for input string to check for the pattern
    private String tape;

    //Variable for index integer to help us move from character to character in the input string
    private int currIdx = 0;

    //Q (set of states): Variable for array of Nodes that represents our set of states
    private Node[] setOfStates;
    private int numStates;
    private int stateIdx;
    
    //∑ (set of symbols): Custom Object instance that helps us determine which language we're using
    private Language inputSymbols;

    //q: (initial state): This will be represented by the Node instanfce at setOfStates[0]

    //F: (set of final states): 
    // Representing this is a little bit more complicated.
    // For each Node instance we define as being a "final" state, we will
    // increase finalStateCount by 1. Then, when we are done defining our states,
    // we will create an array of the size of finalStateCount (at setOfFinalStates) and (using a method)
    // we will push references to all of the Nodes in setOfStates that have the field "isFinalState" set 
    // to true.
    private int finalStateCount;
    private Nodes[] setOfFinalStates;

    // δ: (transition functions) these will be defined in a simple logic in each Node instance's run() method.

    public FiniteAutomata() {

    }

    private void setInputSymbols() {
    
        this.inputSymbols = inputSymbols;

    }

    private void setNumStates(int numStates) {

        setOfStates = new Node[numStates];

    }


}

