package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.DefaultSettings;
import MiniCAD.shapes.Circle;
import MiniCAD.shapes.Line;
import MiniCAD.shapes.Rectangular;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class drawSecondPointState extends CADState{
    private String shapeName;
    private int x1,y1,x2,y2;
    drawSecondPointState(MiniCAD miniCAD, String shapeName, int x1, int y1, int x2, int y2) {
        super(miniCAD);
        this.shapeName = shapeName;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setStateName("drawSecondPointState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("");
        switch (shapeName){
            case "rectangular":
                int width = Math.abs(x2-x1);
                int height = Math.abs(y2-y1);
                getMiniCAD().shapes.add(new Rectangular(x1,y1,width,height, DefaultSettings.DEFAULT_SHAPE_COLOR));
                break;
            case "circle":
                int radius = (int)Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
                getMiniCAD().shapes.add(new Circle(x1,y1,radius,DefaultSettings.DEFAULT_SHAPE_COLOR));
                break;
            case "line":
                getMiniCAD().shapes.add(new Line(x1,y1,x2,y2,DefaultSettings.DEFAULT_SHAPE_COLOR));
                break;
            default:
                logSwitchDefault(shapeName);
                break;
        }
        getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
        setNextState(new drawShapeState(getMiniCAD(),shapeName));
    }

    @Override
    public void clickButton(ActionEvent event) {

    }

    @Override
    public void mouseDragged(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }

    @Override
    public void mouseClicked(MouseEvent event) {

    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {

    }
}
