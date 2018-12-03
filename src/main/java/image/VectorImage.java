package image;

import javafx.scene.paint.Color;
import java.util.List;

public class VectorImage implements Image {

    int width;
    int height;
    List<Shape> shapes;

    public VectorImage(List<Shape> shapes, int width, int height){
        setWidth(width);
        setHeight(height);
        this.shapes = shapes;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        for(Shape shape : shapes){
            if(shape.contains(new Point(x,y))){
                return shape.getColor();
            }
        }
        return Color.WHITE;
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
        this.width=width;
    }

    protected void setHeight(int height){
        this.height=height;
    }
}
