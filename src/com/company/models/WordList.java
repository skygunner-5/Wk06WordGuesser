package com.company.models;

import java.util.Locale;

public class WordList {

    private String theWord;

    public WordList(String theWord) { this.theWord = theWord; }

    //have a conversion to lowercase in the getter in case we add capitalized words to the list
    public String getTheWord() {
        theWord = theWord.toLowerCase();
        return theWord;
    }

    public void setTheWord(String theWord) { this.theWord = theWord; }
}
