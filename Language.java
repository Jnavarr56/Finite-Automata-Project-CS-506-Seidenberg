import java.util.*;

public class Language {

    // Array of character arrays in which each character represents a different "language"
    private char[][] languages = {
        { 
            '0', 
            '1' 
        },
        {
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 
            'z'
        },
    };

    // Integer that determines which character array to use as the current "language"
    private int selector;

    public Language() {

        
    }


}