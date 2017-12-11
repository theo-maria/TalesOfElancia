package character;

import game.Goal;

/**
 * Classe correspondant aux ennemis
 */
public abstract class Enemy extends GameCharacter {
    
    /**
     * Court texte dérivant l'ennemi
     */
    public final String DESCRIPTION;

    /**
     * Pourcentage de chance de réaliser son attaque spéciale en combat
     */
    protected final int SPECIAL_ATTAQUE_CHANCE;

    /**
     * Permet d'instancier un nouvel ennemi
     * @param NAME son nom
     * @param DESCRIPTION son texte descriptif
     * @param BASE_HEALTH sa vie de base
     * @param BASE_ARMOR son armure de base
     * @param BASE_FORCE sa force de base
     * @param BASE_AGILITY son agilité de base
     * @param SPECIAL_ATTAQUE_CHANCE son pourcentage de chance d'attaque spéciale
     */
    public Enemy(String NAME, String DESCRIPTION, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY, int SPECIAL_ATTAQUE_CHANCE) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
        this.DESCRIPTION = DESCRIPTION;
        this.SPECIAL_ATTAQUE_CHANCE = SPECIAL_ATTAQUE_CHANCE;
    }
    
    /**
     * Permet de réaliser une attaque spéciale
     * @param hero le héros à attaquer
     */
    public abstract void specialAttack(Hero hero);

    /**
     * Permet de savoir le pourcentatge de chance d'attaque spéciale de l'ennemi
     * @return le pourcentatge de chance d'attaque spéciale de l'ennemi
     */
    public int getSPECIAL_ATTAQUE_CHANCE() {
        return SPECIAL_ATTAQUE_CHANCE;
    }
    
    /**
     * Permet de faire des dégâts à l'ennemi, ceux-ci seront diminués de l'armure de l'ennemi
     * @param damageValue les dégâts (valeur brute)
     */
    @Override
    public void damage(int damageValue){
        super.damage(damageValue);
        if(currentHealth <= 0 && activableGoals.size() > 0){
            for(Goal g : activableGoals)
                g.achieve();
        }
    }
    
    /**
     * Permet d'effectuer une attaque simple sur un héros
     * @param hero le héros à attaquer
     */
    public void attack(Hero hero){
        hero.damage(this.getTotalForce());
    }
    
}