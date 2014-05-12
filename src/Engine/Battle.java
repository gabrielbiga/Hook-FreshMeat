package Engine;

import Personagens.Kina;
import Personagens.Personagem;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

public class Battle {
    private Personagem heroi;
    private Personagem inimigo;
    
    private Timer tm;
    
    private int i;
    
    public Battle(Personagem heroi, Personagem inimigo) {
        this.heroi   = heroi;
        this.inimigo = inimigo;
        
        iniciarBatalha();
    }
    
    private void iniciarBatalha() {
        this.tm = new Timer(2000, porrada);
        
        
        tm.start();
    }
    
    private Action porrada = new AbstractAction() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inimigo.getVida() <= 0 || heroi.getVida() <= 0) {
                System.out.println("Batalha já encerrada!");
                
                heroi.setSprite(Kina.spriteParado(Kina.olhandoLado));
                
                tm.stop();
                return;
            }
            
            heroi.setSprite(Kina.spriteLutando(Kina.olhandoLado));
            
            System.out.println(String.format("O heroi: %s atacou o inimigo %s com %d de dano!", heroi.getNome(),
                                                                                                inimigo.getNome(),
                                                                                                heroi.getAtaque()));
            
            //Ataque!
            inimigo.setVida(inimigo.getVida() - heroi.getAtaque());
            
            System.out.println(String.format("O inimigo: %s atacou o heroi %s com %d de dano!", inimigo.getNome(),
                                                                                                heroi.getNome(),
                                                                                                inimigo.getAtaque()));
            
            heroi.setVida(heroi.getVida() - inimigo.getAtaque());
            
            System.out.println(String.format("O heroi: %s está com %d de vida.", heroi.getNome(),
                                                                                        heroi.getVida()));
            
            
            System.out.println(String.format("O inimigo: %s está com %d de vida.", inimigo.getNome(),
                                                                                   inimigo.getVida()));
            
            boolean fimBatalha = false;
            
            //Checando fim da batalha...
            if (inimigo.getVida() <= 0) {
                System.out.println(String.format("O inimigo %s perdeu a batalha e está morto!", inimigo.getNome()));
                inimigo.setSprite(Foundation.loadSprite(String.format("%s%sAssets%sChars%scorpse.gif", Config.getPhysicalPath(),
                                                                                    Config.getPathDelim(),
                                                                                    Config.getPathDelim(),
                                                                                    Config.getPathDelim())));
                
                fimBatalha = true;
            } else if (heroi.getVida() <= 0) {
                System.out.println(String.format("O heroi %s perdeu a batalha e está morto!", heroi.getNome()));
                fimBatalha = true;
            }
            
            if (fimBatalha) {
                heroi.setSprite(Kina.spriteParado(Kina.olhandoLado));
            
                tm.stop();
                return;
            }
            
            System.out.println("\n---\n");
        }
    };
}
