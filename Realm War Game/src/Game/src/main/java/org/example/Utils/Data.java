package src.Game.src.main.java.org.example.Utils;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {
    private Connection conn;

    public Data() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/ gameWar";
        String user = "postgres";
        String password = "Yjw83beoxW2";
        conn = DriverManager.getConnection(url, user, password);
    }
    public void createBlockTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS blocks (" +
                "id SERIAL PRIMARY KEY, " +
                "i INT, " +
                "j INT, " +
                "type VARCHAR(50) NOT NULL, " +
                "owner INT" +
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }

    public void insertBlock(int i, int j, String type, int owner) throws SQLException {
        String sql = "INSERT INTO blocks (i, j, type, owner) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, i);
        pstmt.setInt(2, j);
        pstmt.setString(3, type);
        pstmt.setInt(4, owner);
        pstmt.executeUpdate();
        pstmt.close();
    }
    public void readBlocks() throws SQLException {
        String sql = "SELECT * FROM blocks";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            int id = rs.getInt("id");
            int i = rs.getInt("i");
            int j = rs.getInt("j");
            String type = rs.getString("type");
            int owner = rs.getInt("owner");

            System.out.println("Block id: " + id + ", i: " + i + ", j: " + j + ", type: " + type + ", owner: " + owner);
        }

        rs.close();
        stmt.close();
    }

    public void createPlayerTable() throws SQLException {
        String player = "CREATE TABLE IF NOT EXISTS players (" +
                "id SERIAL PRIMARY KEY, " +
                "playerNumber INT, " +
                "gold INT," +
                "food INT,"+
                "isDefeated BOOLEAN," +
                "barrackBuildingCost INT,"+
                "farmBuildingCost INT,"+
                "marketBuildingCost INT,"+
                "towerBuildingCost INT"+
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(player);
        stmt.close();
    }
    public void insertPlayer(int playerNumber, int gold, int food, boolean isDefeated,
                             int barrackCost, int farmCost, int marketCost, int towerCost) throws SQLException {

        String sql = "INSERT INTO players " +
                "(playerNumber, gold, food, isDefeated, barrackBuildingCost, farmBuildingCost, marketBuildingCost, towerBuildingCost) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, playerNumber);
        pstmt.setInt(2, gold);
        pstmt.setInt(3, food);
        pstmt.setBoolean(4, isDefeated);
        pstmt.setInt(5, barrackCost);
        pstmt.setInt(6, farmCost);
        pstmt.setInt(7, marketCost);
        pstmt.setInt(8, towerCost);

        pstmt.executeUpdate();
        pstmt.close();
    }
    public void createGameTable() throws SQLException {
        String game = "CREATE TABLE IF NOT EXISTS games ("+
                "id SERIAL PRIMARY KEY,  "+
                "currentPlayer INT ,"+
                "amountOfPlayer INT,"+
                "timeLeft INT"+
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(game);
        stmt.close();

    }
    public void insertGame(int currentPlayer, int amountOfPlayer, int timeLeft) throws SQLException {
        String sql = "INSERT INTO games (currentPlayer, amountOfPlayer, timeLeft) VALUES (?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, currentPlayer);
        pstmt.setInt(2, amountOfPlayer);
        pstmt.setInt(3, timeLeft);

        pstmt.executeUpdate();
        pstmt.close();
    }
    public void readGame() throws SQLException {
        String sql = "SELECT * FROM games LIMIT 1";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);


        if (rs.next()) {
            int id = rs.getInt("id");
            int currentPlayer = rs.getInt("currentPlayer");
            int amountOfPlayer = rs.getInt("amountOfPlayer");
            int timeLeft = rs.getInt("timeLeft");


        }

        rs.close();
        stmt.close();

    }



    public void createStructureTable() throws SQLException {
        String str = "CREATE TABLE IF NOT EXISTS structures (" +
                "i INT, " +
                "j INT, " +
                "type VARCHAR(50) NOT NULL, " +
                "owner INT, " +
                "hitPoint INT, " +
                "level INT, " +
                "buildingCost INT, " +
                "maintenanceCost INT, " +
                "levelUpCost INT, " +
                "unitSpace INT, " +
                "defenceRange INT, " +
                "produceNum INT, " +
                "isPaid BOOLEAN" +
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(str);
        stmt.close();
    }

    public void insertStructure(int i, int j, String type, int owner, int hitPoint,
                                int level, int buildingCost, int maintenanceCost, int levelUpCost,
                                int unitSpace, int defenceRange, int produceNum, boolean isPaid) throws SQLException {
        String sq = "INSERT INTO structures (i, j, type, owner, hitPoint, level, buildingCost, " +
                "maintenanceCost, levelUpCost, unitSpace, defenceRange, produceNum, isPaid) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sq);
        pstmt.setInt(1, i);
        pstmt.setInt(2, j);
        pstmt.setString(3, type);
        pstmt.setInt(4, owner);
        pstmt.setInt(5, hitPoint);
        pstmt.setInt(6, level);
        pstmt.setInt(7, buildingCost);
        pstmt.setInt(8, maintenanceCost);
        pstmt.setInt(9, levelUpCost);
        pstmt.setInt(10, unitSpace);
        pstmt.setInt(11, defenceRange);
        pstmt.setInt(12, produceNum);
        pstmt.setBoolean(13, isPaid);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void createUnitTable() throws SQLException {
        String stt = "CREATE TABLE IF NOT EXISTS units (" +
                "i INT, " +
                "j INT, " +
                "level INT, " +
                "owner INT, " +
                "hitPoint INT, " +
                "producedBy INT, " +
                "hasSpace BOOLEAN, " +
                "haveEaten BOOLEAN, " +
                "isPaid BOOLEAN, " +
                "hasAttacked BOOLEAN, " +
                "hasMoved BOOLEAN" +
                ");";
        Statement stmt = conn.createStatement();
        stmt.execute(stt);
        stmt.close();
    }

    public void insertUnit(int i, int j, int level, int owner, int hitPoint,
                           int producedBy, boolean hasSpace, boolean haveEaten,
                           boolean isPaid, boolean hasAttacked, boolean hasMoved) throws SQLException {
        String sql = "INSERT INTO units (i, j, level, owner, hitPoint, producedBy, hasSpace, " +
                "haveEaten, isPaid, hasAttacked, hasMoved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement unit = conn.prepareStatement(sql);
        unit.setInt(1, i);
        unit.setInt(2, j);
        unit.setInt(3, level);
        unit.setInt(4, owner);
        unit.setInt(5, hitPoint);
        unit.setInt(6, producedBy);
        unit.setBoolean(7, hasSpace);
        unit.setBoolean(8, haveEaten);
        unit.setBoolean(9, isPaid);
        unit.setBoolean(10, hasAttacked);
        unit.setBoolean(11, hasMoved);
        unit.executeUpdate();
        unit.close();
    }

}

