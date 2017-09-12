package gameComponents.columnSelector;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColumnSelectorUI
{
    private JPanel selectorButtonPanel;
    
    private JButton column_0;
    private JButton column_1;
    private JButton column_2;
    private JButton column_3;
    private JButton column_4;
    private JButton column_5;
    private JButton column_6;
    
    private JButton[] buttons;
    
    public ColumnSelectorUI()
    {
        selectorButtonPanel = new JPanel();
        
        initColumnButtons();
        insertColumnButtonsIntoButtonPanel();
        setButtonColor(Color.GREEN.darker());
    }
    
    private void initColumnButtons()
    {
        createColumnButtons();
        initButtonArray();
        setButtonIcon("▾");
        setButtonSize();
        //removeButtonBorder();
    }
    
    private void removeButtonBorder()
    {
        for (JButton button : buttons)
        {
            button.setBorderPainted(false);
        }
    }

    private void initButtonArray()
    {
        int numberOfButtons = 7;
        buttons = new JButton[numberOfButtons];
        
        buttons[0] = column_0;
        buttons[1] = column_1;
        buttons[2] = column_2;
        buttons[3] = column_3;
        buttons[4] = column_4;
        buttons[5] = column_5;
        buttons[6] = column_6;
    }

    private void createColumnButtons()
    {
        column_0 = new JButton();
        column_1 = new JButton();
        column_2 = new JButton();
        column_3 = new JButton();
        column_4 = new JButton();
        column_5 = new JButton();
        column_6 = new JButton();
    }

    private void insertColumnButtonsIntoButtonPanel()
    {
        for (JButton columnButton : buttons)
        {
            selectorButtonPanel.add(columnButton);
        }
    }

    private void setButtonIcon(String icon)
    {
        for(int i=0; i < buttons.length; i++)
        {
            buttons[i].setText(icon);
        }
    }
    
    private void setButtonSize()
    {
        for (JButton columnButton : buttons)
        {
            columnButton.setPreferredSize(new Dimension(72, 40));
        }
    }
    
    public void setButtonColor(Color color)
    {
        for (JButton button : buttons)
        {
            button.setFont(new Font("Arial", Font.BOLD, 27));
            button.setForeground(color);
        }
    }
    
    public JButton[] getButtons()
    {
        return buttons;
    }
    
    public JPanel getSelectorButtonPanel()
    {
        return selectorButtonPanel;
    }
}
