package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class drawShapeState extends CADState{
    private String shapeName;

    drawShapeState(MiniCAD miniCAD, String shapeName) {
        super(miniCAD);
        setStateName("drawShapeState");
        this.shapeName = shapeName;
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        switch (shapeName){
            case "rectangular":
                setNotify("选择一个点作为矩形左上角");
                break;
            case "circle":
                setNotify("选择一个点作为圆心");
                break;
            case "line":
                setNotify("选择一个点作为直线的第一个点");
                break;
            case "text":
                setNotify("选择一个点作为文字的起始位置");
                break;
            default:
                logSwitchDefault(shapeName);
                break;
        }
    }

    @Override
    public void clickButton(ActionEvent event) {
        //切换至idleState并执行按钮点击
        setNextState(new IdleState(getMiniCAD()));
        getMiniCAD().nowState.clickButton(event);
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
        setNextState(new drawFirstPointState(getMiniCAD(),shapeName,event.getX(),event.getY()));
    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event) {

    }
}
