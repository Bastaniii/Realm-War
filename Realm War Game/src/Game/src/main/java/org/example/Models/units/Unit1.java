package src.Game.src.main.java.org.example.Models.units;

public class Unit1 {
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
    public Unit1() {
        this.x=x;
        this.y=y;
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
}
