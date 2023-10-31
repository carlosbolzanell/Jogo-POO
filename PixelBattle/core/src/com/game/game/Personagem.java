package com.game.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Personagem {
	private Texture textura;
	private Sprite sprite;
	private float posicaoX;
	private float posicaoY;	
	private float vida;
	private float velocidadePulo = 20f;
	private float gravidade = -0.99f;
	private boolean isPulando;
	private boolean isAtacando = false;
	private boolean isSuperAtacando = false;
	private Ataque ataque;
	private SuperAtaque superAtaque;
	private int contadorAtaque = 0;
	private boolean colidiu = false;
	
	public Personagem(String textura, int posicaoX, int posicaoY, int vida, Ataque ataque, SuperAtaque superAtaque) {
		setTextura(textura);
		setSprite(getTextura());	
		ataque.getSprite().setPosition(getPosicaoX() + getSprite().getWidth()/2, getPosicaoY() + getSprite().getHeight()/2);
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
		setVida(vida);
		setAtaque(ataque);
		setSuperAtaque(superAtaque);
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
	public Ataque getAtaque() {
		return ataque;
	}
	public void setAtaque(Ataque ataque) {
		this.ataque = ataque;
	}
	public float getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(float posicaoX) {
		this.posicaoX = posicaoX;
	}
	public float getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(float posicaoY) {
		this.posicaoY = posicaoY;
	}
	public SuperAtaque getSuperAtaque() {
		return superAtaque;
	}
	public void setSuperAtaque(SuperAtaque superAtaque) {
		this.superAtaque = superAtaque;
	}
	public int getContadorAtaque() {
		return contadorAtaque;
	}
	public void setContadorAtaque(int contadorAtaque) {
		this.contadorAtaque = contadorAtaque;
	}
	public boolean isColidiu() {
		return colidiu;
	}
	public void setColidiu(boolean colidiu) {
		this.colidiu = colidiu;
	}
	public boolean isPulando() {
		return isPulando;
	}
	public void setPulando(boolean isPulando) {
		this.isPulando = isPulando;
	}
	public float getVelocidadePulo() {
		return velocidadePulo;
	}
	public void setVelocidadePulo(float velocidadePulo) {
		this.velocidadePulo = velocidadePulo;
	}
	public float getGravidade() {
		return gravidade;
	}
	public void setGravidade(float gravidade) {
		this.gravidade = gravidade;
	}
	public void acoes() {
		pular();
		mover();
		atacar();
	}
	public void pular() {}
	public void mover() {}
	public void atacar() {}
	
	public boolean isAtacando() {
		return isAtacando;
	}
	public void setAtacando(boolean isAtacando) {
		this.isAtacando = isAtacando;
	}
	public boolean isSuperAtacando() {
		return isSuperAtacando;
	}
	public void setSuperAtacando(boolean isSuperAtacando) {
		this.isSuperAtacando = isSuperAtacando;
	}
}
