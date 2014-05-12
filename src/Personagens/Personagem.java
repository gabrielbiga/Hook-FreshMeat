package Personagens;

import Mapa.MapElement;

public class Personagem extends MapElement {
    private String nome;
    
    private int vida;
    private int ataque;
    //private int defesa;
    
    //Lados do personagem
    public static enum Lados {
        FRENTE, TRAS, DIREITA, ESQUERDA
    };

    //---
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
}
