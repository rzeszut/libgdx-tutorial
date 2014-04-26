package org.agh.libgdx.tutorial.model;

import com.badlogic.gdx.math.Vector2;
import org.agh.libgdx.tutorial.Constants;

/**
 * @author mateusz
 * @since 25.04.14
 */
public final class Brick extends GameModel {
    public boolean hit = false;

    public Brick(Vector2 position) {
        super(position, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }
}
