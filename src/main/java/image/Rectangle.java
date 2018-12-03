package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    int x,y,width,height;
    Color color;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.color=color;
    }

    @Override
    public boolean contains(Point point) {
        return point.x>this.x&&point.x<this.x+this.width&&point.y<this.y&&point.y>this.y-this.height;
        //A VERIFIER !
    }

    @Override
    public Color getColor() {
        return this.color;
    }
}
