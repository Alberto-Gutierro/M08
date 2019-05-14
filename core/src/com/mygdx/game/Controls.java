package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Controls {

    static OrthographicCamera camera;
    static Viewport viewport;
    static Vector3 touch = new Vector3();

    public static void init(Viewport viewport) {
        Controls.viewport = viewport;
    }

    public static boolean isLeftPressed() {
        System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
        viewport.unproject(touch.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        System.out.println(" >>>> " + touch.x + " " + touch.y);

        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)
                || Gdx.input.isTouched() && touch.x > 0 && touch.x < 30 && touch.y > 0 && touch.y < 30;
    }

    public static boolean isRightPressed() {
        viewport.unproject(touch.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)
                || Gdx.input.isTouched() && touch.x > 30 && touch.x < 80 && touch.y > 0 && touch.y < 30;
    }

    public static boolean isShootPressed() {
        viewport.unproject(touch.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        return Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)
                || Gdx.input.isTouched() && touch.x > 300 && touch.x < 330 && touch.y > 0 && touch.y < 30;
    }

    public static void render(SpriteBatch batch, Assets assets){
        batch.begin();
        batch.draw(assets.left, 0,0, 30, 30);
        batch.draw(assets.right, 50,0, 30, 30);
        batch.draw(assets.shot, 300, 0, 30, 30);
        batch.end();
    }


}
