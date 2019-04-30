import java.util.*;
public class TransitionFunction {

    private static ArrayList<TransitionFunction> GLOBAL_TRANSITION_FUNCTIONSET = new ArrayList<TransitionFunction>();

    private Node nextState;   
    private Node belongsToState;
    private char[] charSet;    
        
    public TransitionFunction(String[] charSet, Node nextState, Node belongsToState) {

        this.belongsToState = belongsToState;

        this.nextState = nextState;

        this.charSet = new char[charSet.length];
        for (int i = 0; i < charSet.length; i++) {
            this.charSet[i] = charSet[i].charAt(0);
        }

        TransitionFunction.GLOBAL_TRANSITION_FUNCTIONSET.add(this);
    }

    public String getRuleAsStr() {

        return Arrays.toString(charSet)  + " goes to q" + nextState.getGlobalNodeID();

    }

    public char[] getCharset() {

        return charSet;

    }

    public static void printStateTransitionTable() {

        for (TransitionFunction t : TransitionFunction.GLOBAL_TRANSITION_FUNCTIONSET) {
            System.out.println("   q" + t.belongsToState.getGlobalNodeID() + ": " + t.getRuleAsStr());
        }

        String[] finalStates = new String[Node.getFinalNodeSet().size()];
        for (int i = 0; i < Node.getFinalNodeSet().size(); i++) {
            finalStates[i] = "q" + Node.getFinalNodeSet().get(i).getGlobalNodeID();
        }
        System.out.println("   Final States: " + Arrays.toString(finalStates));

    }

    public boolean isInFunction(char currChar) {

        for (int i = 0; i < charSet.length; i++) {
            if (charSet[i] == currChar) {
                return true;
            }
        }

        return false;

    }

    public Node getNextState() {
        return nextState;
    }


}