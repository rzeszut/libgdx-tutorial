package org.agh.libgdx.tutorial.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.agh.libgdx.tutorial.Constants;
import org.agh.libgdx.tutorial.model.Brick;
import org.agh.libgdx.tutorial.model.World;
import org.agh.libgdx.tutorial.util.Rect;

import static org.agh.libgdx.tutorial.Constants.*;

/**
 * @author mateusz
 * @since 25.04.14
 */
public final class GameRenderer {
    private World world;
    private OrthographicCamera camera;

    private ShapeRenderer debugRenderer;

    private SpriteBatch spriteBatch;
    private TextureRegion blockTexture;
    private TextureRegion batTexture;
    private TextureRegion ballTexture;

    private int width;
    private int height;
    private float ppuX;
    private float ppuY;

    public GameRenderer(World world) {
        this.world = world;

        this.camera = new OrthographicCamera(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.camera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);
        this.camera.update();

        this.debugRenderer = new ShapeRenderer();
        this.spriteBatch = new SpriteBatch();
        loadTextures();
    }

    private void loadTextures() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("gen/textures.pack"));
        blockTexture = atlas.findRegion("block");
        batTexture = atlas.findRegion("bat");
        ballTexture = atlas.findRegion("ball");
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.ppuX = (float) width / SCREEN_WIDTH;
        this.ppuY = (float) height / SCREEN_HEIGHT;
    }

    public void render() {
        spriteBatch.begin();
        renderBat();
        renderBall();
        renderBricks();
        spriteBatch.end();

        if (Constants.DEBUG_MODE) {
            renderDebug();
        }
    }

    private void renderDebug() {
        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);

        Rect rect;

        // draw bat
        rect = world.bat.area;
        debugRenderer.setColor(BAT_COLOR);
        debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);

        // draw ball
        rect = world.ball.area;
        debugRenderer.setColor(BALL_COLOR);
        debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);

        // draw bricks
        for (final Brick brick : world.bricks) {
            if (!brick.hit) {
                rect = brick.area;
                debugRenderer.setColor(BRICK_COLOR);
                debugRenderer.rect(rect.x, rect.y, rect.width, rect.height);
            }
        }

        debugRenderer.end();
    }

    private void renderBricks() {

    }

    private void renderBall() {

    }

    private void renderBat() {

    }
}
