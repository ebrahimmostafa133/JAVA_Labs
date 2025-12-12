package dateAndtime;
import javax.swing.*;
import java.awt.*;

public class ClockDisplayApp extends JFrame {

    private final JLabel timeLabel;

    public ClockDisplayApp() {
        setTitle("Time & Date Application Thread");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("Starting Clock Thread...", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Monospaced", Font.PLAIN, 24));
        add(timeLabel, BorderLayout.CENTER);
        
        TimeUpdaterThread updater = new TimeUpdaterThread(timeLabel);
        
        // Start the thread
        Thread clockThread = new Thread(updater);
        clockThread.start();
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                clockThread.interrupt();
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClockDisplayApp::new);
    }
}