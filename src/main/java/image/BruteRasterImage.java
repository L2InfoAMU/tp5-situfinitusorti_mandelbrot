package image;


import javafx.scene.paint.Color;
import util.Matrices;


public class BruteRasterImage implements Image{

    public enum RasterImageType {BRUTE};
    private Color[][] colors;
    private int width;
    private int height;

    public BruteRasterImage(Color color, int width, int height) {
        setWidth(width);
        setHeight(height);
        createRepresentation();
        for (int j = 0; j < getWidth(); j++) {
            for (int i = 0; i < getHeight(); i++) {
                setPixelColor(color,j,i);
            }
        }

    }

    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        setWidth(Matrices.getRowCount(colors));
        setHeight(Matrices.getColumnCount(colors));
        createRepresentation();
        this.setPixelsColor(colors);
    }

    public void createRepresentation() {
        this.colors = new Color[getWidth()][getHeight()];
    } // height ; width

    @Override
    public Color getPixelColor(int x, int y) {
        return colors[x][y]; // x ; y
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
        for(int j = 0; j<getWidth(); j++){
            for(int i = 0; i<getHeight(); i++){
                setPixelColor(color,j,i); // i ; j
            }
        }
    }

    public void setPixelsColor(Color[][] color){
        Matrices.requiresNonNull(color);
        Matrices.requiresNonZeroDimensions(color);
        System.out.println("x = "+this.getWidth()+"y = "+this.getHeight());
        for(int j = 0; j<getWidth(); j++){
            for(int i = 0; i<getHeight(); i++){
                //System.out.println("x = "+j +"y = "+i);
                this.colors[j][i] = color[j][i]; // i ; j .. i ; j
            }
        }

    }

    protected void setWidth(int width){
        this.width=width;
    }
    protected void setHeight(int height){
        this.height=height;
    }

}
