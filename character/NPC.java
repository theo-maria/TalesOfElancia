package character;

/**
 * Classe des PNJ (personnages non joueurs)
 */
public abstract class NPC extends GameCharacter {

    /**
     * Permet d'instancier un PNJ
     * @param NAME son nom
     * @param BASE_HEALTH sa vie de base
     * @param BASE_ARMOR son armure de base
     * @param BASE_FORCE sa force de base
     * @param BASE_AGILITY son agilité de base
     */
    public NPC(String NAME, int BASE_HEALTH, int BASE_ARMOR, int BASE_FORCE, int BASE_AGILITY) {
        super(NAME, BASE_HEALTH, BASE_ARMOR, BASE_FORCE, BASE_AGILITY);
    }
}