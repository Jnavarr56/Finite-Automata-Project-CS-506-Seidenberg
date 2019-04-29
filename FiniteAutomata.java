import java.util.*;

public class FiniteAutomata {

    //Grab users input.
    private Scanner scanner = new Scanner(System.in);
    //Print speed. 
    private int textSpeed;

    //Variable for input string to check for the pattern
    private String tape;
    //Variable for index integer to help us move from character to character in the input string
    private int charIdx = 0;

    //Q (set of states): Variable for array of Nodes that represents our set of states
    //q: (initial state): This will be represented by the Node instance at setOfStates.get(0)
    private ArrayList<Node> setOfStates = Node.getGlobalNodeSet();
    //F: (set of final states): 
    private ArrayList<Node> setOfFinalStates = Node.getFinalNodeSet();
    //∑ (set of symbols): Custom Object instance that helps us determine which language we're using
    private Language inputSymbols;


    // δ: (transition functions) these will be defined in a simple logic in each Node instance's run() method.


    public FiniteAutomata(int textSpeed) {

        this.textSpeed = textSpeed;

    }

    public void defineInitialFeatures() {

        // Setting Language (∑)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  --" + " (∑) Let's start with setting our Input Symbols. Please enter \"binary\" or \"alpha\": ",
            50
        );
        String languageInput = scanner.next();
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
        int stateCountInput = scanner.nextInt();
        int stateCount = stateCountInput;
        while (stateCount > -1) {
            new Node();
            stateCount--;
        }
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (Q) You entered " + stateCountInput + ".\n" +
            "  -- (Q) Our set of states looks like this:\n" +
            "      * " + Node.getGlobalNodeSetStr() + "\n",
            50
        );

        // Recognizing initial state (q)
        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (q) q0 will be our initial state.\n",
            50
        );





        

        
     
    
    }




}

