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
	private boolean isPulando = false;
	private boolean isAtacando = false;
	private boolean isSuperAtacando = false;
	private boolean colidiu = false;
	private Ataque ataque;
	private SuperAtaque superAtaque;
	private int contadorAtaque = 0;
	private int cima;
	private int direita;
	private int esquerda;
	private int baixo;
	private int ataqueInt;
	private int superAtaqueInt;
	private String nome;
	private String lado;

	
	public Personagem(String textura, int posicaoX, int posicaoY, int vida, Ataque ataque, SuperAtaque superAtaque, int cima, int baixo, int esquerda, int direita, int ataqueInt, int superAtaqueInt, String nome, String lado) {
		setTextura(textura);
		setSprite(getTextura());	
		ataque.getSprite().setPosition(getPosicaoX() + getSprite().getWidth()/2, getPosicaoY() + getSprite().getHeight()/2);
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
		setVida(vida);
		setAtaque(ataque);
		setSuperAtaque(superAtaque);
		this.cima = cima;
		this.baixo = baixo;
		this.esquerda = esquerda;
		this.direita = direita;
		this.ataqueInt = ataqueInt;
		this.superAtaqueInt = superAtaqueInt;
		this.nome = nome;
		this.lado = lado;
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
	public boolean isAtacando() {return isAtacando;}
	public void setAtacando(boolean atacando) {isAtacando = atacando;}
	public boolean isSuperAtacando() {return isSuperAtacando;}
	public void setSuperAtacando(boolean superAtacando) {isSuperAtacando = superAtacando;}

	public void acoes() {
		pular(this.cima);
		mover(this.direita, this.esquerda, this.baixo);
		atacar(this.ataqueInt, this.superAtaqueInt);
	}
	public void pular(int cima) {
		if(Gdx.input.isKeyPressed(cima)) {
			if(getPosicaoY() == 87) {
				velocidadePulo = 20f;
				setPulando(true);
			}
		}
		if(isPulando()) {
			setPosicaoY(getPosicaoY() + velocidadePulo);
			velocidadePulo = velocidadePulo + gravidade;

			if(getPosicaoY() <= 87) {
				setPosicaoY(87);
				setPulando(false);
			}
		}
	}
	public void mover(int direita, int esquerda, int baixo) {
		if(Gdx.input.isKeyPressed(direita) && !isColidiu()) {
			if(getPosicaoX() < 1100) {
				setPosicaoX(getPosicaoX() + 10);
			}
		}
		if(Gdx.input.isKeyPressed(esquerda) && !isColidiu()) {
			if(getPosicaoX() > 0) {
				setPosicaoX(getPosicaoX() - 10);
			}
		}

		if(Gdx.input.isKeyPressed(baixo) && !isPulando()) {
			setTextura("./"+this.nome+"/"+this.lado+"/agachado.png");
			setSprite(getTextura());
		}else {
			setTextura("./"+this.nome+"/"+this.lado+"/padrao.png");
			setSprite(getTextura());
		}
	}
	public void atacar(int ataque, int superAtaque) {
		if(Gdx.input.isKeyPressed(ataque)){
			setAtacando(true);
			setTextura("./"+this.nome+"/"+this.lado+"/atacando.png");
			setSprite(getTextura());
		}
		if(isAtacando()) {
			if(ataqueInt == 66 ? getAtaque().getSprite().getX() > 0 : getAtaque().getSprite().getX() < 1280) {
				getAtaque().getSprite().setX(getAtaque().getSprite().getX() + (ataqueInt == 66 ? -getAtaque().getVelocidade() : getAtaque().getVelocidade()));
			}else {
				atacou();
			}
		}else {
			getAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
			getAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		}

		if(Gdx.input.isKeyPressed(superAtaque)) {
			if(getContadorAtaque()>=6) {
				setSuperAtacando(true);
				setTextura("./"+this.nome+"/"+this.lado+"/atacando.png");
				setSprite(getTextura());
				setContadorAtaque(0);
			}
		}

		if(isSuperAtacando()) {
			if(getSuperAtaque().getSprite().getX() > 0) {
				getSuperAtaque().getSprite().setX(getSuperAtaque().getSprite().getX() + (ataqueInt == 66 ? -getAtaque().getDano() : getAtaque().getDano()));
			}else {
				atacou();
			}
		}else {
			getSuperAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
			getSuperAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		}
	}

	public void atacou() {
		getAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
		getAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		getSuperAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
		getSuperAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		setSuperAtacando(false);
		setAtacando(false);
	}
}
