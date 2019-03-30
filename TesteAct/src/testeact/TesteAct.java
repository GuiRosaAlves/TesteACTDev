/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeact;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class TesteAct {

    /**
     * @param args the command line arguments
     */
    private static Menu morningMenu;
    private static Menu nightMenu;
    private static Scanner scan;
    private static TimeOfDay currTime = TimeOfDay.Morning;
    
    static {
        morningMenu = new Menu
        (
            new MenuOption("Eggs", false, TimeOfDay.Morning),
            new MenuOption("Toast", false, TimeOfDay.Morning),
            new MenuOption("Coffee", true, TimeOfDay.Morning),
            null
        );
        nightMenu = new Menu
        (
            new MenuOption("Steak", false, TimeOfDay.Night),
            new MenuOption("Potato", true,TimeOfDay.Night),
            new MenuOption("Wine", false, TimeOfDay.Night),
            new MenuOption("Cake", false, TimeOfDay.Night)
        );
        scan = new Scanner(System.in);
    }
    
    public static void main(String[] args){
        while(true){
            Order currOrder = new Order();
            print("Digite o pedido:");
            currOrder.compileOrder(scan.nextLine());
            scan.nextLine();
        }
    }
    
    public static void print(String message){
        System.out.println(message);
    }

    public static TimeOfDay getCurrTime() {
        return currTime;
    }

    public static void setCurrTime(TimeOfDay time) {
        currTime = time;
    }
    
    public static Menu getMenu(){
        return (currTime == TimeOfDay.Morning) ? morningMenu : nightMenu;
    }
}