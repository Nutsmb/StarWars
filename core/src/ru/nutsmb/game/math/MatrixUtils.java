package ru.nutsmb.game.math;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;

public class MatrixUtils {

    private MatrixUtils() {
    }

    public static void calcTransitionMatrix(Matrix4 mat, Rect src, Rect dst) {
        float scaleX = dst.getWidth() / src.getWidth();
        float scaleY = dst.getHeight() / src.getHeight();
        mat.idt().translate(dst.position.x, dst.position.y, 0f).scale(scaleX, scaleY, 1f).translate(-src.position.x, -src.position.y, 0f);
    }

    public static void calcTransitionMatrix(Matrix3 mat, Rect src, Rect dst) {
        float scaleX = dst.getWidth() / src.getWidth();
        float scaleY = dst.getHeight() / src.getHeight();
        mat.idt().translate(dst.position.x, dst.position.y).scale(scaleX, scaleY).translate(-src.position.x, -src.position.y);
    }
}