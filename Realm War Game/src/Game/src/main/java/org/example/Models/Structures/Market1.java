package src.Game.src.main.java.org.example.Models.Structures;
import src.Game.src.main.java.org.example.Models.structures.Structure1;

public class Market1 extends Structure1{
    protected int gold;
    public Market1(int buildingCost) {
        super(1, 3, 25, 5, buildingCost,5);
        this.gold = 5;
    }
    public int getGold(){
        return this.gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }
    public void upGrade (Market1 market){
        market.setGold(market.getGold()+5);
        market.setLevel(market.getLevel()+1);
        market.setHitPoint(market.getHitPoint()+5);
        market.setLevelUpCost(market.getLevelUpCost()+5);
    }
}
