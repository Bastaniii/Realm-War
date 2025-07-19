package src.Game.src.main.java.org.example.Controllers;
import src.Game.src.main.java.org.example.Models.GameManager;
import src.Game.src.main.java.org.example.Utils.GameLogger;
import src.Game.src.main.java.org.example.Views.ActionPanel;
import src.Game.src.main.java.org.example.Views.InfoPanel;
import src.Game.src.main.java.org.example.Views.StartPanel;
import src.Game.src.main.java.org.example.Views.GameView;
import src.Game.src.main.java.org.example.Views.GameBoardPanel;
import javax.swing.*;
import java.awt.*;
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
    private int timeLeft= duration;
    protected int loser;
    protected int winner;
    protected boolean endGame;

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
            gameManager.refreshPlayer(gameManager.getPlayers());
            gameManager.player(gameManager.getPlayers());
            gameManager.check(gameManager.getPlayers());
            gameManager.getPlayerTurn().update();
            if(!gameManager.getPlayerTurn().getLosers().isEmpty()){
                this.loser=gameManager.getPlayerTurn().Loser().getPlayerNumber();
                GameLogger.log("Player " + loser + " has lost.");
                JOptionPane.showMessageDialog(null,"Player "+loser+" has lost.","Warning",JOptionPane.WARNING_MESSAGE);
                gameManager.getPlayerTurn().removeLoser(gameManager.getPlayerTurn().Loser());
            }
            if(gameManager.endGame(gameManager.getPlayers())){
                this.endGame=true;
                this.winner=gameManager.winner(gameManager.getPlayers()).getPlayerNumber();
                GameLogger.log("Player " + winner + " has won.");
                JOptionPane.showMessageDialog(null,"Player "+winner+" has won.","Warning",JOptionPane.WARNING_MESSAGE);
                FirstUI();
            }
            if(!endGame){
                gameManager.getPlayerTurn().nextTurn();
                StartTurn();
            }
        }catch(Exception e){
            GameLogger.log("Error in endTurn "+ e.getMessage());
            JOptionPane.showMessageDialog(null,"Unexpected error in End Turn "+ e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }


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
        actionPanel.getBarrack().addActionListener(e -> barrackButton());
        actionPanel.getFarm().addActionListener(e -> farmButton());
        actionPanel.getMarket().addActionListener(e -> marketButton());
        actionPanel.getTower().addActionListener(e -> towerButton());
        actionPanel.getPeasant().addActionListener(e -> peasantButton());
        actionPanel.getSpearman().addActionListener(e -> spearmanButton());
        actionPanel.getSwordman().addActionListener(e -> swordmanButton());
        actionPanel.getKnight().addActionListener(e -> knightButton());
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
        this.newStructure="";
        this.producerX=-1;
        this.producerY=-1;
        this.newUnitX=-1;
        this.newUnitY=-1;
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
}