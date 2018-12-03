package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image{

    Color[][] colors;
    int width; // x
    int height; // y


    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){

        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresRectangularMatrix(colors);
        this.width = Matrices.getRowCount(colors);
        this.height = Matrices.getColumnCount(colors);
        this.colors = colors;
    }

    private void setPixelsColor(Color color){
        for(int i = 0; i<this.width; i++){
            for(int j = 0;j<this.height;j++){
                this.colors[i][j] = color;
            }
        }
    }


    public void createRepresentation(){
        this.colors = new Color[width][height];
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
