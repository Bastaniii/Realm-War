package src.Game.src.main.java.org.example.Models;

import src.Game.src.main.java.org.example.Models.Block.Block;
import src.Game.src.main.java.org.example.Models.Structures.Structures;
import src.Game.src.main.java.org.example.Models.units.Unit1;

public class Tile {
    protected Block block;
    protected Structures structure;
    protected Unit1 unit;
    protected boolean movable;
    protected boolean placeUnit;
    protected boolean attackable;
    protected boolean canMakeStructure;
    protected boolean canLevelUpStructure;
    protected boolean protectedByTower;
    public Tile(Block block) {
        this.block = block;
        this.structure = null;
        this.unit = null;
        this.movable = false;
        this.attackable = false;
        this.canMakeStructure = false;
        this.canLevelUpStructure = false;
        this.protectedByTower = false;
        this.placeUnit=false;
    }
    public boolean canPlaceUnit(){
        return placeUnit;
    }
    public void setPlaceUnit(boolean placeUnit) {
        this.placeUnit = placeUnit;
    }
    public boolean isProtectedByTower() {
        return protectedByTower;
    }
    public void setProtectedByTower(boolean protectedByTower) {
        this.protectedByTower = protectedByTower;
    }
    public boolean getCanLevelUpStructure() {
        return canLevelUpStructure;
    }
    public void setCanLevelUpStructure(boolean canLevelUpStructure) {
        this.canLevelUpStructure = canLevelUpStructure;
    }
    public void setCanMakeStructure(boolean canMakeStructure) {
        this.canMakeStructure = canMakeStructure;
    }
    public boolean getCanMakeStructure() {
        return canMakeStructure;
    }
    public void setAttackable(boolean attackable) {
        this.attackable = attackable;
    }
    public boolean isAttackable() {
        return attackable;
    }
    public void setMovable(boolean movable) {
        this.movable = movable;
    }
    public boolean getMovable() {
        return movable;
    }
    public Block getBlock() {
        return block;
    }
    public Structures getStructure() {
        return structure;
    }
    public Unit1 getUnit() {
        return unit;
    }
    public void setBlock(Block block) {
        this.block = block;
    }
    public void setStructure(Structures structure) {
        this.structure = structure;
    }
    public void setUnit(Unit1 unit) {
        this.unit = unit;
    }
    public boolean hasBlock() {
        return block != null;
    }
    public boolean hasStructure() {
        return structure != null;
    }
    public boolean hasUnit() {
        return unit != null;
    }
    public void removeStructure() {
        structure = null;
    }
    public void removeUnit() {
        unit = null;
    }
}
