package gameComponents.settings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import main.GamePanel;

public class SettingsUI
{
    private JPanel settingPanel;

    private JButton settings; // setNames, restart.. 
    private JButton exit;

    private BufferedImage settingsIcon;
    private BufferedImage exitIcon;

    private JLabel timer;
    private long nextSecondsRecording = 0;

    private long elapsedTime = 0;

    private long firstSecondsRecording;
    private long seconds = 0;

    public SettingsUI()
    {
        loadIcons();
        initSettingPanel();
        createButtonsAndTimer();
    }

    private void loadIcons()
    {
        try
        {
            settingsIcon = ImageIO
                .read(getClass().getResource("/settingsIcon.png"));
            exitIcon = ImageIO.read(getClass().getResource("/exitIcon.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initSettingPanel()
    {
        settingPanel = new JPanel();
        settingPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
        settingPanel.setPreferredSize(new Dimension(GamePanel.WIDTH, 40));
    }

    private void createButtonsAndTimer()
    {
        initButtons();
        removeButtonsBorders();
        initTimerLabel();
        addIconToSettingButton();

        settingPanel.add(settings);
        settingPanel.add(timer);
        settingPanel.add(exit);
    }

    private void initTimerLabel()
    {
        timer = new JLabel();
    }

    private void initButtons()
    {
        settings = new JButton();
        exit = new JButton();
    }

    private void removeButtonsBorders()
    {
        settings.setBorderPainted(false);
        exit.setBorderPainted(false);
    }

    private void addIconToSettingButton()
    {
        settings.setIcon(new ImageIcon(settingsIcon));
        exit.setIcon(new ImageIcon(exitIcon));
    }

    public JPanel getSettingPanel()
    {
        return settingPanel;
    }

    public JButton getSettingsButton()
    {
        return settings;
    }

    public JButton getExitButton()
    {
        return exit;
    }

    public void updateElapsedTime() //TODO FIX flow Layout
    {
        firstSecondsRecording = elapsedTime;
        elapsedTime = System.nanoTime() / 1000000000 % 10;
        nextSecondsRecording = elapsedTime;

        if (secondsHaveChanged()) seconds++;

        timer.setText("Elapsed: " + seconds);
    }

    private boolean secondsHaveChanged()
    {
        return firstSecondsRecording != nextSecondsRecording;
    }
}
