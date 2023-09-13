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
	Texture cenario, personagem1, texturaAtaquePersonagem1;
	private Sprite ninja, ataquePersonagem1;
	private float xP1, yP1, xA1, yA1, velocidadePulo, gravidade;
	private boolean isPulando, isAtacando;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem1 = new Texture("ninja1.png");
		ninja = new Sprite(personagem1);
		texturaAtaquePersonagem1 = new Texture("shuriken.png");
		ataquePersonagem1 = new Sprite(texturaAtaquePersonagem1);
		xP1 = 10;
		yP1 = 87;
		xA1 = xP1 ;
		yA1 = yP1 ;
		isPulando = false;
		isAtacando = false;
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
		batch.draw(ataquePersonagem1, xA1 + ninja.getWidth()/2, yA1 + ninja.getHeight()/2);
		batch.draw(personagem1, xP1, yP1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		cenario.dispose();
		personagem1.dispose();
		texturaAtaquePersonagem1.dispose();
	}
	
	public void moveP1() {
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			if(xP1 < cenario.getWidth() - ninja.getWidth()) {
				xP1 += 10;
				personagem1 = new Texture("ninja1.png");
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			if(xP1 > 0) {
				xP1 -= 10;
				personagem1 = new Texture("ninja2.png");
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
		xA1 = xP1;
		yA1 = yP1;
	}
	public void ataque() {
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			isAtacando = true;
		}
		if(isAtacando) {
			xA1 += 10;
		}
	}
}
