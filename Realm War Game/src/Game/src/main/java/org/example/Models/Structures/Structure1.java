package src.Game.src.main.java.org.example.Models.Structures;

public abstract class Structure1 {
    protected static int level;
    protected int maxLevel;
    protected int hitPoint;
    protected int maintenanceCost;
    protected static int buildingCost;
    protected static int levelUpCost;
    protected int owner;
    protected String type;
    protected int maxAmount;
    protected int unitSpace;
    protected int defenceRange;
    protected int food;
    protected int gold;
    protected int produceNum;
    protected boolean isPaidStructure;
    public Structure1(int level, int maxLevel, int hitPoint, int maintenanceCost, int buildingCost, int levelUpCost,int owner,String type,int maxAmount,int unitSpace,int defenceRange,int food,int gold,int produceNum) {
        this.level = level;
        this.maxLevel = maxLevel;
        this.hitPoint = hitPoint;
        this.maintenanceCost = maintenanceCost;
        this.buildingCost = buildingCost;
        this.levelUpCost = levelUpCost;
        this.owner = owner;
        this.type = type;
        this.maxAmount = maxAmount;
        this.unitSpace = unitSpace;
        this.defenceRange = defenceRange;
        this.food = food;
        this.gold = gold;
        this.produceNum = produceNum;
        this.isPaidStructure = false;
    }
    public boolean isPaidStructure() {
        return isPaidStructure;
    }
    public void setPaid(boolean paid) {
        isPaidStructure = paid;
    }
    public int getProduceNum (){
        return produceNum;
    }
    public void setProduceNum(int produceNum) {
        this.produceNum = produceNum;
    }
    public int getGold(){
        return gold ;
    }
    public void setGold(int gold){
        this.gold = gold;
    }
    public int getFood (){
        return food;
    }
    public void setFood(int food){
        this.food = food;
    }
    public int getDefenceRange(){
        return this.defenceRange;
    }
    public void setDefenceRange(int defenceRange){
        this.defenceRange = defenceRange;
    }
    public String getType() {
        return type;
    }
    public int getUnitSpace() {
        return unitSpace;
    }

    public void setUnitSpace(int unitspace) {
        this.unitSpace = unitspace;
    }
    public int getowner(){
        return owner;
    }
    public static int getLevelUpCost() {
        return levelUpCost;
    }
    public void setLevelUpCost(int levelUpCost) {
        this.levelUpCost = levelUpCost;
    }
    public static int getLevel() {
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
    public void setMaintenanceCost(int maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
    public static int getBuildingCost(){
        return buildingCost;
    }
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
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
        return structure.getLevel() == structure.getMaxLevel();
    }
    public  abstract void upgrade();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Structure1 that = (Structure1) obj;

        return level == that.level &&
                maxLevel == that.maxLevel &&
                hitPoint == that.hitPoint &&
                maintenanceCost == that.maintenanceCost &&
                buildingCost == that.buildingCost &&
                levelUpCost == that.levelUpCost &&
                owner == that.owner &&
                maxAmount == that.maxAmount &&
                unitSpace == that.unitSpace &&
                defenceRange == that.defenceRange &&
                food == that.food &&
                gold == that.gold &&
                produceNum == that.produceNum &&
                isPaidStructure == that.isPaidStructure &&
                (type != null ? type.equals(that.type) : that.type == null);
    }
}
