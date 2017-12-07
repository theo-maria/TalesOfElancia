package character;

public abstract class NPC extends GameCharacter {

    public NPC(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_INTELLIGENCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_INTELLIGENCE, BASE_AGILITY);
    }
}