package MiniCAD.StateMachine;

import MiniCAD.MiniCAD;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class CADState {
    protected String stateName;
    protected String notify;
    private MiniCAD miniCAD;

    CADState(MiniCAD miniCAD) {
        this.miniCAD = miniCAD;

    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setNotify(String notify) {
        this.notify = notify;
        miniCAD.setNotifyLable();
    }

    public abstract void handle();

    public abstract void clickButton(ActionEvent event);

    public abstract void mouseDragged(MouseEvent event);

    public abstract void mouseReleased(MouseEvent event);

    public abstract void mouseMoved(MouseEvent event);
    public abstract void mouseEntered(MouseEvent event);
    public abstract void mouseExited(MouseEvent event);
    public abstract void mouseClicked(MouseEvent event);
    public abstract void mousePressed(MouseEvent event);
    public abstract void mouseWheelMoved(MouseWheelEvent event);
    public String getNotify() {
        return notify;
    }

    public String getStateName() {
        return stateName;
    }

    protected void setNextState(CADState nextState){
        miniCAD.nowState = nextState;
    }

}
