package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.game.game.Ataque;
import com.game.game.PersonagemDireita;
import com.game.game.PersonagemEsquerda;
import com.game.game.SuperAtaque;

public class GameScreen extends ScreenAdapter {
	public SpriteBatch batch;
	private Texture cenario;
	private PersonagemEsquerda personagem1;
	private PersonagemDireita personagem2;
	private Texture retangulo;
	private int tamanho1 = 500;
	private int tamanho2 = 500;
	private int position = 700;

    
    @Override
    public void show() {
    	batch = new SpriteBatch();
		cenario = new Texture("Cenario.png");
		personagem1 = new PersonagemEsquerda("./xitxor/esquerda/padrao.png", 10, 87, 200, new Ataque("./xitxor/esquerda/ataque.png", 20, 20), new SuperAtaque("./xitxor/esquerda/especial.png", 10, 10));
		personagem2 = new PersonagemDireita("./bell/direita/padrao.png", 1000, 87, 200, new Ataque("./bell/direita/ataque.png", 20, 20), new SuperAtaque("./bell/direita/especial.png", 10, 10));
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
		batch.draw(personagem2.getAtaque().getSprite(), personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY());
		batch.draw(personagem2.getSprite(), personagem2.getPosicaoX(), personagem2.getPosicaoY());
		batch.draw(personagem1.getAtaque().getSprite(), personagem1.getAtaque().getSprite().getX(), personagem1.getAtaque().getSprite().getY());
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
		Rectangle personagem1Bounds = new Rectangle(personagem1.getPosicaoX(), personagem1.getPosicaoY(), personagem1.getSprite().getWidth() - 80, personagem1.getSprite().getHeight());
		Rectangle personagem2Bounds = new Rectangle(personagem2.getPosicaoX(), personagem2.getPosicaoY(), personagem2.getSprite().getWidth(), personagem2.getSprite().getHeight());
		Rectangle ataque1Bounds = new Rectangle(personagem1.getAtaque().getSprite().getX(), personagem1.getAtaque().getSprite().getY(), personagem1.getAtaque().getSprite().getWidth(), personagem1.getAtaque().getSprite().getHeight());
		Rectangle ataque2Bounds = new Rectangle(personagem2.getAtaque().getSprite().getX(), personagem2.getAtaque().getSprite().getY(), personagem2.getAtaque().getSprite().getWidth(), personagem2.getAtaque().getSprite().getHeight());
		
		if(ataque1Bounds.overlaps(personagem2Bounds)){
			tamanho2 -= personagem1.getAtaque().getDano();
			position += personagem1.getAtaque().getDano();
			personagem1.atacou();
		}
		if(ataque2Bounds.overlaps(personagem1Bounds)) {
			personagem2.setContadorAtaque(personagem2.getContadorAtaque()+1);
			tamanho1 -= personagem2.getAtaque().getDano();
			personagem2.atacou();
		}
		personagem1.setColidiu( (personagem1Bounds.overlaps(personagem2Bounds)) ? true : false);
		personagem2.setColidiu( (personagem2Bounds.overlaps(personagem1Bounds)) ? true : false);
	}

	public void setScreen(GameScreen gameScreen) {
		
	}

}

