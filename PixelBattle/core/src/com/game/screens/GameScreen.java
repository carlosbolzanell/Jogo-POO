package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.game.game.Ataque;
import com.game.game.MyGame;
import com.game.game.Personagem;
import com.game.game.SuperAtaque;

public class GameScreen extends ScreenAdapter {
	public SpriteBatch batch;
	private Texture cenario;
	private Personagem personagem1;
	private Personagem personagem2;
	private Texture retangulo;
	private int tamanho1 = 500;
	private int tamanho2 = 500;
	private int position = 700;
	private String caracter1;
	private String caracter2;

	public GameScreen(String caracter1, String caracter2){
		this.caracter1 = caracter1;
		this.caracter2 = caracter2;
	}

    @Override
    public void show() {
    	batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem1 = new Personagem("./"+caracter1+"/esquerda/padrao.png", 10, 87, 500, new Ataque("./"+caracter1+"/esquerda/ataque.png", 20, 20), new SuperAtaque("./"+caracter1+"/esquerda/especial.png", 10, 40), 51, 47, 29, 32, 46, 33, caracter1, "esquerda");
		personagem2 = new Personagem("./"+caracter2+"/direita/padrao.png", 1000, 87, 500, new Ataque("./"+caracter2+"/direita/ataque.png", 20, 20), new SuperAtaque("./"+caracter2+"/direita/especial.png", 10, 40), 19, 20, 21, 22, 66, 60, caracter2, "direita");
		retangulo = new Texture("branco.png");
    }

    @Override
    public void render(float delta) {
    	personagem1.acoes();
		personagem2.acoes();
		colisao();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(cenario, 0, 0);
		batch.draw(retangulo,50,620, (tamanho1>0) ? tamanho1 : 0, 50);
		batch.draw(retangulo, position ,620, (tamanho2>0) ? tamanho2 : 0, 50);
		if(personagem2.isAtacando()) {
			batch.draw(personagem2.getAtaque().getSprite(), personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY()+50);
		};
		if(personagem2.isSuperAtacando()) {
			batch.draw(personagem2.getSuperAtaque().getSprite(), personagem2.getSuperAtaque().getSprite().getX(), personagem2.getSuperAtaque().getSprite().getY()+50);
		}
		batch.draw(personagem2.getSprite(), personagem2.getPosicaoX(), personagem2.getPosicaoY());
		if(personagem1.isAtacando()) {
			batch.draw(personagem1.getAtaque().getSprite(), personagem1.getAtaque().getSprite().getX(), personagem1.getAtaque().getSprite().getY()+50);
		}
		if(personagem1.isSuperAtacando()) {
			batch.draw(personagem1.getSuperAtaque().getSprite(), personagem1.getSuperAtaque().getSprite().getX(), personagem1.getSuperAtaque().getSprite().getY()+50);
		}
		batch.draw(personagem1.getSprite(), personagem1.getPosicaoX(), personagem1.getPosicaoY());
		batch.end();

    }
    
    @Override
    public void hide() {
    	batch.dispose();
		cenario.dispose();
		personagem1.getTextura().dispose();
		personagem1.getAtaque().getTextura().dispose();
		personagem2.getTextura().dispose();
		personagem2.getAtaque().getTextura().dispose();
    }
    public void colisao() {
		Rectangle personagem1Bounds = new Rectangle(personagem1.getPosicaoX(), personagem1.getPosicaoY(), personagem1.getSprite().getWidth(), personagem1.getSprite().getHeight());
		Rectangle personagem2Bounds = new Rectangle(personagem2.getPosicaoX(), personagem2.getPosicaoY(), personagem2.getSprite().getWidth(), personagem2.getSprite().getHeight());

		if(personagem1.isAtacando()) {
			Rectangle ataque1Bounds = new Rectangle(personagem1.getAtaque().getSprite().getX(), personagem1.getAtaque().getSprite().getY() +50, personagem1.getAtaque().getSprite().getWidth(), personagem1.getAtaque().getSprite().getHeight());

			if(ataque1Bounds.overlaps(personagem2Bounds)){
				personagem1.setContadorAtaque(personagem1.getContadorAtaque()+1);
				tamanho2 -= personagem1.getAtaque().getDano();
				position += personagem1.getAtaque().getDano();
				personagem2.setVida(personagem2.getVida() - personagem1.getAtaque().getDano());
				personagem1.atacou();
			}
		}
		if(personagem2.isAtacando()) {
			Rectangle ataque2Bounds = new Rectangle(personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY()+50, personagem2.getAtaque().getSprite().getWidth(), personagem2.getAtaque().getSprite().getHeight());
			
			if(ataque2Bounds.overlaps(personagem1Bounds)) {
				personagem2.setContadorAtaque(personagem2.getContadorAtaque()+1);
				tamanho1 -= personagem2.getAtaque().getDano();
				personagem1.setVida(personagem1.getVida() - personagem2.getAtaque().getDano());
				personagem2.atacou();
			}			
		}
		
		if(personagem2.isSuperAtacando()) {
			Rectangle ataque2Bounds = new Rectangle(personagem2.getSuperAtaque().getSprite().getX(), personagem2.getSuperAtaque().getSprite().getY()+50, personagem2.getSuperAtaque().getSprite().getWidth(), personagem2.getSuperAtaque().getSprite().getHeight());
			
			if(ataque2Bounds.overlaps(personagem1Bounds)) {
				tamanho1 -= personagem2.getSuperAtaque().getDano();
				personagem1.setVida(personagem1.getVida() - personagem2.getSuperAtaque().getDano());
				personagem2.atacou();
			}		
		}
		
		if(personagem1.isSuperAtacando()) {
			Rectangle ataque1Bounds = new Rectangle(personagem1.getSuperAtaque().getSprite().getX(), personagem1.getSuperAtaque().getSprite().getY()+50, personagem1.getSuperAtaque().getSprite().getWidth(), personagem1.getSuperAtaque().getSprite().getHeight());
			
			if(ataque1Bounds.overlaps(personagem2Bounds)) {
				tamanho2 -= personagem1.getSuperAtaque().getDano();
				position += personagem1.getSuperAtaque().getDano();
				personagem2.setVida(personagem2.getVida() - personagem1.getSuperAtaque().getDano());
				personagem1.atacou();
			}		
		}
		
		personagem1.setColidiu( (personagem1Bounds.overlaps(personagem2Bounds)) ? true : false);
		personagem2.setColidiu( (personagem2Bounds.overlaps(personagem1Bounds)) ? true : false);
		
		if(personagem1.getVida() <= 0) {
			MyGame game = (MyGame) Gdx.app.getApplicationListener();
			game.setScreen(new GameOverScreen("Personagem 2"));
		}
		if(personagem2.getVida() <= 0) {
			MyGame game = (MyGame) Gdx.app.getApplicationListener();
			game.setScreen(new GameOverScreen("Personagem 1"));
		}
	}

	public void setScreen(GameScreen gameScreen) {
		
	}

}

