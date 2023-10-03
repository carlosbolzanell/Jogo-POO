package com.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	public SpriteBatch batch;
	private Texture cenario;
	private Personagem personagem;
	private Personagem2 personagem2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem = new Personagem("ninja1.png");
		personagem2 = new Personagem2("weg verde.png");
	}

	@Override
	public void render () {
		personagem.acoes();
		personagem2.acoes();
		colisao();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(cenario, 0, 0);
		batch.draw(personagem2.getAtaque().getSprite(), personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY());
		batch.draw(personagem.getSprite(), personagem.getPosicaoX(), personagem.getPosicaoY());
		batch.draw(personagem.getAtaque().getSprite(), personagem.getAtaque().getSprite().getX(), personagem.getAtaque().getSprite().getY());
		batch.draw(personagem2.getSprite(), personagem2.getPosicaoX(), personagem2.getPosicaoY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		cenario.dispose();
		personagem.getTextura().dispose();
		personagem.getAtaque().getTextura().dispose();
		personagem2.getTextura().dispose();
		personagem2.getAtaque().getTextura().dispose();
	}
	
	public void colisao() {
		Rectangle personagem1Bounds = new Rectangle(personagem.getPosicaoX(), personagem.getPosicaoY(), personagem.getSprite().getWidth(), personagem.getSprite().getHeight());
		Rectangle personagem2Bounds = new Rectangle(personagem2.getPosicaoX(), personagem2.getPosicaoY(), personagem2.getSprite().getWidth(), personagem2.getSprite().getHeight());
		Rectangle ataque1Bounds = new Rectangle(personagem.getAtaque().getSprite().getX(), personagem.getAtaque().getSprite().getY(), personagem.getAtaque().getSprite().getWidth(), personagem.getAtaque().getSprite().getHeight());
		Rectangle ataque2Bounds = new Rectangle(personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY(), personagem2.getAtaque().getSprite().getWidth(), personagem2.getAtaque().getSprite().getHeight());
		
		if(ataque1Bounds.overlaps(personagem2Bounds)){
			System.out.println("colidiu");
			personagem.atacou();
		}
		if(ataque2Bounds.overlaps(personagem1Bounds)) {
			System.out.println("colidiu");
			personagem2.atacou();
		}
	}
	
	
}
