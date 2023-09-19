package com.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ataque extends ApplicationAdapter{
	private Texture textura;
	private Sprite ataque;
	private int velocidade;
	private boolean direcao;
	private boolean isAtacando;
	private Game game;
	
	@Override
	public void create () {
		textura = new Texture("shuriken.png");
		ataque =new Sprite(textura);
		velocidade = 10;
		direcao = false;
		isAtacando = false;
		game = new Game();	
	}
	
	public void atirar() {
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			isAtacando = true;
		}
		if(game.getDirecao().equals("personagem1Direita")) {
			direcao = true;
		}
		if(direcao) {
			game.getNinja().setX(velocidade);
		}
		
	}
	public Sprite getSprite() {
		return this.ataque;
	}

}
