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

    @Override
    public void show() {
        super.show();
        img = new Texture("pacman.png");
        touch = new Vector2(img.getWidth(),img.getHeight());
        speed = new Vector2(1,1);
        position = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if((position.y+img.getHeight()) < this.touch.y){
            position.y += speed.y;
        }
        else if ((position.y+img.getHeight()) > this.touch.y){
            position.y -= speed.y;
        }

        if((position.x+img.getWidth()) < this.touch.x){
            position.x += speed.x;
        }
        else if ((position.x+img.getWidth()) > this.touch.x){
            position.x -= speed.x;
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
}