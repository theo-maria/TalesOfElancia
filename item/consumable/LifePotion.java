package item.consumable;

public class LifePotion extends Potion {

    private int givenHealth; //Mettre la valeur de la vie récupéré par tour

    @Override
    public void use() {
        this.relatedHero.healHero(givenHealth);
    }
}