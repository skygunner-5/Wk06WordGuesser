package com.company.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetWord {

    private BufferedReader in;
    private String[] words;
    private String theWord;

    public GetWord() {

        //try catch to print error message if input file is not found
        try {
            //Path is an object used to hold a file path
            Path thePath = Paths.get("src/" + "wordlist.txt");

            //in is a BufferedReader object that holds the strings found by following the path
            in = new BufferedReader(new FileReader(String.valueOf(thePath)));

            //array list is an upgraded version of an array that can be dynamically sized
            List<String> lines = new ArrayList<>();

            //line represents each element in the lines array list
            String line = null;

            //inner try catch checks for a failed input operation
            try{
                line = in.readLine();

                //keep reading lines and adding them to the lines array list
                while(line != null){
                    lines.add(line);
                    line = in.readLine();
                }

                //free up space by ending the file reading operation
                in.close();

                /*
                since we need to find a random word from the lines array list but can only
                perform that operation on an array, we need to convert the array list to an array
                 */
                words = lines.toArray(new String[lines.size()]);

                theWord = getRandomWord(words);

                } catch(IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getTheWord() {
        return theWord;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    //function that selects a random word from the words list and assigns it to theWord
    private String getRandomWord(String[] words){
        int rand = new Random().nextInt(words.length);
        return words[rand];
    }

}
