package com.game.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu extends ApplicationAdapter  {
	private SpriteBatch batch;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private BitmapFont bitmap;
	private Texture img;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("Cenario.png");
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
	    parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
	    
	    parameter.size = 30;
	    parameter.borderWidth = 1;
	    parameter.borderColor = Color.BLACK;
	    parameter.color = Color.WHITE;

	    bitmap = generator.generateFont(parameter);
		
	}
	@Override
	public void render() {
		batch.begin();
	    batch.draw(img, 0, 0);
		bitmap.draw(batch, "Começar", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		batch.end();
		
	}
	@Override
	public void dispose() {
		batch.dispose();
	    img.dispose();
	}

}
