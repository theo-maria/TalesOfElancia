package item;


import game.Goal;

public class SoldItem{

    private Goal necessaryGoal;
    private Item relatedItem;

    public SoldItem(Item relatedItem, Goal necessaryGoal) {
        this.relatedItem = relatedItem;
        this.necessaryGoal = necessaryGoal;
    }
    
    public Boolean isSellable()
    {
        return this.necessaryGoal.isAchieved();
    }
    
    public Item retrieveItem(){
        if(necessaryGoal.isAchieved())
            return relatedItem;
        return null;
    }
    
    public String getItemName(){
        return relatedItem.NAME;
    }
}