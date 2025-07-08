package src.Game.src.main.java.org.example.Models.Block;


public class ForestBlock extends Block {

    public ForestBlock(int x, int y) {
        super(x, y);
        this.food=2;
        this.gold=0;
    }

    public String getType() {
        return "forest";
    }
    public void build(){
        food=0;
        gold=0;
    }
}
