package src.Game.src.main.java.org.example.Models;

import src.Game.src.main.java.org.example.Models.Block.EmptyBlock;
import src.Game.src.main.java.org.example.Models.Structures.*;
import src.Game.src.main.java.org.example.Models.units.*;
import src.Game.src.main.java.org.example.Utils.GameLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static src.Game.src.main.java.org.example.Models.units.Unit1.canMerge;

public class GameManager {
    protected int AmountOfPlayers;
    protected PlayerTurn playerTurn;
    protected List<Player> players;
    protected GameBoard GameBoard;
    protected boolean isGameOver;
    public GameManager(int AmountOfPlayers) {
        players=new ArrayList<Player>();
        this.AmountOfPlayers=AmountOfPlayers;
        GameBoard=new GameBoard(AmountOfPlayers);
        playerTurn = new PlayerTurn(players);
        this.isGameOver=false;

        players.add(new Player(1));
        getPlayer(1).addStructure(getTile(1,18).getStructure());
        getPlayer(1).addUnit(getTile(3,16).getUnit());
        players.add(new Player(2));
        getPlayer(2).addStructure(getTile(18,1).getStructure());
        getPlayer(2).addUnit(getTile(16,3).getUnit());
        if(AmountOfPlayers>=3){
            players.add(new Player(3));

            getPlayer(3).addStructure(getTile(1,1).getStructure());
            getPlayer(3).addUnit(getTile(3,3).getUnit());
        }
        if(AmountOfPlayers==4){
            players.add(new Player(4));
            getPlayer(4).addStructure(getTile(18,18).getStructure());
            getPlayer(4).addUnit(getTile(16,16).getUnit());
        }





    }
    //
    public GameBoard getGameBoard() {
        return GameBoard;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public PlayerTurn getPlayerTurn() {

        return playerTurn;
    }

    public Tile getTile(int i, int j) {
        if (i < 0 || i >= 20 || j < 0 || j >= 20) {
            GameLogger.log("Invalid tile access at (" + i + "," + j + ")");
            throw new IndexOutOfBoundsException("Tile coordinates out of bounds.");
        }
        return GameBoard.gameBoard[i][j];
    }
    public int findStructureX(Structure1 structure) {
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Structure1 s = getTile(i, j).getStructure();
                if (s != null && s.equals(structure)) {
                    return i;
                }
            }
        }
        return -1;
    }
    public int findStructureY(Structure1 structure) {
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Structure1 s = getTile(i, j).getStructure();
                if (s != null && s.equals(structure)) {
                    return j;
                }

            }
        }
        return -1;
    }
    public int findUnitsX(Unit1 unit) {
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                Unit1 s = getTile(i, j).getUnit();
                if (s != null && s.equals(unit)) {
                    return i;
                }

            }
        }
        return -1;
    }
    public int findUnitsY(Unit1 unit) {
        for(int i=0; i<20; i++){

            for(int j=0; j<20; j++){
                Unit1 s = getTile(i, j).getUnit();
                if (s != null && s.equals(unit)) {
                    return j;
                }
            }
        }
        return -1;
    }
    // set all
    public void setAllAttackable(){
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                getTile(i,j).setAttackable(false);
            }
        }
    }
    public void setAllMovable(){
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                getTile(i,j).setMovable(false);
            }
        }
    }
    public void setAllPlaceUnit(){
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                getTile(i,j).setPlaceUnit(false);
            }
        }
    }
    public void setAllCanMakeStructure(){
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                getTile(i,j).setCanMakeStructure(false);
            }
        }
    }
    public void setAllVCanLevelUpStructure(){
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                getTile(i,j).setCanLevelUpStructure(false);
            }
        }
    }
    //Structure
    // protected by tower
    public void protectedByTower( int x, int y) {
        int defence=GameBoard.gameBoard[x][y].getStructure().getDefenceRange();
        for(int i=x-defence; i<=x+defence; i++){
            for(int j=y-defence; j<=y+defence; j++){
                if(0<=i&&i<20&&0<=j&&j<20){
                    GameBoard.gameBoard[i][j].setProtectedByTower(true);
                }

            }
        }
        GameBoard.gameBoard[x][y].setProtectedByTower(false);
    }
    public void endProtectionByTower(int x, int y) {
        int defenceVByTower=GameBoard.gameBoard[x][y].getStructure().getDefenceRange();
        for(int i=x-defenceVByTower; i<=x+defenceVByTower; i++){
            for(int j=y-defenceVByTower; j<=y+defenceVByTower; j++){
                if(0<=i&&i<20&&0<=j&&j<20){
                    GameBoard.gameBoard[i][j].setProtectedByTower(false);
                }
            }
        }
    }
    //build new one
    public void buildStructure(int x, int y,Player player,String structureType) {
        if(isForestBlock(x, y)){
            GameBoard.gameBoard[x][y].setBlock(new EmptyBlock());
            GameBoard.gameBoard[x][y].getBlock().setOwner(player.getPlayerNumber());
            GameLogger.log("ForestBlock changed to EmptyBlock");
        }
        if(structureType.equals("Barrack")){
            GameBoard.gameBoard[x][y].setStructure(new Barrack1(player.getBarrackBuildingCost(),player.getPlayerNumber(),player.getProducerNumber()));
            player.setplayerGold(player.getPlayerGold()-GameBoard.gameBoard[x][y].getStructure().getBuildingCost());
            player.addStructure(GameBoard.gameBoard[x][y].getStructure());
            for(int i=0;i<player.playerUnits.size();i++){
                if(!player.getUnit(i).getHasSpace()){
                    if(player.getUnit(i).getUnitSpace()<=GameBoard.gameBoard[x][y].getStructure().getUnitSpace()){
                        GameBoard.gameBoard[x][y].getStructure().setUnitSpace(GameBoard.gameBoard[x][y].getStructure().getUnitSpace()-player.getUnit(i).getUnitSpace());
                        player.getUnit(i).setProducedBy(GameBoard.gameBoard[x][y].getStructure().getProduceNum());
                        player.getUnit(i).setHasSpace(true);
                    }
                }

            }
            player.updateBarrackBuildingCost();
        }
        if(structureType.equals("Farm")){
            GameBoard.gameBoard[x][y].setStructure(new Farm1(player.getFarmBuildingCost(),player.getPlayerNumber()));
            player.setplayerGold(player.getPlayerGold()-GameBoard.gameBoard[x][y].getStructure().getBuildingCost());
            player.addStructure(GameBoard.gameBoard[x][y].getStructure());
            player.updateFarmBuildingCost();
        }
        if(structureType.equals("Market")){
            GameBoard.gameBoard[x][y].setStructure(new Market1(player.getMarketBuildingCost(),player.getPlayerNumber()));
            player.setplayerGold(player.getPlayerGold()-GameBoard.gameBoard[x][y].getStructure().getBuildingCost());
            player.addStructure(GameBoard.gameBoard[x][y].getStructure());
            player.updatedMarketBuildingCost();
        }
        if(structureType.equals("Tower")){
            GameBoard.gameBoard[x][y].setStructure(new Tower(player.getPlayerNumber()));
            player.setplayerGold(player.getPlayerGold()-GameBoard.gameBoard[x][y].getStructure().getBuildingCost());
            player.addStructure(GameBoard.gameBoard[x][y].getStructure());
            protectedByTower(x,y);
        }
    }
    public boolean isForestBlock(int x, int y) {
        return GameBoard.gameBoard[x][y].getBlock().getType().equals("Forest");
    }
    public void changeBlock(int x, int y,Player player) {
        if(Objects.equals(GameBoard.gameBoard[x][y].getBlock().getType(), "Forest")){
            GameBoard.gameBoard[x][y].setBlock(new EmptyBlock());
            GameBoard.gameBoard[x][y].getBlock().setOwner(player.getPlayerNumber());
        }
    }
    public boolean canAffordBuilding(String typeOfStructure, Player player) {
        if(typeOfStructure.equals("Barrack")){
            if(player.getBarrackBuildingCost()<player.getPlayerGold()){
                return true;
            }
        }
        if(typeOfStructure.equals("Farm")){
            if(player.getFarmBuildingCost()<player.getPlayerGold()){
                return true;
            }
        }
        if(typeOfStructure.equals("Market")){
            if(player.getMarketBuildingCost()<player.getPlayerGold()){
                return true;
            }
        }
        if(typeOfStructure.equals("Tower")){
            if(player.getTowerBuildingCost()<player.getPlayerGold()){
                return true;
            }
        }
        return false;
    }
    public boolean HasMaxAmount(Player player,String structureType) {
        if(structureType.equals("Barrack")){
            if(player.getNumberOfBarrack()== player.barrackMaxAmount){
                return true;
            }
        }
        if(structureType.equals("Farm")){
            if(player.getNumberOfFarm()== player.farmMaxAmount){
                return true;
            }
        }
        if(structureType.equals("Market")){
            if(player.getNumberOfMarket()== player.marketMaxAmount){
                return true;
            }
        }
        if(structureType.equals("Tower")){
            if(player.getNumberOfTower()== player.towerMaxAmount){
                return true;
            }
        }
        return false;    }
    public boolean canBuild(Player player) {
        int count=0;
        for(int i=1; i<19;i++){
            for(int j=1; j<19;j++){
                if(GameBoard.gameBoard[i][j].getCanMakeStructure()){
                    count++;
                }
            }
        }
        if(count>0){
            return true;
        }
        return false;
    }
    public void whereToBuildStructure(Player player,String structure) {
        for(int i=1; i<19; i++){
            for(int j=1; j<19; j++){
                if(GameBoard.gameBoard[i][j].getBlock().getOwner()==player.getPlayerNumber()&&GameBoard.gameBoard[i][j].getStructure()==null&&GameBoard.gameBoard[i][j].getUnit()==null){
                    GameBoard.gameBoard[i][j].setCanMakeStructure(true);
                }
            }
        }
    }
    public boolean  canBuildHere(int x, int y) {
        return getTile(x,y).getCanMakeStructure();
    }
    //levelUp
    public boolean canAffordLevelUp(int x,int y,Player player) {
        return GameBoard.gameBoard[x][y].getStructure().getLevelUpCost()<player.getPlayerGold();
    }
    public boolean canLevelUpStructure(Player player) {
        int count=0;
        for(int i=1; i<19; i++){
            for(int j=1; j<19; j++){
                if(GameBoard.gameBoard[i][j].getCanLevelUpStructure()){
                    count++;
                }
            }
        }
        if(count>0){
            return true;
        }
        return false;
    }
    public boolean canLevelUpThis(int x,int y) {
        return getTile(x,y).getCanLevelUpStructure();
    }
    public void whichToLevelUpStructure(Player player) {
        for(int i=1; i<19; i++){
            for(int j=1; j<19; j++){
                if(GameBoard.gameBoard[i][j].getBlock().getOwner()==player.getPlayerNumber()&&GameBoard.gameBoard[i][j].getStructure()!=null&& !GameBoard.gameBoard[i][j].getStructure().isMaxLevel(GameBoard.gameBoard[i][j].getStructure()) && canAffordLevelUp(i, j, player)){
                    GameBoard.gameBoard[i][j].setCanLevelUpStructure(true);
                }
            }
        }
    }
    public void levelUpStructure(int x,int y) {
        GameBoard.gameBoard[x][y].getStructure().upgrade();
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Tower")){
            protectedByTower(x,y);
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Barrack")){
            int player=   GameBoard.gameBoard[x][y].getBlock().getOwner();
            for(int i=0;i<getPlayer(player).playerUnits.size();i++){
                if(!getPlayer(player).getUnit(i).getHasSpace()){
                    if(getPlayer(player).getUnit(i).getUnitSpace()<=GameBoard.gameBoard[x][y].getStructure().getUnitSpace()){
                        GameBoard.gameBoard[x][y].getStructure().setUnitSpace(GameBoard.gameBoard[x][y].getStructure().getUnitSpace()-getPlayer(player).getUnit(i).getUnitSpace());
                        getPlayer(player).getUnit(i).setProducedBy(GameBoard.gameBoard[x][y].getStructure().getProduceNum());
                        getPlayer(player).getUnit(i).setHasSpace(true);
                    }
                }

            }
        }
    }
    //attack and destroy
    public boolean willSurviveStructure(int attackerx,int attackery,int targetx,int targety) {
        if(GameBoard.gameBoard[attackerx][attackery].getUnit().getAttackPower()<GameBoard.gameBoard[targetx][targety].getStructure().getHitPoint()){
            return true;
        }
        return false;
    }
    public void destroyStructure(int x, int y,int attackerX,int attackerY) {
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Tower")){
            endProtectionByTower(x,y);
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("TownHall")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).setDefeated(true);
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Barrack")){
            for(int i=0;i < getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).playerUnits.size();i++){
                if(getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).getProducedBy()==GameBoard.gameBoard[x][y].getStructure().getProduceNum()){
                    getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).setHasSpace(false);
                    getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).setProducedBy(0);

                }
            }
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updateBarrackBuildingCost();
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Farm")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updateFarmBuildingCost();
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Market")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updatedMarketBuildingCost();
        }
        getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).removeStructure(GameBoard.gameBoard[x][y].getStructure());
        GameBoard.gameBoard[x][y].setStructure(null);
        GameBoard.gameBoard[attackerX][attackerY].getUnit().setHasAttacked(true);
    }
    public void destroyStructureNoAttacker(int x, int y) {
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Tower")){
            endProtectionByTower(x,y);
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("TownHall")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).setDefeated(true);
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Farm")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updateFarmBuildingCost();
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Market")){
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updatedMarketBuildingCost();
        }
        if(GameBoard.gameBoard[x][y].getStructure().getType().equals("Barrack")){
            for(int i=0;i < getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).playerUnits.size();i++){
                if(getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).getProducedBy()==GameBoard.gameBoard[x][y].getStructure().getProduceNum()){
                    getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).setHasSpace(false);
                    getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).getUnit(i).setProducedBy(0);

                }
            }
            getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).updateBarrackBuildingCost();
        }
        getPlayer(GameBoard.gameBoard[x][y].getBlock().getOwner()).removeStructure(GameBoard.gameBoard[x][y].getStructure());
        GameBoard.gameBoard[x][y].setStructure(null);
    }
    public void attackStructure(int attackerx,int attackery,int targetx,int targety) {
        GameBoard.gameBoard[targetx][targety].getStructure().setHitPoint(GameBoard.gameBoard[targetx][targety].getStructure().getHitPoint()-GameBoard.gameBoard[attackerx][attackery].getUnit().getAttackPower());
        GameBoard.gameBoard[attackerx][attackery].getUnit().setHasAttacked(true);
    }
    //unit space management
    public boolean hasEnoughUnitSpace(Player player,int space) {
        for(int i=0; i<player.playerStructures.size(); i++){
            if(space<=player.getStructure(i).getUnitSpace()){
                return true;
            }
        }
        return false;
    }
    public boolean HasEnoughUnitSpaceByPN(Player player,int produce,int space) {
        for(int i=0; i<player.playerStructures.size(); i++){
            if(player.getStructure(i).getProduceNum()==produce){
                if(space<=player.getStructure(i).getUnitSpace()){
                    return true;
                }
            }
        }
        return false;
    }
    public int whichHasEnoughUnitSpaceByPN(Player player,int space) {
        for(int i=0; i<player.playerStructures.size(); i++){
            if(space<=player.getStructure(i).getUnitSpace()){
                return player.getStructure(i).getProduceNum();
            }
        }
        return 0;
    }
    //unit
    // attackable
    public void showAttackablePlace (Player player,int attackerx, int attackery) {
        int attackerRange=GameBoard.gameBoard[attackerx][attackery].getUnit().getAttackRange();
        for(int i=attackerx-attackerRange;i<=attackerx+attackerRange;i++){
            for(int j=attackery-attackerRange;j<=attackery+attackerRange;j++){
                if(0<=i&& i<19&&0<=j&&j<19){
                    if(GameBoard.gameBoard[i][j].getBlock().getOwner()!= player.getPlayerNumber()&& !GameBoard.gameBoard[i][j].isProtectedByTower()){
                        if(GameBoard.gameBoard[i][j].getUnit()!=null || GameBoard.gameBoard[i][j].getStructure()!=null){
                            GameBoard.gameBoard[i][j].setAttackable(true);
                        }
                    }

                }

            }
        }
        GameBoard.gameBoard[attackerx][attackery].setAttackable(false);
    }
    public boolean canAttackThis(int x, int y) {
        return GameBoard.gameBoard[x][y].isAttackable();
    }
    public boolean canAttack() {
        int count=0;
        for(int i=1;i<=19;i++){
            for(int j=1;j<=19;j++){
                if(GameBoard.gameBoard[i][j].isAttackable()){
                    count++;
                }
            }
        }
        if(count!=0){
            return true;
        }
        return false;
    }
    // merge
    public boolean CanMerge(Player player,int unit1x,int unit1y,int unit2x,int unit2y) {
        int Space=1;
        int from1= GameBoard.gameBoard[unit1x][unit1y].getStructure().getProduceNum();
        int from2= GameBoard.gameBoard[unit2x][unit2y].getStructure().getProduceNum();
        if(canMerge (GameBoard.gameBoard[unit1x][unit1y].getUnit(),GameBoard.gameBoard[unit2x][unit2y].getUnit())){
            if(GameBoard.gameBoard[unit1x][unit1y].getUnit().getlevel()==2){
                if(from1==from2){
                   return true;
                }
                else{
                    if(hasEnoughUnitSpace(player, 2) || HasEnoughUnitSpaceByPN(player,from1,Space) || HasEnoughUnitSpaceByPN(player,from2,Space)){
                        return true;
                    }
                    return false;
                }

            }
            return true;
        }
        return false;
    }
    public void merge(Player player,int unit1x,int unit1y,int unit2x,int unit2y) {
        int Level=GameBoard.gameBoard[unit1x][unit1y].getUnit().getlevel();
        int from1=GameBoard.gameBoard[unit1x][unit1y].getUnit().getProducedBy();
        int from2=GameBoard.gameBoard[unit2x][unit2y].getUnit().getProducedBy();
        if(Level==1){
            for(int i=0; i<player.playerStructures.size();i++){
                if(player.getStructure(i).getProduceNum()==from2){
                    player.getStructure(i).setUnitSpace(player.getStructure(i).getUnitSpace()+1);
                }
            }
            player.removeUnit(GameBoard.gameBoard[unit1x][unit1y].getUnit());
            player.removeUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
            GameBoard.gameBoard[unit1x][unit1y].setUnit(null);
            GameBoard.gameBoard[unit2x][unit2y].setUnit(null);
            GameBoard.gameBoard[unit2x][unit2y].setUnit(new Spearman(player.getPlayerNumber(),from1));
            player.addUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
        }
        if(Level==2){
            if(from1==from2){
                player.removeUnit(GameBoard.gameBoard[unit1x][unit1y].getUnit());
                player.removeUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
                GameBoard.gameBoard[unit1x][unit1y].setUnit(null);
                GameBoard.gameBoard[unit2x][unit2y].setUnit(null);
                GameBoard.gameBoard[unit2x][unit2y].setUnit(new Spearman(player.getPlayerNumber(),from1));
                player.addUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
            }
            else{
                int from=0;
                if(HasEnoughUnitSpaceByPN(player,from1,1)){
                    from=from1;
                    for(int j=0;j<player.playerStructures.size();j++){
                        if(player.getStructure(j).getProduceNum()==from1){
                            player.getStructure(j).setUnitSpace(player.getStructure(j).getUnitSpace()-1);
                        }
                    }
                    for(int h=0;h<player.playerStructures.size();h++){
                        if(player.getStructure(h).getProduceNum()==from2){
                            player.getStructure(h).setUnitSpace(player.getStructure(h).getUnitSpace()+1);
                        }
                    }
                }
                if(HasEnoughUnitSpaceByPN(player,from2,1)){
                    from=from2;
                    for(int j=0;j<player.playerStructures.size();j++){
                        if(player.getStructure(j).getProduceNum()==from2){
                            player.getStructure(j).setUnitSpace(player.getStructure(j).getUnitSpace()-1);
                        }
                    }
                    for(int h=0;h<player.playerStructures.size();h++){
                        if(player.getStructure(h).getProduceNum()==from1){
                            player.getStructure(h).setUnitSpace(player.getStructure(h).getUnitSpace()+1);
                        }
                    }
                }
                else if(!HasEnoughUnitSpaceByPN(player, from1, 1) && !HasEnoughUnitSpaceByPN(player, from2, 1)){
                    from=whichHasEnoughUnitSpaceByPN(player,2);
                    for(int j=0;j<player.playerStructures.size();j++){
                        if(player.getStructure(j).getProduceNum()==from2){
                            player.getStructure(j).setUnitSpace(player.getStructure(j).getUnitSpace()+1);
                        }
                    }
                    for(int h=0;h<player.playerStructures.size();h++){
                        if(player.getStructure(h).getProduceNum()==from1){
                            player.getStructure(h).setUnitSpace(player.getStructure(h).getUnitSpace()+1);
                        }
                    }
                    for(int h=0;h<player.playerStructures.size();h++){
                        if(player.getStructure(h).getProduceNum()==from){
                            player.getStructure(h).setUnitSpace(player.getStructure(h).getUnitSpace()-2);
                        }
                    }
                }
                player.removeUnit(GameBoard.gameBoard[unit1x][unit1y].getUnit());
                player.removeUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
                GameBoard.gameBoard[unit1x][unit1y].setUnit(null);
                GameBoard.gameBoard[unit2x][unit2y].setUnit(null);
                GameBoard.gameBoard[unit2x][unit2y].setUnit(new Swordman(player.getPlayerNumber(),from));
                player.addUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
            }

        }
        if(Level==3){
            for(int i=0; i<player.playerStructures.size();i++){
                if(player.getStructure(i).getProduceNum()==from2){
                    player.getStructure(i).setUnitSpace(player.getStructure(i).getUnitSpace()+2);
                }
            }
            player.removeUnit(GameBoard.gameBoard[unit1x][unit1y].getUnit());
            player.removeUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
            GameBoard.gameBoard[unit1x][unit1y].setUnit(null);
            GameBoard.gameBoard[unit2x][unit2y].setUnit(null);
            GameBoard.gameBoard[unit2x][unit2y].setUnit(new Knight(player.getPlayerNumber(),from1));
            player.addUnit(GameBoard.gameBoard[unit2x][unit2y].getUnit());
        }
    }

        //buy and place unit
        public boolean canBuyFrom(int x, int y,int unitLevel){
            if(unitLevel==1 || unitLevel==2){
                if(1<=GameBoard.gameBoard[x][y].getStructure().getUnitSpace()){
                    return true;
                }
                return false;
            }
            if(unitLevel==3||unitLevel==4){
                if(2<=GameBoard.gameBoard[x][y].getStructure().getUnitSpace()){
                    return true;
                }
                return false;
            }
            return false;
        }
        public boolean canAffordBuyingUnit(Player player,int unitLevel){
            if(unitLevel==1){
                if(5<=player.getPlayerGold()){
                    return true;
                }
                return false;
            }
            if(unitLevel==2){
                if(10<=player.getPlayerGold()){
                    return true;
                }
                return false;
            }
            if(unitLevel==3){
                if(20<=player.getPlayerGold()){
                    return true;
                }
                return false;
            }
            if(unitLevel==4){
                if(30<=player.getPlayerGold()){
                    return true;
                }
                return false;
            }
            return false;
        }
        public void whereToPlace(Player player){
            for(int i=1;i<19;i++){
                for(int j=1;j<19;j++){
                    if(GameBoard.gameBoard[i][j].getBlock().getOwner()==player.getPlayerNumber()&& !GameBoard.gameBoard[i][j].hasStructure() && !GameBoard.gameBoard[i][j].hasUnit()){
                        GameBoard.gameBoard[i][j].setPlaceUnit(true);
                    };
                }
            }
        }
        public boolean canPlaceUnit(){
            int count=0;
            for(int i=1;i<=19;i++){
                for(int j=1;j<=19;j++){
                    if(GameBoard.gameBoard[i][j].canPlaceUnit()){
                        count++;
                    }
                }
            }
            if(count!=0){
                return true;
            }
            return false;
        }
        public boolean canPlaceUnitThere(int x, int y){
            if(GameBoard.gameBoard [x][y].canPlaceUnit()){
                return true;
            }
            return false;
        }
        public void buyUnit(int unitLevel,Player player,int UnitX,int UnitY,int producerX,int producerY){
            if(unitLevel==1){
                GameBoard.gameBoard[UnitX][UnitY].setUnit(new Peasant(player.getPlayerNumber(),GameBoard.gameBoard[producerX][producerY].getStructure().getProduceNum()));
            }
            if(unitLevel==2){
                GameBoard.gameBoard[UnitX][UnitY].setUnit(new Spearman(player.getPlayerNumber(),GameBoard.gameBoard[producerX][producerY].getStructure().getProduceNum()));
            }
            if(unitLevel==3){
                GameBoard.gameBoard[UnitX][UnitY].setUnit(new Swordman(player.getPlayerNumber(),GameBoard.gameBoard[producerX][producerY].getStructure().getProduceNum()));
            }
            if(unitLevel==4){
                GameBoard.gameBoard[UnitX][UnitY].setUnit(new Knight(player.getPlayerNumber(),GameBoard.gameBoard[producerX][producerY].getStructure().getProduceNum()));
            }
            player.setplayerGold(player.getPlayerGold()-GameBoard.gameBoard[UnitX][UnitY].getUnit().getBuyCost());
            player.addUnit(GameBoard.gameBoard[UnitX][UnitY].getUnit());
            GameBoard.gameBoard[producerX][producerY].getStructure().setUnitSpace(GameBoard.gameBoard[producerX][producerY].getStructure().getUnitSpace()-GameBoard.gameBoard[UnitX][UnitY].getUnit().getUnitSpace());
        }
        // move and add kingdom
        public boolean isThereUnit(int x, int y){
            return getTile(x,y).hasUnit();
        }
        public boolean isUnitMine(int x, int y,Player player){
            return getTile(x,y).getBlock().getOwner()==player.getPlayerNumber();
        }
    public void whereToMove(int UnitX,int UnitY,Player player){
        for(int i=1;i<19;i++){
            for(int j=1;j<19;j++){
                if(getTile(i,j).getBlock().getOwner()==player.getPlayerNumber()&&!GameBoard.gameBoard[i][j].hasStructure() && !GameBoard.gameBoard[i][j].hasUnit()){
                    GameBoard.gameBoard[i][j].setMovable(true);
                }
            }
        }
        int moveRange= GameBoard.gameBoard[UnitX][UnitY].getUnit().getMovementRange();
        for(int i=UnitX-moveRange;i<=UnitX+moveRange;i++){
            for(int j=UnitY-moveRange;j<=UnitY+moveRange;j++){
                if(0<=i && i<19 && 0<=j && j<19){
                    if(!GameBoard.gameBoard[i][j].hasStructure() && !GameBoard.gameBoard[i][j].hasUnit()){
                        GameBoard.gameBoard[i][j].setMovable(true);
                    }
                }



            }
        }
        GameBoard.gameBoard[UnitX][UnitY].setMovable(false);
    }
        public boolean canMoveTo(int x, int y){
            if(GameBoard.gameBoard[x][y].getMovable()){
                return true;
            }
            return false;
        }
        public boolean canMove(){
            int count=0;
            for(int i=1;i<=19;i++){
                for(int j=1;j<=19;j++){
                    if(GameBoard.gameBoard[i][j].getMovable()){
                        count++;
                    }
                }
            }
            if(count!=0){
                return true;
            }
            return false;
        }
        public void Move(int firstX,int firstY,int secondX,int secondY ,Player player ){
            GameBoard.gameBoard[secondX][secondY].setUnit(GameBoard.gameBoard[firstX][firstY].getUnit());
            GameBoard.gameBoard[firstX][firstY].setUnit(null);
            if(GameBoard.gameBoard[secondX][secondY].getBlock().getOwner()!=player.getPlayerNumber()){
                GameBoard.gameBoard[secondX][secondY].getBlock().setOwner(player.getPlayerNumber());
            }
            GameBoard.gameBoard[secondX][secondY].getUnit().setHasMoved(true);
        }





    //attack and die
    public boolean willSurviveUnit(int attackerX,int attackerY,int targetX,int targetY){
        return GameBoard.gameBoard[attackerX][attackerY].getUnit().getAttackPower()<GameBoard.gameBoard [targetX][targetY].getUnit().getHitPoint();
    }
    public void attackUnit(int attackerX,int attackerY,int targetX,int targetY){
        if(isForestBlock(attackerX,attackerY) && isForestBlock(targetX,targetY)){
            GameBoard.gameBoard[targetX][targetY].getUnit().setHitPoint(GameBoard.gameBoard[targetX][targetY].getUnit().getHitPoint()-GameBoard.gameBoard[attackerX][attackerY].getUnit().getAttackPower());
            GameBoard.gameBoard[targetX][targetY].getUnit().setHasAttacked(true);
        }
        if( !isForestBlock(attackerX,attackerY) && isForestBlock(targetX,targetY)){
            GameBoard.gameBoard[targetX][targetY].getUnit().setHitPoint(GameBoard.gameBoard[targetX][targetY].getUnit().getHitPoint()-GameBoard.gameBoard[attackerX][attackerY].getUnit().getAttackPower()+2);
            GameBoard.gameBoard[targetX][targetY].getUnit().setHasAttacked(true);
        }
        if(isForestBlock(attackerX,attackerY) && !isForestBlock(targetX,targetY)){
            GameBoard.gameBoard[targetX][targetY].getUnit().setHitPoint(GameBoard.gameBoard[targetX][targetY].getUnit().getHitPoint()-GameBoard.gameBoard[attackerX][attackerY].getUnit().getAttackPower()-2);
            GameBoard.gameBoard[targetX][targetY].getUnit().setHasAttacked(true);
        }
        if(!isForestBlock(attackerX,attackerY) && !isForestBlock(targetX,targetY)){
            GameBoard.gameBoard[targetX][targetY].getUnit().setHitPoint(GameBoard.gameBoard[targetX][targetY].getUnit().getHitPoint()-GameBoard.gameBoard[attackerX][attackerY].getUnit().getAttackPower());
            GameBoard.gameBoard[targetX][targetY].getUnit().setHasAttacked(true);
        }

    }
    public void dieUnit(int x,int y,int attackerX,int attackerY){
        int player=GameBoard.gameBoard[x][y].getBlock().getOwner();
        int producer=GameBoard.gameBoard[x][y].getUnit().getProducedBy();
        getPlayer(player).removeUnit(GameBoard.gameBoard[x][y].getUnit());
        for(int i=0; i<getPlayer(player).playerStructures.size();i++){
            if(getPlayer(player).getStructure(i).getProduceNum()==producer){
                getPlayer(player).getStructure(i).setUnitSpace(getPlayer(player).getStructure(i).getUnitSpace()+GameBoard.gameBoard[x][y].getUnit().getUnitSpace());
            }
        }
        GameBoard.gameBoard[x][y].setUnit(null);
        GameBoard.gameBoard[attackerX][attackerY].getUnit().setHasAttacked(true);
    }
    public void dieUnitNoAttacker(int x,int y){
        int player=GameBoard.gameBoard[x][y].getBlock().getOwner();
        int producer=GameBoard.gameBoard[x][y].getUnit().getProducedBy();
        getPlayer(player).removeUnit(GameBoard.gameBoard[x][y].getUnit());
        for(int i=0; i<getPlayer(player).playerStructures.size();i++){
            if(getPlayer(player).getStructure(i).getProduceNum()==producer){
                getPlayer(player).getStructure(i).setUnitSpace(getPlayer(player).getStructure(i).getUnitSpace()+GameBoard.gameBoard[x][y].getUnit().getUnitSpace());
            }
        }
        GameBoard.gameBoard[x][y].setUnit(null);
    }
    //game
    public boolean endGame(List<Player> players){
        int count=players.size();
        for(Player player : players){
            if(player.isDefeated()){
                count--;
            }
        }
        if(count==1){
            this.isGameOver=true;
        }
        return isGameOver;

    }
    public Player winner(List<Player> players){
        for(Player player : players){
            if(!player.isDefeated()){
                return player;
            }
        }
        return null;
    }
    public Player Loser(List<Player> players){
        for(Player player : players){
            if(player.isDefeated()){
                return player;
            }
        }
        return null;
    }
    //player
    public Player getPlayer(int playerNum){
        for(Player player : players){
            if(player.getPlayerNumber()==playerNum){
                return player;
            }
        }
        return null;
    }
    public Player whoseTurn(){
        return playerTurn.getCurrentPlayer();
    }
    public void player(List<Player> players){
        for(Player player : players){
            for(Structure1 structures: player.getPlayerStructures()){
                if(structures.getType().equals("TownHall")) {
                    player.setplayerGold(player.getPlayerGold()+structures.getGold());
                    player.setplayerFood(player.getPlayerFood()+structures.getFood());
                }
                if(structures.getType().equals("Market")) {
                    player.setplayerGold(player.getPlayerGold()+structures.getGold());
                }
                if(structures.getType().equals("Farm")) {
                    player.setplayerFood(player.getPlayerFood()+structures.getFood());
                }

            }
            for(int i=0; i<20;i++){
                for (int j=0; j<20; j++){
                    if(getTile(i,j).getBlock().getOwner()==player.getPlayerNumber()){
                        player.setplayerGold(player.getPlayerGold()+getTile(i,j).getBlock().getGold());
                        player.setplayerFood(player.getPlayerFood()+getTile(i,j).getBlock().getFood());
                    }
                }}
            for(Structure1 structures: player.getPlayerStructures()){
                if(structures.getMaintenanceCost()<=player.getPlayerGold()){
                    player.setplayerGold(player.playerGold- structures.getMaintenanceCost());
                    structures.setPaid(true);
                }
            }
            for(Unit1 units:player.getPlayerUnits()){
                if(units.getPayment()<=player.getPlayerGold()){
                    player.setplayerGold(player.playerGold- units.getPayment());
                    units.setPaid(true);
                }
                if(units.getRation()<=player.getPlayerFood()){
                    player.setplayerFood(player.playerFood- units.getRation());
                    units.setHaveEaten(true) ;
                }
            }

        }
    }
    public void refreshPlayer(List<Player> players){

        for(Player player : players){
            for(Structure1 structures: player.getPlayerStructures()){
                structures.setPaid(false);
            }
            for(Unit1 units: player.getPlayerUnits()){
                units.setPaid(false);
                units.setHaveEaten(false);
                units.setHasMoved(false);
                units.setHasAttacked(false);
            }
        }
    }
    public void check(List<Player> players){
        for(Player player : players){
            for(Structure1 structures: player.getPlayerStructures()){
                if(!structures.isPaidStructure()){
                    if(1<=structures.getHitPoint()){
                        structures.setHitPoint(structures.getHitPoint()-1);
                    }
                    else {
                        if(findStructureX(structures)!=-1&& findStructureY(structures)!=-1){
                            destroyStructureNoAttacker(findStructureX(structures),findStructureY(structures));
                        }
                    }
                }
            }
            for(Unit1 units: player.getPlayerUnits()){
                if(!units.isHaveEaten()){
                    if(1<=units.getHitPoint()){
                        units.setHitPoint(units.getHitPoint()-1);
                    }
                    else if(findUnitsX(units)!=-1&& findUnitsY(units)!=-1){
                        dieUnitNoAttacker(findUnitsX(units),findUnitsY(units));
                    }
                }
                if(!units.isPaid()){
                    if(1<=units.getHitPoint()){
                        units.setHitPoint(units.getHitPoint()-1);
                    }
                    else {
                        if(findUnitsX(units)!=-1&& findUnitsY(units)!=-1){
                            dieUnitNoAttacker(findUnitsX(units),findUnitsY(units));
                        }
                    }
                }
            }
        }
    }
}

