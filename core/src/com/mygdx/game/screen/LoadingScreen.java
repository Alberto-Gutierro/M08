package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceInvaders;

public class LoadingScreen extends SpaceInvadersScreen {

    private Texture texture;

    SpriteBatch spriteBatch;

    public LoadingScreen(SpaceInvaders si) {
        super(si);

        spriteBatch = new SpriteBatch();

        Pixmap pixmap = new Pixmap(50, 50, Pixmap.Format.RGBA8888);
        pixmap.setColor(1,1,0,1);
        pixmap.fillRectangle(0, 0, 50, 50);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void render(float delta) {
        if(!assets.update()){
            spriteBatch.begin();
            spriteBatch.draw(texture,0,50, 650*assets.getProgress(),50);
            spriteBatch.end();
            return;
        }

        setScreen(new GameScreen(game));
    }
}
