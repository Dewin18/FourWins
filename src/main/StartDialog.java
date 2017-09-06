package main;

import java.awt.*;
import javax.swing.*;

public class StartDialog
{
    private final int WIDTH = 400;
    private final int HEIGHT = 200;
    
    private final int TITLE_FONT_SIZE = 27;
    private final String TITLE_TEXT = "FOUR WINS";
    
    private JDialog startDialog;
    private JLabel title;
    private JPanel playerNamePanel;
    private JTextField playerOneName;
    private JTextField playerTwoName;
    private JButton startGame;
    private JButton exit;
    
    public StartDialog()
    {
        startDialog = new JDialog(startDialog, "FW");
        
        setLayoutAndSize();
        initComponents();
        addComponentsToDialog();
    }

    private void initComponents()
    {
        initTitle();
        initPlayerNamePanel();
    }

    private void initTitle()
    {
        Font titleFont = new Font(null, Font.PLAIN, TITLE_FONT_SIZE);
        title = new JLabel();
      
        title.setFont(titleFont);
        title.setForeground(Color.BLUE);
        title.setText(TITLE_TEXT);
        title.setHorizontalAlignment(JLabel.CENTER);
    }

    private void initPlayerNamePanel()
    {
        playerNamePanel = new JPanel();
        playerNamePanel.setLayout(new GridLayout(6, 2));
        
        initButtons();
        initTextFields();
        addComponentsToPlayerNamePanel();
    }

    private void initButtons()
    {
        startGame = new JButton("START GAME");
        exit = new JButton("EXIT");
    }
    
    private void initTextFields()
    {
        Dimension textFieldSize = new Dimension(10, 10);
        
        playerOneName = new JTextField();
        playerOneName.setSize(textFieldSize);
        
        playerTwoName = new JTextField();
        playerTwoName.setSize(textFieldSize);
    }

    private void setLayoutAndSize()
    {
        startDialog.setLayout(new BorderLayout());
        startDialog.setSize(WIDTH, HEIGHT);
        startDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    private void addComponentsToPlayerNamePanel()
    {
        playerNamePanel.add(new JLabel(""));
        playerNamePanel.add(new JLabel(""));
        playerNamePanel.add(new JLabel("Player 1 Name: "));
        playerNamePanel.add(playerOneName);
        playerNamePanel.add(new JLabel("Player 2 Name: "));
        playerNamePanel.add(playerTwoName);
        playerNamePanel.add(new JLabel(""));
        playerNamePanel.add(new JLabel(""));
        playerNamePanel.add(startGame);
        playerNamePanel.add(exit);
    }

    private void addComponentsToDialog()
    {
        startDialog.add(title, BorderLayout.NORTH);
        startDialog.add(playerNamePanel, BorderLayout.CENTER);
    }

    public void showDialog()
    {
        startDialog.setLocationRelativeTo(null);
        startDialog.setModal(true);
        startDialog.setVisible(true);
    }
    
    public JButton getStartGameButton()
    {
        return startGame;
    }
    
    public JButton getExitButton()
    {
        return exit;
    }
    
    public JDialog getDialog()
    {
        return startDialog;
    }
    
    public void createGameFrame()
    {
        new GameFrame();
    }
}
