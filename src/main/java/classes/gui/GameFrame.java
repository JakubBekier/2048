package classes.gui;

import javax.swing.*;

public class GameFrame extends JFrame{
    public GameFrame(){
        super("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new Level());

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
