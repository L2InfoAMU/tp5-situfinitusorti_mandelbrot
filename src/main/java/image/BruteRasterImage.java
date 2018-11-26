package image;


import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage implements Image{

    Color[][] colors;
    int width;
    int height;

    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        createRepresentation();
        for (int i = 0; i < height; i++) {
            for (int j = 0; i < width; j++) {
                this.colors[i][j] = color;
            }
        }

    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        this.colors = colors;
        this.width = Matrices.getRowCount(colors);
        this.height = Matrices.getColumnCount(colors);
    }


    public void createRepresentation() {
        this.colors = new Color[this.height][this.width];
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return colors[x][y];
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }


}
