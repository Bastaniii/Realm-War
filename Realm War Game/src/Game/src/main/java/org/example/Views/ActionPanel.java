package src.Game.src.main.java.org.example.Views;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    JButton endTurn;
    JButton attack;
    JButton merge;
    JButton move;
    JButton save;
    JButton buyUnit;
    JButton knight;
    JButton swordman;
    JButton spearman;
    JButton peasant;
    JButton buildStructure;
    JButton barrack;
    JButton farm;
    JButton market;
    JButton tower;
    JButton levelUpStructure;
    JDialog Unit;
    JDialog Structure;

    public ActionPanel() {
        this.setLayout(new GridLayout(4, 2, 10, 10));
        this.setBackground(new Color(18, 177, 171, 184));
        this.setPreferredSize(new Dimension(300, 425));
        this.setMaximumSize(new Dimension(300, 425));
        attack = new JButton("Attack");
        attack.setBackground(Color.WHITE);
        attack.setFont(new Font("Arial", Font.BOLD, 20));
        attack.setForeground(Color.black);
        add(attack);
        move = new JButton("Move");
        move.setBackground(Color.WHITE);
        move.setFont(new Font("Arial", Font.BOLD, 20));
        move.setForeground(Color.black);
        add(move);
        merge = new JButton("Merge");
        merge.setBackground(Color.WHITE);
        merge.setFont(new Font("Arial", Font.BOLD, 20));
        merge.setForeground(Color.black);
        add(merge);
        endTurn = new JButton("End Turn");
        endTurn.setBackground(Color.WHITE);
        endTurn.setFont(new Font("Arial", Font.BOLD, 20));
        endTurn.setForeground(Color.black);
        add(endTurn);
        buyUnit = new JButton("Buy Unit");
        buyUnit.setBackground(Color.WHITE);
        buyUnit.setFont(new Font("Arial", Font.BOLD, 20));
        buyUnit.setForeground(Color.black);
        knight = new JButton("Knight");
        swordman = new JButton("Swordman");
        spearman = new JButton("Spearman");
        peasant = new JButton("Peasant");
        Unit = new JDialog((JFrame) null, "Choose unit", true);
        add(buyUnit);
    }
    public void newUnit(){
        Unit.setSize(400,250);
        Unit.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Choose unit");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        peasant.setAlignmentX(Component.CENTER_ALIGNMENT);

        spearman.setAlignmentX(Component.CENTER_ALIGNMENT);

        swordman.setAlignmentX(Component.CENTER_ALIGNMENT);

        knight.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(10));
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        panel.add(peasant);
        panel.add(Box.createVerticalStrut(10));
        panel.add(spearman);
        panel.add(Box.createVerticalStrut(10));
        panel.add(swordman);
        panel.add(Box.createVerticalStrut(10));
        panel.add(knight);
        Unit.add(panel);
        Unit.setVisible(true);

    }
}