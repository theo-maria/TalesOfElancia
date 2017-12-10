package game;

public class Goal {

    private Boolean achieved;
    String goalDescription;

    public Goal(String goalDescription) {
        achieved = false;
        this.goalDescription = goalDescription;
    }
    
    public void achieve(){
        achieved = true;
    }
    
    public Boolean isAchieved()
    {
        return this.achieved;
    }
}