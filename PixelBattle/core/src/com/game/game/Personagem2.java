package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Personagem2 {
	private Texture textura;
	private Sprite sprite;
	private int posicaoX = 1100;
	private int posicaoY = 87;	
	private float vida;
	private float dano;
	private float velocidadePulo = 20f;
	private float gravidade = -0.99f;
	private boolean isPulando;
	private boolean isAtacando = false;
	private Ataque2 ataque2 = new Ataque2();
	
	public Personagem2(String personagem) {
		setTextura(personagem);
		setSprite(getTextura());
		ataque2.getSprite().setPosition(getPosicaoX() + getSprite().getWidth()/2, getPosicaoY() + getSprite().getHeight()/2);
	}
	
	
	public Personagem2() {
		
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
	public float getVida() {
		return vida;
	}
	public void setVida(float vida) {
		this.vida = vida;
	}
	public float getDano() {
		return dano;
	}
	public void setDano(float dano) {
		this.dano = dano;
	}
	public Ataque2 getAtaque() {
		return ataque2;
	}
	public void setAtaque(Ataque2 ataque) {
		this.ataque2 = ataque;
	}
	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}
	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}
	
	public void acoes() {
		pular();
		mover();
		atacar();
	}
	
	public void pular() {
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			if(posicaoY == 87) {
				isPulando = true;
				velocidadePulo = 20f;
			}
		}
		if(isPulando) {
			posicaoY += velocidadePulo;
			velocidadePulo += gravidade;
			
			if(posicaoY <= 87) {
				posicaoY = 87;
				isPulando = false;
			}
		}
		
	}
	public void mover() {
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			if(posicaoX < 1100) {
				posicaoX += 10;		
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			if(posicaoX > 0) {
				posicaoX -= 10;				
			}
		}
	}
	
	public void atacar() {
		if(Gdx.input.isKeyPressed(Input.Keys.P)) {
			isAtacando = true;
		}
		if(isAtacando) {
			if(ataque2.getSprite().getX()>0) {
				ataque2.getSprite().setX(ataque2.getSprite().getX() - 20);
			}else {
				atacou();
			}
		}else {
			ataque2.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
			ataque2.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
		}
	}
	public void atacou() {
		ataque2.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
		ataque2.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
		isAtacando = false;
	}
	

}

