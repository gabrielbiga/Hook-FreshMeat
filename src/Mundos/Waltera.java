package Mundos;


//required libraries:
import Engine.Battle;
import Engine.Config;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.*;

import Mapa.Map;

import Engine.Foundation;
import Engine.UI;
import Mapa.MapElement;
import Personagens.CreepMago;
import Personagens.CreepNormal;
import Personagens.Kina;
import Personagens.Personagem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;;

public class Waltera extends Map {
    
    public Waltera(JPanel window) {
        //Carregando background do mapa
        this.setBackground(Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Worlds" + Config.getPathDelim() + "Elements" + Config.getPathDelim() + "Shallow_Water_Tile.gif"));
        
        //Carregando mapão
        this.setSprite(Foundation.loadSprite(Config.getPhysicalPath() + Config.getPathDelim() + "Assets" + Config.getPathDelim() + "Worlds" + Config.getPathDelim() + "waltera.png"));
        
        
        //Personagens de ambientacao
        Personagem creepMago1 = new CreepMago();
        
        creepMago1.setX(1200);
        creepMago1.setY(180);
        
        this.addPersonagem(creepMago1);
        
        Personagem creep1 = new CreepNormal();
        
        creep1.setX(1150);
        creep1.setY(400);
        
        this.addPersonagem(creep1);
        
        Personagem creep2 = new CreepNormal();
        
        creep2.setX(1050);
        creep2.setY(200);
        
        this.addPersonagem(creep2);
        
        Personagem creep3 = new CreepNormal();
        
        creep3.setX(900);
        creep3.setY(300);
        
        this.addPersonagem(creep3);
        
        //Hero
        Personagem kina = new Kina();
        
        /*kina.setX(860);
        kina.setY(700);*/
        
        kina.setX(240);
        kina.setY(400);
        
        Kina.memoryPosition = this.addPersonagem(kina);
        
        //-----------------
        
        //Bind do teclado ---
        this.keyboardListner(this, window);
        
        //Bind do mouse
        window.addMouseListener(this.mouseListner(this, window));
    }
    
    private MouseAdapter mouseListner(final Map mapaMundo, final JPanel window) {
        return new MouseAdapter() { 
            @Override
            public void mousePressed(MouseEvent me) { 
                //mapa = 2067x1467
                
                //Coords
                double mouseX = me.getX();
                double mouseY = me.getY();
                
                //fucking i
                int i;
                
                System.out.println(String.format("Click! \n X: %f, Y: %f", mouseX, mouseY)); 
                System.out.println(String.format("Window! \n X: %d, Y: %d", window.getWidth(), window.getHeight())); 
                
                
                System.out.println("Kina :  X= " + mapaMundo.getPersonagem(Kina.memoryPosition).getX()+ ", Y= " + mapaMundo.getPersonagem(Kina.memoryPosition).getY());
                
                
                MapElement elemento;
                Personagem personagemSelecionado;
                
                //Vamos ver se clicou em algum elemento
                for (i = 0; i < mapaMundo.getElementsCount(); i++) {
                    elemento = mapaMundo.getElement(i);
                    
                    int x1 = elemento.getX();
                    int x2 = elemento.getX() + elemento.getSizeX();
                    int y1 = elemento.getY();
                    int y2 = elemento.getY() + elemento.getSizeY();
                    
                    if (mouseX >= x1 && mouseX <= x2) {
                        if (mouseY >= y1 && mouseY <= y2) {
                            
                            System.out.println(String.format("Elemento %d clicado!!", i));
                        }
                    }
                }
                //Vamos ver se clicou em algum heroi
                for (i = 0; i < mapaMundo.getPersonagensCount(); i++) {
                    elemento = mapaMundo.getPersonagem(i);
                    
                    int x1 = elemento.getX();
                    int x2 = elemento.getX() + elemento.getSizeX();
                    int y1 = elemento.getY();
                    int y2 = elemento.getY() + elemento.getSizeY();
                    
                    if (mouseX >= x1 && mouseX <= x2) {
                        if (mouseY >= y1 && mouseY <= y2) {
                            UI.personagemSelecionado = mapaMundo.getPersonagem(i);
                            System.out.println(String.format("Elemento %d clicado!!", i));
                        }
                    }
                }
            } 
        }; 
    }
    
    //Variavel para gravar o ultimo botao precionado;
    private int botaoAnterior;
    
    private void keyboardListner(final Map mapaMundo, final JPanel window) {
        KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {

                    @Override
                    public boolean dispatchKeyEvent(final KeyEvent e) {
                        
                        //Previne eventos repetidos
                        /*if (botaoAnterior != e.getKeyCode()) {
                            botaoAnterior = e.getKeyCode();
                        } else {
                            botaoAnterior = 0;
                            return false;
                        }*/
                        
                        int i;
                        
                        
                        System.out.println("Got: " + e.getKeyCode());
                        
                        if (e.getKeyCode() == 87 ) {
                            mapaMundo.getPersonagem(Kina.memoryPosition).setY( mapaMundo.getPersonagem(Kina.memoryPosition).getY() - 10);
                            Kina.olhandoLado = Personagem.Lados.FRENTE;
                        }
                        
                        //S
                        if (e.getKeyCode() == 83) {
                            //mapaMundo.getElement(Kina.memoryPosition).setSprite(Kina.spriteParado());
                            mapaMundo.getPersonagem(Kina.memoryPosition).setY( mapaMundo.getPersonagem(Kina.memoryPosition).getY() + 10);
                            Kina.olhandoLado = Personagem.Lados.TRAS;
                        } /*else {
                           if (e.getKeyCode() != 87 || e.getKeyCode() != 83) { 
                                mapaMundo.getElement(Kina.memoryPosition).setSprite(Kina.spriteAndando(0));
                           }
                        }*/
                        
                        //D
                        if (e.getKeyCode() == 68) {
                            mapaMundo.getPersonagem(Kina.memoryPosition).setX( mapaMundo.getPersonagem(Kina.memoryPosition).getX() + 10);
                            Kina.olhandoLado = Personagem.Lados.DIREITA;
                        }
                        
                        //A
                        if (e.getKeyCode() == 65) {
                            mapaMundo.getPersonagem(Kina.memoryPosition).setX( mapaMundo.getPersonagem(Kina.memoryPosition).getX() - 10);
                            Kina.olhandoLado = Personagem.Lados.ESQUERDA;
                        }
                        
                        mapaMundo.getPersonagem(Kina.memoryPosition).setSprite(Kina.spriteParado(Kina.olhandoLado));
                        
                        //Enter
                        if (e.getKeyCode() == 49) {
                            //Gambiarra para arrumar o bug do Java Hotspot do MacOS que pega duas vezes a tecla digitada
                            if (botaoAnterior != 49) {
                                new Battle(mapaMundo.getPersonagem(Kina.memoryPosition), UI.personagemSelecionado);
                                
                                botaoAnterior = 49;
                            } else {
                                botaoAnterior = 0;
                            }
                        }

                        //>>
                        if (e.getKeyCode() == 39) {
                            mapaMundo.setX(mapaMundo.getX() - 10);
                            
                            for(i=0; i < mapaMundo.getElementsCount(); i++)
                                mapaMundo.getElement(i).setX( mapaMundo.getElement(i).getX() - 10);
                            
                            for(i=0; i < mapaMundo.getPersonagensCount(); i++)
                                mapaMundo.getPersonagem(i).setX( mapaMundo.getPersonagem(i).getX() - 10);
                        }

                        //<<
                        if (e.getKeyCode() == 37) {
                            mapaMundo.setX(mapaMundo.getX() + 10);
                            
                             for(i=0; i < mapaMundo.getElementsCount(); i++)
                                mapaMundo.getElement(i).setX( mapaMundo.getElement(i).getX() + 10);
                             
                             for(i=0; i < mapaMundo.getPersonagensCount(); i++)
                                mapaMundo.getPersonagem(i).setX( mapaMundo.getPersonagem(i).getX() + 10);
                        }

                        //up
                        if (e.getKeyCode() == 38) {
                            mapaMundo.setY(mapaMundo.getY() + 10);
                            
                             for(i=0; i < mapaMundo.getElementsCount(); i++)
                                mapaMundo.getElement(i).setY( mapaMundo.getElement(i).getY() + 10);
                             
                             for(i=0; i < mapaMundo.getPersonagensCount(); i++)
                                mapaMundo.getPersonagem(i).setY( mapaMundo.getPersonagem(i).getY() + 10);
                        }
                        //down
                        if (e.getKeyCode() == 40) {
                            mapaMundo.setY(mapaMundo.getY() - 10);
                            
                             for(i=0; i < mapaMundo.getElementsCount(); i++)
                                mapaMundo.getElement(i).setY( mapaMundo.getElement(i).getY() - 10);
                             
                             for(i=0; i < mapaMundo.getPersonagensCount(); i++)
                                mapaMundo.getPersonagem(i).setY( mapaMundo.getPersonagem(i).getY() - 10);
                        }
                        
                        //Atualiza canvas
                        window.repaint();
                       
                        return false;
                    }
                }); 
    }
}
