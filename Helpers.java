public class Helpers {

    private static void delay(int delay) {

        try { 
            
            Thread.sleep(delay); 
        
        } 

        catch (Exception e) { 
            
            System.out.println(e); 
        
        }

    }

    public static void typeDelayEffect(int delay, String text) {

        for (int c = 0; c < text.length(); c++) {

            delay(delay);

            System.out.print(text.charAt(c));

        }

    }

}