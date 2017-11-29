package item.consumable;


import item.consumable.DoubleEffectPotion;

public class MysteriousPotion extends DoubleEffectPotion {

    private int givenDamage;
    private int removedArmor;

    @Override
    public void use() {
        this.relatedHero.giveDamage(givenDamage);
        this.relatedHero.giveArmor(removedArmor);
    }

}