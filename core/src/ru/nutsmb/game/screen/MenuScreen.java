package ru.nutsmb.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.nutsmb.game.base.BaseScreen;
import ru.nutsmb.game.math.Rect;
import ru.nutsmb.game.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;
    private Vector2 position;
    private Vector2 touch;
    private Vector2 buf;
    private float SPEED_LEN;
    private Vector2 speed;


    private Background background;

    @Override
    public void show() {
        super.show();
        img = new Texture("pacman.png");//badlogic.jpg
        bg = new Texture("textures/bg.jpeg");
        position = new Vector2();
        background = new Background(bg);
        touch = new Vector2();
        speed = new Vector2();
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
        background.draw(batch);
        batch.draw(img, position.x, position.y,0.1f,0.1f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public void resize(Rect worldBounds){
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch,pointer,button);
    }
}