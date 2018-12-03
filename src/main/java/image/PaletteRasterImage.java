package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    List<Color> palette;
    int[][] indexesOfColor;

    public PaletteRasterImage(Color color,int width, int height){
        super(color,width,height);
    }

    public PaletteRasterImage(Color[][] pixels) {
         super(pixels,Matrices.getRowCount(pixels),Matrices.getColumnCount(pixels));
    }

    public void setPixelColor(Color color, int x, int y){
        if(!(palette.contains(color))){
            palette.add(color);
        }

        indexesOfColor[x][y] = palette.indexOf(color);
    }

    public void createRepresentation(){
        this.indexesOfColor = new int[width][height];
        this.palette = new ArrayList<Color>();
    }

    @Override
    public Color getPixelColor(int x, int y){
        return palette.get(indexesOfColor[x][y]);
    }
}
