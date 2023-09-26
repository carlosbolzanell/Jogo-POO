package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ataque2{
	private Texture textura = new Texture("mao.png");
	private Sprite sprite = new Sprite(textura);
	private int velocidade;
	private int posicaoX = 10;
	private int posicaoY = 87;
	
	public Ataque2(Texture textura, int velocidade, int posicaoX, int posicaoY) {
		super();
		setTextura(textura);
		this.velocidade = velocidade;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
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
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public void moverPosicaoX(int velocidadeMovimento) {
		this.posicaoX += velocidadeMovimento;
	}
	public void trazerPosicaoX(int velocidadeMovimento) {
		this.posicaoX -= velocidadeMovimento;
	}
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	

}
