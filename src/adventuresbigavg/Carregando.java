package adventuresbigavg;

import Engine.Config;
import Engine.Foundation;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class Carregando extends JPanel {
    private Image logo;
    private Image fundo;
    
    
    // Construtor:-----------------------------------------------------
    public Carregando() {
        logo = Foundation.loadSprite(String.format("%s%sAssets%sMenu%s%s", Config.getPhysicalPath(), 
                                                                            Config.getPathDelim(),
                                                                            Config.getPathDelim(),
                                                                            Config.getPathDelim(),
                                                                            "logo.png"));
        fundo = Foundation.loadSprite(String.format("%s%sAssets%sMenu%s%s", Config.getPhysicalPath(), 
                                                                            Config.getPathDelim(),
                                                                            Config.getPathDelim(),
                                                                            Config.getPathDelim(),
                                                                            "back.png"));
        
        prepareImage(logo, this);
        prepareImage(fundo, this);
    }

    //----------------------------------------------------------------
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D) g;

        //Pegando coordenadas da janela
        int h = this.getHeight();
        int w = this.getWidth();

        int i, j;

        //Renderizando o fundo...
        g2d.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
        
        //Renderizando logo...
        g2d.drawImage(logo, getWidth()/2 - 542 /2 , getHeight() /2 - 257/ 2, this);
        
        
        
        

        //Gambiarra para Linux e Mac renderizar corretamente
        Toolkit.getDefaultToolkit().sync();

        g.dispose();
    }
}
