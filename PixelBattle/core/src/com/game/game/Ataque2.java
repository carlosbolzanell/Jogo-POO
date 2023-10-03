package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ataque2{
	private Texture textura = new Texture("mao.png");
	private Sprite sprite = new Sprite(textura);
	private int velocidade;
	
	public Ataque2(Texture textura, int velocidade) {
		setTextura(textura);
		this.velocidade = velocidade;
	}
	public Ataque2() {
		
	}
	public Texture getTextura() {
		return textura;
	}
	public void setTextura(Texture textura) {
		this.textura = textura;
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
	

}
