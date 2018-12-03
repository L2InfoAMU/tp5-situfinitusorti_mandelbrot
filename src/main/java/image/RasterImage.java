package image;

import util.Matrices;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image{
    int width; // x
    int height; // y


    public RasterImage(int width, int height){
        setWidth(width);
        setHeight(height);
    }
    public RasterImage(Color[][] matrice,int width,int height){
        this(width,height);
        Matrices.requiresNonNull(matrice);
        Matrices.requiresNonZeroDimensions(matrice);
        Matrices.requiresRectangularMatrix(matrice);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    protected void setWidth(int width){
        this.width = width;
    }

    protected  void setHeight(int height){
        this.height = height;
    }
}
