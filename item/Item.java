package item;


import character.Hero;

public class Item {

    protected Hero relatedHero;
    private String name;
    
    public void take(Hero hero)
    {
        this.relatedHero = hero;
    }

    public Hero getRelatedHero() 
    {
        return this.relatedHero;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
        
        

}