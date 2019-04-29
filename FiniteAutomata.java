import java.util.*;

public class FiniteAutomata {

    //Grab users input.
    private Scanner scanner = new Scanner(System.in);

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
    private Node[] setOfFinalStates;

    // δ: (transition functions) these will be defined in a simple logic in each Node instance's run() method.

    private int textSpeed;

    public FiniteAutomata(int textSpeed) {

        this.textSpeed = textSpeed;

    }

    public void defineFeatures() {

        // Setting Language (∑)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  --" + " (∑) Let's start with setting our language. Please enter \"binary\" or \"alpha\": "
        );
        String languageInput = scanner.next();
        inputSymbols = new Language(languageInput);
        System.out.println("  -- You selected " + inputSymbols.getLanguageDescriptor() + ".");
        System.out.println("  -- The input symbols will be:");
        Helpers.typeDelayEffect(textSpeed, "       " + inputSymbols.getSymbolsArrayStr() + "\n");

        // Setting Set of States (Q)
     
    
    }




}

