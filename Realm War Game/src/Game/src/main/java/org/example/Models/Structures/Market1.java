package src.Game.src.main.java.org.example.Models.Structures;

public class Market1 extends Structure1{
    protected  int maxAmount;
    public Market1(int buildingCost,int owner) {
        super(1, 3, 25, 5, buildingCost,10, owner,"Market",3,0,0,0,8,0);
    }

    public void upgrade () {
        setLevel(getLevel()+1);
        setMaintenanceCost(getMaintenanceCost()+2);
        setLevelUpCost(getLevelUpCost()+5);
        setGold(getGold()+5);
        setHitPoint(getHitPoint()+25);
    }
}
