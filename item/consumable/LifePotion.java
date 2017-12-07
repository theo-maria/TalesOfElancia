package item.consumable;

public class LifePotion extends Potion {

    private int givenHealth; //Mettre la valeur de la vie récupéré par tour

    public LifePotion(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_DAMAGE, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    @Override
    public void use() {
        this.relatedHero.healHero(givenHealth);
    }
}