package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PersonagemEsquerda extends Personagem{

	public PersonagemEsquerda(String textura, int posicaoX, int posicaoY, int vida, Ataque ataque, SuperAtaque superAtaque) {
		super(textura, posicaoX, posicaoY, vida, ataque, superAtaque);
	}
	
	private boolean isAtacando = false;
	
	@Override
	public void pular() {
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			if(getPosicaoY() == 87) {
				setPulando(true);
				setVelocidadePulo(20f);
			}
		}
		if(isPulando()) {
			setPosicaoY(getPosicaoY() + getVelocidadePulo());
			setVelocidadePulo(getVelocidadePulo() + getGravidade());
			
			if(getPosicaoY() <= 87) {
				setPosicaoY(87);
				setPulando(false);
			}
		}
	}
	@Override
	public void mover() {
		if(Gdx.input.isKeyPressed(Input.Keys.D) && !isColidiu()) {
			if(getPosicaoX() < 1100){
				setPosicaoX(getPosicaoX() + 10);		
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			if(getPosicaoX() > 0) {
				setPosicaoX(getPosicaoX() - 10);				
			}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S) && !isPulando()) {
			setTextura("./xitxor/esquerda/agachado.png");
			setSprite(getTextura());
		}else {
			setTextura("./xitxor/esquerda/padrao.png");
			setSprite(getTextura());
		}			
	}
	
	@Override
	public void atacar() {		
		
		if(Gdx.input.isKeyPressed(Input.Keys.R)){
			isAtacando = true;	
			setTextura("./xitxor/esquerda/atacando.png");
			setSprite(getTextura());
		}else {
			setTextura("./xitxor/esquerda/padrao.png");
			setSprite(getTextura());
		}
		
		if(isAtacando) {
			if(getAtaque().getSprite().getX()<1280) {
				getAtaque().getSprite().setX(getAtaque().getSprite().getX() + 20);
			}else {
				atacou();
			}
		}else {
			getAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
			getAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		}	
	}
	
	public void atacou() {
		getAtaque().getSprite().setX(getPosicaoX() + getSprite().getWidth()/2);
		getAtaque().getSprite().setY(getPosicaoY() + getSprite().getHeight()/2);
		isAtacando = false;
	}

}
