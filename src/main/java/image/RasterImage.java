package image;

import util.Matrices;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image{
    int width; // x
    int height; // y

    private RasterImage(int width, int height){
        setWidth(width);
        setHeight(height);
    }

    public RasterImage(Color matrice, int width, int height){
        this(width, height);
        createRepresentation();
        setPixelsColor(matrice);
    }
    public RasterImage(Color[][] matrice,int width,int height){
        this(width, height);
        Matrices.requiresNonNull(matrice);
        Matrices.requiresNonZeroDimensions(matrice);
        Matrices.requiresRectangularMatrix(matrice);
        createRepresentation();
        setPixelsColor(matrice);
    }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);

    public void setPixelsColor(Color color){
        for(int i = 0; i<getWidth(); i++){
            for(int j = 0;j<getHeight();j++){
                setPixelColor(color,i,j);
            }
        }
    }

    public void setPixelsColor(Color[][] pixels){
        int minimumWidth = Math.min(getWidth(),pixels.length);
        int minimumHeight = Math.min(getHeight(),pixels[0].length);

        for(int i = 0; i<minimumWidth; i++){
            for(int j = 0; j<minimumHeight; j++ ){
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }


    public abstract Color getPixelColor(int x,int y);

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

    protected void setHeight(int height){
        this.height = height;
    }
}
