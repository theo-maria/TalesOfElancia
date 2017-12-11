package item;


import game.Goal;

/**
 * Objet à vendre
 */
public class SoldItem{

    /**
     * Objectif nécessaire pour débloquer l'achat
     */
    private Goal necessaryGoal;
    /**
     * Objet vendu
     */
    private Item relatedItem;

    /**
     * Permet d'instancier un objet à vendre
     * @param relatedItem objet
     * @param necessaryGoal objectif
     */
    public SoldItem(Item relatedItem, Goal necessaryGoal) {
        this.relatedItem = relatedItem;
        this.necessaryGoal = necessaryGoal;
    }
    
    /**
     * Permet de savoir si l'objet est vendable
     * @return true si objectif accompli, sinon false
     */
    public Boolean isSellable()
    {
        return this.necessaryGoal.isAchieved();
    }
    
    /**
     * Permet de récupérer l'objet
     * @return l'objet si objectif accompli, sinon null
     */
    public Item retrieveItem(){
        if(necessaryGoal.isAchieved())
            return relatedItem;
        return null;
    }
    
    /**
     * Permet de savoir le nom de l'objet
     * @return nom
     */
    public String getItemName(){
        return relatedItem.NAME;
    }
}