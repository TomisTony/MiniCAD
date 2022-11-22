package MiniCAD.shapes;
import MiniCAD.DefaultSettings;
import java.awt.*;
import java.io.Serializable;

public class Line extends Shape implements Serializable {
    private int x2,y2;
    private double length;
    public Line(int x1, int y1, int x2, int y2,Color color){
        super(x1,y1,color);
        this.x2 = x2;
        this.y2 = y2;
        recalculateLength();
    }

    private void recalculateLength(){
        this.length = Math.sqrt(Math.pow(x-x2,2) + Math.pow(y-y2,2));
    }

    @Override
    public void addSize(float dsize) {
        int deltaX = x-x2;
        int deltaY = y-y2;
        x2 = x + (int)(deltaX * (length + dsize) / length);
        y2 = y + (int)(deltaX * (length + dsize) / length);
        recalculateLength();
    }

    @Override
    public void subSize(float dsize) {
        if(length - dsize < DefaultSettings.SHAPE_MIN_SIZE) return;
        int deltaX = x-x2;
        int deltaY = y-y2;
        x2 = x + (int)(deltaX * (length - dsize) / length);
        y2 = y + (int)(deltaX * (length - dsize) / length);
        recalculateLength();
    }

    @Override
    public boolean isIn(int nowX, int nowY) {
        //点(x3,y3)到直线距离 = abs((y1-y2)x3+(x2-x1)y3+x1y2-y1x2)/sqrt((y1-y2) ^ 2 +(x1-x2) ^ 2)
        double tmp1 = (y-y2)*nowX+(x2-x)*nowY+x*y2-y*x2;
        double tmp2 = Math.pow(y-y2,2) + Math.pow(x-x2,2);
        return (Math.abs(tmp1)/tmp2 <= DefaultSettings.LINE_NEAR_RANGE);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawLine(x, y, x2, y2);
    }
}
