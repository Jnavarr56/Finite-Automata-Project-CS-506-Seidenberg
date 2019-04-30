import java.util.*;

public class Node {

    private static ArrayList<Node> FINAL_NODE_SET = new ArrayList<Node>();
    private static ArrayList<Node> GLOBAL_NODE_SET = new ArrayList<Node>();

    private char evalChar;
    private int globalNodeID;
    private Node ifIsEvalChar;
    private Node ifNotEvalChar;
    private boolean isFinalState;
    private boolean isInitialState;
    private boolean isDefined = false;

    private FiniteAutomata belongsToFA;

    private ArrayList<TransitionFunction> transitionFunctions = new ArrayList<TransitionFunction>();
    
    public static ArrayList<Node> getGlobalNodeSet() {

        return GLOBAL_NODE_SET;

    }

    public static Node getNodeFromGlobalSet(int id) {

        for (Node state : GLOBAL_NODE_SET) {

            if (state.getGlobalNodeID() == id) {

                return state;

            }

        }

        return null;

    }

    public static String getGlobalNodeSetStr(boolean withCheck) {

        String[] set = new String[GLOBAL_NODE_SET.size()];
        for (int n = 0; n < GLOBAL_NODE_SET.size(); n++) {
            set[n] = 
                "q" + GLOBAL_NODE_SET.get(n).getGlobalNodeID() + 
                (withCheck ? "["+ (GLOBAL_NODE_SET.get(n).getIsDefined() ? "x" : " ") + "]" : "");
        }

        return Arrays.toString(set);

    }

    public static ArrayList<Node> getFinalNodeSet() {

        return FINAL_NODE_SET;

    }

    public Node(FiniteAutomata belongsToFA) {

        this.belongsToFA = belongsToFA;

        globalNodeID = Node.GLOBAL_NODE_SET.size();
        isInitialState = globalNodeID == 0 ? true : false;

        Node.GLOBAL_NODE_SET.add(this);
        
    }

    private void makeFinalState() {

        isFinalState = true;
        Node.FINAL_NODE_SET.add(this);

    }

    public int getGlobalNodeID() {

        return globalNodeID;

    }

    public char getEvalChar() {

        return evalChar;

    }

    public Node getIfIsEvalChar() {

        return ifIsEvalChar;

    }

    public Node getIfNotEvalChar() {

        return ifNotEvalChar;

    }

    public boolean getIsInitialState() {

        return isInitialState;

    }

    public boolean getIsFinalState() {

        return isFinalState;

    }

    public boolean getIsDefined() {

        return isDefined;

    }

    private boolean charClaimed(String[] charsInput) {

        for (int x = 0; x < charsInput.length; x++) { 
            for (int y = 0; y < transitionFunctions.size(); y++) {
                for (int z = 0; z < transitionFunctions.get(y).getCharset().length; z++) {
                    if (charsInput[x].charAt(0) == transitionFunctions.get(y).getCharset()[z]) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private void defineTransitionFuctions(int textSpeed) {
        
        Helpers.typeDelayEffect(
            textSpeed, 
            "      * Enter the transition function: ",
            50
        );
        String transitionFunctionInput = new Scanner(System.in).nextLine();
        if (transitionFunctionInput.equals("done")) {
            return;        
        }
    
        String[] transitionFunctionInputStrArr = transitionFunctionInput.split(" ");

        if (
                !belongsToFA.getLanguage().areLegalChars(
                    Arrays.copyOfRange(
                        transitionFunctionInputStrArr, 
                        0, 
                        transitionFunctionInputStrArr.length - 1
                    )
                )
            ) {

            System.out.println("      * AT LEAST ONE CHARACTER NOT IN SET OF INPUT SYMBOLS. TRY AGAIN.");

        }

        else {

            Node nextNodeRef = getNodeFromGlobalSet(
                Integer.parseInt(transitionFunctionInputStrArr[transitionFunctionInputStrArr.length - 1].substring(1))
            );

            if (nextNodeRef == null) {

                System.out.println("      * STATE DOES NOT EXIST. TRY AGAIN.");

            }

            else if (transitionFunctionInputStrArr[transitionFunctionInputStrArr.length - 1].charAt(0) != 'q') {

                System.out.println("      * STATE TO MOVE TO NOT PROPERLY DEFINED");

            }

            else if (
                charClaimed(                
                    Arrays.copyOfRange(
                        transitionFunctionInputStrArr, 0, 
                        transitionFunctionInputStrArr.length - 1
                    )
                )
            ) {

                System.out.println("      * AT LEAST ONE CHARACTER IS ALREADY IN ANOTHER TRANSITION FUNCTION FOR THIS STATE.");

            }

            else {

                transitionFunctions.add(new TransitionFunction(
                    Arrays.copyOfRange(
                        transitionFunctionInputStrArr, 0, 
                        transitionFunctionInputStrArr.length - 1
                    ),
                    nextNodeRef,
                    this
                ));

            }

        }
    
        defineTransitionFuctions(textSpeed);
        
    }

    public void defineSelf(int textSpeed) {

        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (δ) DEFINING STATE " + "q" + globalNodeID + " [" + (globalNodeID + 1) + "/" + GLOBAL_NODE_SET.size() +"] ---\n" +
            "      * Set of States So Far: " + Node.getGlobalNodeSetStr(true) + "\n",
            50
        );

        // Is final state?
        Helpers.typeDelayEffect(
            textSpeed, 
            "      * Should this state be a final state? [Yy/Nn]: ",
            50
        );
        String finalStateInput = Character.toString(new Scanner(System.in).next().toLowerCase().charAt(0));
        if (finalStateInput.equals("y")) {
            makeFinalState();
        }
        
        defineTransitionFuctions(textSpeed);
        
        isDefined = true;

    }

    public void run() {
        boolean trueEnd = false;
        if (belongsToFA.isLastTapeChar()) {
            trueEnd = true;
        }

        if (!belongsToFA.getStarted()) {
            belongsToFA.setStarted();
        }
        else {
            belongsToFA.incrementTapeChar();
        }

        System.out.println("q" + getGlobalNodeID() + " processing " + belongsToFA.getCurrentChar());

        char currentCharacter = belongsToFA.getCurrentChar();
        boolean isTheLastCharacter = belongsToFA.isLastTapeChar();
        for (TransitionFunction currentTransitionFunction : transitionFunctions)  {
            if (currentTransitionFunction.isInFunction(currentCharacter)) {
                System.out.println(currentTransitionFunction.getRuleAsStr());
                // IF ON THE LAST CHARACTER
                if (isTheLastCharacter && trueEnd) {
                    // if on last character and the transition function's next state is the same as current state
                    if (currentTransitionFunction.getNextState().getGlobalNodeID() == getGlobalNodeID()) {
                        // if current state is final accept
                        if (isFinalState) {
                            System.out.println("ACCEPT");
                            return;
                        }
                        // if current state is not final then reject
                       else {
                            System.out.println("REJECT");
                            return;
                        }
                    }

                    else {
                        System.out.println("REJECT");
                    }
                }
                // IF IS NOT ON THE LAST CHARACTER
                else {
                    System.out.println("moving to q" + currentTransitionFunction.getNextState().getGlobalNodeID());
                    currentTransitionFunction.getNextState().run();
                }
            }
        }
    }
    
}