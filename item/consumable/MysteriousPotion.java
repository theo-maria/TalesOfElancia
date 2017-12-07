package item.consumable;

public class MysteriousPotion extends DoubleEffectPotion {

    private int givenDamage;
    private int removedArmor;

    public MysteriousPotion(String name, int BONUS_DAMAGE, int BONUS_INTELLIGENCE, int BONUS_HEALTH, int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY) {
        super(name, BONUS_DAMAGE, BONUS_INTELLIGENCE, BONUS_HEALTH, BONUS_ARMOR, BONUS_FORCE, BONUS_AGILITY);
    }

    @Override
    public void use() {
        this.relatedHero.giveDamage(givenDamage);
        this.relatedHero.giveArmor(removedArmor);
    }

}