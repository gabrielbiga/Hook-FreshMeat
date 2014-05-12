package adventuresbigavg;

//required libraries:
import Engine.UI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.*;

import Mapa.Map;
import Mundos.Waltera;
import Personagens.Kina;
import Personagens.Personagem;
import java.awt.Font;

public class Janela extends JPanel { // inherit JPanel

    Map mapaMundo;
    UI userinterface;

    // Construtor:-----------------------------------------------------
    public Janela() {
        //Fucking laço
        int i = 0;
        
        //Instanciando mundo
        mapaMundo = new Waltera(this);

        //Ajustando Camera
        mapaMundo.setX((this.getWidth() /2) + 60);
        mapaMundo.setY((this.getHeight() /2) - 800);
        
        //Instanciando UI
        userinterface = new UI();
        
        //Gambiarra para arrumar a porta lixo que Vitinho fez
        mapaMundo.addElement(userinterface.getPortinha());
        
        //this.add(userinterface.getBarraLabel(),  java.awt.BorderLayout.SOUTH);
        
        //Barra de skill
        //MapElement barra = new MapElement();
        
        //barra.setSprite(userinterface.getBarra());
        
        //mapaMundo.addElement(barra);
        
        //Engine bullshit
        prepareImage(mapaMundo.getSprite(), this);
        prepareImage(mapaMundo.getBackground(), this);
        prepareImage(userinterface.getBarra().getSprite(), this);
        
        for (i=0; i < mapaMundo.getElementsCount(); i++) 
            prepareImage(mapaMundo.getElement(i).getSprite(), this);
        
        setDoubleBuffered(true);
        
        mapaMundo.getPersonagem(Kina.memoryPosition).setNome("20matar");
        
        //new Timer(40, ac);
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

        //Renderizando o fundo do mundo...
        for (i = 0; i <= w; i += 32) {
            for (j = 0; j <= h; j += 32) {
                g2d.drawImage(mapaMundo.getBackground(), i, j, this);
            }
        }

        //Reseta o sprite do mapão
        //g2d.translate(w / 2, h / 2);
        //g2d.translate(-mapaMundo.getSprite().getWidth(null) / 2, -mapaMundo.getSprite().getHeight(null) / 2);
        
        int telacentroX = w/2;
        int telacentroY = h/2;
        
        final int posXini = 700;
        final int posYini = -500;
        

        //mapaMundo.setX(posXini - telacentroX);
        //mapaMundo.setY(posXini - telacentroY);
        
        //Renderizando Mapão
        //g2d.drawImage(mapaMundo.getSprite(),  mapaMundo.getX() - telacentroX, mapaMundo.getY() - telacentroY, this);
        
        g2d.drawImage(mapaMundo.getSprite(), mapaMundo.getX(), mapaMundo.getY(), this);
        
        //Renderizando os personagens
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("", 0 , 10));
        for (i=0; i < mapaMundo.getPersonagensCount(); i++) {
            Personagem personagemAtual = mapaMundo.getPersonagem(i);
            
            g2d.drawImage(personagemAtual.getSprite(), personagemAtual.getX(), personagemAtual.getY(), personagemAtual.getSizeX(), personagemAtual.getSizeY(), this);
            
            g2d.drawString(String.format("%s | HP: %d", personagemAtual.getNome(), personagemAtual.getVida()), personagemAtual.getX(),personagemAtual.getY());
        }
        
        //Renderizando demais elementos do mapa
        for (i=0; i < mapaMundo.getElementsCount(); i++) {
            g2d.drawImage(mapaMundo.getElement(i).getSprite(), mapaMundo.getElement(i).getX(), mapaMundo.getElement(i).getY(), this);
        }
            
        
        
        //Barra de skills
        userinterface.getBarra().setX((this.getWidth() /2)  - (userinterface.getBarra().getSizeX() /2));
        userinterface.getBarra().setY(this.getHeight() - userinterface.getBarra().getSizeY());
        
        g2d.drawImage(userinterface.getBarra().getSprite(), userinterface.getBarra().getX(), userinterface.getBarra().getY(),  this);
        //---
        
        
        
        /*g2d.setColor(Color.red);
        g2d.setFont(new Font("", 0, 25));
        g2d.drawString("Kina HP: " + mapaMundo.getPersonagem(Kina.memoryPosition).getVida(), 10, 20);*/
        
        
        
        

        //Gambiarra para Linux e Mac renderizar corretamente
        Toolkit.getDefaultToolkit().sync();

        g.dispose();
    }
}
