package org.agh.libgdx.tutorial.model;

import com.badlogic.gdx.math.Vector2;
import org.agh.libgdx.tutorial.util.Rect;

/**
 * @author mateusz
 * @since 25.04.14
 */
public abstract class GameModel {
    public Rect area = new Rect();
    protected Vector2 position;

    protected GameModel(Vector2 position, float width, float height) {
        this.position = position;
        this.area.setPosition(position);
        this.area.setSize(width, height);
    }

    public final Vector2 getPosition() {
        return area.getPosition(position);
    }
}
