package ru.nutsmb.game.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.nutsmb.game.math.Rect;

public abstract class Sprite extends Rect {

    protected float angle;
    protected float scale;
    protected TextureRegion[] regions;
    protected int frame;

    public Sprite(TextureRegion region){
        if(region == null){
            throw new RuntimeException("Не задана текстура");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw(SpriteBatch batch){
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    public void setHeightProportion(float height){
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public void resize(Rect worldBounds){};

    public void touchDown(Vector2 touch, int pointer, int button){};

    public void touchUp(int screenX, int screenY, int pointer, int button){};

    public void touchDragged(int screenX, int screenY, int pointer){};

    public void update(float delta){};

    public float getAngle(){        return angle; }

    public float getScale(){        return scale; }

    public void setAngle(float angle){        this.angle = angle; }

    public void setScale(float scale){        this.scale = scale; }
}
