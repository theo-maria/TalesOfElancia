package item;


import character.hero.Hero;

public class Item {

    private Hero relatedHero;
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