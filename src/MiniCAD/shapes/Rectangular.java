package MiniCAD.shapes;
import MiniCAD.DefaultSettings;
import java.awt.*;
import java.io.Serializable;

public class Rectangular extends Shape implements Serializable {
    private int width, height;
    public Rectangular(int x, int y, int width, int height,Color color){
        super(x,y,color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void addSize(float dsize) {
        width += dsize;
        height += dsize * height / width;
    }

    @Override
    public void subSize(float dsize) {
        if(width - dsize < DefaultSettings.SHAPE_MIN_SIZE) return;
        width -= dsize;
        height -= dsize * height / width;
    }

    @Override
    public boolean isIn(int nowX, int nowY) {
        return nowX >= x && nowX <= x + width && nowY >= y && nowY <= y + height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawRect(x, y, width, height);
    }
}
