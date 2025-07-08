package src.Game.src.main.java.org.example.Models.Structures;

public class Structure1 {
    protected int level;
    protected int maxLevel;
    protected int hitPoint;
    protected int maintenanceCost;
    protected int buildingCost;
    protected int levelUpCost;
    public Structure1(int level, int maxLevel, int hitPoint, int maintenanceCost, int buildingCost, int levelUpCost) {
        this.level = level;
        this.maxLevel = maxLevel;
        this.hitPoint = hitPoint;
        this.maintenanceCost = maintenanceCost;
        this.buildingCost = buildingCost;
        this.levelUpCost = levelUpCost;
    }

    public int getLevelUpCost() {
        return levelUpCost;
    }
    public void setLevelUpCost(int levelUpCost) {
        this.levelUpCost = levelUpCost;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public int getHitPoint(){
        return hitPoint;
    }
    public int getMaintenanceCost(){
        return maintenanceCost;
    }
    public int getBuildingCost(){
        return buildingCost;
    }
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
    public void setMaintenanceCost(int maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
    public void setBuildingCost(int buildingCost) {
        this.buildingCost = buildingCost;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public static boolean canLevelUp (Structure1 structure) {
        return structure.getLevel() < structure.getMaxLevel();
    }
    public void damage(Structure1 structure, int damage) {
        setHitPoint(structure.getHitPoint()- damage);
    }
    public boolean willSurvive(Structure1 structure, int damage) {
        return structure.getHitPoint() > damage;
    }
    public boolean isMaxLevel(Structure1 structure) {
        return structure.getLevel() == maxLevel;
    }

}
