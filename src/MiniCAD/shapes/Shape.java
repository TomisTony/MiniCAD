package MiniCAD.shapes;
import java.awt.*;
import java.io.Serializable;
import MiniCAD.DefaultSettings;

public abstract class Shape implements Serializable {
    protected int x,y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public abstract void addSize(float dsize);
    public abstract void subSize(float dsize);
    public abstract void draw(Graphics graphics);
    public abstract boolean isIn(int nowX, int nowY);


}
