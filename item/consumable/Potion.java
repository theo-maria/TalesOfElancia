package item.consumable;

public class Potion extends Consumable {
    
	private int remainingDuration;

        public Boolean isStillActive()
        {
            return remainingDuration > 0;
        }
        
}