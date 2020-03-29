package ru.nutsmb.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.nutsmb.game.base.Sprite;
import ru.nutsmb.game.math.Rect;

public class Hero extends Sprite {

    private Vector2 speed;
    private Vector2 position;
    private Vector2 buf;
    private float SPEED_LEN;

    public Hero(Texture region, float velocity) {
        super(new TextureRegion(region));
        position = new Vector2();
        speed = new Vector2();
        buf = new Vector2();
        SPEED_LEN = velocity;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.05f);
        this.position.set(worldBounds.position);
    }

    public void move(Vector2 touch){
        buf.set(touch);
        if(buf.sub(position).len() > SPEED_LEN) {
            position.add(speed);
            System.out.println(position);
        }
        else {
            position.set(touch);
        }
    }

    public void setSpeed(Vector2 touch){
        speed.set(touch.cpy().sub(position).setLength(SPEED_LEN));
    }

    public Vector2 getPosition(){ return position;}

    public Vector2 getSpeed(){ return speed;}

    public Vector2 getBuf(){ return buf;}

    public float getSPEED_LEN(){return SPEED_LEN;}


}
