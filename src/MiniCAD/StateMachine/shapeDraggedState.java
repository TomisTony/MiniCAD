package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.shapes.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class shapeDraggedState extends CADState{
    Shape choosedShape;
    shapeDraggedState(MiniCAD miniCAD, Shape choosedShape) {
        super(miniCAD);
        this.choosedShape = choosedShape;
        setStateName("shapeDraggedState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("正在拖动图形");
    }

    @Override
    public void clickButton(ActionEvent event) {

    }

    @Override
    public void mouseDragged(MouseEvent event) {
        int curX = event.getX();
        int curY = event.getY();
        choosedShape.moveTo(curX,curY);
        getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        setNextState(new shapeChoosedState(getMiniCAD(),choosedShape));
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
