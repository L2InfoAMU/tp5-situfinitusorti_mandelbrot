package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image{

    Color[][] colors;
    int width; // x
    int height; // y

    public BruteRasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){

        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);
        setWidth(Matrices.getRowCount(colors));
        setHeight(Matrices.getColumnCount(colors));
        this.colors = colors;
    }

    private void setPixelsColor(Color color){
        for(int i = 0; i<getWidth(); i++){
            for(int j = 0;j<getHeight();j++){
                setPixelColor(color,i,j);
            }
        }
    }

    public void setPixelColor(Color color, int x, int y){
        this.colors[x][y] = color;
    }


    public void createRepresentation(){
        this.colors = new Color[width][height];
    }

    private void setPixelsColor(Color[][] pixels){
        int minimumWidth = Math.min(getWidth(),pixels.length);
        int minimumHeight = Math.min(getHeight(),pixels[0].length);

        for(int i = 0; i<minimumWidth; i++){
            for(int j = 0; j<minimumHeight; j++ ){
                setPixelColor(pixels[i][j],i,j);
            }
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.colors[x][y];
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
