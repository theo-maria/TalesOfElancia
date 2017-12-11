package game;

/**
 * Objectif d'une partie
 */
public class Goal {
    
    /**
     * L'objectif est accompli
     */
    private Boolean achieved;
    /**
     * Description de l'objectif
     */
    String goalDescription;

    /**
     * Permet d'instancier un objectif
     * @param goalDescription description
     */
    public Goal(String goalDescription) {
        achieved = false;
        this.goalDescription = goalDescription;
    }
    
    /**
     * Permet d'indiquer que l'objectif est accompli
     */
    public void achieve(){
        achieved = true;
    }
    
    /**
     * Permet de savoir si l'objectif est accompli
     * @return true si accompli, sinon false
     */
    public Boolean isAchieved()
    {
        return this.achieved;
    }
}