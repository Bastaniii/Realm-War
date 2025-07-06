package org.example.Models.Block;

public class EmptyBlock extends Block {

    public EmptyBlock(int x, int y) {
        super(x, y);
        this.gold=2;
        this.food=0;
    }
    public String getType() {
        return "Empty";
    }
}