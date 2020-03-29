package ru.nutsmb.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import ru.nutsmb.game.base.BaseScreen;
import ru.nutsmb.game.math.Rect;
import ru.nutsmb.game.sprite.Background;
import ru.nutsmb.game.sprite.Hero;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;

    private Background background;
    private Hero pacman;

    @Override
    public void show() {
        super.show();
        img = new Texture("pacman.png");
        bg = new Texture("textures/bg.jpeg");
        background = new Background(bg);
        pacman = new Hero(img, 0.03f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pacman.move(this.getTouch());
        batch.begin();
        background.draw(batch);
        pacman.draw(batch);
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
        pacman.resize(worldBounds);
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        pacman.setSpeed(getTouch());
        return false;
    }
}