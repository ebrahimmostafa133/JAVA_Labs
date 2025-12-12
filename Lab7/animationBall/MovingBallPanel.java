package animationBall;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;


public class MovingBallPanel extends JPanel implements ActionListener {

    private int ballX, ballY;      
    private int dx, dy;            
    private final int IMAGE_SIZE = 80; 
    private final int SPEED = 6;   
    
    private BufferedImage benzImage; 
    private final Timer timer;
    private final Random random = new Random();

    public MovingBallPanel() {
        try {
            benzImage = ImageIO.read(getClass().getResource("benz.png"));
        } catch (IOException e) {
            System.err.println("Error loading image: benz.png not found or corrupted.");
            e.printStackTrace();
            benzImage = createPlaceholderImage(); 
        }


        ballX = 200;
        ballY = 150;
        
        // Initialize Random Direction
        double angle = random.nextDouble() * 2 * Math.PI;
        dx = (int) (SPEED * Math.cos(angle));
        dy = (int) (SPEED * Math.sin(angle));
        if (dx == 0 && dy == 0) {
            dx = SPEED;
        }

        timer = new Timer(25, this);
        timer.start();
    }
    
    private BufferedImage createPlaceholderImage() {
        BufferedImage img = new BufferedImage(IMAGE_SIZE, IMAGE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 0, IMAGE_SIZE, IMAGE_SIZE);
        g2.dispose();
        return img;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ballX += dx;
        ballY += dy;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (ballX <= 0 || ballX >= panelWidth - IMAGE_SIZE) {
            dx = -dx; 
            
            if (ballX < 0) ballX = 0;
            if (ballX > panelWidth - IMAGE_SIZE) ballX = panelWidth - IMAGE_SIZE;
        }

        if (ballY <= 0 || ballY >= panelHeight - IMAGE_SIZE) {
            dy = -dy; 
            
            if (ballY < 0) ballY = 0;
            if (ballY > panelHeight - IMAGE_SIZE) ballY = panelHeight - IMAGE_SIZE;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (benzImage != null) {
            g.drawImage(benzImage, ballX, ballY, IMAGE_SIZE, IMAGE_SIZE, this);
        }
    }
}