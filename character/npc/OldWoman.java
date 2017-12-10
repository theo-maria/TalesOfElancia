package character.npc;

import character.GameCharacter;
import character.Hero;
import character.NPC;
import item.Key;
import world.Exit;
import world.Place;

public class OldWoman extends NPC {
    
    private Key heldKey;
    private Place nextRoom;

    public OldWoman(Key heldKey, Place nextRoom) {
        super("vieille_dame", 50, 0, 30, 10);
        this.heldKey = heldKey;
        this.nextRoom = nextRoom;
        dialogues.add("A vouloir voler trop vite vers le soleil, on finit par s’en griller les ailes.");
        dialogues.add("Il n’est point sage d’aller au front sans étudier son adversaire au préalable."
                + " Pour vaincre votre ennemi, vous devez faire preuve de patience.");
        dialogues.add("Etudiez le en détail et vous aurez éventuellement une infime chance. Tenez, prenez ceci et continuez d’avancer, elle vous sera utile.");
    }
    
    @Override
    public void talk(Hero heroTalking){
        super.talk(heroTalking);
        System.out.println("La vieille dame vous tend une clé que vous prenez sans broncher puis elle disparaît dans un nuage de fumée opaque.");
        heroTalking.addItem(heldKey);
        currentPlace.addExit(new Exit(nextRoom, "hall"));
        currentPlace.removeCharacter(this);
        System.out.println("Vous continuez d’avancer, puis vous vous trouvez face à une porte.");
    }
}