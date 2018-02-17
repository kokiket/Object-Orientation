/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_hangman;

/**
 *
 * @author s1011316
 */
public class Model {

    private String goalWord;
    private StringBuilder current;
    private int lifes;

    // we get a word from wordReader
    public Model() {
        WordReader words = new WordReader("words.txt");
        this.goalWord = words.getWord();
        this.current = createCurrent(goalWord);
        this.lifes = 10;

    }
    // we get a word from the user
    public Model(String goalWord) {
        this.goalWord = goalWord;
        this.current = createCurrent(goalWord);
        this.lifes = 10;

    }

    public int getLifes() {
        return lifes;
    }

    public void minusLife() {
        lifes--;
    }

    private StringBuilder createCurrent(String goalWord) {
        current = new StringBuilder();
        for (int i = 0; i < goalWord.length(); i++) {
            current.append('*');
        }
        return current;
    }

    public boolean checkWord() {
        return goalWord.equals(current.toString());
    }

    public boolean inWord(char a) {
        for (int i = 0; i < goalWord.length(); i++) {
            if (goalWord.charAt(i) == a) {
                return true;
            }
        }
        return false;
    }

    public void replace(char a) {
        for (int i = 0; i < goalWord.length(); i++) {
            if (goalWord.charAt(i) == a) {
                current.setCharAt(i, a);
            }
        }
    }
    
    @Override
    public String toString() {
        return current.toString();
    }

}
