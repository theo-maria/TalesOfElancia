package item;


import character.Hero;
import java.util.List;

/**
 * Un objet
 */
public class Item {

    /**
     * Héros qui possède l'objet
     */
    protected Hero relatedHero;

    /**
     * Nom de l'objet
     */
    public final String NAME;

    /**
     * Description de l'objet
     */
    public final String DESCRIPTION;

    /**
     * Bonus de vie apporté par l'objet
     */
    protected final int BONUS_HEALTH;

    /**
     * Bonus d'armure apporté par l'objet
     */
    protected final int BONUS_ARMOR;

    /**
     * Bonus de force apporté par l'objet
     */
    protected final int BONUS_FORCE;

    /**
     * Bonus d'agilité apporté par l'objet
     */
    protected final int BONUS_AGILITY;

    /**
     * Objet utilisable avec celui-ci
     */
    protected Item usableWith;
    
    /**
     * Permet d'instancier un objet
     * @param NAME nom
     * @param DESCRIPTION description
     * @param BONUS_HEALTH bonus de vie
     * @param BONUS_ARMOR bonus d'armure
     * @param BONUS_FORCE bonus de force
     * @param BONUS_AGILITY bonus d'agilité
     */
    public Item(String NAME, String DESCRIPTION, int BONUS_HEALTH, 
            int BONUS_ARMOR, int BONUS_FORCE, int BONUS_AGILITY)
    {
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.BONUS_HEALTH = BONUS_HEALTH;
        this.BONUS_ARMOR = BONUS_ARMOR;
        this.BONUS_FORCE = BONUS_FORCE;
        this.BONUS_AGILITY = BONUS_AGILITY;
    }
    
    /**
     * Permet au héros de ramasser l'objet
     * @param hero héros
     */
    public void take(Hero hero)
    {
        this.relatedHero = hero;
        this.relatedHero.getCurrentPlace().removeItemFromPlace(this);
        this.relatedHero.addItem(this);
    }

    /**
     * Permet de savoir quel est le héros qui possède l'objet
     * @return héros
     */
    public Hero getRelatedHero() 
    {
        return this.relatedHero;
    }

    /**
     * Permet de savoir le bonus de vie de l'objet
     * @return bonus de vie
     */
    public int getBONUS_HEALTH() 
    {
        return BONUS_HEALTH;
    }

    /**
     * Permet de savoir le bonus d'armure de l'objet
     * @return bonus d'armure
     */
    public int getBONUS_ARMOR() 
    {
        return BONUS_ARMOR;
    }

    /**
     * Permet de savoir le bonus de force de l'objet
     * @return bonus de force
     */
    public int getBONUS_FORCE() 
    {
        return BONUS_FORCE;
    }

    /**
     * Permet de savoir le bonus d'agilité
     * @return bonus d'agilité
     */
    public int getBONUS_AGILITY() 
    {
        return BONUS_AGILITY;
    }

    /**
     * Permet de définir le héros qui possède l'objet
     * @param relatedHero héros
     */
    public void setRelatedHero(Hero relatedHero) {
        this.relatedHero = relatedHero;
    }
    
    /**
     * Permet de retourner un objet d'une liste à partir de son nom
     * @param items liste des objets
     * @param name nom
     * @return objet
     */
    public static Item getItemByName(List<Item> items, String name){
        Item item = null;
        for(Item i : items){
            if(i.NAME.equals(name))
                item = i;
        }
        return item;
    }

    /**
     * Permet de définir avec quel objet cet objet est utilisable
     * @param usableWith objet
     */
    public void setUsableWith(Item usableWith) {
        this.usableWith = usableWith;
    }
}