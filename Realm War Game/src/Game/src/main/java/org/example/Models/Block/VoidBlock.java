package org.example.Models.Block;

import org.example.Models.Block.Block;

public class VoidBlock extends Block {

    public VoidBlock(int x, int y) {
        super(x, y);
    }
    public String getType(){
        return "void";
    }
    public boolean canBuild() {
        return false;
    }
}
