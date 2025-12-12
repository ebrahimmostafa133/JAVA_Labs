package dateAndtime;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class TimeUpdaterThread implements Runnable {

    private final JLabel targetLabel;
    private final SimpleDateFormat formatter = 
        new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);

    public TimeUpdaterThread(JLabel label) {
        this.targetLabel = label;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                final String timeString = formatter.format(new Date());

                SwingUtilities.invokeLater(() -> {
                    targetLabel.setText(timeString);
                });

                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Time updater thread successfully stopped.");
        }
    }
}