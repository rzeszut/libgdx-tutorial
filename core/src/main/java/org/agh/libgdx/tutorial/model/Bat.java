package org.agh.libgdx.tutorial.model;

import com.badlogic.gdx.math.Vector2;
import org.agh.libgdx.tutorial.Constants;

/**
 * @author mateusz
 * @since 25.04.14
 */
public final class Bat extends GameModel {
    private float dx = 0;

    public Bat(Vector2 position) {
        super(position, Constants.BAT_WIDTH, Constants.BAT_HEIGHT);
    }

    public void update(float delta) {
        area.getPosition(position);

        position.add(dx * delta, 0);

        if (!Constants.SCREEN_AREA.contains(area)) {
            if (position.x < 0) {
                position.x = 0;
            } else if (position.x >= Constants.SCREEN_WIDTH - Constants.BAT_WIDTH) {
                position.x = Constants.SCREEN_WIDTH - Constants.BAT_WIDTH;
            }
        }

        area.setPosition(position);
    }

    public void moveLeft() {
        dx -= Constants.BAT_VELOCITY;
    }

    public void moveRight() {
        dx += Constants.BAT_VELOCITY;
    }

    public void stopMoving() {
        dx = 0;
    }
}
