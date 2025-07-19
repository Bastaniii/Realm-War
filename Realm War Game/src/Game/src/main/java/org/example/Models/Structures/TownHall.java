package src.Game.src.main.java.org.example.Models.Structures;

import src.Game.src.main.java.org.example.Models.units.Unit1;

public class TownHall extends Structure1 {
    protected boolean isDefeated;
    public TownHall(int owner) {
        super(1, 1, 100, 0, 0,0,owner,"TownHall",1,5,0,5,5 ,1);
        this.isDefeated = false;
    }
    public void setDefeated (boolean isDefeated) {
        this.isDefeated = isDefeated;
    }
    public boolean isDefeated () {
        return isDefeated;
    }

    @Override
    public void upgrade() {

    }
}
