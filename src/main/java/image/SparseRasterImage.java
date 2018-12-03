package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.HashMap;

public class SparseRasterImage extends RasterImage {

    HashMap<Point,Color> pixelsMap;

    public SparseRasterImage(Color color,int width, int height){
        super(color,width,height);
    }

    public SparseRasterImage(Color[][] pixels) {
        super(pixels, Matrices.getRowCount(pixels),Matrices.getColumnCount(pixels));
    }

    public void setPixelColor(Color color, int x, int y){
        if(x<this.getWidth()&&y<this.getHeight()){
            pixelsMap.put(new Point(x,y),color);
        }
    }

    public void createRepresentation(){
        pixelsMap = new HashMap<Point,Color>();
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixelsMap.getOrDefault(new Point(x,y),Color.WHITE);
    }
}
