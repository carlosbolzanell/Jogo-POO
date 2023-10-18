package com.game.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.game.game.screans.Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		jogo();
	}
	public static void jogo() {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("PixelBattle");
		config.setWindowedMode(1280, 720);
		new Lwjgl3Application(new Game(), config);
	}
	public static void gameOver(){
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Game over");
		config.setWindowedMode(1280, 720);
		new Lwjgl3Application(new Game(), config);
	}
	
}
