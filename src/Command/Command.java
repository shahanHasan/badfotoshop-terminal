package Command;
import Image.*;
import Tasks.*;
import Editor.*;
/*
* "World of Zuul" is a very simple, text based adventure game.  
 *
 * This class holds information about a command that was issued by the user.
 * A command currently consists of two strings: a command word and a second
 * word (for example, if the command was "take map", then the two strings
 * obviously are "take" and "map").
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

public class Command
{
    private String[] commandWords;
    
    
//    private String commandWord;
//    private String secondWord;
//    private String thirdWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param firstWord The first word of the command. Null if the command
     *                  was not recognised.
     * @param secondWord The second word of the command.
     * @param thirdWord The second word of the command.
     */
    public Command(String firstWord, String secondWord, String thirdWord)
    {
        commandWords = new String[3];
        commandWords[0] = firstWord;
        commandWords[1] = secondWord;
        commandWords[2] = thirdWord;
        
//        commandWord = firstWord;
//        this.secondWord = secondWord;
//        this.thirdWord = secondWord;

    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String[] getCommandWord()
    {
       
        String[] commandReturn = new String[3];
        
                
        if (commandWords[0] != null){
            commandReturn[0] = commandWords[0];
        }
        else {
            commandReturn[0] = null;
        }
        if (commandWords[1] != null){
            commandReturn[1] = commandWords[1];
        }
        else {
            commandReturn[1] = null;
        }
        if (commandWords[2] != null){
            commandReturn[2] = commandWords[2];
        }
        else {
            commandReturn[2] = null;
        }
        
        
        return commandReturn;
        
        
        
        
       
    }

//    /**
//     * @return The second word of this command. Returns null if there was no
//     * second word.
//     */
//    public String getSecondWord()
//    {
//        return secondWord;
//    }
//
//    /**
//     * @return The third word of this command. Returns null if there was no
//     * third word.
//     */
//    public String getThirdWord()
//    {
//        return secondWord;
//    }
    
    /**
     * @return true if this command was not understood.
     */
    public boolean isUnknown()
    {
        return (commandWords[0] == null);
    }

    /**
     * @return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (commandWords[1] != null);
    }
    
    /**
     * @return true if the command has a third word.
     */
    public boolean hasThirdWord()
    {
        return (commandWords[2] != null);
    }
}

