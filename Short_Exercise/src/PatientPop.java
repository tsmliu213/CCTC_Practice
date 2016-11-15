import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    
    public static void main(String[] args) {
        String words1 = "hello,bye,world";
        possible(words1, "hello world");
       
        String words2 = "luke,bb8,anakin";
        possible(words2, "darth vader");
        
        //Test
        //printWordCount();

    }
    
    public static void countWords(String words) {
        String[] wordList = words.split(",");
        for(String word: wordList) {
            if(wordCount.containsKey(word.toLowerCase()) ) {
                wordCount.put(word, wordCount.get(word)+1);
            }
            else {
                wordCount.put(word.toLowerCase(), 1);   
            }
        }
    }
    
    public static void possible(String wordList, String phrase) {
        countWords(wordList);
        String[] phraseWords = phrase.split(" ");
        for(String word: phraseWords) {
            if(wordCount.containsKey(word.toLowerCase())) {
                wordCount.put(word, wordCount.get(word.toLowerCase())-1);
                if(wordCount.get(word) <= 0) {
                    wordCount.remove(word);   
                }
            }
            else {
                System.out.println("not possible");
                return;
            }
        }
        System.out.println("possible");    
    }
               
    public static void printWordCount() {
        for(String word: wordCount.keySet()) {
            int count = wordCount.get(word);
            System.out.println(word + ": " + count);
        }
    }
}