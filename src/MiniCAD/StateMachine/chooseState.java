package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;
import MiniCAD.shapes.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class chooseState extends CADState{
    chooseState(MiniCAD miniCAD) {
        super(miniCAD);
        setStateName("chooseState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("点击一个图形来选中");
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

    }

    @Override
    public void mousePressed(MouseEvent event) {
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

    }
}
