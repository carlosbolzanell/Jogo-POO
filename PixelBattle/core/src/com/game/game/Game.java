package com.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture cenario, personagem1Direita, personagem1Esquerda, texturaAtaquePersonagem1;
	private Sprite ninja, ataquePersonagem1;
	private float xP1, yP1, xA1, yA1, velocidadePulo, gravidade;
	private boolean isPulando, isAtacando, isLancado;
	private Ataque ataque = new Ataque();
	
	public Sprite getNinja() {
		return this.ninja;
	}
	public String getDirecao() {
		return ninja.getTexture().toString();
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem1Direita = new Texture("ninja1.png");
		personagem1Esquerda = new Texture("ninja2.png");
		ninja = new Sprite(personagem1Direita);
		texturaAtaquePersonagem1 = new Texture("shuriken.png");
		ataquePersonagem1 = new Sprite(texturaAtaquePersonagem1);
		xP1 = 10;
		yP1 = 87;
		xA1 = xP1 ;
		yA1 = yP1 ;
		isPulando = false;
		isAtacando = false;
		isLancado = false;
		gravidade = -0.99f;
	}

	@Override
	public void render () {
		moveP1();
		pular();
		moveAtaque();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(cenario, 0, 0);
		batch.draw(ninja, xP1, yP1);
		batch.draw(ataque.getSprite(), xA1 + ninja.getWidth()/2, yA1 + ninja.getHeight()/2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		cenario.dispose();
		personagem1Esquerda.dispose();
		personagem1Direita.dispose();
		texturaAtaquePersonagem1.dispose();
	}
	
	public void moveP1() {
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			if(xP1 < cenario.getWidth() - ninja.getWidth()) {
				xP1 += 10;
				ninja = new Sprite(personagem1Direita);;
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			if(xP1 > 0) {
				xP1 -= 10;
				ninja = new Sprite(personagem1Esquerda);;
			}
		}
			
	}
	public void pular() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			if(yP1 == 87) {
				isPulando = true;
				velocidadePulo = 20f;
			}
		}
		if(isPulando) {
			yP1 += velocidadePulo;
			velocidadePulo += gravidade;
			
			if(yP1 <= 87) {
				yP1 = 87;
				isPulando = false;
			}
		}
		
	}
	public void moveAtaque() {
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			isAtacando = true;
		}
		if(ninja.getTexture() == personagem1Direita && isAtacando) {
			if(!isLancado) {
				xA1 += 10;
				atacando();
				isLancado = true;
			}
			
		}else if(ninja.getTexture() == personagem1Esquerda && isAtacando) {
			if(!isLancado) {
				xA1 -= 10;
				atacando();
				isLancado = true;
			}
		}else {
			xA1 = xP1;
			yA1 = yP1;	
		}
	}
	public void atacando() {
		if(xA1 > cenario.getWidth() || xA1 < -100) {
			isAtacando = false;
			if(ataquePersonagem1.getWidth() > ninja.getWidth()) {
				isLancado = false;
			}else if(ataquePersonagem1.getWidth() < ninja.getWidth()) {
				isLancado = true;
			}
			xA1 = xP1;
			yA1 = yP1;
		}
	}
}
