package textBanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarqueePanel extends JPanel implements ActionListener {

    private final String textToDisplay = "Java World - Welcome to GUI Programming - ";
    private int xPosition = 0;
    private final int speed = 2; 
    private final Timer timer;

    public MarqueePanel() {
        setFont(new Font("Arial", Font.BOLD, 36));

        int delay = 15; 
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        xPosition -= speed;

        if (xPosition < -getFontMetrics(getFont()).stringWidth(textToDisplay)) {
            xPosition = getWidth();
        }

        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE); 
        int yPosition = getHeight() / 2 + g2d.getFontMetrics().getAscent() / 2 - 5;
        g2d.drawString(textToDisplay, xPosition, yPosition);
    }
}