package character.hero;


import character.Enemy;
import character.Hero;

/**
 * Classe du rôle Voleur
 */
public class Thief extends Hero {

	private Boolean firstStrike;

    /**
     * Permet d'instancier un voleur
     */
    public Thief() {
        super("Esccrow", "Voleur", 30, 2, 6, 25);
        firstStrike = true;
    }
    
    /**
     * Permet d'attaquer un ennemi
     * @param enemy ennemi
     */
    @Override
    public void attack(Enemy enemy){
        if(firstStrike){
            enemy.damage(this.getTotalForce()*3);
            firstStrike = false;
        }
        else
            super.attack(enemy);
    }
    
    /**
     * Permet de combattre un ennemi et de repréparer une attaque puissant pour le prochain combat
     * @param e ennemi
     */
    @Override
    public void fight(Enemy e){
        super.fight(e);
        // On repasse l'attribut à true à la fin du combat
        firstStrike = true;
    }
}