package Personagens;

import Engine.Config;
import Engine.Foundation;

public class CreepNormal extends Personagem {
    public CreepNormal() {
        this.setNome("Creep");
        this.setVida(100);
        this.setAtaque(10);
        this.setSprite(Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets"+ Config.getPathDelim() + "Chars" + Config.getPathDelim() + "Enemy" + Config.getPathDelim() + "Creep.gif"));
        
        this.setSizeX(64);
        this.setSizeY(64);
    }
}
