package src.Game.src.main.java.org.example.Views;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {
    private JButton[][] buttons = new JButton[20][20];
    public GameBoardPanel() {
        setLayout(new GridLayout(20,20,1,1));
        setBackground(new Color(18, 177, 171, 184));
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50,50));
                button.setMargin(new Insets(0,0,0,0));
                buttons[i][j]=button;
                button.putClientProperty("i",i);
                button.putClientProperty("j",j);
                add(button);
            }
        }

    }
    public JButton[][] getButtons() {
        return buttons;
    }
    public JButton getButton(int i, int j) {
        return buttons[i][j];
    }
}

