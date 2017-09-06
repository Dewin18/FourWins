package main;

import javax.swing.JFrame;

public class GameFrame
{
    private JFrame gameFrame;
    
    public GameFrame()
    {
        createGameFrame();
        insertGamePanel();
        adjustFrame();
        showFrame();
    }
    
    private void createGameFrame()
    {
        gameFrame = new JFrame("Four Wins");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void insertGamePanel()
    {
        gameFrame.add(new GamePanel());
    }

    private void adjustFrame()
    {
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
    }
    
    private void showFrame()
    {
        gameFrame.setVisible(true);
    }
}
