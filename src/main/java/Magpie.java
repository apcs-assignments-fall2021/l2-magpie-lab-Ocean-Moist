/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 *
 * @author Laurie White
 * @version April 2012
 */


public class Magpie {

    public String getGreeting() {
        return "i was built by a mega genuis u r taling with a god";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        String response;
        if (findWord(statement, "no") >= 0) {
            response = "why no";
        } else if (findWord(statement, "I want") >= 0) {
            response = transformIWantStatement(statement);
        } else if (findWord(statement, "mother") >= 0
                || findWord(statement, "father") >= 0
                || findWord(statement, "sister") >= 0
                || findWord(statement, "brother") >= 0) {
            response = "what r there digits ong";
        } else if (findWord(statement, "cat") >= 0
                || findWord(statement, "dog") >= 0) {
            response = "cats r better than dogs ong";
        } else if (findWord(statement, "nathan") >= 0) {
            response = "He sounds like a good teacher!";
        } else if (findWord(statement, "mom") >= 0) {
            response = "I bet ur mom is cute";
        } else if (findWord(statement, "carti") >= 0) {
            response = "*+!:) !! okey * ok !+ladies , ** - one \uD83D\uDC94 at a time\uD83D\uDDA4& * plss . * slatt _ ! vAMP";
        } else if (findWord(statement, "clb") >= 0) {
            response = "mid";
        } else if (statement.trim().equals("")) {
            response = "Say something";
        } else if (findWord(statement, "I want") >= 0) {
            response = transformIWantStatement(statement);
        } else if (findWord(statement, "I") >= 0 && findWord(statement, "you") >= 0) {
            response = transformIYouStatement(statement);
        } else if (findWord(statement, "I want to") >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findWord(statement, "You") >= 0 && findWord(statement, "me") >= 0) {
            response = transformYouMeStatement(statement);
        } else if (findWord(statement, "is the goat") >= 0) {
            response = transformIsGoatStatement(statement);
        } else {
            response = getRandomResponse();
        }

        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    public String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "thats pretty poggers";
        } else if (whichResponse == 5) {
            response = "bruh moment";
        }



        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        str = " " + str.toLowerCase() + " ";
        word = " " + word.toLowerCase() + " ";
        return str.indexOf(word);
    }


    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into
     * "Would you really be happy if you had <something>?"
     *
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement) {
        int thing = findWord(statement, "I want");
        return "Would you really be happy if you had " + statement.substring(thing + 7) + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into
     * "Why do you <something> me?"
     *
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement) {
        return "Why do you " + statement.substring(2, statement.length() - 4) + " me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into
     * "What would it mean to <something>?"
     *
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement) {
        return "What would it mean to " + statement.substring(10) + "?";
    }


    /**
     * Take a statement with "you <something> me" and transform it into
     * "What makes you think that I <something> you?"
     *
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement) {
        return "What makes you think that I " + statement.substring(7, statement.length() - 3) + " you?";
    }

    /**
     *
     * @param statement countains "is <something> the goat"
     * @return "carti is the goat, <something> is mid"
     */
    public String transformIsGoatStatement(String statement) {
        int begin = statement.replaceAll(" is the goat.*$", "").lastIndexOf(" ");
        if (begin == -1) {
            begin = 0;
        }
         return "*++9 KiNG vAAMP \uD83E\uDDDB iS*&7 Th3E G0@t 1-/(0* SLaatt++_-*^, " + statement.replaceAll(" is the goat.*$", "").substring(begin) + " iS m1D+++***77612365 oN C^rt1 ++ 666 slaTT";
    }
}
