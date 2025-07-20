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
    JButton buildStructure;
    JButton levelUpStructure;
    StructureSelectorPanel structureSelector;
    UnitSelectorPanel unitSelector;
    public ActionPanel() {
        this.setLayout(new GridLayout(5, 2, 10, 10));
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
        add(buyUnit);
        unitSelector = new UnitSelectorPanel();
        add(unitSelector);
        buildStructure=new JButton("Build Structure");
        buildStructure.setBackground(Color.WHITE);
        buildStructure.setFont(new Font("Arial",Font.BOLD,12));
        buildStructure.setForeground(Color.black);
        add(buildStructure);
        structureSelector = new StructureSelectorPanel();
        this.add(structureSelector);
        levelUpStructure=new JButton("LevelUp Structure");
        levelUpStructure.setBackground(Color.WHITE);
        levelUpStructure.setFont(new Font("Arial",Font.BOLD,10));
        levelUpStructure.setForeground(Color.black);
        add(levelUpStructure);
        save=new JButton("Save Game");
        save.setBackground(Color.WHITE);
        save.setFont(new Font("Arial",Font.BOLD,20));
        save.setForeground(Color.black);
        add(save);
    }
    public String StructureName(){
        return structureSelector.getSelectedStructureType();
    }

    public StructureSelectorPanel getStructureSelector() {

        return structureSelector;
    }

    public UnitSelectorPanel getUnitSelector() {

        return unitSelector;
    }
    public JButton getEndTurn() {
        return endTurn;
    }
    public JButton getAttack(){
        return attack;
    }
    public JButton getMerge(){
        return merge;
    }
    public JButton getMove(){
        return move;
    }
    public JButton getBuildStructure(){
        return buildStructure;
    }
    public JButton getBuyUnit(){
        return buyUnit;
    }
    public JButton getLevelUpStructure(){
        return levelUpStructure;
    }
    public JButton getSave(){
        return save;
    }
}