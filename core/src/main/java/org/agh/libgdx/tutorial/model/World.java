package org.agh.libgdx.tutorial.model;

import com.badlogic.gdx.math.Vector2;
import org.agh.libgdx.tutorial.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mateusz
 * @since 26.04.14
 */
public final class World {
    public Bat bat;
    public Ball ball;
    public List<Brick> bricks;

    public World() {
        createWorld();
    }

    private void createWorld() {
        bat = new Bat(new Vector2(Constants.SCREEN_WIDTH / 2, 0));
        ball = new Ball(new Vector2(Constants.SCREEN_WIDTH / 2 + Constants.BAT_WIDTH / 2, Constants.BAT_HEIGHT));

        bricks = new ArrayList<>();
        for (int y = 0; y < 7; ++y) {
            float ypos = Constants.SCREEN_HEIGHT - 2 - y;

            int k;
            float xp;
            if (y % 2 == 0) {
                k = 14;
                xp = 2;
            } else {
                k = 13;
                xp = 3;
            }

            for (int x = 0; x < k; ++x) {
                float xpos = xp + 2 * x;
                bricks.add(new Brick(new Vector2(xpos, ypos)));
            }
        }
    }
}
