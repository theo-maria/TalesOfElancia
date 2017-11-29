package character.npc;

import item.SoldItem;
import java.util.*;

public class Merchant extends NPC {
    
    private Collection<SoldItem> soldItems;
    
    public void showSoldItems()
    {
        System.out.println("\n Objets à vendre : \n");
        for( SoldItem solditem : this.soldItems )
        {
            if( solditem.isSellable() )
            {
                System.out.println("\t" + solditem.getName() + "\n");
            }
        }
    }
}