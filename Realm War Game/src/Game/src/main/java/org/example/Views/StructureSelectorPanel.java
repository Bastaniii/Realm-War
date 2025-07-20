package src.Game.src.main.java.org.example.Views;

import javax.swing.*;
import java.awt.*;

public class StructureSelectorPanel extends JPanel {
    private JComboBox<String> structureSelector;

    public StructureSelectorPanel() {
        setLayout(new FlowLayout());
        setBackground(new Color(200, 255, 250));
        setPreferredSize(new Dimension(300, 60));

        JLabel label = new JLabel("Choose Structure:");
        label.setFont(new Font("Arial", Font.BOLD, 14));

        String[] structureTypes = {"Farm", "Barrack", "Tower","Market"};
        structureSelector = new JComboBox<>(structureTypes);
        structureSelector.setFont(new Font("Arial", Font.PLAIN, 14));

        add(label);
        add(structureSelector);
    }

    public String getSelectedStructureType() {
        return (String) structureSelector.getSelectedItem();
    }

    public void setSelectedStructureType(String type) {
        structureSelector.setSelectedItem(type);
    }
}
