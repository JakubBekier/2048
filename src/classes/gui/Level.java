package classes.gui;

import classes.board.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Level extends JPanel {
    private Board board;
    final private int width = 4;
    final private int height = 4;
    private int delay = 150;

    public Level(){
        this.board = new Board();
        this.setPreferredSize(new Dimension(400, 400));
        setKeyBindings();
    }

    private void setKeyBindings(){
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        String [] values ={
                "A",
                "W",
                "S",
                "D",
                "SPACE"
        };
        for (String el: values){
            inputMap.put(KeyStroke.getKeyStroke(el), el);
            actionMap.put(el, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    board.move(el);
                    if (board.Add2()){
                        System.exit(0);
                    }
                    repaint();
                }
            });
        }

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, getWidth(), getHeight());
        Font font = new Font(g.getFont().getFontName(), Font.BOLD, 40);
        g.setFont(font);

        int rectWidth = getWidth() / width;
        int rectHeight = getHeight() / height;

        int strWidth;

        for (int i = 0; i < width; i ++){
            for (int j = 0; j < height; j++){
                int x = i * (rectWidth + 1);
                int y = j * (rectHeight + 1);

                g.setColor(new Color(255,255,255));
                g.fillRect(x, y, rectWidth - 3, rectHeight - 3);
            }
        }

        int i = 0;
        g.setColor(new Color(0, 0, 0));
        for (Integer[] row: board.values){
            for (Integer el: row) {
                if (el != 0) {
                    strWidth = g.getFontMetrics(font).stringWidth(el.toString());
                    g.drawString(el.toString(), 45 + rectWidth * (i / 4) - strWidth/2, 60 + rectHeight * (i % 4));
                }
                i++;
            }
        }
    }
}
