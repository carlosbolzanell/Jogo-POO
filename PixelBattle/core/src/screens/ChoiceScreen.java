package screens;

import com.badlogic.gdx.ScreenAdapter;
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

public class ChoiceScreen extends ScreenAdapter{
	private SpriteBatch batch;
	private Texture img;
	private Texture xitxor;
	private Texture tinker;
	private Texture bell;
	private Texture erdmann;
	private Texture xitxor1;
	private Texture tiker1;
	private Texture bell1;
	private Texture erdmann1;
	
	@Override
    public void show() {
		batch = new SpriteBatch();
		img = new Texture("Cenario.png");
    }

    @Override
    public void render(float delta) {
       
    }
    
    @Override
    public void hide() {
        
    }

}
