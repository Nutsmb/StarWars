package ru.nutsmb.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.nutsmb.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch;
    private Vector2 speed;
    private Vector2 position;
    private Vector2 buf;
    private float SPEED_LEN;

    @Override
    public void show() {
        super.show();
        img = new Texture("pacman.png");
        touch = new Vector2();
        speed = new Vector2();
        position = new Vector2();
        buf = new Vector2();
        SPEED_LEN = 1f;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);

        if(buf.sub(position).len() > SPEED_LEN) {
            position.add(speed);
        }
        else {
            position.set(touch);
        }

        batch.begin();
        batch.draw(img, position.x, position.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.x = screenX;
        touch.y = Gdx.graphics.getHeight() - screenY;
        speed.set(touch.cpy().sub(position).setLength(SPEED_LEN));
        return false;
    }
}