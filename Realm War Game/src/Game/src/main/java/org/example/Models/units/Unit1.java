package src.Game.src.main.java.org.example.Models.units;

public abstract class Unit1 {
    protected int hitPoint;
    protected int  movementRange;
    protected int attackPower;
    protected int attackRange;
    protected int payment;
    protected int ration;
    protected int unitSpace;
    protected int level;
    protected int producedBy;
    protected int owner;
    protected String type;
    protected int buyCost;
    protected boolean hasSpace;
    protected boolean isPaid;
    protected boolean haveEaten;
    protected boolean hasAttacked;
    protected boolean hasMoved;
    public Unit1(int hitPoint,int  movementRange,int attackPower,int attackRange,int payment,int ration,int unitSpace,int level,int owner,int producedBy,String type,int buyCost) {
        this.hitPoint=hitPoint;
        this.movementRange=movementRange;
        this.attackPower=attackPower;
        this.attackRange=attackRange;
        this.payment=payment;
        this.ration=ration;
        this.unitSpace=unitSpace;
        this.level=level;
        this.producedBy=producedBy;
        this.owner=owner;
        this.type=type;
        this.buyCost=buyCost;
        this.hasSpace=true;
        this.isPaid=false;
        this.haveEaten=false;
        this.hasAttacked=false;
        this.hasMoved=false;
    }
    public boolean isHasAttacked() {
        return hasAttacked;
    }
    public void setHasAttacked(boolean hasAttacked) {
        this.hasAttacked = hasAttacked;
    }
    public boolean isHasMoved() {
        return hasMoved;
    }
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
    public boolean isHaveEaten() {
        return haveEaten;
    }
    public void setHaveEaten(boolean haveEaten) {
        this.haveEaten = haveEaten;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public void setPaid(boolean paid) {
        isPaid =paid;
    }
    public boolean getHasSpace() {
        return hasSpace;
    }
    public void setHasSpace(boolean hasSpace) {
        this.hasSpace = hasSpace;
    }
    public int getBuyCost (){
        return buyCost;
    }
    public int getHitPoint() {
        return hitPoint;
    }
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
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
    public int getOwner(){
        return owner;
    }
    public void setOwner(int owner){
        this.owner=owner;
    }
    public int getlevel() {
        return level;
    }
    public void setProducedBy(int producedBy) {
        this.producedBy = producedBy;
    }
    public int getProducedBy() {
        return producedBy;
    }
    public static boolean canMerge(Unit1 units1, Unit1 units2) {
        if(units1.getlevel()==units2.getlevel()&& units1.getlevel() <4 && units2.getlevel()<4 ) {
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Unit1 that = (Unit1) obj;

        return hitPoint == that.hitPoint &&
                movementRange == that.movementRange &&
                attackPower == that.attackPower &&
                attackRange == that.attackRange &&
                payment == that.payment &&
                ration == that.ration &&
                unitSpace == that.unitSpace &&
                level == that.level &&
                producedBy == that.producedBy &&
                owner == that.owner &&
                buyCost == that.buyCost &&
                hasSpace == that.hasSpace &&
                isPaid == that.isPaid &&
                haveEaten == that.haveEaten &&
                (type != null ? type.equals(that.type) : that.type == null);
    }

}
