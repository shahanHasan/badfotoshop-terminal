
package Parser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import Command.*;
import Editor.*;
import Image.*;
//import Properties.*;
import Tasks.*;

/**
 * This class is taken from the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a three word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input
    public ArrayList<String> cmdwords = new ArrayList<String>();
    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        setupCmdWords();
        reader = new Scanner(System.in);
        
    }

    public void setInputStream(FileInputStream str) { 
        reader = new Scanner(str);
    }
    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;
        String word3 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
            }
            if(tokenizer.hasNext()) {
                word3 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        if(cmdwords.contains(word1)) 
        {
            return new Command(word1, word2, word3);
        }
        else {
            return new Command(null, word2, word3); 
        }
    }
    

    public void setupCmdWords() {
        
    cmdwords.add(commands.HELP.toString());
    cmdwords.add(commands.LOOK.toString());
    cmdwords.add(commands.MONO.toString());
    cmdwords.add(commands.OPEN.toString());
    cmdwords.add(commands.QUIT.toString());
    cmdwords.add(commands.ROT90.toString());
    cmdwords.add(commands.SAVE.toString());
    cmdwords.add(commands.SCRIPT.toString());
    cmdwords.add(commands.FLIPH.toString());
    cmdwords.add(commands.UNDO.toString());
    
    }
    
}
