package gameComponents.playField;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class CustomButton extends JButton
{
    private static final long serialVersionUID = 1L;
    private Image img;

    public CustomButton()
    {
      try
      {
          img = ImageIO.read(getClass().getResourceAsStream("/RED_STONE.png"));
      }
      catch (IOException e)
      {
          e.printStackTrace();
      }
    }

    @Override
    public void paintBorder(Graphics g)
    {
        g.drawImage(img, 0, 0, 70, 70, null);
    }
}
