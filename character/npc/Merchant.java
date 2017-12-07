package character.npc;

import character.NPC;
import item.SoldItem;
import java.util.*;

public class Merchant extends NPC {
    
    private Collection<SoldItem> soldItems;

    public Merchant() {
        super("Marchand", 50, 10, 40, 20);
    }
    
    public void showSoldItems()
    {
        System.out.println("\n Objets à vendre : \n");
        for( SoldItem solditem : this.soldItems )
        {
            if( solditem.isSellable() )
            {
                System.out.println("\t" + solditem.NAME + "\n");
            }
        }
    }
}