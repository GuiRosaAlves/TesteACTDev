/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeact;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Guilherme
 */
public class Order {

    public class Item {

        public MenuOption dish = null;
        public int qtt = 0;

        public Item(MenuOption dish) {
            this.dish = dish;
            this.qtt = 0;
        }
    }

    private Item[] items = new Item[DishType.count];

    private String cupom = "";

    public Item[] compileOrder(String str) throws NumberFormatException {
        str = str.replaceAll("\\s+", ""); //Removes all empty spaces in the string
        ArrayList<Integer> commandCache = new ArrayList();
        int commandOrder = 0;
        String command = ""; //Stores the value between commas

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                continue;
            }

            command += str.charAt(i);

            if ((i + 1) == str.length() || (str.charAt(i + 1) == ',')) {
                //Check and Execute Commands
                if (commandOrder == 0) {
                    checkTimeOfDay(command);
                } else {
                    var lastInput = checkOrder(command);
                    commandCache.add(lastInput);
                    if (lastInput > DishType.count || lastInput == -1) {
                        break;
                    }
                }

                command = "";
                commandOrder++;
            }
        }

        TesteAct.print(checkOut(commandCache));
        return items;
    }

    public void checkTimeOfDay(String timeOfDay) {
        switch (timeOfDay.toLowerCase()) {
            case "morning":
                TesteAct.setCurrTime(TimeOfDay.Morning);
                break;
            case "night":
                TesteAct.setCurrTime(TimeOfDay.Night);
                break;
        }
    }

    public int checkOrder(String menuOption) {
        try {
            int choice = Integer.parseInt(menuOption);
            Menu currMenu = TesteAct.getMenu();

            switch (choice) {
                case 1:
                    if (items[choice - 1] == null) {
                        items[choice - 1] = new Item(currMenu.getEntree());
                    }
                    break;
                case 2:
                    if (items[choice - 1] == null) {
                        items[choice - 1] = new Item(currMenu.getSide());
                    }
                    break;
                case 3:
                    if (items[choice - 1] == null) {
                        items[choice - 1] = new Item(currMenu.getDrink());
                    }
                    break;
                case 4:
                    if (items[choice - 1] == null) {
                        items[choice - 1] = new Item(currMenu.getDessert());
                    }
                    break;
            }

            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String checkOut(ArrayList<Integer> commands) {
        cupom = "";

        for (int i = commands.size() - 1; i != -1; i--) {
            var currCommand = commands.get(i) - 1;

            if (currCommand < items.length && items[currCommand] != null) {
                if (items[currCommand].qtt < 1) {
                    items[currCommand].qtt++;
                } else if (items[currCommand].dish.canOrderMultiple()) {
                    items[currCommand].qtt++;
                    commands.remove(i);
                }
            }
        }

        Collections.sort(commands);

        for (int i = 0; i < commands.size(); i++) {
            if (i > 0) {
                cupom += ", ";
            }

            var currIndex = commands.get(i) - 1;
            if (currIndex >= items.length) {
                cupom += "error";
                break;
            }

            if (items[currIndex] == null) {
                cupom += "error";
                break;
            }
            if (items[currIndex].dish == null) {
                cupom += "error";
                continue;
            }
            if (cupom.contains(items[currIndex].dish.getName().toLowerCase())) {
                cupom += "error";
                break;
            }

            cupom += items[currIndex].dish.getName().toLowerCase();
            if (items[currIndex].qtt > 1) {
                cupom += "(x" + items[currIndex].qtt + ")";
            }
        }
        return cupom;
    }
}
