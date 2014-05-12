package Engine;

import Mapa.MapElement;
import Personagens.Personagem;
import javax.swing.JLabel;

public class UI {
    private MapElement barra;
    private MapElement portinha;
    
    private JLabel barraLabel = new JLabel();
    
    //Grava o personagem selecionado com o mouse;
    public static Personagem personagemSelecionado;
    
    public UI() {
        //this.barra = Foundation.loadSprite("C:\\AventurasVGBG\\Assets\\UI\\Bar.png");
        this.barra = new MapElement();
        this.barra.setSprite(Foundation.loadSprite(String.format("%s%sAssets%sUI%sBar2.png", Config.getPhysicalPath(),
                                                                                    Config.getPathDelim(),
                                                                                    Config.getPathDelim(),
                                                                                    Config.getPathDelim())));
        /*this.barra.setSizeX(1255);
        this.barra.setSizeY(171);*/
        
        this.barra.setSizeX(800);
        this.barra.setSizeY(127);
        
        
        this.portinha = new MapElement();
        
        this.portinha.setSprite(Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() +"Assets" + Config.getPathDelim() + "Worlds" + Config.getPathDelim() + "chupetex.png"));
        
        this.portinha.setX(137);
        this.portinha.setY(307);
    }

    public MapElement getBarra() {
        return barra;
    }

    public  MapElement getPortinha() {
        return portinha;
    }

    public JLabel getBarraLabel() {
        return barraLabel;
    }
    
    
    
    
}
