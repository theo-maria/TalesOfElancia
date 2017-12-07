package item;


import game.Goal;

public class SoldItem extends Item {

    private Goal necessaryGoal;

    public SoldItem(String name, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
    
    public Boolean isSellable()
    {
        return this.necessaryGoal.isAchieved();
    }
}