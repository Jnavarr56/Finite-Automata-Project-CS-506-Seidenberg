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

    // Constructor establishes selector value, which serves as an index for the languages array.
    public Language(String selection) {

        this.selector = selection.equals("binary") ? 0 : 1;
        
    }

    // Return a natural word describing the language selected.
    public String getLanguageDescriptor() {

        return selector == 0 ? "binary" : "alphabetical";

    }

    // Return language array of characters.
    public char[] getSymbolsArray() {

        return languages[selector];

    }

    // Return string version of language array of characters.
    public String getSymbolsArrayStr() {

        return Arrays.toString(languages[selector]);

    }

    // Check to see if character is in the selected language.
    public boolean isLegalChar(char c) {

        for (int i = 0; i < languages[selector].length; i++) {

            if (languages[selector][i] == c) {

                return true;

            }

        }

        return false;

    } 

}