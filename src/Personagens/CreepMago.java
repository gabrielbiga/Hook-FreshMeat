package Personagens;

import Engine.Config;
import Engine.Foundation;

public class CreepMago extends Personagem {
    
    public CreepMago() {
        this.setNome("Creep Maguinho");
        this.setVida(100);
        this.setAtaque(10);
        this.setSprite(Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Chars" + Config.getPathDelim() + "Enemy" + Config.getPathDelim() + "CreepMage.gif"));
        
        this.setSizeX(64);
        this.setSizeY(64);
    }
    
}
