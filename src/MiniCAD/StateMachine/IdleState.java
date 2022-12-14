package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class IdleState extends CADState {
    public IdleState(MiniCAD miniCAD) {
        super(miniCAD);
        setStateName("IdleState");
        getMiniCAD().nowState = this;
        handle();
    }

    @Override
    public void handle() {
        setNotify("(idle)");
    }

    @Override
    public void clickButton(ActionEvent event) {
        logButtonName(event);
        String buttonName = event.getActionCommand();
        switch (buttonName){
            case "rectangular":
            case "circle":
            case "line":
            case "text":
                setNextState(new drawShapeState(getMiniCAD(),buttonName));
                break;
            case "open":
            case "save":
                setNextState(new chooseFilePathState(getMiniCAD(),buttonName));
                break;
            case "choose":
                setNextState(new chooseState(getMiniCAD()));
            default:
                logSwitchDefault(buttonName);
                break;
        }
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
