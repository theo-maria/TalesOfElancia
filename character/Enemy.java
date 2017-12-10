package character;

import game.Goal;

public abstract class Enemy extends GameCharacter {
    
    public final String DESCRIPTION;
    protected final int SPECIAL_ATTAQUE_CHANCE;

    public Enemy(String NAME, String DESCRIPTION, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY, int SPECIAL_ATTAQUE_CHANCE) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
        this.DESCRIPTION = DESCRIPTION;
        this.SPECIAL_ATTAQUE_CHANCE = SPECIAL_ATTAQUE_CHANCE;
    }
    
    public abstract void specialAttack(Hero hero);

    public int getSPECIAL_ATTAQUE_CHANCE() {
        return SPECIAL_ATTAQUE_CHANCE;
    }
    
    @Override
    public void damage(int damageValue){
        super.damage(damageValue);
        if(currentHealth <= 0 && activableGoals.size() > 0){
            for(Goal g : activableGoals)
                g.achieve();
        }
            
    }
    
}