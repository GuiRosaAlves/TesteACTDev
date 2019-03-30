/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeact;

import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Menu {
    private MenuOption entreeOpt;
    private MenuOption sideOpt;
    private MenuOption drinkOpt;
    private MenuOption dessertOpt;

    public Menu(MenuOption entreeOpt, MenuOption sideOpt, MenuOption drinkOpt, MenuOption dessertOpt) {
        this.entreeOpt = entreeOpt;
        this.sideOpt = sideOpt;
        this.drinkOpt = drinkOpt;
        this.dessertOpt = dessertOpt;
    }
    
    public MenuOption getEntree(){
        return entreeOpt;
    }
    public MenuOption getSide(){
        return sideOpt;
    }
    public MenuOption getDrink(){
        return drinkOpt;
    }
    public MenuOption getDessert(){
        return dessertOpt;
    }
}