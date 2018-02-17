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
     * The method ask for user choice for game and process it
     * Taking in account of user mistakes - char/string instead of int and
     * wrong int.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play HangMan!");
        boolean correctInput = false;
        //this while loop will repeat till the user will enter the correct input - checked by the boolean!
        while (!correctInput) { // it is getting nasty long witht he checking of users errors
            //is there any option to break it down for smaller? Maybe switch in a new method?
            //also I was not sure if this should be in a view and what would be then in the main...
            System.out.println("If do you want to guess a random word, enter 1."
                    + "\n" + "if you want to select a word yourself enter 2");
            try {
                int choice = input.nextInt();
                input.nextLine(); //Very important, without it it will not wait 
                //for input from the user! ALWAYS after intergers!!!
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
                    default: {
                        System.out.println("wrong input, try again");
                        break; // not necessary nextLine! Break!!!
                    }
                }
            } catch (Exception e) {
                System.out.println("wrong input, the input must a number, try again");
                input.nextLine(); //necessary nextLine otherwise it will not stop printing the above statement
            }

            //  char target1 = input.nextLine().charAt(0); Personal note for char when use scanner
        }
    }
}
