package character.hero;


import character.Enemy;
import character.Hero;

public class Thief extends Hero {

	private Boolean firstStrike;

    public Thief() {
        super("Esccrow", "Voleur", 30, 4, 6, 25);
        firstStrike = true;
    }
    
    @Override
    public void attack(Enemy enemy){
        if(firstStrike){
            enemy.damage(this.getTotalForce()*3);
            firstStrike = false;
        }
        else
            super.attack(enemy);
    }
    
    @Override
    public void fight(Enemy e){
        super.fight(e);
        // On repasse l'attribut à true à la fin du combat
        firstStrike = true;
    }
}