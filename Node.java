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
    
    public static ArrayList<Node> getGlobalNodeSet() {

        return GLOBAL_NODE_SET;

    }

    public static String getGlobalNodeSetStr() {


        String[] set = new String[GLOBAL_NODE_SET.size()];
        for (int n = 0; n < GLOBAL_NODE_SET.size(); n++) {
            set[n] = "q" + GLOBAL_NODE_SET.get(n).getGlobalNodeID();
        }

        return Arrays.toString(set);

    }

    public static ArrayList<Node> getFinalNodeSet() {

        return FINAL_NODE_SET;

    }


    
    public Node() {

        globalNodeID = Node.GLOBAL_NODE_SET.size();
        isInitialState = globalNodeID == 0 ? true : false;

        Node.GLOBAL_NODE_SET.add(this);
        
    }

    public void makeFinalState() {

        isFinalState = true;
        FINAL_NODE_SET.add(this);

    }

    public int getGlobalNodeID() {

        return globalNodeID;

    }



    
}