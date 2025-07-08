package src.Game.src.main.java.org.example.Models.Block;



public abstract class Block {
    protected int x;
    protected int y;
    protected boolean hasOwner;
    protected int owner;
    protected  String type;
    protected int gold;
    protected int food;
    protected boolean hasBuilt;
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.hasOwner = false;
        this.owner = 0;
        this.hasBuilt = false;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public boolean hasOwner() {
        return hasOwner;
    }
    public int getOwner() {
        return owner;
    }
    public String getType() {
        return type;
    }
    public int getGold() {
        return gold;
    }
    public int getFood() {
        return food;
    }
    public void changeOwner(int newOwner) {
        hasOwner = true;
        owner = newOwner;
    }
    public void build(){
        hasBuilt = true;
    }
    public boolean canBuild() {
        return !hasBuilt;
    }
}

