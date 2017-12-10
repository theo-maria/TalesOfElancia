package character.npc;

import character.Hero;
import character.NPC;
import item.SoldItem;
import java.util.*;

public class Merchant extends NPC {
    
    private List<SoldItem> soldItems;

    public Merchant() {
        super("Marchand", 50, 10, 40, 20);
        soldItems = new ArrayList<>();
    }
    
    @Override
    public void talk(Hero heroTalking){
        showSoldItems();
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Appuyez sur Entrée pour récupérer vos objets ---");
        while(!sc.nextLine().equals("")){}
        retrieveItems(heroTalking);
    }
    
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
    
    public void retrieveItems(Hero hero){
        for(SoldItem soldItem : soldItems){
            if(soldItem.isSellable()){
                System.out.println("Vous récupérez '" + soldItem.getItemName() + "'");
                hero.addItem(soldItem.retrieveItem());
                this.removeSoldItem(soldItem);
            }
        }
    }
    
    public void addSoldItem(SoldItem item){
        soldItems.add(item);
    }
    
    public void removeSoldItem(SoldItem item){
        soldItems.remove(item);
    }
}