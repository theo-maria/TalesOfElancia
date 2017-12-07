package item.consumable;

import item.Consumable;

public abstract class Potion extends Consumable {
    
	private int remainingDuration;

    public Potion(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_DAMAGE, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }
        

        public Boolean isStillActive()
        {
            return remainingDuration > 0;
        }
 
        public void decreaseCount()
        {
            //Prévoir la décrémentation des potions à chaque tour
        }

    @Override
    public abstract void use();
    //To change body of generated methods, choose Tools | Templates.

}