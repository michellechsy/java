package com.mi.anagram;

/**
 * Node for the binary tree that is used to represents a word.
 */
public class AnagramNode<T> {

    private T word;
    private T alpha;   // alphabetized word

    public AnagramNode<T> left;
    public AnagramNode<T> right;

    public AnagramNode(T word, T alpha, AnagramNode<T> left, AnagramNode<T> right) {
        this.word = word;
        this.alpha = alpha;
        this.left = left;
        this.right = right;
    }

    public T getWord() {
        return word;
    }

    public T getAlpha() {
        return alpha;
    }

    public void setWord(T word) {
        this.word = word;
    }

    public void setAlpha(T alpha) {
        this.alpha = alpha;
    }
}
