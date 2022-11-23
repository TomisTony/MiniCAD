package MiniCAD.shapes;
import MiniCAD.DefaultSettings;
import java.awt.*;
import java.io.Serializable;

public class Circle extends Shape implements Serializable {
    private int radius;
    public Circle(int x, int y, int radius, Color color){
        super(x,y,color);
        this.radius = radius;
    }

    @Override
    public void addSize(float dsize) {
        radius += dsize;
    }

    @Override
    public void subSize(float dsize) {
        if(radius - dsize < DefaultSettings.SHAPE_MIN_SIZE) return;
        radius -= dsize;
    }

    @Override
    public boolean isIn(int nowX, int nowY) {
        double distance = Math.pow(nowX - x,2) + Math.pow(nowY-y,2);
        return Math.pow(radius,2) >= distance;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawArc(x-radius,y-radius,2*radius,2*radius,0,360);
    }
}
