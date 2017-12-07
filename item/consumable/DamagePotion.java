package item.consumable;

public class DamagePotion extends BuffPotion {

    private int givenDamage;

    public DamagePotion(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_DAMAGE, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    //Penser a gérer le nombre de tours d'activation de la potion
    
    @Override
    public void use() {
        this.relatedHero.giveDamage(givenDamage);
    }
    
}