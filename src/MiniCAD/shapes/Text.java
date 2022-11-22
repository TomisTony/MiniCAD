package MiniCAD.shapes;
import MiniCAD.DefaultSettings;
import java.awt.*;
import java.io.Serializable;

public class Text extends Shape implements Serializable {
    private int size;
    private String content;
    public Text(int x, int y, int size, Color color){
        super(x,y,color);
        this.size = size;
    }

    @Override
    public void addSize(float dsize) {
        size += dsize;
    }

    @Override
    public void subSize(float dsize) {
        if(size - dsize < DefaultSettings.SHAPE_MIN_SIZE) return;
        size -= dsize;
    }

    @Override
    public boolean isIn(int nowX, int nowY) {
        int width = size * DefaultSettings.FONT_SIZE_BASE * content.length();
        int height = size * DefaultSettings.FONT_SIZE_BASE;
        return nowX >= x && nowX <= x + width && nowY <= y && nowY >= y - height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.setFont(new Font("宋体",Font.PLAIN,size*DefaultSettings.FONT_SIZE_BASE));
        graphics.drawString(content,x,y);
    }
}
