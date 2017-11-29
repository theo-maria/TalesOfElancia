package item;


import game.Goal;

public class SoldItem extends Item {

    private Goal necessaryGoal;
    
    public Boolean isSellable()
    {
        return this.necessaryGoal.isAchieved();
    }
}