package com.game.game;

import com.badlogic.gdx.Game;
import com.game.screens.ChoiceScreen;
import com.game.screens.MenuScreen;

public class MyGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
