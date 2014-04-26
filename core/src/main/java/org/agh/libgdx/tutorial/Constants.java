package org.agh.libgdx.tutorial;

import com.badlogic.gdx.graphics.Color;
import org.agh.libgdx.tutorial.util.Rect;

/**
 * @author mateusz
 * @since 25.04.14
 */
public interface Constants {
    float PI = (float) Math.PI;

    /* Screen constants */
    float SCREEN_WIDTH = 32.f;
    float SCREEN_HEIGHT = 24.f;
    Rect SCREEN_AREA = new Rect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

    /* Ball constants */
    float BALL_SIZE = 1.f;
    float BALL_VELOCITY = 8f;
    float BALL_STARTING_ANGLE = PI / 4;

    /* Bat constants */
    float BAT_WIDTH = 4.f;
    float BAT_HEIGHT = 1.5f;
    float BAT_VELOCITY = 0.4f;

    /* Brick constants */
    float BRICK_WIDTH = 2.f;
    float BRICK_HEIGHT = 1.f;

    /* Debug */
    boolean DEBUG_MODE = false;
    Color BAT_COLOR = new Color(0, 0, 1, 1);
    Color BALL_COLOR = new Color(0, 1, 0, 1);
    Color BRICK_COLOR = new Color(1, 0, 0, 1);
}
