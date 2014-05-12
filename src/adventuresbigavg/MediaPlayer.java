package adventuresbigavg;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;

public class MediaPlayer extends javax.swing.JPanel {

    public MediaPlayer(URL mediauUrl) {

        //initComponents();
        setLayout(new BorderLayout());

        try {
            Player mediaPlayer = Manager.createRealizedPlayer(new MediaLocator(mediauUrl));

            //setBackground(Color.BLACK);
            //setLayout(null);
            Component video = mediaPlayer.getVisualComponent();

            //video.setBounds((this.getWidth() /2)+(860/3), (this.getHeight() /2), 720, 480);
            if (video != null) {
                add(video, BorderLayout.CENTER);
            }

            mediaPlayer.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
