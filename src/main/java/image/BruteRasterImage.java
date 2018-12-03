package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage{

    Color[][] colors;

    public BruteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors,Matrices.getRowCount(colors),Matrices.getColumnCount(colors));
    }

    public void createRepresentation(){
        this.colors = new Color[width][height];
    }


    public void setPixelColor(Color color, int x, int y){
        this.colors[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.colors[x][y];
    }

}
