/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mooc.logic;

import mooc.ui.UserInterface;

/**
 *
 * @author aidan
 */
public class ApplicationLogic {
    private UserInterface ui;
    
    public ApplicationLogic(UserInterface ui) {            
        // It receives as parameter a class which implements the interface 
        // UserInterface. Note: your application logic has to see the interface 
        // and therefore to import it; in other words, the line import 
        // mooc.ui.UserInterface must appear at the beginning of the file
            this.ui = ui;
        }
    
    public void execute(int howManyTimes) {
        for (int i = 0; i < howManyTimes; i++) {
            System.out.println("The application logic works");
            ui.update();
        }
    }
}
