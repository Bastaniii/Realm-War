package src.Game.src.main.java.org.example.Models.Structures;
import src.Game.src.main.java.org.example.Models.units.Unit1;


public class Barrack1 extends Structure1{
    public Barrack1(int buildingCost,int owner,int produceNum) {
        super(1, 3, 50, 3, buildingCost,10, owner,"Barrack",3,15,0,0,0,produceNum);
    }
    public void upgrade () {
        setMaintenanceCost(getMaintenanceCost()+1);
        setLevel(getLevel()+1);
        setLevelUpCost(getLevelUpCost()+5);
        setUnitSpace(getUnitSpace()+10);
        setHitPoint(getHitPoint()+25);

    }
}
