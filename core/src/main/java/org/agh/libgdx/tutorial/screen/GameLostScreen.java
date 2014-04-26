package org.agh.libgdx.tutorial.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author mateusz
 * @since 26.04.14
 */
public class GameLostScreen implements Screen {
    private static final String TEXT = "Game lost";

    private SpriteBatch spriteBatch;
    private BitmapFont font;

    private float textX;
    private float textY;

    public GameLostScreen() {
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, TEXT, textX, textY);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        BitmapFont.TextBounds bounds = font.getBounds(TEXT);
        textX = (width - bounds.width) / 2;
        textY = (height - bounds.height) / 2;
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }
}
