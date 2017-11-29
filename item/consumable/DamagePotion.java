package item.consumable;

public class DamagePotion extends BuffPotion {

    private int givenDamage;

    //Penser a gérer le nombre de tours d'activation de la potion
    
    @Override
    public void use() {
        this.relatedHero.giveDamage(givenDamage);
    }
    
}