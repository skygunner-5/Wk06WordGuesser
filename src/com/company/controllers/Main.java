package com.company.controllers;

import com.company.models.WordList;
import com.company.views.CmdLineView;

import java.util.Arrays;

public class Main {

        public static String[] letters;
        public static int numLetters = 0;
        public static int incorrectGuesses;
        public static boolean correct = false;
        public static String theGuess;
        public static String[] hints;
        public static CmdLineView view;

        public static void main(String[] args) {

            incorrectGuesses = 5;

            //this starts the file reading and selects a random word
            GetWord getWord = new GetWord();
            String theWord = getWord.getTheWord();

            //this ensures the random word chosen is lowercase
            WordList word = new WordList(theWord);

            //WordList word = new WordList(getWord.getTheWord());

            letters = calculateLetters(word.getTheWord());
            String[] hints = new String[letters.length];

            //create view object with letters from the word passed in
            view = new CmdLineView(letters);
            view.startGame();
            //view.cheat(word.getTheWord());

            //initialize the hints array with dashes
            for(int i = 0; i < letters.length; i++){
                hints[i] = "_";
            }

            //while loop to continue the game while the user still has guesses
            while(incorrectGuesses > 0){
                guess(hints);
                //if the user enters a correct letter, a corresponding message displays
                if(correct) {
                    view.displayCorrect();
                }
                //if the user guesses wrong, their guesses left are decremented
                else{
                    incorrectGuesses--;
                    view.displayIncorrect(incorrectGuesses);
                }

                //display however much the user has guessed correct so far
                view.displayHints(hints);

                //if the user has fully guessed the word, end the game with a win
                if(Arrays.equals(hints, letters)){
                    view.endGameWin();
                }
                //if the user still has empty spaces, set correct back to false
                else{
                    correct = false;
                }
            }
            //if the user has run out of correct guesses, end the game with a loss
            view.endGameLose();
        }

        //splits the random word into letters and returns those letters as an array
        private static String[] calculateLetters(String theWord){
            String[] letters = theWord.split("");
            numLetters = letters.length;
            return letters;
        }

        //fills in correct letters as user guesses them
        private static void guess(String[] hints){

            theGuess = view.makeAGuess();

            for(int i = 0; i < letters.length; i++){
                if(letters[i].equals(theGuess)){
                    hints[i] = theGuess;
                    correct = true;
                }
            }
        }
}
