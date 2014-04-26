package org.agh.libgdx.tutorial.model;

import com.badlogic.gdx.math.Vector2;
import org.agh.libgdx.tutorial.Constants;
import org.agh.libgdx.tutorial.util.GameLostException;

import java.util.List;

import static org.agh.libgdx.tutorial.Constants.PI;

/**
 * @author mateusz
 * @since 25.04.14
 */
public final class Ball extends GameModel {
    private float angle = Constants.BALL_STARTING_ANGLE;

    public Ball(Vector2 position) {
        super(position, Constants.BALL_SIZE, Constants.BALL_SIZE);
    }

    public void update(float delta) {
        area.getPosition(position);

        float v = delta * Constants.BALL_VELOCITY;
        position.add(v * (float) Math.cos(angle), v * (float) Math.sin(angle));

        area.setPosition(position);
    }

    public void checkColiision(Bat bat, List<Brick> bricks) {
        checkCollisionWithScreen();
        checkCollisionWithBat(bat);
        for (final Brick brick : bricks) {
            if (!brick.hit) {
                checkCollisionWithBrick(brick);
            }
        }
    }

    private void checkCollisionWithBrick(Brick brick) {
        if (brick.area.collides(area)) {
            boolean bottom = area.getTop() > brick.area.getBottom();
            boolean top = area.getBottom() < brick.area.getTop();
            boolean left = area.getRight() > brick.area.getLeft();
            boolean right = area.getLeft() < brick.area.getRight();
            boolean xin = brick.area.getLeft() < area.getCenterX() && area.getCenterX() < brick.area.getRight();

            if ((top || bottom) && xin) {
                angle = -angle;
            } else if (left || right) {
                angle = PI - angle;
            }

            brick.hit = true;
        }
    }

    private void checkCollisionWithBat(Bat bat) {
        if (bat.area.collides(area)) {
            boolean bottom = area.getTop() > bat.area.getBottom();
            boolean top = area.getBottom() < bat.area.getTop();
            boolean left = area.getRight() > bat.area.getLeft();
            boolean right = area.getLeft() < bat.area.getRight();
            boolean xin = bat.area.getLeft() < area.getCenterX() && area.getCenterX() < bat.area.getRight();

            if ((bottom || top) && xin) {
                angle = -PI * (bat.area.getRight() - area.getCenterX()) / bat.area.width;
            } else if (left || right) {
                angle = PI - angle;
            }
        }
    }

    private void checkCollisionWithScreen() {
        if (!Constants.SCREEN_AREA.contains(area)) {
            boolean bottom = area.getBottom() < 0;
            boolean top = area.getTop() > Constants.SCREEN_HEIGHT;
            boolean left = area.getLeft() < 0;
            boolean right = area.getRight() > Constants.SCREEN_WIDTH;

            if ((left && top) || (top && right)) {
                angle = angle + PI;
            } else if (top) {
                angle = -angle;
            } else if (left || right) {
                angle = PI - angle;
            } else if (bottom) {
                throw new GameLostException();
            }
        }
    }
}
