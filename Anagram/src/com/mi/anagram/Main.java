package com.mi.anagram;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        if (null == args || args.length == 0) {
            System.out.println("Please provide the file name for processing");
            System.exit(0);
        }

        String filename = args[0];
        AnagramTree<String> tree = new AnagramTree();

        Set<String> words = WordsUtil.readDataFromFile(filename);
        for (String word : words) {
            String alpha = WordsUtil.alphabetize(word);
            if (null != alpha) {
                tree.insert(word, alpha);
            }
        }

        tree.findAnagrams(tree.getRoot());
        tree.printAnagrams();
    }
}
