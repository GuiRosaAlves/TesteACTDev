/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeact;

/**
 *
 * @author Guilherme
 */

public class MenuOption {    
    private String name;
    private boolean canOrderMultiple;
    private TimeOfDay timeServed;

    public MenuOption(String food, boolean canOrderMultiple, TimeOfDay timeServed) {
        this.name = food;
        this.canOrderMultiple = canOrderMultiple;
        this.timeServed = timeServed;
    }

    public String getName() {
        return name;
    }
    public TimeOfDay getTimeServed() {
        return timeServed;
    }
    public boolean canOrderMultiple() {
        return canOrderMultiple;
    }
    public void setTimeServed(TimeOfDay timeServed) {
        this.timeServed = timeServed;
    }
    public void setCanOrderMultiple(boolean canOrderMultiple) {
        this.canOrderMultiple = canOrderMultiple;
    }
}