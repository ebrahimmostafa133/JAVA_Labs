package textBanner;

import javax.swing.*;
import java.awt.*;


public class TextBannerApplication extends JFrame {

    public TextBannerApplication() {
        setTitle("Banner Application :)");
        setSize(800, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MarqueePanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextBannerApplication::new);
    }
}
