public class Helpers {

    public static void delay(int delay) {

        try { 
            
            Thread.sleep(delay); 
        
        } 

        catch (Exception e) { 
            
            System.out.println(e); 
        
        }

    }

    public static void typeDelayEffect(int delay, String text, int delayMult) {

        for (int c = 0; c < text.length(); c++) {

            delay(
                !String.valueOf(text.charAt(c)).matches(".") ? delay * delayMult : delay
            );

            System.out.print(text.charAt(c));

        }

    }

}