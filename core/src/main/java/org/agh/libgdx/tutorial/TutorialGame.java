
package org.agh.libgdx.tutorial;

import com.badlogic.gdx.Game;
import org.agh.libgdx.tutorial.screen.GameLostScreen;
import org.agh.libgdx.tutorial.screen.GameScreen;
import org.agh.libgdx.tutorial.util.GameLostException;

public class TutorialGame extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen());
    }

    @Override
    public void render() {
        try {
            super.render();
        } catch (GameLostException e) {
            setScreen(new GameLostScreen());
        }
    }
}
