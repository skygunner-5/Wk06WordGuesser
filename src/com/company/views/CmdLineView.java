package com.company.views;

import java.util.Scanner;

public class CmdLineView {
    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    //start the game by prompting the user and displaying underscores for missing letters
    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    //have the user guess a number and input their guess
    public String makeAGuess(){
        System.out.println("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    //message when user guesses correctly
    public void displayCorrect(){
            System.out.println("Correct!");
    }

    //message when user guesses incorrectly, with number of guesses left
    public void displayIncorrect(int incorrectGuesses){
        System.out.println("Incorrect! You have " + incorrectGuesses + " guesses left");
    }

    //display the user guesses with or without correct letters
    public void displayHints(String[] hints){
        for(String hint: hints){
            System.out.print(hint);
        }
        System.out.print("\n");
    }

    //display win message and exit the program
    public void endGameWin(){
        System.out.println("Congratulations! You have guessed the word!");
        System.exit(0);
    }

    //display lose message and exit the program
    public void endGameLose(){
        System.out.println("Sorry you lose!");
        System.exit(0);
    }

    //extra function to display word for debugging
   /* public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
    }*/

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
