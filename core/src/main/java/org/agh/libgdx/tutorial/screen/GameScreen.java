package org.agh.libgdx.tutorial.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL10;
import org.agh.libgdx.tutorial.controller.GameController;
import org.agh.libgdx.tutorial.model.World;
import org.agh.libgdx.tutorial.view.GameRenderer;

/**
 * @author mateusz
 * @since 26.04.14
 */
public class GameScreen implements Screen, InputProcessor {
    private GameController controller;
    private GameRenderer renderer;

    private int width;
    private int height;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        controller.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        renderer.setSize(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void show() {
        World world = new World();
        renderer = new GameRenderer(world);
        controller = new GameController(world);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
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

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                controller.leftPressed();
                break;
            case Input.Keys.RIGHT:
                controller.rightPressed();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                controller.leftReleased();
                break;
            case Input.Keys.RIGHT:
                controller.rightReleased();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        if (!Gdx.app.getType().equals(Application.ApplicationType.Android)) {
            return false;
        }

        if (y > height / 2) {
            if (x < width / 2) {
                controller.leftPressed();
            } else {
                controller.rightPressed();
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        if (!Gdx.app.getType().equals(Application.ApplicationType.Android)) {
            return false;
        }

        if (y > height / 2) {
            if (x < width / 2) {
                controller.leftReleased();
            } else {
                controller.rightReleased();
            }
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
