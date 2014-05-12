package Mapa;

import Personagens.Personagem;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

//import Engine.Foundation;

public class Map {
    private List<MapElement> elements;
    private List<Personagem> personagens;
    
    private int elementsCount;
    private int personagensCount;
    
    //Camera
    //Store position    
    private int x;
    private int y;
    //---
    
    private Image background;
    private Image sprite;
    
      
    public Map() {
        //Instanciando Elements
        //Não vou usar Diamond para ter melhor entendimento
        this.elements = new ArrayList<MapElement>();
        
        //Instanciando lista de personagens
        this.personagens = new ArrayList<Personagem>();
    }  
    

    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }        
    

    public int getElementsCount() {
        return this.elementsCount;
    }
    
    public int getPersonagensCount() {
        return this.personagensCount;
    }

    
    public int addElement(MapElement Item) {
        this.elements.add(Item);
        elementsCount++;
        
        return elementsCount -1;
    }
    
    public int addPersonagem(Personagem Perso) {
        this.personagens.add(Perso);
        personagensCount++;
                
        return personagensCount -1;
    }
    
    public MapElement getElement(int Index) {
        return this.elements.get(Index);
    }
    
    public Personagem getPersonagem(int Index) {
        return this.personagens.get(Index);
    }

    public void setBackground(Image background) {
        this.background = background;
    }
    
    
    public Image getBackground() {
        return background;
    }
    
    
    //--   
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //--
}
