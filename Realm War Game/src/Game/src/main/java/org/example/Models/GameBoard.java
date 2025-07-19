package src.Game.src.main.java.org.example.Models;

import src.Game.src.main.java.org.example.Models.Block.EmptyBlock;
import src.Game.src.main.java.org.example.Models.Block.ForestBlock;
import src.Game.src.main.java.org.example.Models.Block.VoidBlock;
import src.Game.src.main.java.org.example.Models.Structures.TownHall;
import src.Game.src.main.java.org.example.Models.units.Peasant;

public class GameBoard {
    protected int numberOfPlayers;
    protected Tile[][] gameBoard;
    public GameBoard(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        gameBoard = new Tile[20][20];
        //void
        for (int i = 0; i < 20; i++) {
            gameBoard[i][0] = new Tile(new VoidBlock());
            gameBoard[i][19] = new Tile(new VoidBlock());
        }
        for (int j = 1; j < 19; j++) {
            gameBoard[0][j] = new Tile(new VoidBlock());
            gameBoard[19][j] = new Tile(new VoidBlock());
        }
        //forest
        gameBoard[1][5] = new Tile(new ForestBlock());
        gameBoard[1][14] = new Tile(new ForestBlock());
        gameBoard[2][7] = new Tile(new ForestBlock());
        gameBoard[2][12] = new Tile(new ForestBlock());
        gameBoard[3][5] = new Tile(new ForestBlock());
        gameBoard[3][9] = new Tile(new ForestBlock());
        gameBoard[3][10] = new Tile(new ForestBlock());
        gameBoard[3][14] = new Tile(new ForestBlock());
        gameBoard[4][7] = new Tile(new ForestBlock());
        gameBoard[4][12] = new Tile(new ForestBlock());
        gameBoard[6][3] = new Tile(new ForestBlock());
        gameBoard[6][5] = new Tile(new ForestBlock());
        gameBoard[6][9] = new Tile(new ForestBlock());
        gameBoard[6][10] = new Tile(new ForestBlock());
        gameBoard[6][14] = new Tile(new ForestBlock());
        gameBoard[6][16] = new Tile(new ForestBlock());
        gameBoard[7][8] = new Tile(new ForestBlock());
        gameBoard[7][11] = new Tile(new ForestBlock());
        gameBoard[8][3] = new Tile(new ForestBlock());
        gameBoard[8][6] = new Tile(new ForestBlock());
        gameBoard[8][7] = new Tile(new ForestBlock());
        gameBoard[8][8] = new Tile(new ForestBlock());
        gameBoard[8][9] = new Tile(new ForestBlock());
        gameBoard[8][10] = new Tile(new ForestBlock());
        gameBoard[8][11] = new Tile(new ForestBlock());
        gameBoard[8][12] = new Tile(new ForestBlock());
        gameBoard[8][13] = new Tile(new ForestBlock());
        gameBoard[8][16] = new Tile(new ForestBlock());
        gameBoard[9][1] = new Tile(new ForestBlock());
        gameBoard[9][2] = new Tile(new ForestBlock());
        gameBoard[9][6] = new Tile(new ForestBlock());
        gameBoard[9][7] = new Tile(new ForestBlock());
        gameBoard[9][8] = new Tile(new ForestBlock());
        gameBoard[9][9] = new Tile(new ForestBlock());
        gameBoard[9][10] = new Tile(new ForestBlock());
        gameBoard[9][11] = new Tile(new ForestBlock());
        gameBoard[9][12] = new Tile(new ForestBlock());
        gameBoard[9][13] = new Tile(new ForestBlock());
        gameBoard[9][17] = new Tile(new ForestBlock());
        gameBoard[9][18] = new Tile(new ForestBlock());
        gameBoard[10][1] = new Tile(new ForestBlock());
        gameBoard[10][2] = new Tile(new ForestBlock());
        gameBoard[10][6] = new Tile(new ForestBlock());
        gameBoard[10][7] = new Tile(new ForestBlock());
        gameBoard[10][8] = new Tile(new ForestBlock());
        gameBoard[10][9] = new Tile(new ForestBlock());
        gameBoard[10][10] = new Tile(new ForestBlock());
        gameBoard[10][11] = new Tile(new ForestBlock());
        gameBoard[10][12] = new Tile(new ForestBlock());
        gameBoard[10][13] = new Tile(new ForestBlock());
        gameBoard[10][17] = new Tile(new ForestBlock());
        gameBoard[10][18] = new Tile(new ForestBlock());
        gameBoard[11][3] = new Tile(new ForestBlock());
        gameBoard[11][6] = new Tile(new ForestBlock());
        gameBoard[11][7] = new Tile(new ForestBlock());
        gameBoard[11][8] = new Tile(new ForestBlock());
        gameBoard[11][9] = new Tile(new ForestBlock());
        gameBoard[11][10] = new Tile(new ForestBlock());
        gameBoard[11][11] = new Tile(new ForestBlock());
        gameBoard[11][12] = new Tile(new ForestBlock());
        gameBoard[11][13] = new Tile(new ForestBlock());
        gameBoard[11][16] = new Tile(new ForestBlock());
        gameBoard[12][8] = new Tile(new ForestBlock());
        gameBoard[12][11] = new Tile(new ForestBlock());
        gameBoard[13][3] = new Tile(new ForestBlock());
        gameBoard[13][5] = new Tile(new ForestBlock());
        gameBoard[13][9] = new Tile(new ForestBlock());
        gameBoard[13][10] = new Tile(new ForestBlock());
        gameBoard[13][14] = new Tile(new ForestBlock());
        gameBoard[13][16] = new Tile(new ForestBlock());
        gameBoard[15][7] = new Tile(new ForestBlock());
        gameBoard[15][12] = new Tile(new ForestBlock());
        gameBoard[16][5] = new Tile(new ForestBlock());
        gameBoard[16][9] = new Tile(new ForestBlock());
        gameBoard[16][10] = new Tile(new ForestBlock());
        gameBoard[16][14] = new Tile(new ForestBlock());
        gameBoard[17][7] = new Tile(new ForestBlock());
        gameBoard[17][12] = new Tile(new ForestBlock());
        gameBoard[18][5] = new Tile(new ForestBlock());
        gameBoard[18][14] = new Tile(new ForestBlock());
        //empty
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (gameBoard[i][j] == null) {
                    gameBoard[i][j] = new Tile(new EmptyBlock());
                }
            }
        }
        //playerKingdom
        //player1
        for (int i = 1; i <4; i++) {
            for (int j = 16; j < 19; j++) {
                gameBoard[i][j].getBlock().setOwner(1);
            }
        }
        gameBoard[1][18].setStructure(new TownHall(1));
        gameBoard[3][16].setUnit(new Peasant(1, 1));
        //player2
        for (int i = 16; i < 19; i++) {
            for (int j = 1; j < 4; j++) {
                gameBoard[i][j].getBlock().setOwner(2);
            }
        }
        gameBoard[18][1].setStructure(new TownHall(2));
        gameBoard[16][3].setUnit(new Peasant(2, 1));
        //player3
        if (numberOfPlayers >= 3) {
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    gameBoard[i][j].getBlock().setOwner(3);
                }
            }
            gameBoard[1][1].setStructure(new TownHall(3));
            gameBoard[3][3].setUnit(new Peasant(3, 1));
        }
        //player4
        if (numberOfPlayers == 4) {
            for (int i = 16; i < 19; i++) {
                for (int j = 16; j < 19; j++) {
                    gameBoard[i][j].getBlock().setOwner(4);
                }
            }
            gameBoard[18][18].setStructure(new TownHall(4));
            gameBoard[16][16].setUnit(new Peasant(3, 1));

        }


    }
}
