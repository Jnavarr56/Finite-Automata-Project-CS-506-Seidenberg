public class Main {

    public static void main(String args[]) {

        // Initialize a menu object that serves as a command line UI.
        Menu projectMenu = new Menu(20);
        // Print interactive text to the command line that serves as briefing for the user.
        projectMenu.printIntro();

        // Initialize our FSM object.
        FiniteAutomata CS_506_FSM = new FiniteAutomata(20);
        // Call method to that runs feature to walk user through defining FSM parameters (∑, Q, q). 
        CS_506_FSM.defineInitialFeatures();
        // Call method that runs feature to walk user through defining each State's Transition Fucntion (δ). 
        CS_506_FSM.defineTransitionFunctions();

        CS_506_FSM.runMachine();


        
        
        

    }

}