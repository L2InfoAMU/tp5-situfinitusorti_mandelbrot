package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.List;

public class PaletteRasterImage implements Image {

    List<Color> palette;
    int[][] indexesOfColor;
    int height;
    int width;

    public PaletteRasterImage(Color color,int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels) {

        Matrices.requiresNonNull(pixels);
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        setWidth(Matrices.getRowCount(pixels));
        setHeight(Matrices.getColumnCount(pixels));
        setPixelsColor(pixels);

    }



    public void setPixelColor(Color color, int x, int y){
        if(!(palette.contains(color))){
            palette.add(color);
        }

        indexesOfColor[x][y] = palette.indexOf(color);

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

    private void setPixelsColor(Color color){
        for(int i = 0; i<getWidth(); i++){
            for(int j = 0 ; j<getHeight(); j++){
                setPixelColor(color,i,j);
            }
        }
    }

    public void createRepresentation(){
        this.indexesOfColor = new int[width][height];
    }

    @Override
    public Color getPixelColor(int x, int y){
        return palette.get(indexesOfColor[x][y]);
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

    protected void setHeight(int height){
        this.height = height;
    }
}
