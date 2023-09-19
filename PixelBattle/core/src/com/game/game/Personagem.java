package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Personagem {
	private Texture textura = new Texture("ninja1.png");
	private Sprite sprite = new Sprite(textura);
	private int posicaoX = 10;
	private int posicaoY = 87;	
	private float vida;
	private float dano;
	private float velocidadePulo = 20f;
	private float gravidade = -0.99f;
	private boolean isPulando;
	private boolean isAtacando = false;
	private boolean isLancado = false;
	private Ataque ataque = new Ataque();
	
	public Personagem(Texture textura, int posicaoX, int posicaoY, float vida, float dano) {
		super();
		setTextura(textura);
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.vida = vida;
		this.dano = dano;
	}
	
	
	public Personagem() {
		
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
	public Ataque getAtaque() {
		return ataque;
	}
	public void setAtaque(Ataque ataque) {
		this.ataque = ataque;
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
	
	
	public void pular() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
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
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			if(posicaoX < 1100){
				setTextura(new Texture("ninja1.png"));
				posicaoX += 10;		
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			if(posicaoX > 0) {
				setTextura(new Texture("ninja2.png"));
				posicaoX -= 10;				
			}
		}
	}
	
	public void atacar() {
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			isAtacando = true;
		}
		if(isAtacando) {
			if(ataque.getPosicaoX() < 1200) {
				ataque.moverPosicaoX(10);
			}else {
				atacou();
			}
		}
		if(isAtacando && getTextura().toString() == "ninja2.png") {
			if(ataque.getPosicaoX() > -100) {
				ataque.trazerPosicaoX(10);
			}else {
				atacou();
			}
		}
		else {
			ataque.setPosicaoX(this.posicaoX);
			ataque.setPosicaoY(this.posicaoY);
		}
	}
	public void atacou() {
		ataque.setPosicaoX(this.posicaoX);
		ataque.setPosicaoY(this.posicaoY);
		isAtacando = false;
	}
	

}
