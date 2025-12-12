package animationBall;

import javax.swing.*;
import java.awt.*;

public class AnimationBallApplication extends JFrame {

    public AnimationBallApplication() {
        setTitle("Moving Ball Application");
        setSize(700, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MovingBallPanel ballPanel = new MovingBallPanel();
        
        add(ballPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnimationBallApplication::new);
    }
}
