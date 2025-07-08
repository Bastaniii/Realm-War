package src.Game.src.main.java.org.example.Models.Structures;

public class Farm1 extends Structure1 {
    protected int food;
    public Farm1(int buildingCost) {
        super(1, 3, 25, 5, buildingCost,5);
        this.food = 5;
        this.levelUpCost =5;
    }
    public int getFood(){
        return this.food;
    }
    public void setFood(int food){
        this.food = food;
    }
    public void upGrade (Farm1 farm){
        farm.setFood(farm.getFood()+5);
        farm.setLevel(farm.getLevel()+1);
        farm.setHitPoint(farm.getHitPoint()+5);
        farm.setLevelUpCost(farm.getLevelUpCost()+5);
    }
}
