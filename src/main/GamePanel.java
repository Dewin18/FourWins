package main;

import java.awt.*;
import javax.swing.JPanel;

import gameComponents.ComponentTool;
import gameComponents.columnSelector.ColumnSelector;
import gameComponents.playField.PlayFieldHandler;

public class GamePanel extends JPanel implements Runnable
{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 600;

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private boolean isRunning = true;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;

    private ComponentTool componentTool = new ComponentTool();

    public GamePanel()
    {
        initGamePanel();
        adjustComponents();
        startThread();
    }

    private void initGamePanel()
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
    }

    private void adjustComponents()
    {
        add(getSelectorPanel(), BorderLayout.NORTH);
        add(getPlayFieldHandler(), BorderLayout.CENTER);
        add(getScoreAndDisplay(), BorderLayout.SOUTH);
    }

    private JPanel getSelectorPanel()
    {
        ColumnSelector selector = componentTool.getColumnSelector();
        JPanel selectorPanel = selector.getColumnSelectorPanel();
        return selectorPanel;
    }

    private PlayFieldHandler getPlayFieldHandler()
    {
        PlayFieldHandler playFieldHandler = componentTool.getPlayFieldHandler();
        return playFieldHandler;
    }

    private JPanel getScoreAndDisplay()
    {
        JPanel scoreAndDisplayPanel = componentTool.getScoreAndDisplayPanel();
        return scoreAndDisplayPanel;
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
        }
    }

    private void updateAndDrawPlayField()
    {
        long startTime, elapsedTime, delay;
        startTime = getCurrentTime();

        componentTool.getPlayFieldHandler()
            .repaint();

        componentTool.getSettings().updatePlayTime();
        
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
