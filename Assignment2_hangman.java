/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2_hangman;

import java.util.Scanner;

/**
 *
 * @author s1011316
 */
public class Assignment2_hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play HangMan!");
        
        boolean correctInput = false;
        while (!correctInput){
            System.out.println("If do you want to guess a random word, enter 1." 
                    + "\n"+ "if you want to select a word yourself enter 2");
            int choice = input.nextInt();
        input.nextLine(); //Very important, without it it will not wait for input from the user! ALWAYS after intergers!!!
        switch (choice) {
            case 1: {
                Model model = new Model();
                View game = new View(model);
                game.newGame();
                correctInput = true;
                break;
            }
            case 2: {
                System.out.println("Enter your word: ");
                String goalWord = input.nextLine();
                Model model = new Model(goalWord);
                View game = new View(model);
                game.newGame();
                correctInput = true;
                break;
            }
            default:{
                System.out.println("wrong input, try again");
                break;
        }}}

        //  char target1 = input.nextLine().charAt(0);
    }
}
