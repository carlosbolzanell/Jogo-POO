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
	private float velocidadePulo = 20f;
	private float gravidade = -0.99f;
	private boolean isPulando;
	private boolean isAtacando = false;
	private boolean player1;
	private Ataque ataque;
	private SuperAtaque superAtaque;
	private int contadorAtaque = 0;
	private boolean colidiu = false;
	
	public Personagem(String textura, int posicaoX, int posicaoY, int vida, Ataque ataque, SuperAtaque superAtaque ,boolean player1) {
		setTextura(textura);
		setSprite(getTextura());	
		ataque.getSprite().setPosition(getPosicaoX() + getSprite().getWidth()/2, getPosicaoY() + getSprite().getHeight()/2);
		setPosicaoX(posicaoX);
		setPosicaoY(posicaoY);
		setVida(vida);
		setAtaque(ataque);
		setSuperAtaque(superAtaque);
		this.player1 = player1;
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
		if(player1) {
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
		}else {
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
		
	}
	public void mover() {
		if(player1) {
			if(Gdx.input.isKeyPressed(Input.Keys.D) && !isColidiu()) {
				if(posicaoX < 1100){
					posicaoX += 10;		
				}
			}
			if(Gdx.input.isKeyPressed(Input.Keys.A)) {
				if(posicaoX > 0) {
					posicaoX -= 10;				
				}
			}			
		}else {
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				if(posicaoX < 1100) {
					posicaoX += 10;		
				}
			}
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && !isColidiu()) {
				if(posicaoX > 0) {
					posicaoX -= 10;				
				}
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && !isPulando) {
				setTextura("verdeAgachado.png");
				setSprite(getTextura());
			}else {
				setTextura("weg verde.png");
				setSprite(getTextura());
			}
		}
	}
	
	public void atacar() {
		if(player1) {
			if(Gdx.input.isKeyPressed(Input.Keys.R)){
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
			
		}else if(!player1){
			if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
				isAtacando = true;				
			}
			if(isAtacando) {
				if(ataque.getSprite().getX() > 0) {
					ataque.getSprite().setX(ataque.getSprite().getX() - 20);
				}else {
					atacou();
				}
			}else {
				ataque.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
				ataque.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
			}
		}
		
	}
	public void atacou() {
		ataque.getSprite().setX(this.posicaoX + getSprite().getWidth()/2);
		ataque.getSprite().setY(this.posicaoY + getSprite().getHeight()/2);
		isAtacando = false;
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
}
