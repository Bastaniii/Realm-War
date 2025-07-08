package src.Game.src.main.java.org.example.Models.structures;

import src.Game.src.main.java.org.example.Models.structures.Structure1;
import src.Game.src.main.java.org.example.Models.units.Unit1;

public class TownHall extends Structure1  {
    protected int unitSpace;
    protected int food;
    protected int gold;
    public TownHall() {
        super(1, 1, 25, 0, 0,0);
        this.unitSpace = 10;
        this.food = 5;
        this.gold = 5;
    }
    public int getFood(){
        return this.food;
    }
    public int getGold(){
        return this.gold;
    }
    public int getUnitSpace() {
        return unitSpace;
    }
    public void setUnitSpace(int unitspace) {
        this.unitSpace = unitspace;
    }
    public boolean isFull(TownHall townHall) {
        return townHall.getUnitSpace() ==0;
    }
    public boolean canAddUnit(TownHall townHall, Unit1 unit) {
        return unit.getUnitSpace()<townHall.getUnitSpace();
    }
    public void addUnit (TownHall townHall, Unit1 unit) {
        if (canAddUnit(townHall, unit)) {
            setUnitSpace(townHall.getUnitSpace()-unit.getUnitSpace());
        }
    }
    public void removeUnit(TownHall townHall, Unit1 unit) {
        townHall.setUnitSpace(townHall.getUnitSpace()+unit.getUnitSpace());
    }
}
