package item;


import game.Goal;

public class SoldItem extends Item {

    private Goal necessaryGoal;

    public SoldItem(String NAME, String DESCRIPTION, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(NAME, DESCRIPTION, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
    
    public Boolean isSellable()
    {
        return this.necessaryGoal.isAchieved();
    }
}