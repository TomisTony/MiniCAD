package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class shapeChoosedState extends CADState{
    Shape choosedShape;
    shapeChoosedState(MiniCAD miniCAD, Shape choosedShape) {
        super(miniCAD);
        this.choosedShape = choosedShape;
        setStateName("shapeChoosedState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("已经选中了一个shape。按下颜色按钮改变颜色；滚动滚轮改变大小；按下删除按钮删除图形");
    }

    @Override
    public void clickButton(ActionEvent event) {
        logButtonName(event);
        String buttonName = event.getActionCommand();
        switch (buttonName){
            case ""://color buttons->no name
                JButton choosedButton = (JButton) event.getSource();
                Color choosedColor = choosedButton.getBackground();
                choosedShape.setColor(choosedColor);
                getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
                break;
            case "delete":
                getMiniCAD().shapes.remove(choosedShape);
                getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
                break;
            case "rectangular":
            case "circle":
            case "line":
            case "text":
            case "open":
            case "save":
            case "choose":
                //切换至idleState并执行按钮点击
                setNextState(new IdleState(getMiniCAD()));
                getMiniCAD().nowState.clickButton(event);
                break;
            default:
                logSwitchDefault(buttonName);
                break;

        }
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        setNextState(new shapeDraggedState(getMiniCAD(),choosedShape));
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
        //选择一个新shape
        int curX = event.getX();
        int curY = event.getY();
        for(Shape shape:getMiniCAD().shapes){
            if(shape.isIn(curX,curY)){
                setNextState(new shapeChoosedState(getMiniCAD(),shape));
                break;
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {
        int wheelRotation = event.getWheelRotation() * 20;
        //根据鼠标滚轮的方向调整了一下sub和add的顺序
        if(wheelRotation > 0)
            choosedShape.subSize(wheelRotation);
        else
            choosedShape.addSize(-1 * wheelRotation);
        getMiniCAD().paintAllShapes(getMiniCAD().graphics2D);
    }
}
