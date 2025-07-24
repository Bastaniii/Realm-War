package src.Game.src.main.java.org.example.Controllers;
import src.Game.src.main.java.org.example.Models.GameManager;
import src.Game.src.main.java.org.example.Models.Player;
import src.Game.src.main.java.org.example.Utils.Data;
import src.Game.src.main.java.org.example.Utils.GameLogger;
import src.Game.src.main.java.org.example.Views.ActionPanel;
import src.Game.src.main.java.org.example.Views.InfoPanel;
import src.Game.src.main.java.org.example.Views.StartPanel;
import src.Game.src.main.java.org.example.Views.GameView;
import src.Game.src.main.java.org.example.Views.GameBoardPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class GameController extends Container {
    ImageIcon ForestNoOwner= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/noOwner/ForestNoOwner.jpg")));
    ImageIcon EmptyNoOwner= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/noOwner/EmptyNoOwner.jpg")));
    ImageIcon Empty1nothing= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Empty1nothing.jpg")));
    ImageIcon Empty2nothing=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Empty2nothing.jpg")));
    ImageIcon Empty3nothing= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Empty3nothing.jpg")));
    ImageIcon Empty4nothing=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Empty4nothing.jpg")));
    ImageIcon Forest1nothing= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Forest1nothing.jpg")));
    ImageIcon Forest2nothing=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Forest2nothing.jpg")));
    ImageIcon Forest3nothing= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Forest3nothing.jpg")));
    ImageIcon Forest4nothing= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Forest4nothing.jpg")));
    ImageIcon Barrack1= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Barrack1.jpg")));
    ImageIcon Barrack2= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Barrack2.jpg")));
    ImageIcon Barrack3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Barrack3.jpg")));
    ImageIcon Barrack4= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Barrack4.jpg")));
    ImageIcon TownHall1= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/TownHall1.jpg")));
    ImageIcon TownHall2= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/TownHall2.jpg")));
    ImageIcon TownHall3= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/TownHall3.jpg")));
    ImageIcon TownHall4 =new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/TownHall4.jpg")));
    ImageIcon Tower1 =new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Tower1.jpg")));
    ImageIcon Tower2= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Tower2.jpg")));
    ImageIcon Tower3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Tower3.jpg")));
    ImageIcon Tower4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Tower4.jpg")));
    ImageIcon Farm1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Farm1.jpg")));
    ImageIcon Farm2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Farm2.jpg")));
    ImageIcon Farm3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Farm3.jpg")));
    ImageIcon Farm4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Farm4.jpg")));
    ImageIcon Market1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Market1.jpg")));
    ImageIcon Market2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Market2.jpg")));
    ImageIcon Market3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Market3.jpg")));
    ImageIcon Market4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Market4.jpg")));
    ImageIcon Peasant1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Peasant1.jpg")));
    ImageIcon Peasant2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Peasant2.jpg")));
    ImageIcon Peasant3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Peasant3.jpg")));
    ImageIcon Peasant4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Peasant4.jpg")));
    ImageIcon Spearman1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Spearman1.jpg")));
    ImageIcon Spearman2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Spearman2.jpg")));
    ImageIcon Spearman3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Spearman3.jpg")));
    ImageIcon Spearman4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Spearman4.jpg")));
    ImageIcon Swordman1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Swordman1.jpg")));
    ImageIcon Swordman2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Swordman2.jpg")));
    ImageIcon Swordman3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Swordman3.jpg")));
    ImageIcon Swordman4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Swordman4.jpg")));
    ImageIcon knight1=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Knight1.jpg")));
    ImageIcon knight2=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Knight2.jpg")));
    ImageIcon knight3=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Knight3.jpg")));
    ImageIcon knight4=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Knight4.jpg")));
    ImageIcon Peasant1Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Peasant1Forest.jpg")));
    ImageIcon Peasant2Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Peasant2Forest.jpg")));
    ImageIcon Peasant3Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Peasant3Forest.jpg")));
    ImageIcon Peasant4Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Peasant4Forest.jpg")));
    ImageIcon Spearman1Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Spearman1Forest.jpg")));
    ImageIcon Spearman2Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Spearman2Forest.jpg")));
    ImageIcon Spearman3Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Spearman3Forest.jpg")));
    ImageIcon Spearman4Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Spearman4Forest.jpg")));
    ImageIcon Swordman1Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Swordman1Forest.jpg")));
    ImageIcon Swordman2Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Swordman2Forest.jpg")));
    ImageIcon Swordman3Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Swordman3Forest.jpg")));
    ImageIcon Swordman4Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Swordman4Forest.jpg")));
    ImageIcon knight1Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player1/Knight1Forest.jpg")));
    ImageIcon knight2Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player2/Knight2Forest.jpg")));
    ImageIcon knight3Forest= new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player3/Knight3Forest.jpg")));
    ImageIcon knight4Forest=new ImageIcon(Objects.requireNonNull(getClass().getResource("/gameImage/player4/Knight4Forest.jpg")));

    //
    protected StartPanel start;
    protected GameBoardPanel board;
    protected GameView game;
    protected GameManager gameManager;
    protected ActionPanel actionPanel;
    protected InfoPanel infoPanel;
    protected JPanel rightPanel;
    //
    protected int players;
    protected boolean attackMode;
    protected int AttackerX;
    protected int AttackerY;
    protected int TargetX;
    protected int TargetY;
    protected boolean moveMode;
    protected int fromX;
    protected int fromY;
    protected int toX;
    protected int toY;
    protected boolean mergeMode;
    protected int firstX;
    protected int firstY;
    protected int secondX;
    protected int secondY;
    protected boolean buyUnitMode;
    protected int unitX;
    protected int unitY;
    public boolean buildStructureMode;
    protected int structureX;
    protected int structureY;
    protected boolean levelUpStructureMode;
    protected int levelUpX;
    protected int levelUpY;
    protected int newUnit;
    protected int newUnitX;
    protected int newUnitY;
    protected int producerX;
    protected int producerY;
    protected String newStructure;
    private Timer timer;
    private  int duration=40;
    private int timeLeft;
    protected int loser;
    protected int winner;
    protected boolean endGame;
    protected Data data;
    public GameController(){
        rightPanel=new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(300, 850));
        this.attackMode=false;
        this.AttackerX=-1;
        this.AttackerY=-1;
        this.TargetX=-1;
        this.TargetY=-1;
        this.moveMode=false;
        this.fromX=-1;
        this.fromY=-1;
        this.toX=-1;
        this.toY=-1;
        this.mergeMode=false;
        this.firstX=-1;
        this.firstY=-1;
        this.secondX=-1;
        this.secondY=-1;
        this.buyUnitMode=false;
        this.unitX=-1;
        this.unitY=-1;
        this.levelUpStructureMode=false;
        this.levelUpX=-1;
        this.levelUpY=-1;
        this.buildStructureMode=false;
        this.structureX=-1;
        this.structureY=-1;
        this.newUnit=-1;
        this.newStructure="";
        this.producerX=-1;
        this.producerY=-1;
        this.newUnitX=-1;
        this.newUnitY=-1;
        this.endGame=false;
        this.loser=-1;
        this.winner=-1;
        FirstUI();


    }
    public void StartTurn() {
        try {
            if (timer != null) {
                timer.stop();
                timer = null;
            }
            timeLeft=duration;
            infoPanel.update(gameManager.whoseTurn());
            GameLogger.log("Player " + gameManager.whoseTurn().getPlayerNumber() + "'s turn started.");
            timer=new Timer(1000,e ->  {
                timeLeft--;
                infoPanel.updateTimer(timeLeft);
                gameManager.getPlayerTurn().update();
                if(!gameManager.getPlayerTurn().getLosers().isEmpty()){
                    this.loser=gameManager.getPlayerTurn().Loser().getPlayerNumber();
                    GameLogger.log("Player " + loser + " has lost.");
                    JOptionPane.showMessageDialog(null,"Player "+loser+" has lost.","Warning",JOptionPane.WARNING_MESSAGE);
                    gameManager.getPlayerTurn().removeLoser(gameManager.getPlayerTurn().Loser());
                }
                if(gameManager.endGame(gameManager.getPlayers())){
                    this.endGame=true;
                    timer.stop();
                    this.winner=gameManager.winner(gameManager.getPlayers()).getPlayerNumber();
                    GameLogger.log("Player " + winner + " has won.");
                    JOptionPane.showMessageDialog(null,"Player "+winner+" has won.","Warning",JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null,"End Game","END",JOptionPane.INFORMATION_MESSAGE);
                    GameLogger.log("end game");


                    if (timer != null && timer.isRunning()) {
                        timer.stop();
                    }

                    game.remove(board);
                    game.remove(rightPanel);
                    disposeGame();
                    game.setContentPane(new StartPanel());
                    game.revalidate();
                    game.repaint();
                    return;
                }
                if(timeLeft<=0){
                    GameLogger.log("Player " + gameManager.whoseTurn().getPlayerNumber() + "'s turn timed out.");
                    endTurn();
                }
            });
            timer.start();
        }
        catch (Exception ex){
            GameLogger.log("Error while starting turn: "+ ex.getMessage());
        }

    }
    public void endTurn(){
        try{  if(timer!=null&& timer.isRunning()){
            timer.stop();
            GameLogger.log("Player " + gameManager.whoseTurn().getPlayerNumber() + " ended turn.");
        }
            gameManager.player(gameManager.getPlayers());
            gameManager.check(gameManager.getPlayers());
            gameManager.refreshPlayer(gameManager.getPlayers());
            gameManager.getPlayerTurn().nextTurn();
            StartTurn();

        }catch(Exception e){
            GameLogger.log("Error in endTurn "+ e.getMessage());
            JOptionPane.showMessageDialog(null,"Unexpected error in End Turn "+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    public void disposeGame() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        start=null;
        board = null;
        gameManager = null;
        actionPanel=null;
        infoPanel=null;
        rightPanel = null;
        ForestNoOwner = null;
        EmptyNoOwner = null;
        Empty1nothing = null;
        Empty2nothing = null;
        Empty3nothing = null;
        Empty4nothing = null;
        Forest1nothing = null;
        Forest2nothing = null;
        Forest3nothing = null;
        Forest4nothing = null;
        Barrack1 = null;
        Barrack2 = null;
        Barrack3 = null;
        Barrack4 = null;
        TownHall1 = null;
        TownHall2 = null;
        TownHall3 = null;
        TownHall4 = null;
        Tower1 = null;
        Tower2 = null;
        Tower3 = null;
        Tower4 = null;
        Farm1 = null;
        Farm2 = null;
        Farm3 = null;
        Farm4 = null;
        Market1 = null;
        Market2 = null;
        Market3 = null;
        Market4 = null;
        Peasant1 = null;
        Peasant2 = null;
        Peasant3 = null;
        Peasant4 = null;
        Spearman1 = null;
        Spearman2 = null;
        Spearman3 = null;
        Spearman4 = null;
        Swordman1 = null;
        Swordman2 = null;
        Swordman3 = null;
        Swordman4 = null;
        knight1 = null;
        knight2 = null;
        knight3 = null;
        knight4 = null;
        Peasant1Forest = null;
        Peasant2Forest = null;
        Peasant3Forest = null;
        Peasant4Forest = null;
        Spearman1Forest = null;
        Spearman2Forest = null;
        Spearman3Forest = null;
        Spearman4Forest = null;
        Swordman1Forest = null;
        Swordman2Forest = null;
        Swordman3Forest = null;
        Swordman4Forest = null;
        knight1Forest = null;
        knight2Forest = null;
        knight3Forest = null;
        knight4Forest = null;
        System.gc();
        GameLogger.log("GameController resources disposed.");
    }
    private void FirstUI(){
        game=new GameView();
        start = new StartPanel();
        start.getButton1Start().addActionListener(e ->  button1());
        start.getButton2Start().addActionListener(e -> button2());
        start.getButton3Start().addActionListener(e -> button3());
        game.setContentPane(start);
        game.revalidate();
        game.repaint();
    }
    public void firstButtons(){
        gameManager=new GameManager(players);
        board=new GameBoardPanel();
        addBoard();
        updateBoard(board,gameManager);
        actionPanel=new ActionPanel();
        actionPanel.getAttack().addActionListener(e -> attack());
        actionPanel.getMove().addActionListener(e -> move());
        actionPanel.getBuildStructure().addActionListener(e -> buildNewStructure());
        actionPanel.getLevelUpStructure().addActionListener(e -> levelUp());
        actionPanel.getMerge().addActionListener(e -> merge());
        actionPanel.getBuildStructure().addActionListener(e -> buildNewStructure());
        actionPanel.getBuyUnit().addActionListener( buyNewUnit());
        actionPanel.getEndTurn().addActionListener(e ->  endTurn());
        actionPanel.getSave().addActionListener(e -> {
            try {
                saveData();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        infoPanel=new InfoPanel();
        infoPanel.update(gameManager.whoseTurn());
        SwingUtilities.invokeLater(this::StartTurn);
        rightPanel.add(infoPanel);
        rightPanel.add(actionPanel);
        start.getStart().dispose();
        secondUI();
    }
    public boolean isValid(int a){
        if(0<=a && a<20){
            return true;
        }
        return false;
    }
    public void refresh(){
        gameManager.setAllAttackable();
        gameManager.setAllMovable();
        gameManager.setAllPlaceUnit();
        gameManager.setAllCanMakeStructure();
        gameManager.setAllVCanLevelUpStructure();
        game.revalidate();
        game.repaint();
        this.attackMode=false;
        this.AttackerX=-1;
        this.AttackerY=-1;
        this.TargetX=-1;
        this.TargetY=-1;
        this.moveMode=false;
        this.fromX=-1;
        this.fromY=-1;
        this.toX=-1;
        this.toY=-1;
        this.mergeMode=false;
        this.firstX=-1;
        this.firstY=-1;
        this.secondX=-1;
        this.secondY=-1;
        this.buyUnitMode=false;
        this.unitX=-1;
        this.unitY=-1;
        this.levelUpStructureMode=false;
        this.levelUpX=-1;
        this.levelUpY=-1;
        this.buildStructureMode=false;
        this.structureX=-1;
        this.structureY=-1;
        this.newUnit=-1;
        this.newStructure=null;
        this.producerX=-1;
        this.producerY=-1;
        this.newUnitX=-1;
        this.newUnitY=-1;
        actionPanel.getStructureSelector().setSelectedStructureType(null);
        actionPanel.getUnitSelector().resetSelectedUnitId(-1);
    }
    public void button1(){
        this.players=2;
        firstButtons();
    }
    public void button2(){
        this.players=3;
        firstButtons();
    }
    public void button3(){
        this.players=4;
        firstButtons();
    }
    private void secondUI(){
        game.getContentPane().removeAll();
        game.setLayout(new BorderLayout(0,0));
        game.add(board,BorderLayout.CENTER);
        game.add(rightPanel,BorderLayout.EAST);
        game.revalidate();
        game.repaint();

    }
    public void updateBoard(GameBoardPanel board, GameManager gameManager){
        try{
            for(int i=0; i<20; i++){
                for(int j=0; j<20; j++){
                    if(gameManager.getTile(i,j).getBlock().getOwner()==1){
                        if(gameManager.getTile(i,j).hasStructure()){
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Barrack")){
                                board.getButton(i,j).setIcon(Barrack1);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Farm")){
                                board.getButton(i,j).setIcon(Farm1);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Market")){
                                board.getButton(i,j).setIcon(Market1);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Tower")){
                                board.getButton(i,j).setIcon(Tower1);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("TownHall")){
                                board.getButton(i,j).setIcon(TownHall1);
                            }
                        }
                        else{
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getlevel()==1){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Peasant1Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Peasant1);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==2){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Spearman1Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Spearman1);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==3){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Swordman1Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Swordman1);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==4){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(knight1Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(knight1);
                                    }
                                }
                            }
                            else{
                                if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                    board.getButton(i,j).setIcon(Forest1nothing);
                                }
                                else{
                                    board.getButton(i,j).setIcon(Empty1nothing);
                                }

                            }
                        }
                    }
                    else if(gameManager.getTile(i,j).getBlock().getOwner()==2){
                        if(gameManager.getTile(i,j).hasStructure()){
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Barrack")){
                                board.getButton(i,j).setIcon(Barrack2);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Farm")){
                                board.getButton(i,j).setIcon(Farm2);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Market")){
                                board.getButton(i,j).setIcon(Market2);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Tower")){
                                board.getButton(i,j).setIcon(Tower2);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("TownHall")){
                                board.getButton(i,j).setIcon(TownHall2);
                            }
                        }
                        else{
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getlevel()==1){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Peasant2Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Peasant2);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==2){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Spearman2Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Spearman2);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==3){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Swordman2Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Swordman2);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==4){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(knight2Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(knight2);
                                    }
                                }
                            }
                            else{
                                if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                    board.getButton(i,j).setIcon(Forest2nothing);
                                }
                                else{
                                    board.getButton(i,j).setIcon(Empty2nothing);
                                }

                            }
                        }
                    }
                    else if(gameManager.getTile(i,j).getBlock().getOwner()==3){
                        if(gameManager.getTile(i,j).hasStructure()){
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Barrack")){
                                board.getButton(i,j).setIcon(Barrack3);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Farm")){
                                board.getButton(i,j).setIcon(Farm3);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Market")){
                                board.getButton(i,j).setIcon(Market3);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Tower")){
                                board.getButton(i,j).setIcon(Tower3);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("TownHall")){
                                board.getButton(i,j).setIcon(TownHall3);
                            }
                        }
                        else{
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getlevel()==1){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Peasant3Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Peasant3);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==2){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Spearman3Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Spearman3);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==3){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Swordman3Forest); }
                                    else {
                                        board.getButton(i,j).setIcon(Swordman3);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==4){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(knight3Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(knight3);
                                    }
                                }
                            }
                            else{
                                if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                    board.getButton(i,j).setIcon(Forest3nothing);
                                }
                                else{
                                    board.getButton(i,j).setIcon(Empty3nothing);
                                }

                            }
                        }
                    }
                    else if(gameManager.getTile(i,j).getBlock().getOwner()==4){
                        if(gameManager.getTile(i,j).hasStructure()){
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Barrack")){
                                board.getButton(i,j).setIcon(Barrack4);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Farm")){
                                board.getButton(i,j).setIcon(Farm4);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Market")){
                                board.getButton(i,j).setIcon(Market4);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("Tower")){
                                board.getButton(i,j).setIcon(Tower4);
                            }
                            if(gameManager.getTile(i,j).getStructure().getType().equals("TownHall")){
                                board.getButton(i,j).setIcon(TownHall4);
                            }
                        }
                        else{
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getlevel()==1){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Peasant4Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Peasant4);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==2){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Spearman4Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Spearman4);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==3){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(Swordman4Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(Swordman4);
                                    }
                                }
                                if(gameManager.getTile(i,j).getUnit().getlevel()==4){
                                    if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                        board.getButton(i,j).setIcon(knight4Forest);
                                    }
                                    else {
                                        board.getButton(i,j).setIcon(knight4);
                                    }
                                }
                            }
                            else{
                                if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                                    board.getButton(i,j).setIcon(Forest4nothing);
                                }
                                else{
                                    board.getButton(i,j).setIcon(Empty4nothing);
                                }

                            }
                        }
                    }
                    else if(gameManager.getTile(i,j).getBlock().getOwner()==0){
                        if(gameManager.getTile(i,j).getBlock().getType().equals("Void")){
                            board.getButton(i,j).setBackground(Color.BLACK);
                        }
                        if(gameManager.getTile(i,j).getBlock().getType().equals("Empty")){
                            board.getButton(i,j).setIcon(EmptyNoOwner);
                        }
                        else if(gameManager.getTile(i,j).getBlock().getType().equals("Forest")){
                            board.getButton(i,j).setIcon(ForestNoOwner);
                        }
                    }
                }
            }
            GameLogger.log("Board updated for Player " + gameManager.whoseTurn().getPlayerNumber());
        }
        catch (Exception e){
            GameLogger.log("Error in updateBoard "+ e.getMessage());
        }

    }
    public void attack(){
        refresh();
        this.attackMode=true;
    }
    public void move(){
        refresh();
        this.moveMode=true;
    }
    public void merge(){
        refresh();
        this.mergeMode=true;
    }
    public void levelUp(){
        refresh();
        this.levelUpStructureMode=true;
    }
    private ActionListener buyNewUnit(){// change
        return e -> {
            refresh();
            this.buyUnitMode=true;


        };
    }
    public void buildNewStructure(){// change
        refresh();
        this.newStructure=null;

        this.buildStructureMode=true;

    }

    private void addBoard(){
        for(int i=0; i<20;i++){
            for(int j=0; j<20; j++){
                board.getButton(i,j).addActionListener(boardAction());
            }
        }
    }
    private ActionListener boardAction(){
        return e -> {
            try{
                JButton click=(JButton)e.getSource();
                int i=(int)click.getClientProperty("i");
                int j=(int)click.getClientProperty("j");
                if(isValid(i) && isValid(j)){
                    GameLogger.log("Invalid click on tile (" + i + "," + j + ")");
                    if(attackMode){
                        if(AttackerX==-1 && AttackerY==-1){
                            if(!gameManager.getTile(i,j).getUnit().isHasAttacked()){
                                gameManager.showAttackablePlace(gameManager.whoseTurn(),i,j);
                                if(gameManager.canAttack()){
                                    AttackerX=i;
                                    AttackerY=j;
                                    GameLogger.log("Player selected attacker at (" + i + "," + j + ")");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"You're not able to attack!","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"This unit has already attacked","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }

                        }
                        else if(AttackerX!=-1 && AttackerY!=-1){
                            if(gameManager.canAttackThis(i,j)){
                                TargetX=i;
                                TargetY=j;
                                if(gameManager.getTile(i,j).hasStructure()){
                                    if(gameManager.willSurviveStructure(AttackerX,AttackerY,TargetX,TargetY)){
                                        gameManager.attackStructure(AttackerX,AttackerY,TargetX,TargetY);
                                        JOptionPane.showMessageDialog(null,"You attacked!","Warning",JOptionPane.WARNING_MESSAGE);
                                        GameLogger.log("Player attempting attack from (" + AttackerX + "," + AttackerY + ") to a structure (" + i + "," + j + ")");
                                        refresh();
                                    }
                                    else{
                                        gameManager.destroyStructure(TargetX,TargetY,AttackerX,AttackerY);
                                        updateBoard(board, gameManager);
                                        GameLogger.log("Player destroyed a structure (" + TargetX + "," + TargetY + ")");
                                        refresh();

                                    }

                                }
                                else if(gameManager.getTile(i,j).hasUnit()){
                                    if(gameManager.willSurviveUnit(AttackerX,AttackerY,TargetX,TargetY)){
                                        gameManager.attackUnit(AttackerX,AttackerY,TargetX,TargetY);
                                        JOptionPane.showMessageDialog(null,"You attacked!","Warning",JOptionPane.WARNING_MESSAGE);
                                        GameLogger.log("Player attempting attack from (" + AttackerX + "," + AttackerY + ") to a unit (" + i + "," + j + ")");
                                        refresh();
                                    }
                                    else{
                                        gameManager.dieUnit(TargetX,TargetY,AttackerX,AttackerY);
                                        updateBoard(board, gameManager);
                                        GameLogger.log("Player killed a unit (" + TargetX + "," + TargetY + ")");//
                                        refresh();
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"You're not able to attack this block! Try again.","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }
                        }
                    }
                    else if(mergeMode){
                        if(firstX==-1 && firstY==-1){
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getOwner()==gameManager.whoseTurn().getPlayerNumber()){
                                    if(gameManager.getTile(i,j).getUnit().getlevel()<4){
                                        firstX=i;
                                        firstY=j;
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"This unit has the max level.","Warning",JOptionPane.WARNING_MESSAGE);
                                        refresh();
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"It's not your Unit","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"There's no unit here!","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }
                        }
                        else if(firstX!=-1 && firstY!=-1){
                            if(gameManager.getTile(i,j).hasUnit()){
                                if(gameManager.getTile(i,j).getUnit().getOwner()==gameManager.whoseTurn().getPlayerNumber()){
                                    if(gameManager.getTile(i,j).getUnit().getlevel()<4){
                                        if(gameManager.CanMerge(gameManager.whoseTurn(),firstX,firstY,i,j)){
                                            secondX=i;
                                            secondY=j;
                                            gameManager.merge(gameManager.whoseTurn(),firstX,firstY,secondX,secondY);
                                            updateBoard(board, gameManager);
                                            JOptionPane.showMessageDialog(null, "Units merged successfully!", "Merge", JOptionPane.INFORMATION_MESSAGE);
                                            GameLogger.log("Player attempting merge firs unit ("+firstX+","+firstY+")with second unit at (" + i + "," + j + ")");
                                            refresh();
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"You can't merge these units! try again.","Warning",JOptionPane.WARNING_MESSAGE);
                                            refresh();
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"This unit has the max level.","Warning",JOptionPane.WARNING_MESSAGE);
                                        refresh();
                                    }
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"It's not your Unit","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"There's no unit here!","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }

                        }
                    }
                    else if(moveMode){
                        if(fromX==-1 && fromY==-1){
                            if(gameManager.isThereUnit(i,j)){
                                if(!gameManager.getTile(i,j).getUnit().isHasMoved()){
                                    if(gameManager.isUnitMine(i,j,gameManager.whoseTurn())){
                                        gameManager.whereToMove(i,j,gameManager.whoseTurn());
                                        if(gameManager.canMove()){
                                            fromX=i;
                                            fromY=j;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"You're not able to move!","Warning",JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"It's not your Unit","Warning",JOptionPane.WARNING_MESSAGE);
                                    }

                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"This unit has already moved.","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }

                            }
                            else{
                                JOptionPane.showMessageDialog(null,"There's no unit!","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();//
                            }

                        }
                        else if(fromX!=-1 && fromY!=-1){
                            if(gameManager.canMoveTo(i,j)){
                                toX=i;
                                toY=j;
                                gameManager.Move(fromX,fromY,toX, toY, gameManager.whoseTurn());
                                updateBoard(board, gameManager);
                                GameLogger.log("Player attempting move from (" + fromX + "," + fromY + ") to (" + i + "," + j + ")");
                                refresh();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"You're not able to go there!","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }
                        }
                    }
                    else if(buyUnitMode){
                        this.newUnit=actionPanel.getUnitSelector().getSelectedUnitId();//
                        if(this.newUnit!=-1){
                            if(producerX==-1 && producerY==-1){
                                if(gameManager.getTile(i,j).hasStructure()){
                                    if(gameManager.canAffordBuyingUnit(gameManager.whoseTurn(),newUnit)){
                                        if(gameManager.canBuyFrom(i,j,newUnit)){
                                            producerX=i;
                                            producerY=j;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"You can't buy unit from here!","Warning",JOptionPane.WARNING_MESSAGE);
                                            refresh();
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"You don't have enough gold!","Warning",JOptionPane.WARNING_MESSAGE);
                                        refresh();//
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"There's no producer here.","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }

                            }
                            else if(producerX!=-1 && producerY!=-1){
                                gameManager.whereToPlace(gameManager.whoseTurn());
                                if(gameManager.canPlaceUnit()){
                                    if(gameManager.canPlaceUnitThere(i,j)){
                                        newUnitX=i;
                                        newUnitY=j;
                                        gameManager.buyUnit(newUnit,gameManager.whoseTurn(),newUnitX,newUnitY,producerX,producerY);
                                        updateBoard(board, gameManager);
                                        GameLogger.log("Player has bought a unit with level"+newUnit+"(" + i + "," + j + ") from (" + producerX + "," + producerY + ")" );
                                        refresh();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"You can't place unit here!","Warning",JOptionPane.WARNING_MESSAGE);
                                        refresh();
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"You can't place a new unit!","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Choose unit!","Warning",JOptionPane.WARNING_MESSAGE);
                            refresh();
                        }

                    }
                    else if(buildStructureMode){
                        this.newStructure=actionPanel.StructureName();//
                        if(this.newStructure!=null){
                            if(!gameManager.HasMaxAmount(gameManager.whoseTurn(),newStructure)){
                                if(gameManager.canAffordBuilding(newStructure,gameManager.whoseTurn())){
                                    gameManager.whereToBuildStructure(gameManager.whoseTurn(),newStructure);
                                    if(gameManager.canBuild(gameManager.whoseTurn())){
                                        if(gameManager.canBuildHere(i,j)){
                                            gameManager.buildStructure(i,j,gameManager.whoseTurn(),newStructure);
                                            updateBoard(board, gameManager);
                                            GameLogger.log("Player attempting to build " + newStructure + " at (" + i + "," + j + ")");
                                            refresh();
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null,"You can't build here!","Warning",JOptionPane.WARNING_MESSAGE);
                                            refresh();
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null,"You can't build this structure!","Warning",JOptionPane.WARNING_MESSAGE);
                                        refresh();
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"You don't have enough gold!","Warning",JOptionPane.WARNING_MESSAGE);
                                    refresh();
                                }

                            }
                            else{
                                JOptionPane.showMessageDialog(null,"You already have the max amount","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Choose structure!!","Warning",JOptionPane.WARNING_MESSAGE);
                            refresh();
                        }


                    }
                    else if(levelUpStructureMode){
                        gameManager.whichToLevelUpStructure(gameManager.whoseTurn());
                        if(gameManager.canLevelUpStructure(gameManager.whoseTurn())){
                            if(gameManager.canLevelUpThis(i,j)){
                                gameManager.levelUpStructure(i,j);
                                JOptionPane.showMessageDialog(null,"Level up successful!","Success",JOptionPane.INFORMATION_MESSAGE);
                                GameLogger.log("Player attempting to level up structure at (" + i + "," + j + ")");
                                refresh();
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"You can't level up this Structure!","Warning",JOptionPane.WARNING_MESSAGE);
                                refresh();
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"You can't level up any Structure.","Warning",JOptionPane.WARNING_MESSAGE);
                            refresh();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You haven't enabled any Action!","Warning",JOptionPane.WARNING_MESSAGE);
                        refresh();
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "Not valid input", "Error", JOptionPane.ERROR_MESSAGE);
                    refresh();
                }
            }
            catch (Exception ex){
                GameLogger.log("Unexpected error in boardAction: "+ ex.getMessage());
                JOptionPane.showMessageDialog(null,"Unexpected error in action"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                refresh();
            }


        };
    }
    public void saveData() throws SQLException, ClassNotFoundException {
        data=new Data();
        data.createBlockTable();
        data.createUnitTable();
        data.createStructureTable();
        data.createGameTable();
        data.createPlayerTable();
        data.insertGame(gameManager.getPlayerTurn().getCurrentPlayerIndex(),players,timeLeft);
        for(Player player: gameManager.getPlayers()){
            data.insertPlayer(players,player.getPlayerGold(),player.getPlayerFood(),player.isDefeated(),player.getBarrackBuildingCost(),player.getFarmBuildingCost(),player.getMarketBuildingCost() ,player.getTowerBuildingCost());
        }

        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                data.insertBlock(i,j,gameManager.getTile(i,j).getBlock().getType(),gameManager.getTile(i,j).getBlock().getOwner());
                if(gameManager.getTile(i,j).hasStructure()){
                    data.insertStructure(i,j,gameManager.getTile(i,j).getStructure().getType() ,gameManager.getTile(i,j).getStructure().getowner(),gameManager.getTile(i,j).getStructure().getHitPoint(),gameManager.getTile(i,j).getStructure().getLevel(),gameManager.getTile(i,j).getStructure().getBuildingCost(),gameManager.getTile(i,j).getStructure().getMaintenanceCost() , gameManager.getTile(i,j).getStructure().getLevelUpCost(),
                            gameManager.getTile(i,j).getStructure().getUnitSpace(),gameManager.getTile(i,j).getStructure().getDefenceRange(),gameManager.getTile(i,j).getStructure().getProduceNum() ,gameManager.getTile(i,j).getStructure().isPaidStructure());
                }
                if(gameManager.getTile(i,j).hasUnit()){
                    data.insertUnit(i,j,gameManager.getTile(i,j).getUnit().getlevel(),gameManager.getTile(i,j).getUnit().getOwner(),
                            gameManager.getTile(i,j).getUnit().getHitPoint(),gameManager.getTile(i,j).getUnit().getProducedBy(),
                            gameManager.getTile(i,j).getUnit().getHasSpace(),gameManager.getTile(i,j).getUnit().isHaveEaten(),
                            gameManager.getTile(i,j).getUnit().isPaid(),gameManager.getTile(i,j).getUnit().isHasAttacked(),
                            gameManager.getTile(i,j).getUnit().isHasMoved());
                }
            }
        }
        this.endGame=true;
        timer.stop();
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        game.remove(board);
        game.remove(rightPanel);
        disposeGame();
        game.setContentPane(new StartPanel());
        game.revalidate();
        game.repaint();
        GameLogger.log("Game saved");
    }
}