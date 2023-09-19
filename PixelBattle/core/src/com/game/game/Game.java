package com.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture cenario;
	private Personagem personagem;
	private Ataque ataque;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem = new Personagem();
	}

	@Override
	public void render () {
		personagem.pular();
		personagem.mover();
		personagem.atacar();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(cenario, 0, 0);
		batch.draw(personagem.getTextura(), personagem.getPosicaoX(), personagem.getPosicaoY());
		batch.draw(personagem.getAtaque().getSprite(), personagem.getAtaque().getPosicaoX() + personagem.getTextura().getWidth() / 2, personagem.getAtaque().getPosicaoY() + personagem.getTextura().getHeight() / 2);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		cenario.dispose();
		personagem.getTextura().dispose();
	}
	
	
}
