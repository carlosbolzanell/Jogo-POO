package com.game.screens;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.game.game.MyGame;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChoiceScreen extends ScreenAdapter{
	private SpriteBatch batch;
	private Texture img;
	private Texture selecao1;
	private Texture selecao2;
	private String caracter1;
	private String caracter2;
	private  Texture inicio;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private BitmapFont bitmap;

	@Override
    public void show() {
		batch = new SpriteBatch();
		img = new Texture("Cenario.png");
		selecao1 = new Texture("selecaop1normal.png");
		selecao2 = new Texture("selecaop2normal.png");
		inicio = new Texture("Inicio.png");

		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = 30;
		parameter.borderWidth = 1;
		parameter.borderColor = Color.BLACK;
		parameter.color = Color.WHITE;

		bitmap = generator.generateFont(parameter);
    }

    @Override
    public void render(float delta) {
		changeScreen();
		changeSelect1();
		changeSelect2();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(selecao1, 20, img.getHeight()/2 - 200);
		batch.draw(inicio, 470, img.getHeight()/2 - 140);
		batch.draw(selecao2, 790, img.getHeight()/2 - 200);
		bitmap.draw(batch, "Aperte F para Comecar", 480, img.getHeight()/2 - 150);
		batch.end();
    }
    
    @Override
    public void hide() {
		img.dispose();
		selecao1.dispose();
    }

	public void changeScreen() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.F)) {
			MyGame game = (MyGame) Gdx.app.getApplicationListener();
			game.setScreen(new GameScreen(caracter1, caracter2));
		}
	}

	public void changeSelect1 (){
		if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
			selecao1 = new Texture("selecaop1a.png");
			this.caracter1 = "tinker";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
			selecao1 = new Texture("selecaop1d.png");
			this.caracter1 = "bell";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
			selecao1 = new Texture("selecaop1w.png");
			this.caracter1 = "xitxor";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S)){
			selecao1 = new Texture("selecaop1s.png");
			this.caracter1 = "erdmann";
		}
	}

	public void changeSelect2 (){
		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
			selecao2 = new Texture("selecaop2a.png");
			this.caracter2 = "tinker";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
			selecao2 = new Texture("selecaop2d.png");
			this.caracter2 = "bell";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
			selecao2 = new Texture("selecaop2w.png");
			this.caracter2 = "xitxor";
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
			selecao2 = new Texture("selecaop2s.png");
			this.caracter2 = "erdmann";
		}
	}

}
