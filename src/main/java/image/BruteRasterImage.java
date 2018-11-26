package image;


import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage implements Image{

    Color[][] colors;
    Color color;
    int width;
    int height;

    public BruteRasterImage(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        this.colors = colors;
        this.width = Matrices.getRowCount(colors);
        this.height = Matrices.getColumnCount(colors);
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
