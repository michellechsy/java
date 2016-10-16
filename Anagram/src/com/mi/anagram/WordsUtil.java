package com.mi.anagram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Words util.
 */
public class WordsUtil {

    /**
     * Alphabetize string. Assuming the word is a single word, whitespace will
     * be removed if there's any in the middle.
     *
     * @param word the word
     * @return the alphabetized string
     */
    public static String alphabetize(String word) {

        if (null == word) {
            return null;
        }

        char[] chars = word.replaceAll("\\s", "").toLowerCase().toCharArray();
        if (chars.length < 2) {
            return null;
        }

        Arrays.sort(chars);
        String alpha = String.valueOf(chars);
        return alpha;
    }

    public static Set<String> readDataFromFile(final String filename) {
        Set<String> words = new HashSet<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = "";
            while ( (line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}
