package src.Game.src.main.java.org.example.Models.Structures;
import src.Game.src.main.java.org.example.Models.structures.Structure1;
import src.Game.src.main.java.org.example.Models.units.Unit1;


public class Barrack extends Structure1{
    protected int unitSpace;
    protected String BarrackName;
    public Barrack(int buildingCost,String BarrackName) {
        super(1, 3, 25, 5, buildingCost,5);
        this.unitSpace = 20;
    }
    public int getUnitSpace() {
        return unitSpace;
    }

    public void setUnitSpace(int unitspace) {
        this.unitSpace = unitspace;
    }
    public boolean isFull(Barrack barrack) {
        return barrack.getUnitSpace() ==0;
    }
    public boolean canAddUnit(Barrack barrack, Unit1 unit) {
        return unit.getUnitSpace()<barrack.getUnitSpace();
    }
    public void addUnit (Barrack barrack, Unit1 unit) {
        if (canAddUnit(barrack, unit)) {
            setUnitSpace(barrack.getUnitSpace()-unit.getUnitSpace());
        }
    }
    public void updateLevelUpCost(Barrack barrack) {
        barrack.setLevelUpCost(barrack.getLevelUpCost()+5);
    }
    public void removeUnit(Barrack barrack, Unit1 unit) {
        barrack.setUnitSpace(barrack.getUnitSpace()+unit.getUnitSpace());
    }
    public void upgradeStructure(Barrack barrack) {
        barrack.setLevel(barrack.getLevel()+1);
        barrack.setLevelUpCost(barrack.getLevelUpCost()+5);
        barrack.setUnitSpace(barrack.getUnitSpace()+5);
        barrack.setHitPoint(barrack.getHitPoint()+5);
    }
}
