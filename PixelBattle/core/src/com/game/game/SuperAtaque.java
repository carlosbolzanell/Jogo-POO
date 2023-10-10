package com.game.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SuperAtaque{
	private Texture textura;
	private Sprite sprite;
	private int velocidade;
	private int dano;
	
	public SuperAtaque(String textura, int velocidade, int dano) {
		setTextura(textura);
		setSprite(getTextura());
		this.velocidade = velocidade;
		this.setDano(dano);
	}
	public Texture getTextura() {
		return textura;
	}
	public void setTextura(String textura) {
		this.textura = new Texture(textura);
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Texture sprite) {
		this.sprite = new Sprite(sprite);
	}
	public int getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	

}
