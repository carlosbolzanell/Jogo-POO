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

public class GameOverScreen extends ScreenAdapter{
	private SpriteBatch batch;
	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private BitmapFont bitmap;
	private Texture img;
	private String vencedor;
	
	public GameOverScreen(String vencedor) {
		this.vencedor = vencedor;
	}
	
	 @Override
	    public void show() {
		 	batch = new SpriteBatch();
			img = new Texture("black.jpg");
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
			bitmap.draw(batch, "Game Over", Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2 + 100);
			bitmap.draw(batch, vencedor + "  Ganhou!", Gdx.graphics.getWidth()/2 -120, Gdx.graphics.getHeight()/2);
			bitmap.draw(batch, "Aperte SPACE para jogar novamente", Gdx.graphics.getWidth()/2 - 200, Gdx.graphics.getHeight()/2-100);
			batch.end();
	    }
	    
	    @Override
	    public void hide() {
	    	img.dispose();
	    }
	    
	    public void changeScreen() {
	    	if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
	    		MyGame game = (MyGame) Gdx.app.getApplicationListener();
                game.setScreen(new MenuScreen());
	    	}
	    }

}
