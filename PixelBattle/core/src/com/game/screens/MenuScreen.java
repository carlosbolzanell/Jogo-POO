package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.game.game.MyGame;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends ScreenAdapter{
	private SpriteBatch batch;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private BitmapFont bitmap;
	private Texture img;
	
	 @Override
	    public void show() {
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
	    public void render(float delta) {
	    	changeScreen();
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        batch.begin();
		    batch.draw(img, 0, 0);
			bitmap.draw(batch, "Comecar", Gdx.graphics.getWidth()/2 -50, Gdx.graphics.getHeight()/2);
			batch.end();
	    }
	    
	    @Override
	    public void hide() {
	    	img.dispose();
	    }
	    
	    public void changeScreen() {
	    	if(Gdx.input.isKeyPressed(Input.Keys.G)) {
	    		MyGame game = (MyGame) Gdx.app.getApplicationListener();
                game.setScreen(new ChoiceScreen());
	    	}
	    }

}
