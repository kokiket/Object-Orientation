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
public class View {

    private Model game;

    public View(Model game) {
        this.game = game;
    }

    public void newGame() {
        
        Scanner input = new Scanner(System.in);
        while ((game.getLifes() > 0) && !game.checkWord()) {
            System.out.println("Enter a letter");
            String line = input.nextLine();
            if (line.length() > 0) {
                char a = line.charAt(0);
                if (game.inWord(a)) {
                    game.replace(a);
                    System.out.println("A Lucky guess! The letter is in the word!"
                            + game);
                } else {
                    game.minusLife();
                    System.out.println("Ups, wrong guess! Try it again, you "
                            + "have " + game.getLifes() + " lifes " + game);
                }
            }
        }
        if (game.getLifes() == 0) {
            System.out.println("You have" + game.getLifes() + "lifes. It means "
                    + "game over!");
        }
        if (game.checkWord()) {
            System.out.println("You made it! Well done! The word is " + game);
        }
    }
}
