package src.Game.src.main.java.org.example.Views;

import src.Game.src.main.java.org.example.Utils.GameLogger;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    JButton newGame;
    JButton loadGame;
    JButton button1;
    JButton button2;
    JButton button3;
    JDialog start;
    public StartPanel() {
        this.setBackground(new Color(144, 238, 144));
        this.setSize(1500, 600);
        this.setOpaque(true);
        setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Game");
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(173, 216, 230));
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 60));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setSize(400, 200);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);
        newGame = new JButton("New Game");
        newGame.setOpaque(true);
        newGame.setBackground(new Color(173, 216, 230));
        newGame.setFont(new Font("Arial", Font.BOLD, 15));
        newGame.setForeground(Color.BLACK);
        Dimension buttonSize = new Dimension(200, 100);
        newGame.setPreferredSize(buttonSize);
        newGame.setMaximumSize(buttonSize);
        newGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.button1 = new JButton("2");
        this.button2 = new JButton("3");
        this.button3 = new JButton("4");
        start = new JDialog((JFrame) null, "Choose number of players", true);
        newGame.addActionListener(e -> {
            try {
                GameLogger.log("New Game clicked - showing player selection dialog");
                start.getContentPane().removeAll();
                start.setSize(400, 250);
                start.setLocationRelativeTo(null);
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                JLabel label = new JLabel("Choose number of players");
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                this.button1.setAlignmentX(Component.CENTER_ALIGNMENT);

                this.button2.setAlignmentX(Component.CENTER_ALIGNMENT);

                this.button3.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(Box.createVerticalStrut(10));
                panel.add(label);
                panel.add(Box.createVerticalStrut(10));
                panel.add(button1);
                panel.add(Box.createVerticalStrut(10));
                panel.add(button2);
                panel.add(Box.createVerticalStrut(10));
                panel.add(button3);
                start.getContentPane().add(panel);
                start.pack();
                start.setLocationRelativeTo(null);
                start.setVisible(true);
            } catch (Exception ex) {
                GameLogger.log("Error while opening new game dialog: " + ex.getMessage());
            }
        });
        loadGame = new JButton("Load Game");
        loadGame.setOpaque(true);
        loadGame.setBackground(new Color(173,216,230));
        loadGame.setFont(new Font("Arial",Font.BOLD,15));
        loadGame.setForeground(Color.BLACK);
        loadGame.setPreferredSize(buttonSize);
        loadGame.setMaximumSize(buttonSize);
        loadGame.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.setBackground(new Color(144, 238, 144));
        buttonPanel.setOpaque(true);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(newGame);
        buttonPanel.add(Box.createHorizontalStrut(50)); // فاصله بین دکمه‌ها
        buttonPanel.add(loadGame);
        buttonPanel.add(Box.createHorizontalGlue());
        add(buttonPanel, BorderLayout.CENTER);
    }
    public JButton getButton1Start(){
        return button1;
    }
    public JButton getButton2Start(){
        return button2;
    }
    public JButton getButton3Start(){
        return button3;
    }
    public JDialog getStart(){
        return start;
    }
}
