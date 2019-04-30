import java.util.*;

public class FiniteAutomata {

    //Grab users input.
    private static Scanner scanner = new Scanner(System.in);
    //Print speed. 
    private int textSpeed;

    //Variable for input string to check for the pattern
    private String tape;
    //Variable for index integer to help us move from character to character in the input string
    private int charIdx = 0;

    //Q (set of states): Variable for array of Nodes that represents our set of states
    private ArrayList<Node> setOfStates = Node.getGlobalNodeSet();
    //F: (set of final states): 
    private ArrayList<Node> setOfFinalStates = Node.getFinalNodeSet();
    //∑ (set of symbols): Custom Object instance that helps us determine which language we're using
    private Language inputSymbols;

    private boolean started = false;


    // δ: (transition functions) these will be defined in a simple logic in each Node instance's run() method.


    public FiniteAutomata(int textSpeed) {

        this.textSpeed = textSpeed;

    }

    public void incrementTapeChar() {

        charIdx = charIdx < tape.length() - 1 ? charIdx + 1 : charIdx;
    
    }

    public boolean isLastTapeChar() {
        
        return charIdx == tape.length() - 1;
    
    }

    public char getCurrentChar() {
        
        return tape.charAt(charIdx);
    
    }

    public int getCharIdx() {
        
        return charIdx;
    
    }


    public void defineInitialFeatures() {

        // Setting Language (∑)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  --" + " (∑) Let's start with setting our Input Symbols. Please enter \"binary\" or \"alpha\": ",
            50
        );
        String languageInput = FiniteAutomata.scanner.next();
        inputSymbols = new Language(languageInput);
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (∑) You selected " + inputSymbols.getLanguageDescriptor() + ".\n" +
            "  -- (∑) The input symbols will be:\n" +
            "      * " + inputSymbols.getSymbolsArrayStr() + "\n",
            50
        );


        // Setting Set of States (Q)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (Q) Next, let's define our Set of States.\n" + 
            "  -- (Q) First, we need a total number of states. Later we'll define each one.\n" +
            "  -- (Q) Please enter the total number of states: ",
            50
        );
        int stateCountInput = FiniteAutomata.scanner.nextInt();
        int stateCount = stateCountInput;
        while (stateCount > 0) {
            new Node(this);
            stateCount--;
        }
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (Q) You entered " + stateCountInput + ".\n" +
            "  -- (Q) Our set of states looks like this:\n" +
            "      * " + Node.getGlobalNodeSetStr(false) + "\n",
            50
        );

        // Recognizing initial state (q)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (q) q0 will be our initial state.\n",
            50
        );

    }

    // Setting Transition Functions (q)
    public void defineTransitionFunctions() {

        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (δ) Now, we will define the transition functions for our states (node by node).\n" +
            "  -- (δ) When we are done we will generate a state transition table to summarize our FSM.\n" + 
            "  -- (δ) To define the transition functions for each state you must enter a space separated\n" +
            "         list of characters with the name of corresponding state at the end.\n" +
            "  -- (δ) The checkboxes indicate if a state has been defined yet.\n",
            50
        );

        for (Node state : setOfStates) {

            state.defineSelf(textSpeed);

        };

        Helpers.typeDelayEffect(
            textSpeed,
            "  -- ALL STATES DEFINED " + Node.getGlobalNodeSetStr(true) + " ---\n",
            50
        );

        Helpers.typeDelayEffect(
            textSpeed*2,
            "  -- GENERATING TRANSITION STATE TABLE ---\n",
            25
        );

        TransitionFunction.printStateTransitionTable();
        
    }
    

    public Language getLanguage() {

        return inputSymbols;

    }

    public void runMachine() {

        tape = " ";

        while (tape != "-1")  {

            System.out.print("Enter the pattern you'd like to test: ");

            reset();

            tape = new Scanner(System.in).next();
    
            setOfStates.get(0).run();

        }

    }

    public void reset() {
        charIdx = 0;
        started = false;
    }

    public boolean getStarted() {

        return started;

    }

    public void setStarted() {
        
        started = true;

    }



}

