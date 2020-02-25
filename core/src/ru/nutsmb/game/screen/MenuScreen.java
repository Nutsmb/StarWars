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
    private Vector2 step;
    private Vector2 direction;

    @Override
    public void show() {
        super.show();
        img = new Texture("pacman.png");
        touch = new Vector2(img.getWidth(),img.getHeight());
        speed = new Vector2(1,1);
        position = new Vector2();
        step = new Vector2();
        direction = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(position.dst(this.touch.x, this.touch.y) > step.len()) {
            position.add(step);
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
        /* посчитаем направление вектора скорости
           разделим разность координат по осям на модуль разности
           т.к. мы работаем в I квадранте, то составляющие direction будут принимать
           значение  1 при движении слева направо и снизу вверх,и
           значение -1 при движении справа налево и сверху вниз*/
        direction.x = (touch.x - position.x) / Math.abs(touch.x - position.x);
        direction.y = (touch.y - position.y) / Math.abs(touch.y - position.y);
        // посчитаем тангенс направления движения
        double tan = (position.y - this.touch.y) / (position.x - this.touch.x);
        // и проекции скорости на это направление
        step.x = (float) (speed.len() * (1 / (Math.sqrt(1 + Math.pow(tan, 2)))));
        step.y = (float) (speed.len() * (1 / (Math.sqrt(1 + Math.pow((1 / tan), 2)))));
        step.x = step.x * direction.x;
        step.y = step.y * direction.y;
        return false;
    }
}