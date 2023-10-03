package com.game.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Personagem {
	private Texture textura;
	private Sprite sprite;
	private int posicaoX =10;
	private int posicaoY =87;	
	private float vida;
	private float dano;
	private float velocidadePulo = 20f;
	private float gravidade = -0.99f;
	private boolean isPulando;
	private boolean isAtacando = false;
	private Ataque ataque = new Ataque();
	
	public Personagem(String textura) {
		setTextura(textura);
		setSprite(getTextura());	
		ataque.getSprite().setPosition(getPosicaoX() + getSprite().getWidth()/2, getPosicaoY() + getSprite().getHeight()/2);
	}
	
	
	public Personagem() {
		
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

	public void acoes() {
		pular();
		mover();
		atacar();
//		colidiu();
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
				posicaoX += 10;		
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			if(posicaoX > 0) {
				posicaoX -= 10;				
			}
		}
	}
	
	public void atacar() {
		if(Gdx.input.isKeyPressed(Input.Keys.R)) {
			isAtacando = true;
		}
		if(isAtacando) {
			if(ataque.getSprite().getX()<1280) {
				ataque.getSprite().setX(ataque.getSprite().getX() + 20);
			}else {
				atacou();
			}
		}else {
			ataque.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
			ataque.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
		}
	}
	public void atacou() {
		ataque.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
		ataque.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
		isAtacando = false;
	}
	
//	public void colidiu() {
//		if(ataqueBounds.overlaps(personagem2Bounds)) {
//			personagem2.setVida(personagem2.getVida() - dano);
//			atacou();
//		}
//	}
	

}
