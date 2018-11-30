package image;

import javafx.scene.paint.Color;

public class PaletteRasterImage implements Image{


    private Color color;
    private int width;
    private int height;

    public PaletteRasterImage(Color color, int width, int height){
        this.color = color;
        this.width = width;
        this.height = height;

    }

    public PaletteRasterImage(Color[][] pixels){

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
