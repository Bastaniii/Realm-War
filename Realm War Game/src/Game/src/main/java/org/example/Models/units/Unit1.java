package src.Game.src.main.java.org.example.Models.units;

public abstract class Unit1 {
    private int x;
    private int y;
    protected int hitPoint;
    protected int  movementRange;
    protected int attackPower;
    protected int attackRange;
    protected int payment;
    protected int ration;
    protected int unitSpace;
    protected int level;
    protected String producedBy;
    public Unit1(int x,int y,int hitPoint,int  movementRange,int attackPower,int attackRange,int payment,int ration,int unitSpace,int level,String producedBy) {
        this.x=x;
        this.y=y;
        this.hitPoint=hitPoint;
        this.movementRange=movementRange;
        this.attackPower=attackPower;
        this.attackRange=attackRange;
        this.payment=payment;
        this.ration=ration;
        this.unitSpace=unitSpace;
        this.level=level;
        this.producedBy=producedBy;
    }
    public int getHitPoint() {
        return hitPoint;
    }
    public int getMovementRange() {
        return movementRange;
    }
    public int getAttackPower(){
        return attackPower;
    }
    public int getAttackRange(){
        return attackRange;
    }
    public int getPayment(){
        return payment;
    }
    public int getRation(){
        return ration;
    }
    public int getUnitSpace(){
        return unitSpace;
    }
    public void setx(int x) {
        this.x = x;
    }
    public void sety(int y) {
        this.y = y;
    }
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
    //public static void merge(Units u1, Units u2) {
    //      int newLevel;
    //    if(u1.level==u2.level && u1.level<=4) {
    //      newLevel=u1.level+1;
    //}
//}
    public int getlevel() {
        return level;
    }
    public void setlevel(int level) {
        this.level = level;
    }
    public String getProducedBy() {
        return producedBy;
    }
    public boolean canMerge(Unit1 units1, Unit1 units2) {
        if(units1.getlevel()==units2.getlevel()&& units1.getlevel() <4 && units2.getlevel()<4 ) {
            return true;
        }
        return false;
    }
}
