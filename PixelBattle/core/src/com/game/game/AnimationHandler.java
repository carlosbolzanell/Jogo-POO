package com.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.game.screens.GameScreen;

public class AnimationHandler {
    GameScreen game;
    float stateTime = 0;
    Animation<TextureRegion> animationTrack;
    Texture animationSheet;
    int FRAME_COLS;
    int FRAME_ROWS;
    float frameDuration;

    public void updateAnimation() {
        TextureRegion[][] tmp = TextureRegion.split(animationSheet,
                animationSheet.getWidth() / FRAME_COLS,
                animationSheet.getHeight() / FRAME_ROWS);

        TextureRegion[] animationFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }

        animationTrack = new Animation<TextureRegion>(frameDuration, animationFrames);
        stateTime = 0;
    }

    public AnimationHandler(GameScreen game, Texture animationSheet, int FRAME_COLS, int FRAME_ROWS, float frameDuration) {
        this.game = game;
        this.animationSheet = animationSheet;
        this.FRAME_COLS = FRAME_COLS;
        this.FRAME_ROWS = FRAME_ROWS;
        this.frameDuration = frameDuration;

        this.updateAnimation();
    }

    public void setFrameDuration(float frameDuration) {
        this.frameDuration = frameDuration;
        updateAnimation();
    }


    public void render(float x, float y) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animationTrack.getKeyFrame(stateTime, true);
        game.batch.draw(currentFrame, x, y);
    }

}
