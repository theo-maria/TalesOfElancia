package character.npc;

import character.Hero;
import character.NPC;
import item.SoldItem;
import java.util.*;

/**
 * Classe correspondant à un marchand
 */
public class Merchant extends NPC {
    
    /**
     * Liste des objets vendus par le marchand
     */
    private List<SoldItem> soldItems;

    /**
     * Permet d'instancier un marchand
     */
    public Merchant() {
        super("marchand", 50, 10, 40, 20);
        soldItems = new ArrayList<>();
    }
    
    /**
     * Permet de répondre à un héros
     * @param heroTalking héros
     */
    @Override
    public void talk(Hero heroTalking){
        showSoldItems();
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Appuyez sur Entrée pour récupérer vos objets ---");
        while(!sc.nextLine().equals("")){}
        retrieveItems(heroTalking);
    }
    
    /**
     * Permet de lister les objets vendus
     */
    public void showSoldItems()
    {
        System.out.println("\n Voici les objets à vendre : \n");
        for( SoldItem solditem : this.soldItems )
        {
            if( solditem.isSellable() )
            {
                System.out.println("\t" + solditem.getItemName() + "\n");
            }
        }
    }
    
    /**
     * Permet au héros de récupérer les objets auxquels il a droit
     * @param hero héros
     */
    public void retrieveItems(Hero hero){
        for(SoldItem soldItem : soldItems){
            if(soldItem.isSellable()){
                System.out.println("Vous récupérez '" + soldItem.getItemName() + "'");
                hero.addItem(soldItem.retrieveItem());
                this.removeSoldItem(soldItem);
            }
        }
    }
    
    /**
     * Permet d'ajouter un objet vendu par le marchand
     * @param item objet
     */
    public void addSoldItem(SoldItem item){
        soldItems.add(item);
    }
    
    /**
     * Permet d'enlever un objet vendu par le marchand
     * @param item objet
     */
    public void removeSoldItem(SoldItem item){
        soldItems.remove(item);
    }
    
    /**
     * Permet de toujours permettre la discussion avec le marchand
     * @return true
     */
    @Override
    public boolean isTalkable() {
        return true;
    }
}