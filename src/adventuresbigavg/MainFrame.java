/*
 * Para funcionalidades de teclado, em MacOS use: "defaults write -g ApplePressAndHoldEnabled -bool false"
 */
package adventuresbigavg;

import Engine.Config;
import Engine.OS;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MainFrame extends JFrame {

    Carregando mPanel;

    MainFrame() {
        try {
            JPanel x = abrirForm(new MediaPlayer(new URL(String.format("file:%s%s%s%sAssets%sMenu%s%s", Config.getPhysicalPath(), 
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        "logo.avi"))), this);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //Workarround para video de logo que nao está presente no repo do Github
            //Thread.sleep(19000); 
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getContentPane().removeAll();
        
        this.add(new Carregando());
        this.setVisible(true);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getContentPane().removeAll();
        
        this.add(new Janela());
        
        this.setVisible(true);
        
    }

    private static JPanel abrirForm(JPanel mPanel, JFrame window) {
        window.setTitle("Aventuras");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(mPanel); // add MainPanel JPanel to JFrame

        if (OS.MacOS.isMacOSX()) {
            OS.MacOS.enableFullScreenMode(window);
        } else {
            window.setUndecorated(true);
        }

        window.setVisible(true); // show class
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        return mPanel;
    }

    public static void main(String[] args) throws IOException {
        //Config...
        Config.setPhysicalPath(new File(".").getCanonicalPath());
        Config.setPathDelim('/');
        //---

        System.out.println("Carregando Aventuras...");
        System.out.println("Path: " + Config.getPhysicalPath());
        
        new MainFrame();
    }
}
