package main;

import java.awt.*;
import javax.swing.JPanel;

import gameComponents.columnSelector.ColumnSelector;
import gameComponents.playField.PlayFieldHandler;
import gameComponents.scoreDisplay.ScoreDisplay;

public class GamePanel extends JPanel implements Runnable
{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 560;

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean isRunning = true;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    
    private ColumnSelector columnSelector;
    private PlayFieldHandler playFieldHandler;
    private ScoreDisplay scoreDisplay;

    //6 * 7 = 42 fields
    public GamePanel()
    {
        createComponents();
        initGamePanel();
        adjustComponents();
        startThread();
    }

    private void createComponents()
    {
        playFieldHandler = new PlayFieldHandler();
        columnSelector = new ColumnSelector(playFieldHandler);
        scoreDisplay = new ScoreDisplay();
    }

    private void initGamePanel()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
    }

    private void adjustComponents()
    {
        add(columnSelector.getColumnSelectorPanel(), BorderLayout.NORTH);
        add(playFieldHandler, BorderLayout.CENTER);
        add(scoreDisplay.getSouthPanel(), BorderLayout.SOUTH);
    }

    private void startThread()
    {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
        while (isRunning)
        {
            updateAndDrawPlayField();
            
            //System.out.println("RUNNING");
        }
    }

    private void updateAndDrawPlayField()
    {
        long startTime, elapsedTime, delay;
        startTime = getCurrentTime();

        //playField.update();
        playFieldHandler.repaint();

        elapsedTime = getCurrentTime() - startTime;
        
        delay = targetTime - elapsedTime / 1000000;
        compensateDelay(delay);
    }

    private long getCurrentTime()
    {
        return System.nanoTime();
    }

    private void compensateDelay(long delay)
    {
        if (delay <= 0) delay = 5;

        try
        {
            Thread.sleep(delay);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
