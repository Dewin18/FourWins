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
    private JPanel timerPanel;

    private JButton settings; // setNames, restart.. 
    private JButton exit;

    private BufferedImage settingsIcon;
    private BufferedImage exitIcon;

    private JLabel timerLabel;
    private long nextSecondsRecording = 0;

    private long elapsedTime = 0;

    private long firstSecondsRecording;
    private long seconds = 0;
    private StopWatch stopWatch;

    public SettingsUI()
    {
        stopWatch = new StopWatch();
        
        loadIcons();
        initSettingPanel();
        initTimerPanel();
        createButtonsAndTimer();
    }

    private void loadIcons()
    {
        try
        {
            settingsIcon = ImageIO
                .read(getClass().getResource("/keyboard.png"));
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

    private void initTimerPanel()
    {
        timerPanel = new JPanel();
        timerPanel.setPreferredSize(new Dimension(150, 25));
    }

    private void createButtonsAndTimer()
    {
        initButtons();
       // removeButtonsBorders();
        initTimerLabel();
        addIconToSettingButton();

        timerPanel.add(timerLabel);

        settingPanel.add(settings);
        settingPanel.add(timerPanel);
        settingPanel.add(exit);
    }

    private void initTimerLabel()
    {
        timerLabel = new JLabel();
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

    public void updateElapsedTime() 
    {
        stopWatch.updateElapsedTime();
        timerLabel.setText(stopWatch.getElapsedTime());
    }
}
