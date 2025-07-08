package src.Game.src.main.java.org.example.Models.structures;

import src.Game.src.main.java.org.example.Models.units.Unit1;

public class Tower extends Structure1 {
    public Tower(){
        super(1,4,25,5,5,5);
    }
    public void upGrade(Tower tower){
        tower.setLevel(tower.getLevel()+1);
        tower.setHitPoint(tower.getHitPoint()+5);
        tower.setLevelUpCost(tower.getLevelUpCost()+5);
    }
    public boolean restrict(Tower tower, Unit1 units) {
        if (units.getlevel() <= tower.getLevel()) {
            return true;
        }
        return false;
    }
}
