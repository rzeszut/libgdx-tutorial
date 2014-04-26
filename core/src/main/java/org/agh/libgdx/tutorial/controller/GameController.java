package org.agh.libgdx.tutorial.controller;

import org.agh.libgdx.tutorial.model.Bat;
import org.agh.libgdx.tutorial.model.World;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mateusz
 * @since 26.04.14
 */
public class GameController {
    private World world;
    private Map<Key, Boolean> keys;

    public GameController(World world) {
        this.world = world;

        keys = new HashMap<>(2);
        keys.put(Key.LEFT, false);
        keys.put(Key.RIGHT, false);
    }

    public void leftPressed() {
        keys.put(Key.LEFT, true);
    }

    public void rightPressed() {
        keys.put(Key.RIGHT, true);
    }

    public void leftReleased() {
        keys.put(Key.LEFT, false);
    }

    public void rightReleased() {
        keys.put(Key.RIGHT, false);
    }

    public void update(float delta) {
        world.bat.update(delta);
        world.ball.update(delta);
        world.ball.checkColiision(world.bat, world.bricks);

        processInput();
    }

    private void processInput() {
        final Bat bat = world.bat;
        if (keys.get(Key.LEFT)) {
            bat.moveLeft();
        }

        if (keys.get(Key.RIGHT)) {
            bat.moveRight();
        }

        if ((keys.get(Key.LEFT) && keys.get(Key.RIGHT)) ||
                (!keys.get(Key.LEFT) && !keys.get(Key.RIGHT))) {
            bat.stopMoving();
        }
    }

    private static enum Key {
        LEFT, RIGHT
    }
}
