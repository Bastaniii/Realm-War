package src.Game.src.main.java.org.example.Models.Structures;

//import src.Game.src.main.java.org.example.Models.units.Unit1;
import src.Game.src.main.java.org.example.Models.units.Unit1;

public class Tower extends Structure1{
    public Tower(int owner){
        super(1,3,60,3,10,10,owner,"Tower",5,0,1,0,0,0);
    }
    public void upgrade(){
        setLevel(getLevel()+1);
        setMaintenanceCost(getMaintenanceCost()+1);
        setLevelUpCost(getLevelUpCost()+5);
        setHitPoint(getHitPoint()+20);
        setDefenceRange(getDefenceRange()+1);
    }

}
