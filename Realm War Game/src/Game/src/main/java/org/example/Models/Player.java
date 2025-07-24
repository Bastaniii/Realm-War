package src.Game.src.main.java.org.example.Models;

import src.Game.src.main.java.org.example.Models.Structures.Structure1;
import src.Game.src.main.java.org.example.Models.units.Unit1;

import java.util.ArrayList;
import java.util.List;

public class Player {
    protected int playerNumber;
    protected int playerGold;
    protected int playerFood;
    protected int barrackBuildingCost;
    protected int farmBuildingCost;
    protected int marketBuildingCost;
    protected int towerBuildingCost;
    protected List<Structure1> playerStructures;
    protected List<Unit1> playerUnits;
    protected int barrackMaxAmount;
    protected int farmMaxAmount;
    protected int marketMaxAmount;
    protected int towerMaxAmount;
    protected boolean defeated;
    public Player(int playerNum) {
        this.playerNumber = playerNum;
        this.playerGold = 30;
        this.playerFood = 20;
        this.barrackBuildingCost = 10;
        this.farmBuildingCost = 10;
        this.marketBuildingCost = 10;
        this.playerStructures = new ArrayList<Structure1>();
        this.playerUnits= new ArrayList<Unit1>();
        this.barrackMaxAmount = 3;
        this.farmMaxAmount = 3;
        this.marketMaxAmount = 3;
        this.towerMaxAmount = 5;
        this.towerBuildingCost = 10;
        this.defeated = false;
    }
    public boolean isDefeated() {
        return defeated;
    }
    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }
    public void setplayerGold(int playerGold){
        this.playerGold = playerGold;
    }
    public int getPlayerGold(){
        return this.playerGold;
    }
    public void setplayerFood(int playerFood){
        this.playerFood = playerFood;
    }
    public int getPlayerFood(){
        return this.playerFood;
    }
    public void addStructure(Structure1 structure){
        this.playerStructures.add(structure);
    }
    public void removeStructure(Structure1 structure){
        this.playerStructures.remove(structure);
    }
    public List<Structure1> getPlayerStructures(){
        return this.playerStructures;
    }
    public Structure1 getStructure(int index){
        return this.playerStructures.get(index);
    }
    public void addUnit(Unit1 unit){
        this.playerUnits.add(unit);
    }
    public void removeUnit(Unit1 unit){
        this.playerUnits.remove(unit);
    }
    public List<Unit1> getPlayerUnits(){
        return this.playerUnits;
    }
    public Unit1 getUnit(int index){
        return this.playerUnits.get(index);
    }
    public int getPlayerNumber() {
        return playerNumber;
    }
    public void updateBarrackBuildingCost () {
        this.barrackBuildingCost = getNumberOfBarrack()*5+10;
    }
    public int getBarrackBuildingCost() {
        return barrackBuildingCost;
    }
    public void updateFarmBuildingCost () {
        this.farmBuildingCost = getNumberOfFarm()*5+10;
    }
    public int getFarmBuildingCost() {
        return farmBuildingCost;
    }
    public void updatedMarketBuildingCost () {
        this.marketBuildingCost =getNumberOfMarket()*5+10;
    }
    public int getTowerBuildingCost(){
        return towerBuildingCost;
    }
    public int getMarketBuildingCost() {
        return marketBuildingCost;
    }
    public int playerStructureAmount() {
        return this.playerStructures.size();
    }
    public int playerUnitAmount() {
        return this.playerUnits.size();
    }
    public int getNumberOfBarrack(){
        int numberOfBarrack = 0;
        for(Structure1 structure : playerStructures){
            if (structure.getType().equals("Barrack")){
                numberOfBarrack++;
            }
        }
        return numberOfBarrack;
    }
    public int getNumberOfFarm(){
        int numberOfFarm = 0;
        for(Structure1 structure : playerStructures){
            if (structure.getType().equals("Farm")){
                numberOfFarm++;
            }
        }
        return numberOfFarm;
    }
    public int getNumberOfMarket(){
        int numberOfMarket = 0;
        for(Structure1 structure : playerStructures){
            if (structure.getType().equals("Market")){
                numberOfMarket++;
            }
        }
        return numberOfMarket;
    }
    public int getNumberOfTower(){
        int numberOfTower = 0;
        for(Structure1 structure : playerStructures){
            if (structure.getType().equals("Tower")){
                numberOfTower++;
            }
        }
        return numberOfTower;
    }
    public int getProducerNumber(){
        int count2=0;
        int count3=0;
        int count4=0;
        for(Structure1 structure : playerStructures){
            if (structure.getType().equals("Barrack")){
             if(structure.getProduceNum()==2){
                 count2++;
             }
             if(structure.getProduceNum()==3){
                 count3++;
             }
             if(structure.getProduceNum()==4){
                 count4++;
             }
            }
            if(count2==0){
                return 2;
            }
            if(count3==0){
                return 3;
            }
            if(count4==0){
                return 4;
            }
        }
        return 0;
    }


}
