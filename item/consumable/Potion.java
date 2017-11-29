package item.consumable;

public abstract class Potion extends Consumable {
    
	private int remainingDuration;
        

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