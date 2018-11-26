package image;


import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage implements Image{

    private Color[][] colors;
    private int width;
    private int height;

    public BruteRasterImage(Color color, int height, int width) {
        this.width = width;
        this.height = height;
        createRepresentation();
        for (int i = 0; i < height; i++) {
            for (int j = 0; i < width; j++) {
                setPixelColor(color,i,j);
            }
        }

    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        this.width = Matrices.getRowCount(colors);
        this.height = Matrices.getColumnCount(colors);
        createRepresentation();
        this.colors.setPixelsColor(colors);
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

    public void setPixelColor(Color color, int x, int y){
        colors[x][y] = color;
    }

    public void setPixelsColor(Color color){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                setPixelColor(color,i,j);
            }
        }
    }

    public void setPixelsColor(Color[][] color){
        Matrices.requiresNonNull(color);
        Matrices.requiresNonZeroDimensions(color);
        for(int i = 0; i<color.length; i++){
            for(int j = 0; j<color[0].length; j++){
                this.colors[i][j] = color[i][j];
            }
        }
    }


}
