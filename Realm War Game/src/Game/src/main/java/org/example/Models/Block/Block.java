package src.Game.src.main.java.org.example.Models.Block;



public abstract class Block {
    protected boolean hasOwner;
    protected int owner;
    protected int gold;
    protected int food;
    protected boolean hasBuilt;

    public Block(int food, int gold) {
        this.hasOwner = false;
        this.owner = 0;
        this.hasBuilt = false;
        this.food = food;
        this.gold = gold;
    }
    public int getOwner() {
        return owner;
    }
    public void setOwner(int owner) {
        this.owner = owner;
    }
    public abstract String getType();
    public int getGold() {
        return gold;
    }
    public int getFood() {
        return food;
    }

}

