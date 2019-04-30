import java.util.*;

public class Node {

    private static ArrayList<Node> FINAL_NODE_SET = new ArrayList<Node>();
    private static ArrayList<Node> GLOBAL_NODE_SET = new ArrayList<Node>();
    private static Scanner scanner = new Scanner(System.in);

    private char evalChar;
    private int globalNodeID;
    private Node ifIsEvalChar;
    private Node ifNotEvalChar;
    private boolean isFinalState;
    private boolean isInitialState;
    private boolean isDefined = false;

    private FiniteAutomata belongsToFA;
    
    public static ArrayList<Node> getGlobalNodeSet() {

        return GLOBAL_NODE_SET;

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

    private void defineTransitionFuctions(int textSpeed) {
        
        Helpers.typeDelayEffect(
            textSpeed, 
            "      * Enter the transition function: ",
            50
        );
        String transitionFunction = new Scanner(System.in).nextLine();
        if (!transitionFunction.equals("done")) {
            defineTransitionFuctions(textSpeed);
        }

    }

    public void defineSelf(int textSpeed) {

        Helpers.typeDelayEffect(
            textSpeed, 
            "  -- (δ) DEFININING STATE " + "q" + globalNodeID + " [" + (globalNodeID + 1) + "/" + GLOBAL_NODE_SET.size() +"] ---\n" +
            "      * Set of States So Far: " + Node.getGlobalNodeSetStr(true) + "\n",
            50
        );

        // Is final state?
        Helpers.typeDelayEffect(
            textSpeed, 
            "      * Should this state be a final state? [Yy/Nn]: ",
            50
        );
        String finalStateInput = Character.toString(scanner.next().toLowerCase().charAt(0));
        if (finalStateInput.equals("y")) {
            makeFinalState();
        }
        
        defineTransitionFuctions(textSpeed);
        
        isDefined = true;

    }

    
}