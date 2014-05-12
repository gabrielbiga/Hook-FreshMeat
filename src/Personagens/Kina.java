package Personagens;

import Engine.Config;
import Engine.Foundation;
import java.awt.Image;

public class Kina extends Personagem {
    public static int memoryPosition; //Posicao no array de elementos do mapa
    public static Lados olhandoLado = Personagem.Lados.FRENTE; //Ultimo lado que esteve olhando
    
    public Kina() {
        this.setNome("Kina");
        this.setVida(100);
        this.setAtaque(50);
        this.setSprite(spriteParado(Personagem.Lados.FRENTE));
        
        this.setSizeX(80);
        this.setSizeY(80);
    }
    
    //Funções estáticas para carregamento facil de sprites
    public static Image spriteAndando(Lados sentido) {
        if (sentido == Personagem.Lados.FRENTE)  {
            return Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Chars" + Config.getPathDelim() + "Hero" + Config.getPathDelim() + "Kina" + Config.getPathDelim() + "PSD" + Config.getPathDelim() + "Walk.gif");
        }
        
        return null;
    }
    
    public static Image spriteParado(Lados sentido) {
        if (sentido == Personagem.Lados.FRENTE)  {
            return Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Chars" + Config.getPathDelim() + "Hero" + Config.getPathDelim() + "Kina" + Config.getPathDelim() + "PSD" + Config.getPathDelim() + "Parado_Frente.gif");
        }
        
        if (sentido == Personagem.Lados.DIREITA) {
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Direita.gif"));
        }
        
        if (sentido == Personagem.Lados.ESQUERDA) {
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Esquerda.gif"));
        }
        
        if (sentido == Personagem.Lados.TRAS) {
            
            System.out.println(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Costas.gif"));
            
            
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Costas.gif"));
        }
        
        return null;
        
    }
    
    public static Image spriteLutando(Lados sentido) {
        if (sentido == Personagem.Lados.FRENTE)  {
            return Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Chars" + Config.getPathDelim() + "Hero" + Config.getPathDelim() + "Kina" + Config.getPathDelim() + "PSD" + Config.getPathDelim() + "Parado_Frente.gif");
        }
        
        if (sentido == Personagem.Lados.DIREITA) {
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%sAtack%s%s", Config.getPhysicalPath(), 
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        Config.getPathDelim(),
                                                                                                        "AtackDireita.gif"));
        }
        
        if (sentido == Personagem.Lados.ESQUERDA) {
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Esquerda.gif"));
        }
        
        if (sentido == Personagem.Lados.TRAS) {
            
            System.out.println(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Costas.gif"));
            
            
            return Foundation.loadSprite(String.format("%s%sAssets%sChars%sHero%sKina%sPSD%s%s", Config.getPhysicalPath(), 
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                Config.getPathDelim(),
                                                                                                "Parado_Costas.gif"));
        }
        
        return null;
        
    }
}
