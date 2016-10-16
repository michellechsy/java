package com.mi.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramTree<T extends Comparable> {
    private AnagramNode root;
    private HashMap<T, List<T>> anagrams;

    public AnagramTree() {
        root = null;
        anagrams = new HashMap();
    }

    public AnagramNode getRoot() {
        return root;
    }

    public HashMap getAnagrams() {
        return anagrams;
    }

    /**
     * insert a word into a proper place within the tree.
     *  @param word String to insert
     * @param alpha a key for searching for the proper place in the tree.
     */
    public void insert(final T word, final T alpha) {
        root = insert(word, alpha, this.root);
    }

    public void findAnagrams(AnagramNode node) {
        if (null != node) {
            findAnagrams(node.left);
            searchWords(node);
            findAnagrams(node.right);
        }
    }

    public void printAnagrams() {
        if (anagrams.size() == 0) {
            System.out.println("No anagrams found.");
        } else {
            for (Map.Entry entry : anagrams.entrySet()) {
                ArrayList<T> words = (ArrayList)entry.getValue();
                for (T word : words) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }

    private void searchWords(AnagramNode node) {
        AnagramNode tempWord = find((T)node.getWord(), (T)node.getAlpha(), root);
        if (null != tempWord) {
            if (anagrams.containsKey(node.getAlpha())) {
                ArrayList<T> words = (ArrayList)anagrams.get(node.getAlpha());
                if (!words.contains(node.getWord())) {
                    words.add((T)node.getWord());
                    anagrams.put((T)node.getAlpha(), words);
                }
            } else {
                ArrayList<T> words = new ArrayList<>();
                words.add((T)node.getWord());
                words.add((T)tempWord.getWord());
                anagrams.put((T)node.getAlpha(), words);
            }
        }
    }

    private AnagramNode<T> insert(final T word, final T alpha, AnagramNode<T> node) {
        if (null == node) {
            node = new AnagramNode(word, alpha, null, null);
        } else if (alpha.compareTo(node.getAlpha()) < 0) {
            node.left = insert(word, alpha, node.left);
        } else if (alpha.compareTo(node.getAlpha()) >= 0) {
            node.right = insert(word, alpha, node.right);
        }
        return node;
    }

    private AnagramNode<T> find(final T word, final T alpha, AnagramNode<T> node) {
        while (null != node) {
            if (alpha.compareTo(node.getAlpha()) < 0) {
                node = node.left;
            } else if (alpha.compareTo(node.getAlpha()) > 0) {
                node = node.right;
            } else {
                if (!word.equals(node.getWord())) {
                    return node;
                } else {
                    return null;
                }
            }
        }
        return null;
    }
}