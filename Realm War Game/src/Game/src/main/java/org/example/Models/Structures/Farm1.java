package src.Game.src.main.java.org.example.Models.Structures;

public class Farm1 extends Structure1 {
    public Farm1(int buildingCost,int owner) {
        super(1, 3, 50, 5, buildingCost,10,owner,"Farm",3,0,0,6,0,0);
    }
    public void upgrade () {
        setLevel(getLevel()+1);
        setMaintenanceCost(getMaintenanceCost()+1);
        setLevelUpCost(getLevelUpCost()+5);
        setFood(getFood()+5);
        setHitPoint(getHitPoint()+25);
    }
}
