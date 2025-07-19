package src.Game.src.main.java.org.example.Views;

import src.Game.src.main.java.org.example.Models.Player;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    JLabel whoseTurnLabel;
    JLabel goldLabel;
    JLabel foodLabel;
    JLabel timer;
    public InfoPanel() {
        setPreferredSize(new Dimension(300,425));
        setLayout(new GridLayout(4, 1, 0, 30));
        setBackground(new Color(18, 177, 171, 184));
        whoseTurnLabel=new JLabel("Current Turn: Player 1",SwingConstants.LEADING);
        goldLabel=new JLabel("Gold: 0",SwingConstants.LEFT);
        foodLabel=new JLabel("Food: 0",SwingConstants.LEFT);
        timer=new JLabel("Time: 0",SwingConstants.LEADING);
        Font font = new Font("Arial", Font.PLAIN, 20);
        whoseTurnLabel.setFont(font);
        goldLabel.setFont(font);
        foodLabel.setFont(font);
        timer.setFont(font);
        add(whoseTurnLabel);
        add(goldLabel);
        add(foodLabel);
        add(timer);
    }
    public void update(Player p) {
        whoseTurnLabel.setText("Current Turn: Player " + p.getPlayerNumber());
        goldLabel.setText("Gold: "+ p.getPlayerGold());
        foodLabel.setText("Food: "+ p.getPlayerFood());
    }
    public void updateTimer(int time) {
        timer.setText("Time Left : "+time+" Seconds");
    }
}
