package src.Game.src.main.java.org.example.Views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UnitSelectorPanel extends JPanel {
    private JComboBox<String> UnitSelector;
    private Map<String, Integer> nameToIdMap;

    public UnitSelectorPanel() {
        setLayout(new FlowLayout());
        setBackground(new Color(200, 255, 250));
        setPreferredSize(new Dimension(300, 60));

        JLabel label = new JLabel("Choose Unit:");
        label.setFont(new Font("Arial", Font.BOLD, 14));


        String[] names = {"Peasant", "Spearman", "Swordman", "Knight"};


        nameToIdMap = new HashMap<>();
        nameToIdMap.put("Peasant", 1);
        nameToIdMap.put("Spearman", 2);
        nameToIdMap.put("Swordman", 3);
        nameToIdMap.put("Knight", 4);

        UnitSelector = new JComboBox<>(names);
        UnitSelector.setFont(new Font("Arial", Font.PLAIN, 14));

        add(label);
        add(UnitSelector);
    }


    public int getSelectedUnitId() {
        String selected = (String) UnitSelector.getSelectedItem();
        return nameToIdMap.getOrDefault(selected, -1);
    }
    public void resetSelectedUnitId(int id) {
        UnitSelector.setSelectedIndex(id);
    }

}
